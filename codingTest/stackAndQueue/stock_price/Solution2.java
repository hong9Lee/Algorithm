package stackAndQueue.stock_price;

import java.util.*;

public class Solution2 {
    public int[] solution(int[] prices) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            queue.offer(prices[i]);
        }

        int siz = queue.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < siz - 1; i++) {
            int count = 0;
            int flag = queue.poll();

            Iterator<Integer> it = queue.iterator();
            while (it.hasNext()) {
//                if (flag <= it.next()) count++;
                count++;
                if(flag > it.next()) break;
            }
            list.add(count);

        }
        list.add(0);


        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(new int[]{1, 2, 3, 2, 3});
    }
}
