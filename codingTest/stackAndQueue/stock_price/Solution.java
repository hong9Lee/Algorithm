package stackAndQueue.stock_price;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://programmers.co.kr/learn/courses/30/lessons/42584
// 주식가격
public class Solution {
    public int[] solution(int[] prices) {

        Queue<Integer> queue = IntStream.range(0, prices.length)
                .mapToObj(i -> prices[i])
                .collect(Collectors.toCollection(LinkedList::new));

        List<Integer> retList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int a = queue.poll();

            List<Integer> collect = queue.stream()
                    .filter(i -> a <= i)
                    .collect(Collectors.toList());

            retList.add(collect.size());
        }


        return retList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 2, 3});
    }
}
