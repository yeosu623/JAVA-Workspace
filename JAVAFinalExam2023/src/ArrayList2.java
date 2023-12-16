import java.util.Iterator;
import java.util.Vector;

public class ArrayList2 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        v.add(3);
        v.add(5);
        v.add(7);

        Iterator<Integer> it = v.iterator();
        while(it.hasNext()) {
            int n = it.next();
            System.out.println(n);
        }
    }
}
