import java.util.ArrayList;

public class QueueTree {
    ArrayList<Node> nodes;
    Node root;

    public QueueTree() {
        nodes = new ArrayList<>();
    }

    public boolean isEmpty(){
        return nodes.isEmpty();
    }

    public void enQueue(Node node) {
        nodes.add(node);
    }

    public Node deQueue() {
        if (!isEmpty()) {
            Node minNode = nodes.get(0);
            for (int i = 1; i < nodes.size(); i++)
                if(minNode.getNumber() > nodes.get(i).getNumber())
                    minNode = nodes.get(i);
            nodes.remove(minNode);
            return minNode;
        }
        System.out.println("Queue is empty!");
        return null;
    }

    public boolean increase(String str){
        if (nodes.size() == 0)
            return false;

        for (Node node : nodes) {
            if (node.getStr().equalsIgnoreCase(str)) {
                node.setNumber(node.getNumber() + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node node : nodes) {
            s.append(node.getStr()).append(node.getCode()).append(" ");
        }
        return s.toString();
    }

    void inorderTraversal(Node t) {
        if (t != null) {
            inorderTraversal(t.left);
            System.out.print(t.getStr() + ":" + t.getNumber() + " ");
            inorderTraversal(t.right);
        }
    }

    void preorderTraversal(Node t) {
        if (t != null) {
            System.out.print(t.getStr() + ":" + t.getNumber() + " ");
            preorderTraversal(t.left);
            preorderTraversal(t.right);
        }
    }
}