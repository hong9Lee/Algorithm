package codingTest.greedy.joystick;

import java.util.ArrayList;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42860
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution("BBAABB");
        System.out.println(result);
    }


    public int solution(String name) {
        int len = name.length();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(65);
        }

        ArrayList<Integer> cList = new ArrayList<>();
        char[] charList = name.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            cList.add((int) charList[i]);
        }


        int fAnswer = 0;
        int bAnswer = 0;

        // 앞에서 탐색
        for (int i = 0; i < cList.size(); i++) {
            if(isEqual(list, cList)) break; // 원본하고 같은가?
            else {
                if (i != 0) {
                    fAnswer += 1;
                }
                list.set(i, cList.get(i));
                fAnswer += getAscii(cList.get(i), 65);
            }
        }


        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list2.add(65);
        }

        // 뒤에서 탐색
        Integer firstVal = cList.get(0);
        if (firstVal != 65) bAnswer += getAscii(firstVal, 65);
        cList.remove(0);
        list2.remove(0);

        for (int i = cList.size() - 1; i >= 0; i--) {
            if(isEqual(list2, cList)) break; // 원본하고 같은가?
            else {
                bAnswer += 1;
                list2.set(i, cList.get(i));
                bAnswer += getAscii(cList.get(i), 65);
            }
        }


        return Math.min(fAnswer, bAnswer);
    }

    public Integer getAscii(Integer a, Integer b) {
        if (a >= 77) return 90 - a + 1;
        return a - b;
    }

    public boolean isEqual(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) != b.get(i)) return false;
        }
        return true;
    }

}
