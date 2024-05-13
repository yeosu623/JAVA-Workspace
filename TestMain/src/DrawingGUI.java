import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class DrawingGUI extends JFrame{

    // Variables
    Integer selectLineNum = 0;
    Point startPoint = new Point(-1, -1); // 선의 시작점
    Point endPoint = new Point(-1, -1); // 선의 끝점
    ArrayList<Point> startPointArr = new ArrayList<>();
    ArrayList<Point> endPointArr = new ArrayList<>();
    ArrayList<Color> lineColorArr = new ArrayList<>();

    enum Mode {
        DRAW, MOVE
    }
    Mode mode = Mode.DRAW;
    Color color = Color.BLACK;
    Color colorPrev = Color.BLACK;
    Container container = getContentPane();

    // Swing Variables
    JLabel point1_label = new JLabel("(x1, y1) : ");
    JTextField x1 = new JTextField(4);
    JTextField y1 = new JTextField(4);
    JLabel point2_label = new JLabel("(x2, y2) : ");
    JTextField x2 = new JTextField(4);
    JTextField y2 = new JTextField(4);
    JButton draw = new JButton("그리기");
    JLabel line_number_label = new JLabel("선 번호 : ");
    JTextField line_number = new JTextField(4);

    JTextField x3 = new JTextField(4);
    JTextField y3 = new JTextField(4);

    JLabel line_move_label = new JLabel("움직일 x, y 길이 : ");
    JButton move = new JButton("움직이기");


    // Methods
    public DrawingGUI() {
        super("Computer Graphics Homework - DrawingGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.add(new NorthPanel(), BorderLayout.NORTH);
        container.add(new CenterPanel(), BorderLayout.CENTER);
        container.add(new SouthPanel(), BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);

        draw.addActionListener(new DrawActionListener());
        move.addActionListener(new MoveActionListener());
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
                    if(mode == Mode.DRAW) {
                        Point startP = e.getPoint();
                        startPointArr.add(startP);
                        lineColorArr.add(color);
                        selectLineNum = lineColorArr.size() - 1;
                    }
                    if(mode == Mode.MOVE) {
                        if (isOnLine(e.getPoint())) {
                            prevPt = e.getPoint();
                            line_number.setText(selectLineNum.toString());
                        }
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if(mode == Mode.MOVE) {
                        if (prevPt != null) {
                            int dx = e.getX() - prevPt.x;
                            int dy = e.getY() - prevPt.y;

                            startPoint.translate(dx, dy);
                            endPoint.translate(dx, dy);
                            prevPt = e.getPoint();
                            repaint();
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(mode == Mode.DRAW) {
                        Point endP = e.getPoint();
                        endPointArr.add(endP);
                        repaint();
                    }
                    if(mode == Mode.MOVE) {
                        prevPt = null;
                    }
                }

                private boolean isOnLine(Point p) {
                    for(int i = 0; i < startPointArr.size(); i++) {
                        startPoint = startPointArr.get(i);
                        endPoint = endPointArr.get(i);
                        selectLineNum = i;

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

            // MOVE 전용
            if(!startPointArr.isEmpty()) g2.setColor(lineColorArr.get(selectLineNum));
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

    class SouthPanel extends JPanel {

        public SouthPanel() {
            setBackground(Color.GRAY);
            if(mode == Mode.DRAW) {
                add(point1_label);
                add(x1);
                add(y1);
                add(point2_label);
                add(x2);
                add(y2);
                add(draw);


            }
            else if(mode == Mode.MOVE) {
                add(line_number_label);
                add(line_number);
                add(line_move_label);
                add(x3);
                add(y3);
                add(move);
            }
        }
    }

    class ButtonDrawLineActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = Mode.DRAW;
            container.remove(2);
            container.add(new SouthPanel(), BorderLayout.SOUTH);
            container.revalidate();
        }
    }

    class ButtonMoveLineActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = Mode.MOVE;
            container.remove(2);
            container.add(new SouthPanel(), BorderLayout.SOUTH);
            container.revalidate();
        }
    }

    class ButtonColorActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            color = JColorChooser.showDialog(container, "Select line color", colorPrev);
            colorPrev = color;
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

    class MoveActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int dx = Integer.parseInt(x3.getText());
            int dy = Integer.parseInt(y3.getText());

            selectLineNum = Integer.parseInt(line_number.getText());
            startPoint = startPointArr.get(selectLineNum);
            endPoint = endPointArr.get(selectLineNum);

            startPoint.translate(dx, dy);
            endPoint.translate(dx, dy);

            repaint();
        }
    }

    public static void main(String[] args) {
        new DrawingGUI();
    }
}
