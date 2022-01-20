public class answer {
        public int solution(String s) {
            System.out.printf(s);

            int strLength = s.length();
            int answer = s.length();


            for (int i = 1; i <= strLength/2; i++) { // 자를 수
                String strFrag = s.substring(0, i);
                int flag = 1;
                StringBuffer sb = new StringBuffer();

                for (int j = i; j <= strLength; j += i) {
                    // 다음 문자 찾기
                    String next = s.substring(j, i + j > strLength ? strLength : i + j);

                    if(strFrag.equals(next)) flag++;
                    else {
                        sb.append((flag != 1 ? flag : "") + strFrag);
                        flag = 1;
                        strFrag = next;
                    }

                }
                sb.append(strFrag);
                answer = Math.min(sb.length(), answer);
            }

            return answer;
        }



        public static void main(String[] args) {
            Solution s = new Solution();
            s.solution("aabbaccc");
        }
    }
