package programmers.stackAndQueue.printer;

import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42587
public class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            qu.add(priorities[i]);
        }

        int k = 0;
        while (!qu.isEmpty()) {
            if (k == location) {
                qu.poll();
                qu.add(0);
                continue;
            }

            int p = qu.poll();
            int ret = Integer.MAX_VALUE;
            int qqq = qu.peek();
            while (true) {
                if (p < qqq) {
                    ret = p;
                    qu.add(p);
                    break;
                }
            }

            if (ret == 0) break;
            k++;
        }


        int answer = k;
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{2,1,3,2}, 2);
    }
}
