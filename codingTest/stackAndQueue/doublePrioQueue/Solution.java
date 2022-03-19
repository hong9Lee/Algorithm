package codingTest.stackAndQueue.doublePrioQueue;

import java.util.TreeMap;

/**
 이중우선순위큐
 https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s = solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(s);
    }


    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < operations.length; i++) {
            String command = operations[i].split(" ")[0]; // ex) | or D
            Integer num = Integer.parseInt(operations[i].split(" ")[1]); // ex) 7

            // 삭제
            if (command.equals("D") && map.size() != 0) {
                if (num == 1) map = handlingMap(map.lastKey(), map); // 최대값 삭제
                else map = handlingMap(map.firstKey(), map); // 최소값 삭제
                continue;
            }


            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        if(map.size() <= 1) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }

    public TreeMap<Integer, Integer> handlingMap(Integer key, TreeMap<Integer, Integer> map) {

        Integer value = map.get(key);
        if(value > 1) map.put(key, value - 1);
        else map.remove(key);

        return map;
    }


}
