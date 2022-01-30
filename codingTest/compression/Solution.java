package compression;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/60057
// 문자열 압축
public class Solution {

    /**
     * aabbaccc
     * 1 -> 2a2ba3c = 7
     * 2 -> aa bb ac cc = 2a2bac2c = 8
     * 3 -> aab bac cc = 2abbac2c = 8
     * 4 -> aabb accc = 8
     * 5 -> aabba ccc = 8
     * 6 -> aabbac cc = 8
     * 7 -> aabbacc c = 8
     * 8 -> aabbaccc = 8
     */

    public int solution(String s) {

        int a = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            String start = s.substring(0, i);
            for (int j = i; j < s.length(); j += i) {

                if(j + i >= s.length()){
                    String check = s.substring(j, s.length());
                    if (start.equals(check)) {
                        count++;
                        sb.append(count + check);
                    }else {
                        if(count != 1){
                            sb.append(count + start + check);
                        }else{
                            sb.append(start + check);
                        }
                    }
                    break;
                }

                String next = s.substring(j, j+i);

                if (!start.equals(next)){
                    if (count != 1) {
                        sb.append(count + start);
                        count = 1;
                    }else{
                        sb.append(start);
                    }
                } else {
                    count++;
                }

                start = next;
            }

            a = Math.min(a, sb.length());
        }
        return a;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("aabbaccc");
//        solution.solution("aabba");
    }
}
