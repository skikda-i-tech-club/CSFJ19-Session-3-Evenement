package graphic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class Paint extends JComponent {

  private List<Point2D> list;
  private static final int RAYON = 50;

  public Paint() {
    list = new ArrayList<>();
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Point2D point2D = new Point2D.Float(e.getX() - RAYON / 2, e.getY() - RAYON / 2);
        list.add(point2D);
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());

    g2d.translate(0, getHeight());
    g2d.scale(1, -1);

    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{5, 5, 10, 10}, 0));
    g2d.setPaint(getForeground());

    for (int i = 0; i < list.size(); i++) {
      Point2D pt = list.get(i);
      g.drawOval((int) pt.getX(), (int) pt.getY(), RAYON, RAYON);
    }
  }

}
