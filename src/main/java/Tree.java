public class Tree {
    Node root;

    public Tree(Node root) {

    }

    public void insert(int repetition, String character, Node node) {
        if (root == null)
            root = new Node(character, repetition);
        else {

            if (repetition > node.repetition) {
                if (node.right == null)
                    node.right = new Node(character, repetition);
                else
                    insert(repetition, character, node.right);
            } else {
                if (node.left == null)
                    node.right = new Node(character, repetition);
                else
                    insert(repetition, character, node.left);
            }

        }

    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.repetition);
            inorderTraversal(node.right);
        }
    }


}
