package codingTest.morehot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// {1, 2, 3, 9, 10, 12}, 7)}
public class Answer {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            if (i < K) queue.offer(i);
        }

        int answer = 0;
        while (!queue.isEmpty()) {

            Integer curr = queue.poll();
            if(curr >= K) break;

            Integer next = queue.poll();

            if (next == null) {
                if (curr < K) return -1;
                return answer;
            }

            queue.offer(curr + next * 2);
            answer += 1;

    }
        return answer == 0 ? -1 : answer;
}


    public static void main(String[] args) {
        Answer s = new Answer();
//        int result = s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
//        int result = s.solution(new int[]{4, 8, 9, 10}, 9);
        int result = s.solution(new int[]{1, 2, 4, 5}, 3);

        System.out.println("result = " + result);
    }
}
