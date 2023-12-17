import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
    public static void main(String[] args) {

        File src = new File("C:\\Users\\yeosu\\Desktop\\sample_image.png");
        File dest = new File("C:\\Users\\yeosu\\Desktop\\folder\\sample_image.png");

        int c;
        try {
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);

            while ((c = fi.read()) != -1) {
                fo.write((byte) c);
            }
            fi.close();
            fo.close();

            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
        } catch (IOException e) {
            System.out.println("파일 복사 오류");
        }
    }
}
