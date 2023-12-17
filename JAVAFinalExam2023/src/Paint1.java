import javax.swing.*;
import java.awt.*;

public class Paint1 extends JFrame {
    private MyPanel panel = new MyPanel();

    public Paint1() {
        setTitle("JPanel의 paintComponent() 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel); // 생성한 panel 패널을 컨탠트 팬으로 사용
        setSize(250, 200);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLUE);
            g.drawRect(10, 10, 50, 50);
            g.drawRect(50, 50, 50, 50);

            g.setColor(Color.MAGENTA);
            g.drawRect(90, 90, 50, 50);
        }
    }

    public static void main(String[] args) {
        new Paint1();
    }
}
