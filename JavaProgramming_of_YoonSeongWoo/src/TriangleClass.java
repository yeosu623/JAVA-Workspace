class TriangleClass {
    double base;
    double height;

    public TriangleClass(double b, double h) {
        base = b;
        height = h;
    }

    public void inputBase(double b) {
        base = b;
    }

    public void inputHeight(double h) {
        height = h;
    }

    public double calcArea() {
        return base * height / 2;
    }
}

class TriangleClassTestCode {
    public static void main(String[] args) {
        TriangleClass tc = new TriangleClass(3.0, 3.0);

        tc.inputBase(5.0);
        tc.inputHeight(5.0);
        double area = tc.calcArea();
        System.out.println("넓이 : " + area);
    }
}