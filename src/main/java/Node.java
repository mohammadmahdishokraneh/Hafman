public class Node {

    private String str, code;
    private int number;
    Node right;
    Node left;

    public Node(String str, int number) {
        this.str = str;
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
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

    public Node merge(Node node){
        return new Node(this.str + node.str, this.number + node.number);
    }
}
