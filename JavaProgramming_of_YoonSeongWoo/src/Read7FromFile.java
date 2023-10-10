import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class Read7FromFile {
    public static void main(String[] args) {
        try(InputStream in = new FileInputStream("data.txt")) {
            int dat = in.read();
            System.out.println(dat);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
