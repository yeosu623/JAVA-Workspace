import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream2 {
    public static void main(String[] args) {
        byte b[] = new byte[6];

        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\yeosu\\Desktop\\test.out");

            int n = 0, c;
            while((c = fin.read()) != -1) {
                b[n] = (byte)c;
                n++;
            }

            for(int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            }

            fin.close();

        } catch(IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
