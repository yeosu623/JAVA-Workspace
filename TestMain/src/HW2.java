// 21911981 정수열
import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {
        int[][] cache = new int[1000][1000];
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) cache[i+1][j+1] = cache[i][j] + 1;
                else cache[i+1][j+1] = Math.max(cache[i+1][j], cache[i][j+1]);
            }

        int y = s1.length();
        int x = s2.length();
        String s = "";
        while(cache[y][x] != 0) {
            if(cache[y][x] == cache[y-1][x]) y--;
            else if(cache[y][x] == cache[y][x-1]) x--;
            else {
                s += s1.charAt(y-1);
                y--;
                x--;
            }
        }
        s = new StringBuilder(s).reverse().toString();

        System.out.println(s);
        System.out.println(cache[s1.length()][s2.length()]);
    }
}