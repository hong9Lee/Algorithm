package programmers.stackAndQueue.printer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = IntStream.range(0, priorities.length)
                .mapToObj(i -> new Document(priorities[i], i == location))
                .collect(Collectors.toCollection(LinkedList::new));

        int outCount = 0;
        while (!queue.isEmpty()) {
            Document document = queue.poll();

            if (queue.stream().anyMatch(d -> d.getPriority() > document.getPriority())) {
                queue.offer(document);
            } else {
                outCount++;
                if (document.isMine()) break;
            }
        }
        return outCount;
    }



    public static void main(String[] args) {
        Answer solution = new Answer();
        int solution1 = solution.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(solution1);
    }
}


class Document {
    private final int priority;
    private final boolean isMine;

    public Document(int priority, boolean isMine) {
        this.priority = priority;
        this.isMine = isMine;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isMine() {
        return isMine;
    }
}
