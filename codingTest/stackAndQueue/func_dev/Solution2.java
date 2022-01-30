package stackAndQueue.func_dev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {

    public int[] solution(int[] progresses, int[] speeds) {


//        Queue<Document> queue = IntStream.range(0, progresses.length)
//                .mapToObj(i -> new Document(progresses[i], (int) Math.ceil((100.0 - progresses[i]) / speeds[i])))
//                .collect(Collectors.toCollection(LinkedList::new));

        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Document(progresses[i], (int) Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }


        List<Integer> retList = new ArrayList<>();
        int cnt = 1;
        while (!queue.isEmpty()) {

            Document doc = queue.poll();
            if (queue.peek() != null && doc.getValue() >= queue.peek().getValue()) {
                    cnt++;
            } else {
                retList.add(cnt);
                cnt = 1;
            }

        }

        return retList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
//        solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}


class Document {
    private final int key;
    private final int value;

    public Document(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
