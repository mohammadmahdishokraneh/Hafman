import java.util.ArrayList;

public class Queue {
    private ArrayList<Node> queue;

    public Queue() {
        this.queue = new ArrayList<Node>();
    }

    public void Enqueue(Node node) {
        queue.add(node);
    }

    public Node Dequeue() {
        if (size() > 0) {
            return queue.remove(0);
        }
        return null;
    }

    public int size() {
        return queue.size();
    }

}