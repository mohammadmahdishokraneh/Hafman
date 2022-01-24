public class Node {

    private String str;
    private int number;
    Node right;
    Node left;

    public Node(String str, int number) {
        this.str = str;
        this.number = number;
    }

    public Node(String str, int number, Node right, Node left) {
        this.str = str;
        this.number = number;
        this.right = right;
        this.left = left;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node merge(Node node){
        return new Node(this.str + node.str, this.number + node.number);
    }
}
