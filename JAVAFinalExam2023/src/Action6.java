import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Action6 extends JFrame {
    private JLabel[] keyMessage; // 3개의 메시지를 출력할 레이블 컴포넌트 배열

    public Action6() {
        setTitle("keyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.addKeyListener(new MyKeyListener());



        keyMessage = new JLabel[3];
        keyMessage[0] = new JLabel(" getKeyCode() ");
        keyMessage[1] = new JLabel(" getKeyChar() ");
        keyMessage[2] = new JLabel(" getKeyText() ");

        for(int i = 0; i < keyMessage.length; i++) {
            c.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.YELLOW);
        }

        setSize(300, 150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 키 코드 알아내기
            char keyChar = e.getKeyChar(); // 키 문자값 알아내기
            String keyText = e.getKeyText(keyCode);

            keyMessage[0].setText(Integer.toString(keyCode)); // 키코드 출력
            keyMessage[1].setText(Character.toString(keyChar)); // 키 문자 출력
            keyMessage[2].setText(keyText); // 키 문자열 출력
        }
    }

    public static void main(String[] args) {
        new Action6();
    }
}
