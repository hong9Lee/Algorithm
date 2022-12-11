package programmers.lotto;

import java.util.ArrayList;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        boolean b = Arrays.stream(lottos).anyMatch(x -> x != 0);
        if(!b) return new int[] {1, 6}; // 전부 0

        ArrayList<Integer> intArr = new ArrayList<>();
        int zeroVal = 0;
        for (int i : lottos) {
            if (i != 0) {
                intArr.add(i);
                continue;
            }
            zeroVal++;
        }

        // 0이 없는 경우
        if(zeroVal == 0) {
            // 전부 같다면
            if (Arrays.stream(lottos).sum() == Arrays.stream(win_nums).sum()) {
                return new int[] {1, 1};
            }

            // 전부 같지 않다면 -> 일치하는 숫자만큼 리턴
            int posNum = getPositiveNum(intArr, win_nums);
            return new int[] {getCase(posNum), getCase(posNum)};
        }

        // 전부다 0이 아니면서 존재하는 경우 -> 0의 갯수 최대최소 + 일치하는갯수
        int posNum = getPositiveNum(intArr, win_nums);
        return new int[] {getCase(zeroVal+posNum), getCase(posNum)};
    }

    public int getCase (int num) {

        if(num == 2) return 5;
        else if(num == 3) return 4;
        else if(num == 4) return 3;
        else if(num == 5) return 2;
        else if(num == 6) return 1;

        return 6;
    }

    public int getPositiveNum(ArrayList<Integer> intArr,int[] win_nums){
        int count = 0;
        for (int i : intArr) {
            if(Arrays.stream(win_nums).anyMatch(x -> x == i)) count++;
        }

        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});

//        int[] solution1 = solution.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(solution1);
    }


}
