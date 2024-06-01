import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Scanner;

public class DrawingGUI extends JFrame {

    // Variables
    Integer selectLineNum = 0;
    Point startPoint = new Point(-1, -1); // 선의 시작점
    Point endPoint = new Point(-1, -1); // 선의 끝점
    ArrayList<Point> startPointArr = new ArrayList<>();
    ArrayList<Point> endPointArr = new ArrayList<>();
    ArrayList<Color> lineColorArr = new ArrayList<>();

    enum Mode {
        DRAW
    }

    Mode mode = Mode.DRAW;
    Color color = Color.BLACK;
    Container container = getContentPane();

    // Swing Variables
    JLabel x1_label = new JLabel("            x1 : ");
    JTextField x1 = new JTextField(4);
    JLabel y1_label = new JLabel("            y1 : ");
    JTextField y1 = new JTextField(4);
    JLabel x2_label = new JLabel("            x2 : ");
    JTextField x2 = new JTextField(4);
    JLabel y2_label = new JLabel("            y2 : ");
    JTextField y2 = new JTextField(4);
    JLabel null_label = new JLabel("");
    JButton draw = new JButton("draw");
    JLabel line_number_label = new JLabel("선 번호 : ");
    JTextField line_number = new JTextField(4);

    // Methods
    public DrawingGUI() {
        super("Computer Graphics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.add(new CenterPanel(), BorderLayout.CENTER);
        container.add(new EastPanel(), BorderLayout.EAST);
        setSize(400, 400);
        setVisible(true);

        draw.addActionListener(new DrawActionListener());
        draw.addKeyListener(new MyKeyListener());
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
                        line_number.setText(selectLineNum.toString());
                    } else {
                        startPoint = e.getPoint();
                        startPointArr.add(startPoint);
                        lineColorArr.add(color);
                        selectLineNum = lineColorArr.size() - 1;
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
                    if (prevPt != null) {
                        prevPt = null;
                    } else {
                        endPoint = e.getPoint();
                        endPointArr.add(endPoint);
                        repaint();
                    }
                }

                private boolean isOnLine(Point p) {
                    for (int i = 0; i < startPointArr.size(); i++) {
                        startPoint = startPointArr.get(i);
                        endPoint = endPointArr.get(i);
                        selectLineNum = i;

                        if (Math.abs(distance(startPoint, p) + distance(p, endPoint) - distance(startPoint, endPoint)) < 1)
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
            g2.setStroke(new BasicStroke(1));

            // MOVE 전용
            if (!startPointArr.isEmpty()) g2.setColor(lineColorArr.get(selectLineNum));
            g2.draw(new Line2D.Double(startPoint.x, startPoint.y, endPoint.x, endPoint.y));

            // 나머지 선도 전부 다시 그리기
            for (int i = 0; i < startPointArr.size(); i++) {
                Point s = startPointArr.get(i);
                Point e = endPointArr.get(i);

                g2.setColor(lineColorArr.get(i));
                g2.draw(new Line2D.Double(s.x, s.y, e.x, e.y));
            }
        }
    }

    class EastPanel extends JPanel {

        public EastPanel() {
            setBackground(Color.YELLOW);
            setLayout(new GridLayout(5, 2));

            add(x1_label);
            add(x1);
            add(y1_label);
            add(y1);
            add(x2_label);
            add(x2);
            add(y2_label);
            add(y2);
            add(null_label);
            add(draw);
        }
    }

    class ButtonDrawLineActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = Mode.DRAW;
            container.remove(2);
            container.add(new EastPanel(), BorderLayout.SOUTH);
            container.revalidate();
        }
    }

    class DrawActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startPoint = new Point(Integer.parseInt(x1.getText()), Integer.parseInt(y1.getText()));
            endPoint = new Point(Integer.parseInt(x2.getText()), Integer.parseInt(y2.getText()));

            startPointArr.add(startPoint);
            endPointArr.add(endPoint);
            lineColorArr.add(color);
            repaint();
        }
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    startPoint.translate(0, -10);
                    endPoint.translate(0, -10);
                    repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    startPoint.translate(0, 10);
                    endPoint.translate(0, 10);
                    repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    startPoint.translate(-10, 0);
                    endPoint.translate(-10, 0);
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    startPoint.translate(10, 0);
                    endPoint.translate(10, 0);
                    repaint();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new DrawingGUI();
    }
}