package algorithm;


public class ArrayAndString_281 {

    static class Sort {
        public String sort(String s) {
            char[] content = s.toCharArray();
            java.util.Arrays.sort(content);
            return new String(content);
        }

        // 정렬
        public boolean permutation(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            return sort(s).equals(sort(t));
        }

        // 문자열에 포함된 문자의 출현 횟수가 같은지 검사
        boolean permutation1(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] letters = new int[128];
            char[] s_array = s.toCharArray();
            for (char c : s_array) {
                letters[c]++;
            }

            for (int i = 0; i < t.length(); i++) {
                int c = (int) t.charAt(i);
                letters[c]--;
                if (letters[c] < 0) {
                    return false;
                }
            }
            return true;
        }

        // 문자열에 들어 있는 모든 공백을 ‘%20’으로 바꾸는 메서드를 작성 ==> TODO
        void replaceSpaces(char[] str, int trueLength) {
            int spaceCount = 0, index, i = 0;

            for (i = 0; i < trueLength; i++) {
                if (str[i] == ' ') spaceCount++;
            }

            index = trueLength + spaceCount * 2;
            if (trueLength < str.length) str[trueLength] = '\0';
            for (i = trueLength - 1; i >= 0; i--) {
                if (str[i] == ' ') {
                    str[index - 1] = '0';
                    str[index - 2] = '2';
                    str[index - 3] = '%';
                    index = index - 3;
                } else {
                    str[index - 1] = str[i];
                    index--;
                }
            }
        }

        /**
         * 회문순열 : 앞 && 뒤 에서 읽었을 때, 같은 문자.
         * 모든 문자가 각각 짝수 개 존재하며 절반은 왼쪽 나머지는 오른쪽에 존재. 단 한개의 문자만 홀수이며 가장 정 중앙에 있어야함.
         * 문자열의 길이가 홀수여야한다.
         */

        boolean isPermutationOfPalindrome(String phrase) { // O(N)
            int[] table = buildCharFrequencyTable(phrase);
            return checkMaxOneOdd(table);
        }

        boolean checkMaxOneOdd(int[] table) {
            boolean foundOdd = false;
            for (int count : table) {
                if (count % 2 == 1) {
                    if (foundOdd) {
                        return false;
                    }
                    return true;
                }
            }
            return foundOdd;
        }

        int[] buildCharFrequencyTable(String pharse) {
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

            for (char c : pharse.toCharArray()) {
                int x = getCharNumber(c);
                if (x != -1) {
                    table[x]++;
                }
            }
            return table;
        }

        /**
         * 각 문자에 숫자를 대응 시킴. z => 35 a => 10    c가 a일때 c - a => 0  a=0, b=2 식으로 대응시킨다.
         */
        private int getCharNumber(char c) {
            int a = Character.getNumericValue('a');
            int z = Character.getNumericValue('z');
            int val = Character.getNumericValue(c);

            if (a <= val && val <= z) {
                return val - a;
            }
            return -1;
        }

        boolean isPermutationOfPalindrome2(String pharse) {
            int countOdd = 0;
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

            for (char c : pharse.toCharArray()) {
                int x = getCharNumber(c);
                if (x != -1) {
                    table[x]++;
                    if (table[x] % 2 == 1) {
                        countOdd++;
                    } else {
                        countOdd--;
                    }
                }
            }
            return countOdd <= 1;
        }


        /** 회문순열 END  TODO = bit연산 */

        /**
         * 하나 뺴기
         */
        boolean oneEidtAway(String first, String second) {
            if (first.length() == second.length()) {
                return oneEditReplace(first, second);
            } else if (first.length() + 1 == second.length()) {
                return oneEditInsert(first, second);
            } else if (first.length() - 1 == second.length()) {
                return oneEditInsert(second, first);
            }

            return false;
        }

        // 문자열 하나만 바꿔서
        private boolean oneEditReplace(String s1, String s2) {
            boolean foundDifference = false;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (foundDifference) return false;
                    foundDifference = true;
                }
            }
            return true;
        }

        // s1에 문자 하나를 삽입해서 s2를 만들 수 있는가
        boolean oneEditInsert(String s1, String s2) {
            int index1 = 0;
            int index2 = 0;
            while (index2 < s2.length() && index1 < s1.length()) {
                if (s1.charAt(index1) != s2.charAt(index2)) {
                    if (index1 != index2) {
                        return false;
                    }
                    index2++;
                } else {
                    index1++;
                    index2++;
                }
            }
            return true;
        }

        boolean oneEidtAway2(String first, String second) {
            // 길이 체크
            if (Math.abs(first.length() - second.length()) > 1) {
                return false;
            }

            // 길이가 짧은 문자열 찾기
            String s1 = first.length() < second.length() ? first : second;
            String s2 = first.length() < second.length() ? second : first;

            int index1 = 0;
            int index2 = 0;
            boolean foundDifference = false;

            while (index2 < s2.length() && index1 < s1.length()) {
                if (s1.charAt(index1) != s2.charAt(index2)) {
                    // 반드시 첫 번쨰로 다른 문자여야 한다.
                    if(foundDifference) return false;
                    foundDifference = true;

                    if (s1.length() == s2.length()) index1++; // 교체의 경우 짧은 문자열의 포인터를 증가
                } else {
                  index1++; // 동일하다면 짧은 문자열의 포인터 증가
                }
                index2++; // 긴 문자열의 포인터는 언제나 증가
            }
            return true;
        }
        /** 하나 뺴기  END */

        /** 문자열 압축 */
        String compressBad(String str) {
            String compressedString = ""; // StringBuilder를 쓰면 개선됨.
            int countConsecutive = 0;

            for (int i = 0; i < str.length(); i++) {
                countConsecutive++;

                /** 다음 문자와 현재 문자가 같지 않다면 현재 문자를 결과 문자열에 추가. */
                if (i+1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    compressedString += "" + str.charAt(i) + countConsecutive;
                    countConsecutive = 0;
                }
            }
            return compressedString.length() < str.length() ? compressedString : str;
        }

        String compress(String str) {
            /** 압축된 문자열의 길이가 입력 문자열보다 길다면 입력 문자열을 반환한다. */
            int finalLength = countCompression(str);
            if(finalLength >= str.length()) return str;

            StringBuilder sb = new StringBuilder(finalLength);
            int countConsecutive = 0;
            for (int i = 0; i < str.length(); i++) {
                countConsecutive++;

                /** 다음 문자와 현재 문자가 같지 않다면 현재 문자를 결과 문자열에 추가한다. */
                if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    sb.append(str.charAt(i));
                    sb.append(countConsecutive);
                    countConsecutive = 0;
                }
            }

            return sb.toString();
        }

        private int countCompression(String str) {
            int compressedLength = 0;
            int countConsecutive = 0;
            for (int i = 0; i < str.length(); i++) {
                countConsecutive++;

                if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1) ) {
                    compressedLength += 1 + String.valueOf(countConsecutive).length();
                    countConsecutive = 0;
                }
            }
            return compressedLength;
        }


        /** 문자열 압축 END*/

        /**
         * 행렬회전 N x N 행렬 90도로 회전
         */

        boolean rotate(int[][] matrix) {
            if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
            int n = matrix.length;

            for (int layer = 0; layer < n / 2; layer++) {
                int first = layer;
                int last = n - 1 - layer;

                for (int i = first; i < last; i++) {
                    int offset = i - first;
                    int top = matrix[first][i]; // 윗 부분 저장

                    // 왼 -> 위
                    matrix[first][i] = matrix[last - offset][first];

                    // 아래 -> 왼
                    matrix[last-offset][first] = matrix[last][last - offset];

                    // 오른쪽 -> 아래쪽
                    matrix[last][last-offset] = matrix[i][last];

                    // 위 -> 오
                    matrix[i][last] = top; // 오른쪽 <- 미리 저장해 놓은 top
                }
            }
            return true;
        }
        /** 행렬회전 END*/

        /** O행렬 295p*/

        /** O행렬 END */



    }


    public static void main(String[] args) {
        Sort sort = new Sort();
//        boolean permutation = sort.permutation1("abc", "cba");
//        char[] chars = {'a', 'b', 'c', ' ', 'd', ' ', 'e'};
//        int length = chars.length;
//        sort.replaceSpaces(chars, length);
//        boolean isOdd = sort.isPermutationOfPalindrome("abc");
//        sort.oneEidtAway2("bb", "abc");

//        sort.compress("aaabbbbbc");

        int[][] matrix = new int[][]{{1, 2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        sort.rotate(matrix);


    }
}
