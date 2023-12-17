import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream1 {
    public static void main(String[] args) {
        byte b[] = {7, 51, 3, 4, -1, 24};

        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\yeosu\\Desktop\\test.out");

            for(int i = 0; i < b.length; i++)
                fout.write(b[i]);

            fout.close();
        }
        catch(IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
