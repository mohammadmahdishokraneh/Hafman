import java.io.*;

public class Huffman {
    static int all = 0;
    String[] mainSplit;
    QueueTree queueTree = new QueueTree();

    public void getMain() {
        String main = Test.input.nextLine();

        while (main.length() == 0) {
            System.out.println("The entrance is empty! Try again");
            main = Test.input.nextLine();
        }

        mainSplit = main.split("");
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
        if (node.left == null && node.right == null) {
            queueTree.enQueue(node);
            return;
        }

        if (queueTree.root == node) {
            node.right.setCode("1");
            codeForLetter(node.right);
            node.left.setCode("0");
            codeForLetter(node.left);
        }

        if (node.right != null && queueTree.root != node) {
            node.right.setCode("1" + node.getCode());
            codeForLetter(node.right);
        }
        if (node.left != null && queueTree.root != node) {
            node.left.setCode("0" + node.getCode());
            codeForLetter(node.left);
        }
    }

    public void compression() throws IOException {
        String result = "";
        for (String s : mainSplit) {
            for (int i = 0; i < queueTree.nodes.size(); i++) {
                if (queueTree.nodes.get(i).getStr().equalsIgnoreCase(s)) {
                    result += queueTree.nodes.get(i).getCode();
                    break;
                }
            }
        }
        System.out.println(result);
        byte bs[];
        if (result.length()%8==0){
            bs = new byte[(result.length() / 8)];
        }else
            bs = new byte[(result.length() / 8)+1];
        mainSplit = result.split("");
        byte b = 0;
        for (int i = 1; i <= mainSplit.length; i++) {
            b = (byte) (b << 1);
            if (mainSplit[i - 1].equalsIgnoreCase("1"))
                b++;
            if ((i % 8) == 0 )
                bs[(i/8)-1] = b;
            else if (i == mainSplit.length)
                bs[i/8] = b;
        }
        writeCodedFile(bs);
    }

    public void writeCodedFile(byte[] b) throws IOException {
        File coddingFile = new File("Text.txt");
        FileOutputStream f = new FileOutputStream(coddingFile);
        ObjectOutputStream out = new ObjectOutputStream(f);
        out.write(b);
    }

    public void readCodedFile() throws IOException, ClassNotFoundException {
        File coddingFile = new File("Text.txt");
        FileInputStream f = new FileInputStream(coddingFile);
        ObjectInputStream in = new ObjectInputStream(f);
        byte[] b = in.readAllBytes();
        System.out.println(b[0]);
        //byte [] bytes =

        //whit buffer reader
    }
}
