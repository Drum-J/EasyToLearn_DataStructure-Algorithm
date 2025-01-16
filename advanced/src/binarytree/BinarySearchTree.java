package binarytree;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTree<T> root;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(BinaryTree<T> rootNode) {
        this.root = rootNode;
    }

    public BinaryTree<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        //처음 삽입하는 경우
        if (root == null) {
            root = new BinaryTree<>(data);
            return;
        }

        //데이터가 하나 이상 있을 경우
        BinaryTree<T> currentNode = root;
        BinaryTree<T> parentNode = null; // 삽입할 위치의 부모노드를 가리키게 됨

        while (currentNode != null) { // currentNode 가 null 이 되면 삽입 위치를 찾은거임
            parentNode = currentNode;

            if (currentNode.getData().compareTo(data) > 0) { //삽입 데이터 < 현재 데이터. 작으면 왼쪽
                currentNode = currentNode.getLeftSubTree();
            } else if (currentNode.getData().compareTo(data) < 0) { // 삽입 데이터 > 현재 데이터. 크면 오른쪽
                currentNode = currentNode.getRightSubTree();
            } else { // 같다면? 중복을 허용하지 않으므로 return
                return;
            }
        }

        BinaryTree<T> newNode = new BinaryTree<>(data);

        // 다시 한 번 크기 비교
        if (parentNode.getData().compareTo(data) > 0) { // 부모 데이터 > 자식. 왼쪽
            parentNode.setLeftSubTree(newNode);
        } else {
            parentNode.setRightSubTree(newNode); // 부모 데이터 < 자식 . 오른쪽
        }
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

    public BinaryTree<T> remove(T target) {
        BinaryTree<T> fakeParentRootNode = new BinaryTree<T>(null); // 루트 노드를 제거할 때 사용
        BinaryTree<T> parentNode = fakeParentRootNode;

        BinaryTree<T> currentNode = root;
        BinaryTree<T> deletingNode = null; //여기에 반환 값을 담아 넘김

        fakeParentRootNode.setRightSubTree(this.root);

        while (currentNode != null && currentNode.getData() != target) {
            parentNode = currentNode;

            if (currentNode.getData().compareTo(target) > 0) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        //제거 할 노드를 찾지 못한 경우
        if (currentNode == null) {
            return null;
        }

        deletingNode = currentNode;

        //자식 노드가 하나도 없는 경우
        if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree();
            } else {
                parentNode.removeRightSubTree();
            }
        }

        //자식 노드가 1개인 노드를 제거하는 경우
        else if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
            BinaryTree<T> deletingNodeChild;

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

            deletingNode = replacingNode;
            deletingNode.setData(deletingNodeData);
        }

        //루트를 제거할 경우
        if (fakeParentRootNode.getRightSubTree() != root) {
            root = fakeParentRootNode.getRightSubTree();
        }

        return deletingNode;
    }
}
