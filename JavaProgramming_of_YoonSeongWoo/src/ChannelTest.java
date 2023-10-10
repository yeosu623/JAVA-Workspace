import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.READ;

class ChannelTest {
    public static void main(String[] args) {
        Path src = Path.of("source.txt");
        Path dst = Path.of("destination.txt");

        // 하나의 버퍼 생성
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // try에서 두 개의 채널 생성
        try(FileChannel ifc = FileChannel.open(src, StandardOpenOption.READ);
            FileChannel ofc = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            int num;
            while(true) {
                num = ifc.read(buf); // 채널 ifc에서 버퍼로 읽어 들임
                if(num == -1) // 읽어 들인 데이터가 없다면
                    break;

                buf.flip(); // 모드 변환
                ofc.write(buf); // 버퍼에서 채널 ofc로 데이터 전송
                buf.clear();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}