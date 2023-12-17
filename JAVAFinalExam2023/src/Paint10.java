import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Paint10 extends JFrame {
    private MyPanel panel = new MyPanel();
    public Paint10() {
        setTitle("drawing Line by Mouse 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 300);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private Vector<Point> vStart = new Vector<>();
        private Vector<Point> vEnd = new Vector<>();

        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    Point startP = e.getPoint();
                    vStart.add(startP);
                }

                public void mouseReleased(MouseEvent e) {
                    Point endP = e.getPoint();
                    vEnd.add(endP);
                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);

            for(int i = 0; i < vStart.size(); i++) {
                Point s = vStart.elementAt(i);
                Point e = vEnd.elementAt(i);

                g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
            }
        }
    }

    public static void main(String[] args) {
        new Paint10();
    }
}
