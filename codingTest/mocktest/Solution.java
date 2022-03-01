package codingTest.mocktest;

import java.util.Arrays;

// 완전탐색
// https://programmers.co.kr/learn/courses/30/lessons/42840
public class Solution {

    public int[] solution(int[] answers) {

        int[] num1 = resetArr(new int[]{1, 2, 3, 4, 5}, answers);
        int[] num2 = resetArr(new int[]{2, 1, 2, 3, 2, 4, 2, 5},answers);
        int[] num3 = resetArr(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5},answers);


        int num1Result = 0;
        for (int i = 0; i < num1.length; i++) {
            if(num1[i] == answers[i]) num1Result++;
        }


        int num2Result = 0;
        for (int i = 0; i < num2.length; i++) {
            if(num2[i] == answers[i]) num2Result++;
        }


        int num3Result = 0;
        for (int i = 0; i < num3.length; i++) {
            if(num3[i] == answers[i]) num3Result++;
        }







        int[] answer = {};
        return answer;
    }

    public int[] resetArr(int[] arr, int[] ret) {
        if(arr.length > ret.length) return Arrays.copyOfRange(arr,0, ret.length);
        return arr;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new int[]{1, 2, 3, 4, 5});
        System.out.println("result = " + result);
    }
}
