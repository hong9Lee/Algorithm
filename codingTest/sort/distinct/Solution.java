package codingTest.sort.distinct;

import java.util.ArrayList;
import java.util.HashSet;

// https://app.codility.com/programmers/lessons/6-sorting/distinct/start/
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[]{2, 1, 1, 2, 3, 1});
        System.out.println("result = " + result);
    }

    public int solution(int[] A) {
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : A) {
            if (list.size() != 0 && list.contains(i)) continue;
            list.add(i);
        }

        return list.size();
         */

        HashSet<Integer> set = new HashSet<>();

        for (int i : A) {
            set.add(i);
        }
        return set.size();
    }
}
