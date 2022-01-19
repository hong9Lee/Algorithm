

class Solution {
    public int solution(String s) {
        System.out.printf(s);

        /**
         1. 입력 String의 length를 기준으로
         2. 현재 size를 -> 1까지 줄여가며
         3. 현재 size만큼의 문자와 현재 size만큼의 뒤 문자와 같다면 totalsize++를 해준다. (문자열 삭제하며)
         4. 압축 문자끼리 숫자 비교

         aabbaccc

         8 aabbaccc -> 8
         7 aabbacc c -> 8
         6 aabbac cc -> 8
         5 aabba ccc -> 8
         4 aabb accc -> 8
         3 aab bac cc -> 8
         2 aa bb ac cc -> 2a2baccc -> 8
         1 a a b b a c c c -> 2a2ba3c -> 7
         */

        int stringSize = s.length(); // 문자열 총 길이
        int answer = 0;

        int cNum = 0;

        for(int t = stringSize; 0 < t; t--){ // i는 자를 수

            String a = "";
            String temp = ""; // 뒷 문자열과 비교할 String
            int count = 0;
            String flag = "N";

            for(int i = 0; i <= s.length();  ){
                if(i == 0) {
                    temp = s.substring(i, t);
                    a = s.substring(i, t);

                }else{

                    if(i + (t) >= s.length()){
                        if(temp.equals(s.substring(i, s.length()))){
                            if(flag.equals("N")){
                                count++;
                            }
                        }else{
                            a += s.substring(i, s.length());
                        }
                        break;
                    }

                    if(temp.equals(s.substring(i, i+t))){
                        if(flag.equals("N")){
                            count++;
                            flag = "Y";
                        }else{
                            continue;
                        }

                    }else{
                        flag = "N";
                        a += s.substring(i, i+t);
                        temp = s.substring(i, i+t);
                    }

                }
                i += (t);
            }
            count += a.length();


            if(t == stringSize){
                cNum = count;
            }else{
                if(cNum > count) cNum = count;
            }

        }

        answer = cNum;
        return answer;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("abcabcabcabcdededededede");



//        String a = "";
//        String b = "abcabcabcabcdededededede";
//        int t = 6;
//
//        String temp = ""; // 뒷 문자열과 비교할 String
//        int count = 0;
//        String flag = "N";
//
//        for(int i = 0; i <= b.length();  ){
//            if(i == 0) {
//                temp = b.substring(i, t);
//                a = b.substring(i, t);
//
//            }else{
//
//                if(i + (t) >= b.length()){
//                    if(temp.equals(b.substring(i, b.length()))){
//                        if(flag.equals("N")){
//                            count++;
//                        }
//                    }else{
//                        a += b.substring(i, b.length());
//                    }
//                    break;
//                }
//
//                if(temp.equals(b.substring(i, i+t))){
//                    if(flag.equals("N")){
//                        count++;
//                        flag = "Y";
//                    }else{
//                        continue;
//                    }
//
//                }else{
//                    flag = "N";
//                    a += b.substring(i, i+t);
//                    temp = b.substring(i, i+t);
//                }
//
//            }
//                i += (t);
//        }
//        count += a.length();
//        System.out.printf(a);

    }
}