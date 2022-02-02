import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
    String[] mainSplit;
    QueueTree queueTree = new QueueTree();
    QueueTree queueTreeDecode = new QueueTree();
    JFrame f = new JFrame();
    String result = "";

    public void getMain() {

        Scanner input = new Scanner(System.in);
        String main = JOptionPane.showInputDialog("Enter your Text : ");
        while (main.length() == 0) {
            JOptionPane.showMessageDialog(f, "The entrance is empty! Try again");
            main = input.nextLine();
        }

        mainSplit = main.split("");
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
            node.right.setCode(node.getCode() + "1");
            codeForLetter(node.right);
        }
        if (node.left != null && queueTree.root != node) {
            node.left.setCode(node.getCode() + "0");
            codeForLetter(node.left);
        }
    }

    public void compression() throws IOException {

        for (String s : mainSplit) {
            for (int i = 0; i < queueTree.nodes.size(); i++) {
                if (queueTree.nodes.get(i).getStr().equalsIgnoreCase(s)) {
                    result += queueTree.nodes.get(i).getCode();
                    break;
                }
            }
        }
        writeCodedFile(result);

    }

    public void Preparation(String let) {
        String[] split = let.split("\\.");
        ArrayList<String> chars = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        for (String value : split) {
            chars.add(value.substring(0, 1));
            codes.add(value.substring(1));
        }
        for (int i = 0; i < chars.size(); i++) {
            Node node = new Node(chars.get(i), codes.get(i));
            queueTreeDecode.nodes.add(node);
        }
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
        byte[] bytes = in.readAllBytes();
        codedString = codedString + toBinary(bytes);
        in.close();
        String s = b.readLine();
        x.close();
        Preparation(s);
        decode(codedString);
    }

    public void decode(String result) {
        String decoded = "";
        while (!result.equals("")) {
            for (int i = 0; i < queueTreeDecode.nodes.size(); i++) {
                int length = queueTreeDecode.nodes.get(i).getCode().length();
                if (result.length() >= length) {
                    if (result.substring(0, length).equals(queueTreeDecode.nodes.get(i).getCode())) {
                        decoded = decoded + (queueTreeDecode.nodes.get(i).getStr());
                        result = result.substring(length);
                        break;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(f, decoded);
    }


    String toBinary(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for (int i = 0; i < Byte.SIZE * bytes.length; i++)
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }

}
