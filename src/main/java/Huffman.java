import java.io.*;

public class Huffman {
    static int all = 0;
    QueueTree queueTree = new QueueTree();

    public void getMain() {
        String main = Test.input.nextLine();

        if (main.length()==0) {
            System.out.println("The entrance is empty!");
            System.exit(0);
        }

        String[] mainSplit = main.split("");
        all += mainSplit.length;
        checkRepetition(mainSplit);
    }

    public void checkRepetition(String[] str) {
        Node node = new Node(str[0], 1);
        queueTree.enQueue(node);

        for (int i = 1; i < str.length; i++) {
            for (int j = 0; j < queueTree.nodes.size(); j++) {
                if (str[i].equalsIgnoreCase(queueTree.nodes.get(j).getStr())) {
                    queueTree.nodes.get(j).setNumber(queueTree.nodes.get(j).getNumber() + 1);
                    break;
                }else{
                    node.setStr(str[i]);
                    node.setNumber(1);
                    queueTree.enQueue(node);
                }
            }
        }
    }

    public void huffmanTree() {

        while (queueTree.nodes.size() != 1){
            Node left = queueTree.deQueue();
            Node right = queueTree.deQueue();
            Node merge = left.merge(right);
            merge.left = left;
            merge.right = right;
            queueTree.enQueue(merge);
        }

        queueTree.root = queueTree.deQueue();
    }

    public void characterCodding() {


    }

    public void writeCodedFile(byte b) throws IOException {
        File coddingFile = new File("Text.txt");
        FileWriter fileWriter = new FileWriter(coddingFile );
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(b);
        writer.close();


        //whit buffer writer
    }

    public void readCodedFile() throws IOException {
        File coddingFile = new File("Text.txt");
        FileReader fileWriter = new FileReader(coddingFile );
        BufferedReader reader = new BufferedReader(fileWriter);
        String s = reader.readLine();

        //byte [] bytes =

        //whit buffer reader
    }


}
