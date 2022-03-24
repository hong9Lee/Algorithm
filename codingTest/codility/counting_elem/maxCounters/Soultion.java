package codingTest.codility.counting_elem.maxCounters;

import java.util.Arrays;


public class Soultion {

    public static void main(String[] args) {
        Soultion soultion = new Soultion();
        int[] result = soultion.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        System.out.println(result);
    }


    public int[] solution(int N, int[] A) {
        int[] result = new int[N];

        for (int i = 0; i < A.length; i++) {
            if(A[i] == N+1) Arrays.fill(result, setMaximun(result));
            if(A[i] >=1 && A[i] <= N) result[A[i]-1]++;
        }

        return result;
    }

    private Integer setMaximun(int[] result) {
        Arrays.sort(result);
        return result[result.length - 1];
    }


}
