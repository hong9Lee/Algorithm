package codingTest.diskcontroller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        for (int[] job : jobs) {
            queue.offer(job);
        }


        int size = queue.size();
        int answer = 0;
        int post = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            answer += curr[1] + post - curr[0];
            post = curr[1] + post;
        }

        return (answer) / size;
    }





    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println("result = " + result);
    }
}
