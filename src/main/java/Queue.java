import java.util.ArrayList;

public class Queue {
    ArrayList<Node> nodes;
    Node root;

    public Queue() {
        nodes = new ArrayList<>();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return nodes.isEmpty();
    }

    public void enQueue(Node element) {
        nodes.add(element);
    }

    public Node deQueue() {
        if (!isEmpty()) {
            Node minNode = nodes.get(0);
            for (int i = 1; i < nodes.size(); i++)
                if(minNode.getNumber() > nodes.get(i).getNumber())
                    minNode = nodes.get(i);

            return minNode;
        }
        System.out.println("Queue is empty!");
        return null;
    }
}