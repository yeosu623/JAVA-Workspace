import javax.swing.*;
import java.awt.*;

public class Component6 extends JFrame {
    public Component6() {
        setTitle("라디오버튼 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon cherryIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample1.png");
        ImageIcon selectedCherryIcon = new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample2.png");

        // ratio button 생성
        ButtonGroup g = new ButtonGroup();

        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배", true);
        JRadioButton cherry = new JRadioButton("체리", cherryIcon);
        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(selectedCherryIcon);

        g.add(apple);
        g.add(pear);
        g.add(cherry);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Component6();
    }
}
