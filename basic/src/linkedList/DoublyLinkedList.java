package linkedList;

import node.Node;

public class DoublyLinkedList<T> {

    private Node<T> head; // 첫 번째 노드
    private Node<T> tail; // 마지막 노드
    private int size;     // 리스트 크기

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode; // 이전 노드 설정
            this.head = newNode;
        }

        this.size++;
    }

    public void addLast(T data) {
        Node<T> lastNode = new Node<>(data);

        if (isEmpty()) {
            this.head = this.tail = lastNode;
        } else {
            lastNode.prev = this.tail;
            this.tail.next = lastNode;
            this.tail = lastNode;
        }

        size++;
    }

    public void add(int index, T data) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }

        if (index == 0) { // 첫 위치에 삽입할 때
            addFirst(data);
        } else if (index == this.size) { // 마지막 위치에 삽입할 때
            addLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> currentNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            newNode.prev = currentNode;

            currentNode.next = newNode;
            newNode.next.prev = newNode;

            this.size++;
        }
    }

    // 데이터만 입력할 경우 기본적으로 맨 뒤에 데이터 삽입
    public void add(T data) {
        addLast(data);
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("리스트가 비어있어 제거할 수 없습니다.");
        }

        T deletedData = this.head.data;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;

        return deletedData;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("리스트가 비어있어 제거할 수 없습니다.");
        }

        T deletedData = this.tail.data;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null; // 다음 노드 참조 제거
        }

        this.size--;

        return deletedData;
    }

    public T remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }

        if (index == 0) { // 첫 번째 노드 삭제
           return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> currentNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                // 중요!! currentNode.next 가 실제로 제거될 대상이다.
                currentNode = currentNode.next;
            }

            T deletedData = currentNode.next.data; // 제거할 노드의 데이터

            currentNode.next =  currentNode.next.next;
            currentNode.next.prev = currentNode;

            this.size--;

            return deletedData;
        }
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }

        return this.head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }

        return this.tail.data;
    }

    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }

        if (index == 0) {
            return getFirst();
        } else if (index == size - 1) {
            return getLast();
        } else {
            Node<T> currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            return currentNode.data;
        }
    }

    public void clear() {
        this.head = this.tail = null;
        this.size = 0;
    }

    // 메모리 누수를 해결하기 위한 clear 메서드 추가
    public void safeClear() {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.next;
            currentNode.next = null; // 명시적인 참조 해제
            currentNode = nextNode;
        }

        this.head = this.tail = null;
        this.size = 0;
    }

    public void printAll() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("linked List is Empty!");
        } else {
            Node<T> currentNode = this.head;

            sb.append("linked List = [");

            while (currentNode != null) {
                sb.append(currentNode.data);
                currentNode = currentNode.next;
                if (currentNode != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        System.out.println(sb);
    }
}
