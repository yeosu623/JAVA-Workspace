class NumberPrinter {
    private int myNum = 0;
    // 클래스 변수는 프로그램 내에서 공유하는 변수이다.
    // 클래스 메서드는 프로그램 내에서 공유하는 메서드이다.
    static void showInt(int n) { System.out.println(n);}
    static void showDouble(double n) { System.out.println(n);}

    void setMyNumber(int n) { myNum = n;}
    void showMyNumber() { showInt(myNum); } // 내부 접근
}

class ClassMethod {
    public static void main(String[] args) {
        NumberPrinter.showInt(20); // 외부 접근
        NumberPrinter np = new NumberPrinter();
        np.setMyNumber(75);
        np.showMyNumber();
    }
}