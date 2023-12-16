import java.util.Vector;

public class Vector3 {
    public static void printVector(Vector<Integer> v) {
        for(int i = 0; i < v.size(); i++) {
            int n = v.get(i);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        v.add(1);
        v.add(10);
        v.add(100);

        printVector(v);
    }

}
