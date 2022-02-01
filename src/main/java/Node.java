public class Node {

    private final String str;
    private String code;
    private int number;
    Node right;
    Node left;

    public Node(String str, String code) {
        this.str = str;
        this.code = code;
    }
    public Node(String str, int number) {
        this.str = str;
        this.number = number;
    }



    public String getStr() {
        return str;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node merge(Node node) {
        return new Node(this.str + node.str, this.number + node.number);
    }
}
