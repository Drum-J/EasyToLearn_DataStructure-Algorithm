package node;

public class Node<T> {
    public T data; // 데이터
    public Node<T> next; // 다음 노드
    public Node<T> prev; // 이전 노드 (양방향 연결리스트를 위해 추가)

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
