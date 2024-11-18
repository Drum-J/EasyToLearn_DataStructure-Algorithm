package node;

public class NodeTest {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node.next = node2;
        node2.next =node3;

        System.out.println(node.data);
        System.out.println(node.next.data);
        System.out.println(node.next.next.data);
    }
}
