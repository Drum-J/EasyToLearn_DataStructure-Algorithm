package avltree;

public class AvlTree<T extends Comparable<T>> {

    private BinaryTree<T> root;

    public AvlTree() {
        this(null);
    }

    public AvlTree(BinaryTree<T> rootNode) {
        this.root = rootNode;
    }

    public BinaryTree<T> getRoot() {
        return root;
    }

    public BinaryTree<T> search(T targetData) {
        BinaryTree<T> currentNode = root;

        while (currentNode != null) {
            if (currentNode.getData().compareTo(targetData) == 0) { // 현재 데이터와 찾을 데이터가 같다면 현재 노드를 반환
                return currentNode;
            } else if (currentNode.getData().compareTo(targetData) > 0) { // 현재 데이터 > 찾을 데이터. 왼쪽으로 이동
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree(); // 현재 데이터 < 찾을 데이터. 오른쪽으로 이동
            }
        }

        return null;
    }

    public int getHeight(BinaryTree<T> tree) {
        if (tree == null) {
            return 0;
        }

        return tree.getHeight();
    }

    public void updateHeight(BinaryTree<T> tree) {
        int leftChildHeight = getHeight(tree.getLeftSubTree());
        int rightChildHeight = getHeight(tree.getRightSubTree());

        tree.setHeight(Math.max(leftChildHeight, rightChildHeight) + 1);
    }

    public int getBalanceFactor(BinaryTree<T> tree) {
        return getHeight(tree.getLeftSubTree()) - getHeight(tree.getRightSubTree());
    }

    //LL 회전
    public BinaryTree<T> rotateLeft(BinaryTree<T> tree) {
        BinaryTree<T> childNode = tree.getRightSubTree();
        tree.setRightSubTree(childNode.getLeftSubTree());
        childNode.setLeftSubTree(tree);

        updateHeight(tree);
        updateHeight(childNode);

        return childNode;
    }

    //RR 회전
    public BinaryTree<T> rotateRight(BinaryTree<T> tree) {
        BinaryTree<T> childNode = tree.getLeftSubTree();
        tree.setLeftSubTree(childNode.getRightSubTree());
        childNode.setRightSubTree(tree);

        updateHeight(tree);
        updateHeight(childNode);

        return childNode;
    }

    //상황에 맞게 회전시키는 함수
    public BinaryTree<T> rotation(BinaryTree<T> targetNode, T data) {
        int balanceFactor = getBalanceFactor(targetNode);
        boolean isRootNode = targetNode == root;

        // balanceFactor 의 값이 -1 보다 작고 data 값이 타겟 노드의 오른쪽 자식 노드 데이터 보다 클 경우 LL회전
        if (balanceFactor < -1 && data.compareTo(targetNode.getRightSubTree().getData()) > 0) {
            targetNode = rotateLeft(targetNode);
        } else if (balanceFactor > 1 && data.compareTo(targetNode.getLeftSubTree().getData()) < 0) { //RR
            targetNode = rotateRight(targetNode);
        } else if (balanceFactor > 1 && data.compareTo(targetNode.getLeftSubTree().getData()) > 0) { //LR
            targetNode.setLeftSubTree(rotateLeft(targetNode.getLeftSubTree()));
            targetNode = rotateRight(targetNode);
        } else if (balanceFactor < -1 && data.compareTo(targetNode.getRightSubTree().getData()) < 0){ //RL
            targetNode.setRightSubTree(rotateLeft(targetNode.getRightSubTree()));
            targetNode = rotateLeft(targetNode);
        }

        //루트 노드가 회전했을 경우
        if (isRootNode) {
            this.root = targetNode;
        }

        return targetNode;
    }

    //균형을 무너뜨리는 노드를 구하는 함수
    public BinaryTree<T> getUnBalanceNode(BinaryTree<T> targetRootNode,BinaryTree<T> unBalanceNode) {
        // 자식이 하나도 없을 때
        if (targetRootNode.getLeftSubTree() == null && targetRootNode.getRightSubTree() == null) {
            unBalanceNode = targetRootNode;
            return unBalanceNode;
        }

        int balanceFactor = getBalanceFactor(targetRootNode); //어떤 곳이 더 높은지

        if (balanceFactor > 0) { // 왼쪽이 높은 경우
            unBalanceNode = getUnBalanceNode(targetRootNode.getLeftSubTree(), unBalanceNode);
        } else if (balanceFactor < 0) { // 오른쪽이 높은 경우
            unBalanceNode = getUnBalanceNode(targetRootNode.getRightSubTree(), unBalanceNode);
        } else { //높이가 같다면 오른쪽 선택
            unBalanceNode = targetRootNode.getRightSubTree();
        }

        return unBalanceNode;
    }

    //삽입 재귀사용
    public BinaryTree<T> insert(BinaryTree<T> targetRootNode, T data) {
        if (targetRootNode == null) {
            targetRootNode = new BinaryTree<>(data);
        }

        //AVL 트리에 처음 삽입 하는 경우
        if (root == null) {
            root = targetRootNode;
        } else if (targetRootNode.getData().compareTo(data) == 0) { // 중복인 경우
            return targetRootNode;
        } else if (targetRootNode.getData().compareTo(data) > 0) { // 왼쪽에 삽입
            targetRootNode.setLeftSubTree(insert(targetRootNode.getLeftSubTree(), data));
        } else { // 오른쪽에 삽입
            targetRootNode.setRightSubTree(insert(targetRootNode.getRightSubTree(), data));
        }

        updateHeight(targetRootNode);
        targetRootNode = rotation(targetRootNode, data);

        return targetRootNode;
    }

    //제거 재귀사용
    public BinaryTree<T> remove(BinaryTree<T> targetRootNode, T data, BinaryTree<T> parentNode) {
        // 데이터가 현재 노드 데이터보다 작고 왼쪽 자식 노드가 있을 때
        if (targetRootNode.getData().compareTo(data) > 0 && targetRootNode.getLeftSubTree() != null) {
            targetRootNode.setLeftSubTree(remove(targetRootNode.getLeftSubTree(), data, targetRootNode));
        } else if (targetRootNode.getData().compareTo(data) < 0 && targetRootNode.getRightSubTree() != null) { //크고 오른쪽 자식 노드가 있을 때
            targetRootNode.setRightSubTree(remove(targetRootNode.getRightSubTree(), data, targetRootNode));
        } else if (targetRootNode.getData().compareTo(data) == 0) { // 같을 때 제거한다.
            targetRootNode = removeHelper(targetRootNode, parentNode);

            if (parentNode == null && targetRootNode != null) {
                updateHeight(targetRootNode);

                BinaryTree<T> unBalanceNode = getUnBalanceNode(targetRootNode, null);
                targetRootNode = rotation(targetRootNode, unBalanceNode.getData());
            }
            return targetRootNode;
        }

        updateHeight(targetRootNode);

        BinaryTree<T> unBalanceNode = getUnBalanceNode(targetRootNode, null);
        targetRootNode = rotation(targetRootNode, unBalanceNode.getData());
        return targetRootNode;
    }

    private BinaryTree<T> removeHelper(BinaryTree<T> deletingNode, BinaryTree<T> parentNode) {
        BinaryTree<T> fakeParentRootNode = new BinaryTree<T>(null); // 루트 노드를 제거할 때 사용
        fakeParentRootNode.setRightSubTree(this.root);

        if (parentNode == null) {
            parentNode = fakeParentRootNode;
        }

        BinaryTree<T> deletingNodeChild = null;

        if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree();
            } else {
                parentNode.removeRightSubTree();
            }
        }

        else if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
            if (deletingNode.getLeftSubTree() != null) {
                deletingNodeChild = deletingNode.getLeftSubTree();
            } else {
                deletingNodeChild = deletingNode.getRightSubTree();
            }

            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.setLeftSubTree(deletingNodeChild);
            } else {
                parentNode.setRightSubTree(deletingNodeChild);
            }
        }

        //자식 노드개 2개인 노드를 제거하는 경우
        else {
            BinaryTree<T> replacingNode = deletingNode.getLeftSubTree();
            BinaryTree<T> replacingNodeParent = deletingNode;

            while (replacingNode.getRightSubTree() != null) {
                replacingNodeParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            T deletingNodeData = deletingNode.getData();
            deletingNode.setData(replacingNode.getData());

            if (replacingNodeParent.getLeftSubTree() == replacingNode) {
                replacingNodeParent.setLeftSubTree(replacingNode.getLeftSubTree());
            } else {
                replacingNodeParent.setRightSubTree(replacingNode.getLeftSubTree());

            }

            deletingNodeChild = deletingNode;
        }

        //루트를 제거할 경우
        if (fakeParentRootNode.getRightSubTree() != root) {
            root = fakeParentRootNode.getRightSubTree();
        }

        return deletingNodeChild;
    }
}
