// 21911981 정수열
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            String compare = phone_book[i];
            String target = phone_book[i+1];

            if(compare.length() <= target.length())
                if(target.substring(0, compare.length()).equals(compare))
                    return false;
        }

        return true;
    }
}