
class A {
    int a, b;
    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int get() {
        return a+b;
    }
}

class B extends A {
    int t;
    public B(int t) {
        super(t, t+1);
    }

    public int get() {
        return t*t;
    }
}
public class Main2 {
    public static void main(String[] args) {
        A a = new B(3);
    }
}

