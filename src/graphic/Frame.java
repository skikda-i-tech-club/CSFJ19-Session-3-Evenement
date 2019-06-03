package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Frame extends JFrame {

  public Frame() {
    setTitle("Fenetre");
    setSize(640, 480);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//    Paint panel = new Paint();
    Paint2 panel = new Paint2();
    panel.setText("Panel2");
    Font font = new Font("Monospaces", Font.ITALIC | Font.BOLD, 30);
    panel.setFont(font);

    panel.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
          panel.setDrawingOval(!panel.isDrawingOval());
        }
      }
    });

    setVisible(true);

    panel.setBackground(Color.white);
    panel.setForeground(Color.red);
    setContentPane(panel);
  }

  public static void main(String[] args) {
    new Frame();
  }

}
