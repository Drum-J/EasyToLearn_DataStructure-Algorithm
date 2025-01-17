package avltree;

public class AvlTreeMain2 {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>(new BinaryTree<>(1));

        avlTree.insert(avlTree.getRoot(), 1);
        avlTree.insert(avlTree.getRoot(), 2);
        avlTree.insert(avlTree.getRoot(), 3);
        avlTree.insert(avlTree.getRoot(), 4);
        avlTree.insert(avlTree.getRoot(), 5);
        avlTree.insert(avlTree.getRoot(), 6);
        avlTree.insert(avlTree.getRoot(), 7);

        System.out.println(avlTree.getRoot()); //root
        System.out.println(avlTree.getRoot().getLeftSubTree()); //left
        System.out.println(avlTree.getRoot().getRightSubTree()); //right

        avlTree.getRoot().inOrderTraversal(); //중위 순회

        System.out.println("==== 제거 ====");
        avlTree.remove(avlTree.getRoot(), 2, null);
        avlTree.remove(avlTree.getRoot(), 3, null);
        avlTree.remove(avlTree.getRoot(), 1, null);

        System.out.println(avlTree.getRoot()); //root
        System.out.println(avlTree.getRoot().getLeftSubTree()); //left
        System.out.println(avlTree.getRoot().getRightSubTree()); //right
        avlTree.getRoot().inOrderTraversal(); //중위 순회
    }
}
