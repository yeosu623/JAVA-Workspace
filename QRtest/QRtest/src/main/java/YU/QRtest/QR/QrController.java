package YU.QRtest.QR;

import com.google.gson.JsonObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QrController {

    public String jsonToStringExample(){
        String key1 = "신한카드";
        String value1 = "정수열";

        String key2 = "Card Number";
        String value2 = "9999-0000-1111-2222";

        String key3 = "Expire Date";
        String value3 = "2024/05/02";

        JsonObject obj =new JsonObject();

        obj.addProperty(key1, value1);
        obj.addProperty(key2, value2);

        JsonObject data = new JsonObject();

        data.addProperty(key3, value3);

        obj.add("Internal Data", data);

        System.out.println(obj);

        return obj.toString();
    }

    @GetMapping("/qr/code")
    public ResponseEntity<byte[]> QRCode() throws WriterException, IOException {
        // QR 정보
        int width = 200;
        int height = 200;
        String url = jsonToStringExample();

        // 한글 설정
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // QR Code - BitMatrix: qr code 정보 생성
        BitMatrix encode = new MultiFormatWriter()
                .encode(url, BarcodeFormat.QR_CODE, width, height, hints);

        // QR Code - Image 생성. : 1회성으로 생성해야 하기 때문에
        // stream으로 Generate(1회성이 아니면 File로 작성 가능.)
        try {
            //output Stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            //Bitmatrix, file.format, outputStream
            MatrixToImageWriter.writeToStream(encode, "PNG", out);

            // QR code 커스터마이징
            //MatrixToImageConfig custom = new MatrixToImageConfig(MatrixToImageConfig.BLACK, -1);

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(out.toByteArray());

        }catch (Exception e){System.out.println("Exception 발생 : " + e);}

        return null;
    }
}
