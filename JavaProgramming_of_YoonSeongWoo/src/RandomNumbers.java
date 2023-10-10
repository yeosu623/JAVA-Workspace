import java.util.Random;
import java.util.Scanner;

class RandomNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("난수 생성의 시작 범위 : ");
        int a = sc.nextInt();
        System.out.print("난수 생성의 끝 범위 : ");
        int z = sc.nextInt();

        System.out.println("난수 생성 결과 : ");
        Random rand = new Random();
        int num;
        for(int i=0; i<10; i++) {
            num = a + rand.nextInt(z - a + 1); // a ~ z 사이의 난수 반환
            System.out.print(num + " ");
        }
    }
}