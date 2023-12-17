import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Action10 extends JFrame {
    public Action10() {
        setTitle("Click and DoubleClick 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener4());
        setSize(300, 200);
        setVisible(true);
    }

    class MyMouseListener4 extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 2) {
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);

                Component c = (Component)e.getSource();
                c.setBackground(new Color(r, g, b));
            }
        }
    }

    public static void main(String[] args) {
        new Action10();
    }
}
