class AccessWay {
    static int num = 0;

    AccessWay() { incrCnt(); }
    void incrCnt() {
        num++; // 클래스 내부에서 이름을 통한 접근
    }
}

class ClassVarAccess {
    public static void main(String[] args) {
        AccessWay way = new AccessWay();
        // way.num++; // 외부에서 인스턴스의 이름을 통한 접근. 가급적 사용하지 말 것
        AccessWay.num++; // 외부에서 클래스의 이름을 통한 접근. 권장되는 사용법이다.
        System.out.println("num = " + AccessWay.num);
    }
}