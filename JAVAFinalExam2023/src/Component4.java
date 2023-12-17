import javax.swing.*;
import java.awt.*;

public class Component4 extends JFrame {
    public Component4() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon cherryIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample1.png");
        ImageIcon selectedCherryIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample2.png");

        // 3개의 체크박스 생성
        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배", true);
        JCheckBox cherry = new JCheckBox("체리", cherryIcon);
        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(selectedCherryIcon);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Component4();
    }
}
