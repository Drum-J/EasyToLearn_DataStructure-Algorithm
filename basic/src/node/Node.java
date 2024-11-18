package node;

public class Node<T> {
    public T data; // 데이터
    public Node<T> next; // 다음 노드

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
