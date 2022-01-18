public class Node {
    String character;
    int repetition;
    Node right;
    Node left;

    public Node(String character, int repetition) {

    }


    public String getCharacter() {
        return character;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }
}
