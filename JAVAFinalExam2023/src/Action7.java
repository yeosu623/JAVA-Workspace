import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Action7 extends JFrame {
    private JLabel la = new JLabel();

    public Action7() {
        setTitle("Key Code 예제 : F1키:초록색, %키:노란색");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.addKeyListener(new MyKeyListener2());
        c.add(la);

        setSize(300, 150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    class MyKeyListener2 extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            Container contentPane = (Container)e.getSource();

            la.setText(e.getKeyText(e.getKeyCode()) + "키가 입력되었음");

            if(e.getKeyChar() == '%')
                contentPane.setBackground(Color.YELLOW);
            else if(e.getKeyCode() == KeyEvent.VK_F1)
                contentPane.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new Action7();
    }
}
