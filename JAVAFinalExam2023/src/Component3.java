import javax.swing.*;
import java.awt.*;

public class Component3 extends JFrame {
    public Component3() {
        setTitle("이미지 버튼 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // 3개의 이미지를 파일로부터 읽어들인다.
        ImageIcon normalIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample1.png");
        ImageIcon rolloverIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample2.png");
        ImageIcon pressedIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample3.png");

        // 3개의 이미지를 가진 1개의 버튼 생성
        JButton btn = new JButton("call~~", normalIcon);
        btn.setPressedIcon(pressedIcon);
        btn.setRolloverIcon(rolloverIcon);

        btn.setVerticalAlignment(SwingConstants.BOTTOM);

        c.add(btn);
        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Component3();
    }
}
