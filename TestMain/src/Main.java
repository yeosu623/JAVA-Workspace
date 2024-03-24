// 21911981 정수열
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        ArrayList<Integer> v = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int b = Integer.parseInt(st.nextToken());
            v.add(b);
        }

        HashSet<Integer> set = new HashSet<>(v);
        ArrayList<Integer> w = new ArrayList<>(set);
        Collections.sort(w);

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < w.size(); i++) {
            indexMap.put(w.get(i), i);
        }

        for (int n : v) {
            bw.write(indexMap.get(n) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
