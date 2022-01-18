

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
        int answer = stringSize;

        int cNum;
        for(int i = 0; i < stringSize; i++){
            cNum = stringSize - 1; // 몇개로 자를것인지

            double b = stringSize / (double)cNum;
            if (b-(int)b != 0.0) b += 1;
            int divNum = (int)b;


            String addStr = "";
//            for(int c = 0; c < divNum; c++){
//
//                s.substring(0, cNum);
//            }
            while (true){

            }





        }
        return answer;
    }



    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution();

        String a = "";
        String b = "aabbaccc";
        int t = 8;
        for(int i = 0; i < b.length();  ){
            if(i == 0) {
                a = b.substring(i, t);
            }else{
                if(i + (t) > b.length()){
                    a += (" " + b.substring(i, b.length()));
                    break;
                }
                a += (" " + b.substring(i, i+t));
            }
                i = i + (t);
        }

        System.out.printf(a);

    }
}