package codingTest.sort.triangle;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[]{10, 2, 5, 1, 8, 20});
        System.out.println("result = " + result);
    }


    public int solution(int[] A) {
        Arrays.sort(A);
        if (A.length < 3) return 0;
        for (int i = 0; i < A.length; i++) {
            if (i + 2 >= A.length) return 0;
            if (A[i] + A[i + 1] > A[i + 2]) return 1;
        }


        return 0;
    }

}
