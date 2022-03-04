package codingTest.stackAndQueue.brackets;

import java.util.ArrayList;
import java.util.Collections;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/start/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution("{[()()]}");
//        int result = s.solution("([)()]");
        System.out.println("result = " + result);
    }

    public int solution(String S) {
        if(S.length() % 2 != 0) return 0;
        if(S.equals("")) return 1;

        char[] chars = S.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }


        if(!chkFreq(list)) return 0;


        int i = 0;
        while (i+1 <= list.size()-1) {
            if (chkChar(list.get(i), list.get(i+1))) {
                list.remove(i + 1);
                list.remove(i);
                i = 0;
            } else {
                i += 1;
            }
        }


        return list.size() > 0 ? 0 : 1;
    }

    public boolean chkChar(char a, char b) {
        if(a == '[' && b == ']') return true;
        if(a == '{' && b == '}') return true;
        if(a == '(' && b == ')') return true;
        return false;
    }

    public boolean chkFreq(ArrayList<Character> list) {
        int a = Collections.frequency(list, '{');
        int b = Collections.frequency(list, '}');
        if(a != b) return false;

        int c = Collections.frequency(list, '[');
        int d = Collections.frequency(list, ']');
        if(c != d) return false;

        int f = Collections.frequency(list, '(');
        int g = Collections.frequency(list, ')');
        if(f != g) return false;

        return true;
    }

}
