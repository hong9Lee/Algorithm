package codingTest.stackAndQueue.brackets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int result = s.solution("{[()()]}");
//        int result = s.solution("([)()]");
        System.out.println("result = " + result);
    }




    public int solution(String S) {
        if(S.length() % 2 != 0) return 0;
        if(S.equals("")) return 1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return 0;

                Character lastC = stack.pop();
//                if(!chkParam(pop,c)) return 0;
                if (c == ')' && lastC != '(') {
                    return 0;
                }

                if (c == '}' && lastC != '{') {
                    return 0;
                }

                if (c == ']' && lastC != '[') {
                    return 0;
                }


            }
        }
        System.out.println();
        if(!stack.isEmpty()) return 0;
        return 1;
    }

    public boolean chkParam(char a, char b) {
        if(a == '[' && b == ']') return true;
        if(a == '{' && b == '}') return true;
        if(a == '(' && b == ')') return true;
        return false;
    }

}
