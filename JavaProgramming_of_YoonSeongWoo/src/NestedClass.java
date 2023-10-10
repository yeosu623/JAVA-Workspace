import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AnonymousComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ROBOT");
        list.add("APPLE");
        list.add("BOX");

        // 앞의 Comparator<String> cmp
        // Comparator 인터페이스형 참조변수 cmp를 선언한다.

        // 뒤의 new Comparator<String>()
        // Comparator 인터페이스를 구현한 익명 클래스의 인스턴스를 생성한다.
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        /*
        Printalbe p = new Printable() {
            public void print() {
                System.out.println(con);
            }
        }
         */

        Collections.sort(list, cmp);
        System.out.println(list);
    }
}