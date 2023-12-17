import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy3 {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\yeosu\\Desktop\\sample_image.png");
        File dest = new File("C:\\Users\\yeosu\\Desktop\\folder\\sample_image.png");

        try {
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);

            byte[] buf = new byte[1024 * 10]; // 한번에 10KB씩 블록 단위로 고속 복사

            while(true) {
                int n = fi.read(buf); // 읽은 데이터는 buf에 저장. 반환값은 실제 읽은 바이스 반환
                fo.write(buf, 0, n); // buf[0]부터 n바이트 쓰기

                if(n < buf.length)
                    break;
            }
            fi.close();
            fo.close();
            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
        }
        catch(IOException e) {
            System.out.println("파일 복사 오류");
        }
    }
}
