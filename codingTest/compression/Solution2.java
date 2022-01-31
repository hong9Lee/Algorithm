package compression;

public class Solution2 {
    public int solution(String s) {

        int answer = 0;
        for (int i = 1; i <= (s.length() / 2) + 1; i++) {
            int result = getCompression(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);

        }
        return answer;
    }

    private String getCompression(String s, int i, int repeat) {

        if(s.length() < i) return s;
        String pre = s.substring(0, i);
        String post = s.substring(i, s.length());

        StringBuffer sb = new StringBuffer();
        if (!post.startsWith(pre)) {
            if(repeat == 1) return sb.append(pre + getCompression(post, i, 1)).toString();
            return sb.append(repeat + pre + getCompression(post, i, 1)).toString();
        }

        return sb.append(getCompression(post, i, ++repeat)).toString();

    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution("aabbaccc");
//        solution.solution("aabba");
    }
}
