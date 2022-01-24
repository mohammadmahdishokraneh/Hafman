import java.util.ArrayList;

public class Queue {
    ArrayList<Element> elements;

    public Queue() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public void enQueue(Element element) {
        elements.add(element);
    }

    public Element deQueue() {
        if (!isEmpty()) {
            Element minElement = elements.get(0);
            for (int i = 1; i < elements.size(); i++)
                if(minElement.getNumber() > elements.get(i).getNumber())
                    minElement = elements.get(i);

            return minElement;
        }
        System.out.println("Queue is empty!");
        return null;
    }
}