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