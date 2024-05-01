class AAA {
    int a;
    public AAA(int a) {
        this.a = a;
    }

    public int geta() {
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        AAA aaa = null;
        System.out.println(aaa.geta());
    }
}
