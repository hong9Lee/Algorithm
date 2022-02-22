package algorithm;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

public class TreeNGraph {

    /*
    // 노드 사이의 경로 : 방향 그래프가 주어졌을때 두 노드 사이에 경로가 존재 하는지 확인하는 알고리즘을 작성하라. 337p
    enum State {Unvisited, Visited, Visiting}

    // 너비 우선 탐색
    boolean search(Graph g, Node start, Node end) {
        if(start == end) return true;

        LinkedList q = new LinkedList<>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); //  == dequeue;

            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
            return false;
        }
    }


    // 최소트리:오름차순으로 정렬된 배열이 있다. 이 배열안에 들어 있는 원소는 정수이며 중복된 값이 없다고 했을때 높이가 최소가 되는 이진탐색트리를 만드는 알고리즘을 작성하라.

    // 1. 배열의 가운데 원소를 트리에 삽입한다.
    // 2. 왼쪽 하위 트리에 왼쪽 절반 배열 원소들을 삽입한다.
    // 3. 오른쪽 하위 트리에 오른쪽 절반 배열 원소들을 삽입힌다.
    // 4. 재귀 호출을 실행한다.

    TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    TreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) return null;

        int mid = (start +end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
    */



}
