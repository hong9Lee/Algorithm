package codingTest.hash.numberlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 전화번호 목록
 # 큰 값부터 잘라서 비교
 https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(result);
    }


    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int minLen = phone_book[phone_book.length - 1].length();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(i, phone_book[i]);
        }


        for (int i = 0; i < map.size(); i++) {
            String val = map.get(i);

            for (int j = minLen; j < val.length(); j++) {
                if(map.containsValue(val.substring(0, j))) return false;
            }
        }
        return true;
    }

}
