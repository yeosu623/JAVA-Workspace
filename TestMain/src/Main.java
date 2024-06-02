import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

class Cmp implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        else {
            if(s1.length() > s2.length()) return 1;
            else return -1;
        }
    }
}
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeSet<String> words = new TreeSet<>(new Cmp());
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }

        for(String word : words) {
            System.out.println(word);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
