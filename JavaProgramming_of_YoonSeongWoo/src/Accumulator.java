public class Accumulator {
    static int result = 0;

    static void add(int i) {
        result += i;
    }

    static void showResult() {
        System.out.println("result = " + result);
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++)
            Accumulator.add(i); // 인자로 전달되는 값을 모두 누적 (0~9 누적하므로 45가 된다.)
        Accumulator.showResult(); // 최종 누적 결과를 출력
    }
}
