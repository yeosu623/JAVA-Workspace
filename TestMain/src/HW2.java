// 22113637 김민우
import java.util.ArrayList;
import java.util.Scanner;

public class HW2 {

    static int n;
    static int k;

    static void recursion(int count, int number, ArrayList<Integer> arrOrigin) {
        ArrayList<Integer> arrPart;

        count++;
        for(int i = number; i <= n - (k - count); i++) {
            arrPart = new ArrayList<>(arrOrigin);
            arrPart.add(i);

            if(count == k) {
                System.out.print("[");
                for(int j = 0; j < k; j++) {
                    System.out.print(arrPart.get(j));
                    if(j != k-1) System.out.print(", ");
                }
                System.out.print("] ");
            }
            else recursion(count, i+1, arrPart);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 n과 k를 입력? ");
        n = sc.nextInt();
        k = sc.nextInt();

        recursion(0, 1, new ArrayList<>());
    }
}
