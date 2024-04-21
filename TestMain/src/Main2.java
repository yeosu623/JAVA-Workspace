import java.util.HashMap;

public class Main2 {
    public static void main(String[] args) {

        HashMap<String, String> h1 = new HashMap<>();
        h1.put("aaa", "1111");
        h1.put("bbb", "2222");
        h1.put("ccc", "3333");

        System.out.println(h1.get("ddd"));
    }
}

