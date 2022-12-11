package codingTest.greedy.gymsuit;


// https://programmers.co.kr/learn/courses/30/lessons/42862
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int n = 5;
        int result = s.solution(n, lost, reserve);
        System.out.println("result = " + result);

    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        int answer = n;

        for (int i : lost) {
            students[i - 1]--;
        }

        for (int j : reserve) {
            students[j - 1]++;
        }


        for (int i = 0; i < students.length; i++) {
            if (students[i] == -1) {
                if (i-1 >= 0 && students[i-1] == 1) {
                    students[i]++;
                    students[i - 1]--;
                } else if (i+1 < students.length && students[i + 1] == 1) {
                    students[i]++;
                    students[i + 1]--;
                } else {
                    answer--;
                }
            }
        }



        return answer;
    }
}
