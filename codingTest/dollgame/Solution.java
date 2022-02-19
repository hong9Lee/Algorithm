package codingTest.dollgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/64061
public class Solution {
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int m : moves) {
            m -= 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][m] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][m]){
                        stack.pop();
                        answer += 2;

                    } else {
                        stack.push(board[i][m]);
                    }


                    board[i][m] = 0;
                    break;
                }else {
                    continue;
                }
            }
        }

        return answer;
    }



    public static void main(String[] args) {

        Solution s = new Solution();
        int result = s.solution(new int[][]
        {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        }
        , new int[] {1,5,3,5,1,2,1,4});

        System.out.println("result = " + result);
    }
}
