package codingTest.full_search.carpet_fullsearch;

// 완전탐색
// https://programmers.co.kr/learn/courses/30/lessons/42842
public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;
        for (int i = 1; i <= area; i++) {
            int row = i; // 세로
            int col = area / row; // 가로

            if(row > col) continue;

            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
        return answer;
    }




    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(8, 1);
        System.out.println("solution = " + solution);
    }
}
