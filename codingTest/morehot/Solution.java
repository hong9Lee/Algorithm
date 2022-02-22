package codingTest.morehot;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// {1, 2, 3, 9, 10, 12}, 7)}
// https://programmers.co.kr/learn/courses/30/lessons/42626
public class Solution {
    public int solution(int[] scoville, int K) {
//        Arrays.sort(scoville); // 오름차순 정렬

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : scoville) {
            if (i <= K) list.add(i);
        }


        // 1. K 보다 큰 값들은 제거
        // 2. 앞의 값을 계산한 후, 전부 비교할 필요는 없다.

        int answer = 0;
        int i = 0;
        while (chkUnderK(list, K)) {

            Collections.sort(list);
            int calc = list.get(i) + list.get(i + 1) * 2;
            list.remove(i);
            list.set(i, calc);

            if (list.size() <= 1) {
                if (list.get(i) <= K) return -1;
                return answer += 1;
            }
            answer += 1;
        }

        return answer == 0 ? -1 : answer;
    }

    public boolean chkUnderK(ArrayList<Integer> scoville, int k) {
        for (int i : scoville) {
            if (i <= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int result = s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
//        int result = s.solution(new int[]{4, 8, 9, 10}, 9);
        int result = s.solution(new int[]{1, 2, 4, 5}, 6);

        System.out.println("result = " + result);
    }
}
