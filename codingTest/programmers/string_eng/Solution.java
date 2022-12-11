package codingTest.string_eng;

// 숫자 문자열과 영단어 https://programmers.co.kr/learn/courses/30/lessons/81301
public class Solution {

    public int solution(String s) {
        char[] chArr = s.toCharArray();

        String result = "";
        StringBuilder sb = new StringBuilder();
        char next = ' ';
        for (int i = 0; i < chArr.length; i++) {
            System.out.println(i);
            if (i + 1 <= chArr.length - 1 ) {
                next = chArr[i + 1];
            } else {
                if (!chkChar(chArr[i])) {
                    sb.append(chArr[i]);
                    break;
                } else {
                    result += chArr[i];
                    sb.append(stringToNum(result));
                }
            }

            if (chkChar(chArr[i])) { // 현재가 문자
                result += chArr[i];
                if (!chkChar(next)) { // 다음이 숫자
                    sb.append(stringToNum(result));
                    sb.append(next);
                    result = "";
                    i++;
                }else{
                    if(stringToNum(result) == null) continue;
                    else {
                        sb.append(stringToNum(result));
                        result = "";
                    }
                }
            }else {
                sb.append(chArr[i]);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public String stringToNum (String str) {

        switch (str) {
            case "zero": return "0";
            case "one": return "1";
            case "two": return "2";
            case "three": return "3";
            case "four": return "4";
            case "five": return "5";
            case "six": return "6";
            case "seven": return "7";
            case "eight": return "8";
            case "nine": return "9";
        }
        return null;
    }

    public boolean chkChar (Character ch) {
        if (Character.isLowerCase(ch)) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        Solution s = new Solution();
//        int result = s.solution("one4seveneight");
//        int result = s.solution("23four5six7");
//        int result = s.solution("2three45sixseven");
        int result = s.solution("123");
        System.out.println("result = " + result);
    }
}
