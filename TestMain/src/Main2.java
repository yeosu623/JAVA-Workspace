import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {

    // 2차원 ArrayList를 String으로 변환하는 함수
    public static String arrayListToString(ArrayList<ArrayList<String>> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<String> row : arrayList) {
            sb.append(String.join(",", row));
            sb.append(";");
        }
        // 마지막 세미콜론 제거
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    // String을 2차원 ArrayList로 변환하는 함수
    public static ArrayList<ArrayList<String>> stringToArrayList(String str) {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        String[] rows = str.split(";");
        for (String row : rows) {
            ArrayList<String> rowList = new ArrayList<>(Arrays.asList(row.split(",")));
            arrayList.add(rowList);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        // 예제 2차원 ArrayList
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>(Arrays.asList("a", "b", "c")));
        arrayList.add(new ArrayList<>(Arrays.asList("d", "e", "f")));
        arrayList.add(new ArrayList<>(Arrays.asList("g", "h", "i")));

        // ArrayList를 String으로 변환
        String str = arrayListToString(arrayList);
        System.out.println("ArrayList to String: " + str);

        // String을 ArrayList로 변환
        ArrayList<ArrayList<String>> convertedArrayList = stringToArrayList(str);
        System.out.println("String to ArrayList: " + convertedArrayList);
        System.out.println(convertedArrayList.get(0).get(1));
    }
}
