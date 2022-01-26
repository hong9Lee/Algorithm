package func_dev;

import java.util.LinkedList;
import java.util.Queue;

/** 카카오 level2 기능개발 문제 */
public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> pQueue = new LinkedList<>();
        for (int progress : progresses) {
            pQueue.add(progress);
        }

        Queue<Integer> sQueue = new LinkedList<>();
        for (int speed : speeds) {
            sQueue.add(speed);
        }

        int index = 0;
        int count = 0;
        int i = 1;
        int[] answer = new int[pQueue.size()];
        int queueSize = pQueue.size();


        int flag = 0;
        // 95, 90, 99, 99, 80, 99           1,1,1,1,1

        int p = pQueue.peek(); // 95
        int s = sQueue.peek(); // 1

        Integer p_pop = 100 - p; // 5
        int calc = p_pop / s; //   5/1 => 5
        while(true) {

            if(i == queueSize){
                answer[index] = count;
                answer[index+1] = 1;
                break;
            }

            if( (calc * s + p) >= 100) {
                count++;



                pQueue.poll();
                sQueue.poll();



                p = pQueue.peek();
                s = sQueue.peek();

            }
            else {

                answer[index] = count;

                p_pop = 100 - p;
                calc = p_pop / s;



                pQueue.poll();
                sQueue.poll();

                count = 1;
                index++;
            }
            i++;

        }


        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        Queue<Integer> pQueue = new LinkedList<>();
//        pQueue.add(1);
//        pQueue.add(2);
//        pQueue.add(3);
//
//        if(pQueue.poll() == null) System.out.println("!");
//        if(pQueue.poll() == null) System.out.println("@");
//        if(pQueue.poll() == null) System.out.println("#");
//        if(pQueue.poll() == null) System.out.println("%%");

        System.out.println("@@");
//        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

}
