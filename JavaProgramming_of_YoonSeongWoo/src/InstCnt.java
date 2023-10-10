class InstCnt {
    static int instNum = 100; // 클래스 변수의 적절한 초기화 위치.

    InstCnt() {
        instNum++;
        System.out.println("인스턴스 생성 : " + instNum);

        // 클래스 변수는 생성자 기반으로 해서 초기화를 하면 안된다!!!
        // 이유 : 그런 경우에는 인스턴스 생성시마다 값이 리셋될 것이다.
    }
}

class OnlyClassNoInstance {
    public static void main(String[] args) {
        InstCnt.instNum -= 15; // 인스턴스 생성 없이 instNum에 접근.
        System.out.println(InstCnt.instNum);
    }
}