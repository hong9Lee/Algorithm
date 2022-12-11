package codingTest.keypad;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class Solution {


    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int left = 10, right= 12;
        int L_this, R_this;
        for (int n : numbers) {
            L_this = 0; R_this = 0;

            if (n == 1 || n == 4 || n == 7) {
                left = n;
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                right = n;
                sb.append("R");
            } else {

                if(n == 0) n = 11;
//                L_this = n - left;
//                R_this = n - right;
                L_this = (Math.abs(n-left))/3 + (Math.abs(n-left))%3;
                R_this = (Math.abs(right-n))/3 + (Math.abs(right-n))%3;

                if (L_this > R_this) {
                    right = n;
                    sb.append("R");
                } else if (L_this < R_this) {
                    left = n;
                    sb.append("L");
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = n;
                    }else {
                        sb.append("L");
                        left = n;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println("result = " + result);
    }
}
