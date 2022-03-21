package codingTest.hash.nplayer;

import java.util.*;

/**
 완주하지 못한 선수 - 해시

 https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println(result);
    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i]) + 1);
                continue;
            }
            map.put(participant[i], 1);
        }



        for (String s : completion) {
            if(map.containsKey(s)) {
                if (map.get(s) == 1) map.remove(s);
                else {
                    map.put(s, map.get(s) - 1);
                }
            } else {
                return s;
            }
        }

        return map.keySet().toArray()[0].toString();
    }
}
