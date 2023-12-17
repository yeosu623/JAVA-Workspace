import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Component11 extends JFrame {
    String[] fruits = {"apple", "banana", "kiwi", "mango"};

    ImageIcon[] images = {
            new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample1.png"),
            new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample2.png"),
            new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample3.png"),
            new ImageIcon("C:\\Users\\yeosu\\Pictures\\sample4.png")};

    JLabel imgLabel = new JLabel(images[0]); // 이미지 레이블에 사과 이미지
    JComboBox<String> strCombo = new JComboBox<String>(fruits);

    public Component11() {
        setTitle("콤보박스 활용 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(strCombo);
        c.add(imgLabel);

        strCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>)e.getSource();

                int index = cb.getSelectedIndex();
                imgLabel.setIcon(images[index]);
            }
        });

        setSize(300, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Component11();
    }
}
