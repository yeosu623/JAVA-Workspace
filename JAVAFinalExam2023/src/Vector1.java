import java.util.Vector;

public class Vector1 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(); // 백터 크기 default 10

        v.add(5);
        v.add(4);
        v.add(-1);

        v.add(2, 100); // 4와 -1 사이에 정수 100 삽입

        System.out.println("백터 내의 요소 객체 수 : " + v.size());
        System.out.println("백터의 현재 용량 : " + v.capacity());

        // 모든 요소 정수 출력하기
        for(int i = 0; i < v.size(); i++) {
            int n = v.get(i);
            System.out.println(n);
        }

        // 백터 속의 모든 정수 더하기
        int sum = 0;
        for(int i = 0; i < v.size(); i++) {
            int n = v.elementAt(i); // v.get과 동일
            sum += n;
        }
        System.out.println("백터에 있는 정수 합 : " + sum);
    }
}
