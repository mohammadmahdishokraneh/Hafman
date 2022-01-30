import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
    static int all = 0;
    String[] mainSplit;
    QueueTree queueTree = new QueueTree();
    QueueTree queueTreeDecode = new QueueTree();

    public void getMain() {
        Scanner input = new Scanner(System.in);
        String main = input.nextLine();


        while (main.length() == 0) {
            System.out.println("The entrance is empty! Try again");
            main = input.nextLine();
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
        writeCodedFile(result);
        System.out.println(result);


    }

    public void writeCodedFile(String s) throws IOException {
        File coddingFile = new File("Text.txt");
        File letterCoddingFile = new File("lettersCode.txt");
        FileOutputStream f = new FileOutputStream(coddingFile);
        FileWriter x = new FileWriter(letterCoddingFile);
        BufferedWriter b = new BufferedWriter(x);

        byte buffer = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {

            buffer = (byte) (buffer * 2);

            if (s.charAt(i) == '1') {
                buffer = (byte) (buffer + 1);
            }
            if (i % 8 == 7 || i == n - 1) {
                f.write(buffer);
                buffer = 0;
            }
        }

        f.close();
        b.write(queueTree.toString());
        b.close();
    }

    public void readCodedFile() throws IOException {
        File coddingFile = new File("Text.txt");
        FileInputStream in = new FileInputStream(coddingFile);
        File letterCoddingFile = new File("lettersCode.txt");
        FileReader x = new FileReader(letterCoddingFile);
        BufferedReader b = new BufferedReader(x);
        String codedString = "";
        StringBuilder decoded = new StringBuilder();

        byte[] bytes = in.readAllBytes();
        for (byte aByte : bytes) {
            int k = aByte;
            codedString = codedString + decToBinary(k);

            //decToBinary((int) aByte);//
        }
        //codedString = Integer.toBinaryString(Integer.parseInt(codedString));
        in.close();
        System.out.println(codedString);
        String s = b.readLine();
        x.close();

        String[] split = s.split(" ");
        ArrayList<String> chars = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        for (String value : split) {
            if(value.charAt(0) == ' ')
                chars.add(" ");

            chars.add(value.substring(0, 1));
            codes.add(value.substring(1));
        }


        for (int i = 0; i < chars.size(); i++) {
            Node node = new Node(chars.get(i), codes.get(i));
            queueTreeDecode.enQueue(node);
        }
        for (int i = 0; i < chars.size(); i++) {

            int length = queueTree.nodes.get(i).getCode().length();

            if (queueTree.nodes.get(i).getCode().equals(codedString.substring(0, length + 1))) {
                decoded.append(queueTree.nodes.get(i).getStr());

                codedString = codedString.substring(length + 1);
                i++;
            }

        }
        System.out.println(decoded);
    }

    public String decToBinary(int n) {

        int[] binaryNum = new int[1000];
        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        String bi = "";
        for (int j = i - 1; j >= 0; j--)
            bi = bi + binaryNum[j];

        return bi;
    }
}


//        System.out.println(result);
//        byte bs[];
//        if (result.length()%8==0){
//            bs = new byte[(result.length() / 8)];
//        }else
//            bs = new byte[(result.length() / 8)+1];
//        mainSplit = result.split("");
//        byte b = 0;
//        for (int i = 1; i <= mainSplit.length; i++) {
//            b = (byte) (b << 1);
//            if (mainSplit[i - 1].equalsIgnoreCase("1"))
//                b++;
//            if ((i % 8) == 0 )
//                bs[(i/8)-1] = b;
//            else if (i == mainSplit.length)
//                bs[i/8] = b;
//        }
//        writeCodedFile(bs);