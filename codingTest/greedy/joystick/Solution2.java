package codingTest.greedy.joystick;

import java.util.ArrayList;

// https://programmers.co.kr/learn/courses/30/lessons/42860
public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int result = s.solution("JAB");
        System.out.println(result);
    }

    static public int solution(String name) {
        int answer = 0;

        int len = name.length();

        //최대로 가질 수 있는 min값은 끝까지 가는것
        int min_move = len-1;

        for(int i=0; i<len; i++) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            //좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
            int next = i+1;// 현재 다음 위치부터
            //내 다음이 A라면 계속 NEXT++
            while(next<len && name.charAt(next) == 'A')
                next++;

            min_move = Math.min(min_move, i+len-next + i);
        }//for

        answer += min_move;

        return answer;
    }



}
