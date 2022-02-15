package codingTest.newid;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

// 신규 아이디 추천 https://programmers.co.kr/learn/courses/30/lessons/72410
/**
 * 1. 대문자 -> 소문자
 * 2. 소문자, 숫자, -, _, . 제외 전부 제거
 * 3. .. -> .
 * 4. 처음, 끝 . 제거
 *
 * 5. null -> a
 * 6. 16자 이상 -> 15자로 ,,, 마지막에 . 이라면 제거
 * 7. 2자 이하 -> 마지막 문자를 길이가 3 될떄까지 끝에 붙인다.
 */
public class Solution {
    public String solution(String new_id) {

        String low = new_id.toLowerCase();
        CharacterIterator it = new StringCharacterIterator(low);

        char temp = ' ';
        StringBuilder sb = new StringBuilder();
        while (it.current() != CharacterIterator.DONE) {
            if (chkChar(it.current()) && !((it.current() == temp) && temp == '.')) {
                temp = it.current();
                sb.append(it.current());
            }
            it.next();
        }

        if(sb.length() > 1) chkComma(sb, 0);

        chkComma(sb, sb.length()-1);
        if(sb.length() == 0) sb.append("a");
        if(sb.length() >= 15){
            sb.delete(15, sb.length());
            chkComma(sb, sb.length()-1);
        }

        while (sb.length() < 3) {
            sb = sb.append(sb.charAt(sb.length()-1));
        }

        return sb.toString();
    }

    private StringBuilder chkComma(StringBuilder sb, int i) {
        if (sb.charAt(i) == '.') {
            sb.deleteCharAt(i);
            return sb;
        }
        return sb;
    }


    public boolean chkChar (Character ch) {
        if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch.equals('-') || ch.equals('_') || ch.equals('.')) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
//        String solution = s.solution("...!@BaT#*..y.abcdefghijklm");
//        String solution = s.solution("z-+.^.");
//        String solution = s.solution(	"=.=");
//        String solution = s.solution("123_.def");
        String solution = s.solution("abcdefghijklmn.p");
        System.out.println("solution = " + solution);
    }
}
