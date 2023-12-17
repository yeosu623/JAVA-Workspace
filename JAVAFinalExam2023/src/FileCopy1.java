import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy1 {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\yeosu\\Desktop\\test.txt");
        File dest = new File("C:\\Users\\yeosu\\Desktop\\folder\\test.txt");

        int c;
        try {
            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(dest);

            while((c = fr.read()) != -1) {
                fw.write((char)c);
            }

            fr.close();
            fw.close();

            System.out.println(src.getPath()+ "를\n" + dest.getPath() + "로 복사하였습니다.");
        }
        catch(IOException e) {
            System.out.println("파일 복사 오류");
        }
    }
}
