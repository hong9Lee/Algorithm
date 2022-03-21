package codingTest.binarysearch.immigration;

import java.util.Arrays;

/**
 @입국심사@

 https://programmers.co.kr/learn/courses/30/lessons/43238
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.solution(6, new int[] {7, 10});
        System.out.println(result);
    }




    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = 0L;
        long start = 1; // 최선
        long end = (long) times[times.length - 1] * n; // 최악

        while(start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }


        }









        return answer;
    }
}
