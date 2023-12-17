import javax.swing.*;
import java.awt.*;

public class Paint9 extends JFrame {
    private MyPanel panel = new MyPanel();

    public Paint9() {
        setTitle("클리핑 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);
        setSize(300, 400);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\aaa.png");
        private Image img = icon.getImage();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setClip(100, 20, 150, 150);

            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.ITALIC, 40));

            g.drawString("Go Gator!!", 10, 150);
        }
    }

    public static void main(String[] args) {
        new Paint9();
    }
}
