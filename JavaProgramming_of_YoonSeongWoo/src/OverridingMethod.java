class Cake {
    public void yummy() {
        System.out.println("Yummy Cake");
    }
}

class CheeseCake extends Cake {
    public void yummy() {
        super.yummy(); // 오버라이딩 된 메서드를 호출한다.
        System.out.println("Yummy Cheese Cake");
    }

    public void tasty() {
        super.yummy();
        System.out.println("Yummy Tasty Cake");
    }
}

class OverriddedCakeMain {
    public static void main(String[] args) {
        Cake c = new CheeseCake();

        c.yummy();
    }
}