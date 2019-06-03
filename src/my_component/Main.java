package my_component;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main implements ActionListener {

  private JTextFieldX textField;

  public Main() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(480, 300);
    frame.setLocationRelativeTo(null);

    textField = new JTextFieldX();
    textField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
    textField.setPlaceHolder("0x xx xx xx xx");
    // this est un ActionListener parce qu'il implemente l'interface ActionListener.
    textField.addActionListener(this);

    textField.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        System.out.println("insertUpdate");
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        System.out.println("removeUpdate");
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        System.out.println("changeUpdate");
      }
    });
    frame.add(textField, BorderLayout.PAGE_END);

    JButton button = new JButton("Afficher");
    button.addActionListener(this);
    // l'attribut 'name' dans les composants swing ressemble à l'attribut 'id' dans html.
    button.setName("Button1");
    frame.add(button, BorderLayout.PAGE_START);

    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JComponent source = (JComponent) e.getSource();
    String name = source.getName();
    if (name == null) {
      System.out.println(textField.getText());
    } else {
      System.out.println("From " + name + ": " + textField.getText());
    }
  }

  public static void main(String[] args) {
    new Main();
  }
}
