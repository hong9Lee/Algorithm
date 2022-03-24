package codingTest.codility.counting_elem.permCheck;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{4, 1, 3, 2});
        System.out.println(result);

    }

    public int solution(int[] A) {
        Arrays.sort(A);
        if(A[A.length - 1] == A.length) return 1;
        return 0;
    }

}
