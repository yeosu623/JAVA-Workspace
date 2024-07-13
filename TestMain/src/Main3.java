import java.util.ArrayList;
import java.util.Arrays;

public class Main3 {

    // ArrayList<String>을 String으로 변환하는 함수
    public static String arrayListToString(ArrayList<String> list) {
        return String.join(",", list);
    }

    // String을 ArrayList<String>으로 변환하는 함수
    public static ArrayList<String> stringToArrayList(String str) {
        // 빈 문자열이 들어오는 경우를 처리하기 위해 빈 ArrayList를 반환
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        String[] items = str.split(",");
        return new ArrayList<>(Arrays.asList(items));
    }

    public static void main(String[] args) {
        // 예제 사용법
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // ArrayList -> String
        String str = arrayListToString(list);
        System.out.println("ArrayList to String: " + str);

        // String -> ArrayList
        ArrayList<String> newList = stringToArrayList(str);
        System.out.println("String to ArrayList: " + newList);
    }
}
