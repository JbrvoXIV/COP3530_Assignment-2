class Main {

    public static int countGreaterThanValue(BinaryNode<Integer> root, int value) {
        if(root == null) {
            return 0;
        }

        if(root.element > value) {
            return 1 + countGreaterThanValue(root.left, value) + countGreaterThanValue(root.right, value);
        }

        return 0 + countGreaterThanValue(root.left, value) + countGreaterThanValue(root.right, value);
    } // needs work

    public static boolean isSymmetric(BinaryNode<Integer> root) {
        return isSymmetricHelper(root, root);
    }

    private static boolean isSymmetricHelper(BinaryNode<Integer> node1, BinaryNode<Integer> node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 != null && node2 != null) {
            return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
        }
        return false;
    } // needs work

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<Integer>(
            10, new BinaryNode<>(
                8, new BinaryNode<>(6), new BinaryNode<>(9)
                ), new BinaryNode<>(
                    14, new BinaryNode<>(12), new BinaryNode<>(null)
                    )
        );
        // System.out.println(countGreaterThanValue(root, 9));
        System.out.println(isSymmetric(root));
    }
}