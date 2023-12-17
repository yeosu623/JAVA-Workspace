import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMap2 {
    public static void main(String[] args) {
        HashMap<String, Integer> scoreMap = new HashMap<>();

        scoreMap.put("김성동", 97);
        scoreMap.put("황기태", 88);
        scoreMap.put("김남윤", 98);
        scoreMap.put("이재문", 70);
        scoreMap.put("환원선", 99);

        System.out.println("haspMap의 요소 개수 : " + scoreMap.size());

        // 모든 사람의 점수 출력. scoreMap에 들어있는 모든 (key, Value) 쌍 출력
        // key 문자열을 가진 집합 Set 컬렉션 리턴
        Set<String> keys = scoreMap.keySet();

        // key 문자열을 순서대로 접근할 수 있는 Iterator 리턴
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name + ":" + score);
        }
    }
}
