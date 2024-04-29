package LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node1.next = node2;
        node2.next = node3;

        System.out.println("node1.data = " + node1.data);
        System.out.println("node1.next.data = " + node1.next.data);
        System.out.println("node1.next.next.data = " + node1.next.next.data);

        System.out.println("==== intserAt() 호출 ====");
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.insertAt(0, 0);
        linkedList.insertAt(1, 1);
        linkedList.insertAt(2, 2);
        linkedList.insertAt(3, 3);
        linkedList.insertAt(4, 4);
        linkedList.insertAt(5, 5);

        linkedList.printAll();

        System.out.println("==== clear() 호출 ====");
        linkedList.clear();
        linkedList.printAll();

        System.out.println("==== insertLast() 호출 ====");
        linkedList.insertLast(5);
        linkedList.insertLast(2);
        linkedList.insertLast(1);
        linkedList.insertLast(4);
        linkedList.insertLast(3);
        linkedList.printAll();

        System.out.println("==== deleteAt(1) 호출 ====");
        Object data = linkedList.deleteAt(1);
        System.out.println("삭제된 노드의 Data = " + data);
        linkedList.printAll();

        System.out.println("==== deleteLast() 호출 ====");
        Object lastData = linkedList.deleteLast();
        System.out.println("삭제된 노드의 Data = " + lastData);
        linkedList.printAll();

        System.out.println("==== getNodeAt(1) 호출 ====");
        Object nodeData = linkedList.getNodeAt(1);
        System.out.println("인덱스 노드의 Data = " + nodeData);

    }
}
