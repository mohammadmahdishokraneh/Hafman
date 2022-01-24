import java.io.*;
import java.util.BitSet;

public class Huffman {
    static int all = 0;
    String main;
    QueueTree queueTree = new QueueTree();

    public void getMain() {
        main = Test.input.nextLine();

        while (main.length() == 0) {
            System.out.println("The entrance is empty! Try again");
            main = Test.input.nextLine();
        }

        String[] mainSplit = main.split("");
        all += mainSplit.length;
        checkRepetition(mainSplit);
    }

    public void checkRepetition(String[] str) {

        for (String s : str) {
            if (!queueTree.increase(s)) {
                Node node = new Node(s, 1);
                queueTree.enQueue(node);
            }
        }
    }

    public void huffmanTree() {

        while (queueTree.nodes.size() != 1) {
            Node left = queueTree.deQueue();
            Node right = queueTree.deQueue();
            Node merge = left.merge(right);
            merge.left = left;
            merge.right = right;
            queueTree.enQueue(merge);
        }

        queueTree.root = queueTree.deQueue();
    }

    public void codeForLetter(Node node) {
        if (node.left ==null && node.right == null) {
            queueTree.enQueue(node);
            return;
        }

        if (queueTree.root == node){
            node.right.setCode("1");
            codeForLetter(node.right);
            node.left.setCode("0");
            codeForLetter(node.left);
        }

        if (node.right != null&&queueTree.root != node) {
            node.right.setCode("1" + node.getCode());
            codeForLetter(node.right);
        }
        if (node.left !=null&&queueTree.root != node) {
            node.left.setCode("0" + node.getCode());
            codeForLetter(node.left);
        }
    }

    public void compression(){

    }

    public void writeCodedFile(byte b) throws IOException {
        File coddingFile = new File("Text.txt");
        FileOutputStream f = new FileOutputStream(coddingFile);
        ObjectOutputStream out = new ObjectOutputStream(f);
        out.writeObject(b);
        out.close();
    }

    public void readCodedFile() throws IOException, ClassNotFoundException {
        File coddingFile = new File("Text.txt");
        FileInputStream f = new FileInputStream(coddingFile);
        ObjectInputStream in = new ObjectInputStream(f);
        byte b = (byte)in.readObject();

        //byte [] bytes =

        //whit buffer reader
    }
}
