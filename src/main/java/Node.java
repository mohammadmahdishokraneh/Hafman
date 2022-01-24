public class Node {
    private Element element;
    Node right;
    Node left;

    public Node(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
