import java.util.*;

public class HW0101 {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++)
            for(int j = 0; j < numbers.length; j++)
            {
                if(i == j) continue;
                else set.add(numbers[i] + numbers[j]);
            }

        int[] answer = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String args[])
    {
        HW0101 hw0101 = new HW0101();
        hw0101.solution(null);
    }
}
