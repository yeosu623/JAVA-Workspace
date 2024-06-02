import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HW2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int part1, part2, part3, part4;
        int len = str.length();

        for(int i = 1; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                for(int k = j + 1; k < len; k++) {
                    part1 = Integer.parseInt(str.substring(0, i));
                    part2 = Integer.parseInt(str.substring(i, j));
                    part3 = Integer.parseInt(str.substring(j, k));
                    part4 = Integer.parseInt(str.substring(k, len));

                    if(part1 <= 255 && part2 <= 255 && part3 <= 255 && part4 <= 255)
                        bw.write(part1 + "." + part2 + "." + part3 + "." + part4 + "\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}