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

public class Paint2 extends JComponent {

  private List<Point2D> listLines;
  private List<Point2D> listCircles;
  private String text;
  private boolean drawingOval;
  private static final int RAYON = 50;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isDrawingOval() {
    return drawingOval;
  }

  public void setDrawingOval(boolean drawingOval) {
    this.drawingOval = drawingOval;
  }

  public Paint2() {
    setFocusable(true);
    drawingOval = false;
    listLines = new ArrayList<>();
    listCircles = new ArrayList<>();
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Point2D point2D = new Point2D.Float(e.getX(), e.getY());
        if (drawingOval) {
          listCircles.add(point2D);
        } else {
          listLines.add(point2D);
        }
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());

//    g2d.translate(0, getHeight());
//    g2d.scale(1, -1);
    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{5, 5, 10, 10}, 0));
    g2d.setPaint(getForeground());

    for (int i = 0; i < listCircles.size(); i++) {
      Point2D pt = listCircles.get(i);
      g.drawOval((int) pt.getX() - RAYON / 2, (int) pt.getY() - RAYON / 2, RAYON, RAYON);
    }

    for (int i = 1; i < listLines.size(); i++) {
      Point2D pt1 = listLines.get(i - 1);
      Point2D pt2 = listLines.get(i);
      g.drawLine((int) pt1.getX(), (int) pt1.getY(), (int) pt2.getX(), (int) pt2.getY());
    }

    if (text != null) {
      g2d.setFont(getFont());
      g2d.drawString(text, getWidth() / 2, getHeight() / 2);
    }
  }

}
