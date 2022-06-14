class Main {

    public static int countGreaterThanValue(BinaryNode<Integer> root, int value) {
        if(root == null) {
            return 0;
        }

        if(root.element > value) {
            return 1 + countGreaterThanValue(root.left, value) + countGreaterThanValue(root.right, value);
        }

        return 0 + countGreaterThanValue(root.left, value) + countGreaterThanValue(root.right, value);
    }

    public static boolean isSymmetric(BinaryNode<Integer> root) {
        BinaryNode<Integer> leftSubtree = root.left;
        BinaryNode<Integer> rightSubtree = root.right;

        if(leftSubtree == null && rightSubtree == null) {
            return true;
        } else if(leftSubtree == null || rightSubtree == null) {
            return false;
        } else {
            while(leftSubtree != null && rightSubtree != null) {
                BinaryNode<Integer> leftSubtreeRoot = leftSubtree;
                BinaryNode<Integer> rightSubtreeRoot = rightSubtree;
                BinaryNode<Integer> leftSubtreeSucNode = leftSubtreeRoot;
                BinaryNode<Integer> rightSubtreeSucNode = rightSubtreeRoot;

                if(leftSubtree.left == null && leftSubtree.right == null) {
                    if(rightSubtree.left == null && rightSubtree.right == null) {
                        leftSubtree = leftSubtreeSucNode;
                        rightSubtree = rightSubtreeSucNode;
                    } else {
                        return false;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<Integer>(
            10, new BinaryNode<>(
                8, new BinaryNode<>(6), new BinaryNode<>(9)
                ), new BinaryNode<>(
                    14, new BinaryNode<>(12), new BinaryNode<>(17)
                    )
        );

        System.out.println(countGreaterThanValue(root, 9));
        System.out.println(isSymmetric(root));
    }
}