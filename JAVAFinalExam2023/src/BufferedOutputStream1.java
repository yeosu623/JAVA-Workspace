import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedOutputStream1 {
    public static void main(String[] args) {
        int c;

        try {
            FileReader fin = new FileReader("C:\\Users\\yeosu\\Desktop\\test.txt");
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);

            while((c = fin.read()) != -1) {
                out.write(c);
            }

            new Scanner(System.in).nextLine();
            out.flush();

            fin.close();
            out.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
