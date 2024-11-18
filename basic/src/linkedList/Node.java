package linkedList;

public class Node<T> {
    T data; // 데이터
    Node<T> next; // 다음 노드

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
