import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action2 extends JFrame {
    public Action2() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener2());
        c.add(btn);

        setSize(350, 150);
        setVisible(true);
    }

    // 내부 클래스로 만들기
    private class MyActionListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            if (b.getText().equals("Action")) {
                b.setText("액션");
            }
            else {
                b.setText("Action");
            }
        }
    }

    public static void main(String[] args) {
        new Action2();
    }
}
