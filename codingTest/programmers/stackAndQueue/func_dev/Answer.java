package programmers.stackAndQueue.func_dev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Answer {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }

        List<Integer> numList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            numList.add(cnt);

        }


        return numList.stream().mapToInt(Integer::intValue).toArray();

    }







    public static void main(String[] args) {
        Answer solution = new Answer();

        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
//      solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}
