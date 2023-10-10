/*
class Point implements Cloneable {
    private int xPos;
    private int yPos;

    public Point(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void showPosition() {
        System.out.printf("[%d, %d]", xPos, yPos);
        System.out.println();
    }

    public void changePos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    @Override
    // clone() 메서드의 접근 지시자를 public으로 바꾸어 주기 위해서 overriding을 함.
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // 해당 클래스 자료형의 수준에서만 인스턴스를 복사한다.
    }
}

class Rectangle implements Cloneable {
    private Point upperLeft;
    private Point lowerRight;

    public Rectangle(int x1, int y1, int x2, int y2) {
        upperLeft = new Point(x1, y1);
        lowerRight = new Point(x2, y2);
    }

    public void changePos(int x1, int y1, int x2, int y2) {
        upperLeft.changePos(x1, y1);
        lowerRight.changePos(x2, y2);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Rectangle copy = (Rectangle)super.clone();

        copy.upperLeft = (Point)upperLeft.clone();
        copy.lowerRight = (Point)lowerRight.clone();

        return copy;
    }

    public void showPosition() {
        System.out.print("좌측 상단: ");
        upperLeft.showPosition();

        System.out.print("우측 하단: ");
        lowerRight.showPosition();
        System.out.println();
    }
}

class ShallowCopy {
    public static void main(String[] args) {
        Rectangle org = new Rectangle(1, 1, 9, 9);
        Rectangle cpy;

        try {
            cpy = (Rectangle) org.clone(); // 인스턴스 복사
            org.changePos(2, 2, 7, 7);
            org.showPosition();
            cpy.showPosition();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
*/