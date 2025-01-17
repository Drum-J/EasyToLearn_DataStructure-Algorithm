package avltree;

public class AvlTreeMain {
    public static void main(String[] args) {
        /**
         * 5 - root
         */
        AvlTree<Integer> avlTree = new AvlTree<>(new BinaryTree<>(5));

        /**
         *    5
         *   /
         *  3
         */
        avlTree.insert(avlTree.getRoot(), 3);

        /**
         *      5
         *     /
         *    3
         *   /
         *  1          이렇게 삽입했으나 삽입과 동시에 높이 업데이트 및 회전이 이뤄진다.
         */
        avlTree.insert(avlTree.getRoot(), 1);

        /**
         * 최종 결과
         *     3
         *   /   \
         *  1     5
         */
        System.out.println("avlTree = " + avlTree.getRoot()); //5-3-1 순서로 삽입했는데 정렬되어 나오는걸 볼 수 있다.
    }
}
