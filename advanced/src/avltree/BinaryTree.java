package avltree;

public class BinaryTree<T extends Comparable<T>> {
    private T data;
    private BinaryTree<T> leftSubTree;
    private BinaryTree<T> rightSubTree;

    private int height;

    public BinaryTree(T data) {
        this(data, null, null, 1);
    }

    public BinaryTree(T data, BinaryTree<T> leftSubTree, BinaryTree<T> rightSubTree, int height) {
        this.data = data;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
        this.height = height;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftSubTree() {
        return leftSubTree;
    }

    public void setLeftSubTree(BinaryTree<T> tree) {
        leftSubTree = tree;
    }

    public BinaryTree<T> removeLeftSubTree() {
        BinaryTree<T> deleteNode = leftSubTree;
        leftSubTree = null;
        return deleteNode;
    }

    public BinaryTree<T> getRightSubTree() {
        return rightSubTree;
    }

    public void setRightSubTree(BinaryTree<T> tree) {
        rightSubTree = tree;
    }

    public BinaryTree<T> removeRightSubTree() {
        BinaryTree<T> deleteNode = rightSubTree;
        rightSubTree = null;
        return deleteNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 전위 순회 -> 루트 - 왼쪽 - 오른쪽
     * 특정 노드부터 순회하고 싶을 때 사용
     * @param tree
     */
    public void preOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.data); // 루트 노드 출력
        preOrderTraversal(tree.getLeftSubTree()); //왼쪽 자식 재귀 호출
        preOrderTraversal(tree.getRightSubTree()); //오른쪽 자식 재귀 호출
    }

    /**
     * 전위 순회 -> 루트 - 왼쪽 - 오른쪽
     * 자기자신을 사용해서 preOrderTraversal(this) 호출
     */
    public void preOrderTraversal() {
        preOrderTraversal(this);
    }

    /**
     * 중위 순회 -> 왼쪽 - 루트 - 오른쪽
     * 특정 노드부터 순회하고 싶을 때 사용
     * @param tree
     */
    public void inOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) {
            return;
        }

        inOrderTraversal(tree.getLeftSubTree()); //왼쪽 자식 재귀 호출
        System.out.println(tree.data); //루트 노드 출력
        inOrderTraversal(tree.getRightSubTree()); //오른쪽 자식 재귀 호출
    }

    /**
     * 중위 순회 -> 왼쪽 - 루트 - 오른쪽
     * 자기자신을 사용해서 inOrderTraversal(this) 호출
     */
    public void inOrderTraversal() {
        inOrderTraversal(this);
    }

    /**
     * 후위 순회 -> 왼쪽 - 오른쪽 - 루트
     * 특정 노드부터 순회하고 싶을 때 사용
     * @param tree
     */
    public void postOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) {
            return;
        }

        postOrderTraversal(tree.getLeftSubTree()); //왼쪽 자식 재귀 호출
        postOrderTraversal(tree.getRightSubTree()); //오른쪽 자식 재귀 호출
        System.out.println(tree.data); //루트 노드 출력
    }

    /**
     * 후위 순회 -> 왼쪽 - 오른쪽 - 루트
     * 자기자신을 사용해서 postOrderTraversal(this) 호출
     */
    public void postOrderTraversal() {
        postOrderTraversal(this);
    }

    /**
     * leftSubTree, rightSubTree 를 그대로 출력하게 되면
     * 하위 트리까지 모두 출력 되기 때문에
     * (left/right)SubTree.data 로 해당 트리의 자식 데이터까지만 출력
     * 왼쪽 또는 오른쪽 자식 노드가 없을 경우를 위해 null 체크
     * @return
     */
    @Override
    public String toString() {
        return  "BinaryTree{" +
                "data=" + data +
                ", leftSubTree=" + (leftSubTree != null ? leftSubTree.data : "null") +
                ", rightSubTree=" + (rightSubTree != null ? rightSubTree.data : "null") +
                '}';
    }
}
