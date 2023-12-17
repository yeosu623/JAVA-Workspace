import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action3 extends JFrame {
    public Action3() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");
        c.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                if (b.getText().equals("Action")) {
                    b.setText("액션");
                }
                else {
                    b.setText("Action");
                    setTitle(b.getText());
                }
            }
        });

        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Action3();
    }
}
