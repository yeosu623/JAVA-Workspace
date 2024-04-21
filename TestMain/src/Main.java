// 21911981 정수열
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++)
            for(int j = 1; j <= s.length() - i; j++)
                set.add(s.substring(i, i+j));

        System.out.println(set.size());
    }
}
