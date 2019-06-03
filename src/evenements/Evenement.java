package evenements;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Evenement {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Fenetre");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(640, 480);
    frame.setLocationRelativeTo(null);

    JButton button = new JButton("Button");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed 1");
      }
    });
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed 2");
      }
    });

    frame.add(button, BorderLayout.PAGE_START);

    JPanel panel = new JPanel();
    panel.setBackground(Color.red);
    MouseAdapter mouseAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
      }

      @Override
      public void mouseMoved(MouseEvent e) {
        System.out.println("Moved");
      }

      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("WheelMoved");
      }
    };
    panel.addMouseListener(mouseAdapter);
    panel.addMouseMotionListener(mouseAdapter);
    panel.addMouseWheelListener(mouseAdapter);

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> list = new JList<>(listModel);
    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    for (int i = 1; i <= 100; i++) {
      listModel.addElement("Element " + i);
    }

    list.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
          return;
        }
        JList<String> list = (JList) e.getSource();
        List<String> strs = list.getSelectedValuesList();
        System.out.println(strs.toString());
      }
    });

    frame.add(new JScrollPane(list), BorderLayout.CENTER);

    frame.setVisible(true);
  }

}
