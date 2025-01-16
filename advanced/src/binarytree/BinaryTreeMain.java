package binarytree;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
        BinaryTree<Integer> tree2 = new BinaryTree<>(2);
        BinaryTree<Integer> tree3 = new BinaryTree<>(3);
        BinaryTree<Integer> tree4 = new BinaryTree<>(4);
        BinaryTree<Integer> tree5 = new BinaryTree<>(5);
        BinaryTree<Integer> tree6 = new BinaryTree<>(6);
        BinaryTree<Integer> tree7 = new BinaryTree<>(7);

        /**
         *     1
         *    / \
         *   2   3
         */
        tree1.setLeftSubTree(tree2);
        tree1.setRightSubTree(tree3);

        /**
         *       1
         *     /   \
         *    2     3
         *   / \
         *  4   5
         */
        tree2.setLeftSubTree(tree4);
        tree2.setRightSubTree(tree5);

        /**
         *       1
         *     /   \
         *    2     3
         *   / \   /  \
         *  4   5 6    7
         */
        tree3.setLeftSubTree(tree6);
        tree3.setRightSubTree(tree7);

        System.out.println("1번 노드의 오른쪽 자식 노드 : " + tree1.getRightSubTree().getData());
        System.out.println("1번 노드의 오른쪽 자식 노드의 왼쪽 자식 노드 : "
                + tree1.getRightSubTree().getLeftSubTree().getData());

        System.out.println("== 전위 순회 결과 ==");
        tree1.preOrderTraversal();

        System.out.println("== 중위 순회 결과 ==");
        tree1.inOrderTraversal();

        System.out.println("== 후위 순회 결과 ==");
        tree1.postOrderTraversal();
    }
}
