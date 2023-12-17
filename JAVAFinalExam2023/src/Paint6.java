import javax.swing.*;
import java.awt.*;

public class Paint6 extends JFrame {
    private MyPanel panel = new MyPanel();

    public Paint6() {
        setTitle("원본 크기로 원하는 위치에 이미지 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);
        setSize(300, 420);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        ImageIcon icon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample1.png");
        Image img = icon.getImage();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(img, 20, 20, this);
        }
    }

    public static void main(String[] args) {
        new Paint6();
    }
}
