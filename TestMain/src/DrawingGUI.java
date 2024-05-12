import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class DrawingGUI extends JFrame{

    Point startPoint = new Point(-1, -1); // 선의 시작점
    Point endPoint = new Point(-1, -1); // 선의 끝점
    ArrayList<Point> startPointArr = new ArrayList<>();
    ArrayList<Point> endPointArr = new ArrayList<>();

    public DrawingGUI() {
        super("Computer Graphics Homework - DrawingGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);
    }

    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.GRAY);

            JButton buttonDrawLine = new JButton("Draw Line");
            JButton buttonMoveLine = new JButton("Move Line");
            JButton buttonColor = new JButton("Color");

            buttonDrawLine.addActionListener(new ButtonDrawLineActionListener());
            buttonMoveLine.addActionListener(new ButtonMoveLineActionListener());
            buttonColor.addActionListener(new ButtonColorActionListener());

            add(buttonDrawLine);
            add(buttonMoveLine);
            add(buttonColor);
        }
    }
    class CenterPanel extends JPanel {

        public CenterPanel() {
            setBackground(Color.WHITE);
            MouseAdapter mouseAdapter = new MouseAdapter() {
                private Point prevPt;

                @Override
                public void mousePressed(MouseEvent e) {
                    if (isOnLine(e.getPoint())) {
                        prevPt = e.getPoint();
                    } else {
                        Point startP = e.getPoint();
                        startPointArr.add(startP);
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (prevPt != null) {
                        int dx = e.getX() - prevPt.x;
                        int dy = e.getY() - prevPt.y;

                        startPoint.translate(dx, dy);
                        endPoint.translate(dx, dy);
                        prevPt = e.getPoint();
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(prevPt != null) {
                        prevPt = null;
                    } else {
                        Point endP = e.getPoint();
                        endPointArr.add(endP);
                        repaint();
                    }
                }

                private boolean isOnLine(Point p) {
                    for(int i = 0; i < startPointArr.size(); i++) {
                        startPoint = startPointArr.get(i);
                        endPoint = endPointArr.get(i);

                        if(Math.abs(distance(startPoint, p) + distance(p, endPoint) - distance(startPoint, endPoint)) < 0.5)
                            return true;
                    }

                    return false;
                }

                private double distance(Point p1, Point p2) {
                    int dx = p1.x - p2.x;
                    int dy = p1.y - p2.y;
                    return Math.sqrt(dx * dx + dy * dy);
                }
            };

            addMouseListener(mouseAdapter);
            addMouseMotionListener(mouseAdapter);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.draw(new Line2D.Double(startPoint.x, startPoint.y, endPoint.x, endPoint.y));

            for (int i = 0; i < startPointArr.size(); i++) {
                Point s = startPointArr.get(i);
                Point e = endPointArr.get(i);

                g2.draw(new Line2D.Double(s.x, s.y, e.x, e.y));
            }
        }
    }

    class SouthPanel extends JPanel {
        public SouthPanel() {
            setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        new DrawingGUI();
    }
}
