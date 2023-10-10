public abstract class House {
    public void methodOne() {
        System.out.println("method one");
    }

    public abstract void methodTwo();
}

class ThisIsMain {
    public static void main(String[] args) {
        House h1; // OK
        // House h2 = new House(); // ERROR

        // h1.methodOne(); // 당연히 이것도 불가.
    }
}
