class ContinueBasic {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;

        while((num++) < 100) {
            if(((num % 5) != 0) || ((num % 7) != 0))
                continue;
            count++; // 5와 7의 배수가 동시에 있는 경우만 실행
            System.out.println(num); // 그 숫자를 출력
        }
        System.out.println("count: " + count);
    }
}