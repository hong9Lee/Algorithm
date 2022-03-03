package codingTest.full_search.mocktest;

import java.util.ArrayList;

// 완전탐색
// https://programmers.co.kr/learn/courses/30/lessons/42840
public class Solution {

    public int[] solution(int[] answers) {

        int[] num1 = new int[]{1, 2, 3, 4, 5};
        int[] num2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int ret1 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(num1[i % num1.length] == answers[i]) ret1++;
        }

        int ret2 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(num2[i % num2.length] == answers[i]) ret2++;
        }

        int ret3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(num3[i % num3.length] == answers[i]) ret3++;
        }



        ArrayList<Integer> list = new ArrayList<>();

        int max = Math.max(Math.max(ret1, ret2), ret3);
        if(ret1 == max) list.add(1);
        if(ret2 == max) list.add(2);
        if(ret3 == max) list.add(3);


        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        System.out.println(7 % 3 +"  "+ 7 / 3);
        Solution s = new Solution();
        int[] result = s.solution(new int[]{1, 2, 3, 4, 5});
        System.out.println("result = " + result);
    }
}
