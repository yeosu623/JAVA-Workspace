import javax.swing.*;
import java.awt.*;

public class Component2 extends JFrame {
    public Component2() {
        setTitle("레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 문자열 레이블 생성
        JLabel textLabel = new JLabel("사랑합니다.");

        // 이미지 레이블 생성
        ImageIcon beauty = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample_image.png");
        JLabel imageLabel = new JLabel(beauty);

        ImageIcon normalIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample_image.png");
        JLabel label = new JLabel("보고 싶으면 전화하세요", normalIcon, SwingConstants.CENTER);

        c.add(textLabel);
        c.add(imageLabel);
        c.add(label);

        setSize(400, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Component2();
    }
}
