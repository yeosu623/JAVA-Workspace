class SimpleBox {
    private int data;

    SimpleBox(int data) {
        // this가 변수에 쓰이면 "이 인스턴스의 변수"를 뜻한다.
        this.data = data;
    }

    void printData() {
        System.out.println("data : " + data);
    }
}

class SimpleBoxMain {
    public static void main(String[] args) {
        SimpleBox sb = new SimpleBox(5);

        sb.printData();
    }
}