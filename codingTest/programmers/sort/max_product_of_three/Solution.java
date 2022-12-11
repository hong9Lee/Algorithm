package codingTest.sort.max_product_of_three;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[]{-3, 1, 2, -2, 5, 6});
        System.out.println("result = " + result);
    }


    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length - 1;
        int p_max = A[n] * A[n - 1] * A[n - 2];
        int m_max = A[n] * A[0] * A[1];

        return p_max > m_max ? p_max : m_max;
    }
}
