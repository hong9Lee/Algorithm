
// 연결리스트
public class Node {

    Node next = null;

    int data;
    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.appendToTail(4);
    }
}
