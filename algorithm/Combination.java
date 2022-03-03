package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 순열 -> 순서가 존재하는 열
public class Combination {

    static ArrayList<Integer> list = new ArrayList();

    public static void main(String[] args) {
        Combination s = new Combination();
        System.out.println(s.solution("17"));

    }

    public static int solution(String numbers) {
        char[] charArr = numbers.toCharArray();
        int[] arr = new int[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            arr[i] = Character.getNumericValue(charArr[i]);
        }

        int n = arr.length;
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < arr.length; i++) {
            permutation(arr, output, visited, 0, n, i + 1);
        }

        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        return newList.size();
    }

    private static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr, int r) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < r; i++) {
            sb.append(arr[i]);
        }

        if (!checkPrime(Integer.parseInt(sb.toString()))) {
            System.out.println(Integer.parseInt(sb.toString()));
            list.add(Integer.parseInt(sb.toString()));
        }
    }

    public static boolean checkPrime(int num) {
        if(num < 2) return true;

        boolean isPrime = false;
        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                isPrime = true;
                break;
            }

        }
        return isPrime;
    }

}
