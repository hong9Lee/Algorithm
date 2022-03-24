package codingTest.codility.counting_elem.FrogRiverOne;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(result);
    }

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                set.add(A[i]);
                if (set.size() == X) return i;
            }

        }
        return -1;
    }
}
