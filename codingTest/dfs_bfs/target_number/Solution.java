package codingTest.dfs_bfs.target_number;

// https://programmers.co.kr/learn/courses/30/lessons/43165
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println("result = " + result);
    }


    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = this.count;

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){
            if (target == result){
                this.count++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(numbers, depth+1, target, add);
        dfs(numbers, depth+1, target, sub);

    }
}
