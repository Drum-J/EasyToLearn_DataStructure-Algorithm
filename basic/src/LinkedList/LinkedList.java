package LinkedList;

public class LinkedList<E> {
    public Node<E> head; //연결리스트의 시작노드를 가리키는 헤드
    public int count; //총 갯수

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    // 전체 출력
    public void printAll() {
        Node<E> currentNode = this.head;

        StringBuilder sb = new StringBuilder();

        sb.append("LinkedList = [");
        while (currentNode != null) {
            sb.append(currentNode.data);
            currentNode = currentNode.next;

            if (currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    //삭제
    public void clear() {
        this.head = null;
        this.count = 0;
    }

    //삽입
    public void insertAt(int index, E data) {
        if (index > this.count || index < 0) {
            throw new IndexOutOfBoundsException("범위를 넘어갔습니다.");
        }

        Node<E> newNode = new Node<>(data);
        // 가장 앞 부분에 삽입하는 경우
        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node<E> currentNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        this.count++;
    }

    // 맨 뒤에 삽입
    public void insertLast(E data) {
        this.insertAt(this.count, data);
    }

    // 삭제
    public E deleteAt(int index) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException("범위를 넘어섰기 때문에 삭제할 수 없습니다.");
        }

        Node<E> currentNode = this.head;

        // 첫 노드를 삭제하는 경우
        if (index == 0) {
            Node<E> deleteNode = this.head;
            this.head = currentNode.next;
            this.count--;

            return deleteNode.data;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            Node<E> deleteNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            this.count--;

            return deleteNode.data;
        }
    }

    // 마지막 노드 삭제
    public E deleteLast() {
        return this.deleteAt(this.count - 1);
    }

    // 해당 인덱스의 노드를 읽기
    public E getNodeAt(int index) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException("범위를 넘어갔습니다.");
        }

        Node<E> currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }
}
