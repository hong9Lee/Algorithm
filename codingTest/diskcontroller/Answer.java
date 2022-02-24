package codingTest.diskcontroller;

import java.util.*;

public class Answer {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        int answer = 0;
        int count = 0;
        int now = 0;

        int i = 0;

        // TODO
        while(count < jobs.length){
            while (i< jobs.length && jobs[i][0] <= now){
                queue.add(jobs[i++]);
            }

            if(queue.isEmpty()){
                now = jobs[i][0];
            }else{
                int[] tmp = queue.poll();
                answer += tmp[1] + now - tmp[0];
                now += tmp[1];
                count++;
            }
        }


        return answer / jobs.length;

    }

    public static void main(String[] args) {
        Answer s = new Answer();
        int result = s.solution(new int[][]{{1, 9}, {2, 6}, {0, 3}});
        System.out.println("result = " + result);
    }





}
