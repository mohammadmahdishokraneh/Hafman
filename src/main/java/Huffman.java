import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
    static int all = 0;
    String[] mainSplit;
    QueueTree queueTree = new QueueTree();
    QueueTree queueTreeDecode = new QueueTree();
    JFrame f = new JFrame();
    String result ="";

    public void getMain() {

        Scanner input = new Scanner(System.in);
        String main = JOptionPane.showInputDialog("Enter your Text : ");
        while (main.length() == 0) {
            JOptionPane.showMessageDialog(f, "The entrance is empty! Try again");
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
        String decoded = "";
        byte[] bytes = in.readAllBytes();
        //ArrayList<Integer> c = new ArrayList<>();
        codedString = codedString + toBinary(bytes);
        for (byte aByte : bytes) {

        }

//        for (int j = 0; j < c.size() - 1; j++) {
//            String n = "";
//            if (c.get(j) < 0) {
//                n = n + "1";
//                c.set(j, 128 + c.get(j));
//            } else {
//                n = n + "0";
//            }
//            for (int i = 6; i >= 0; i--) {
//                int t = (int) Math.pow(2, i);
//                if (c.get(j) > t) {
//                    n = n + "1";
//                    c.set(j, c.get(j) - t);
//
//                } else {
//                    n = n + "0";
//                }
//                if (n.length() > 7) {
//                    codedString = codedString + n;
//                }
//            }
//            int remain = all - n.length();
//            if (remain >= 8) {
//                for (int i = 6; i >= 0; i--) {
//                    int t = (int) Math.pow(2, i);
//                    if (c.get(j) > t) {
//                        n = n + "1";
//                        c.set(j, c.get(j) - t);
//                    } else {
//                        n = n + "0"; }
//                    if (n.length() > 7) {
//                        codedString = codedString + n; }}}
//                    else {
//                        for (int i = remain; i >= 0; i--) {
//                            int t = (int) Math.pow(2, i);
//                            if (c.get(c.size()-1) > t) {
//                                n = n + "1";
//                                c.set(j, c.get(c.size()-1) - t);
//                            } else {
//                                n = n + "0"; }
//                            if (n.length() > 7) {
//                                codedString = codedString + n; }
//                    }
//                }
        in.close();
        System.out.println(codedString);
        String s = b.readLine();
        x.close();
        System.out.println(s);
        String[] split = s.split("\\.");
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

        int i = 0;
        while (!codedString.equals("")) {
            int length = queueTreeDecode.nodes.get(i).getCode().length();
            if (codedString.substring(0, length + 1).equals(queueTreeDecode.nodes.get(i).getCode())) {
                decoded = decoded + (queueTreeDecode.nodes.get(i).getStr());
                codedString = codedString.substring(length + 1);
            }
            i++;
            if (i == queueTreeDecode.nodes.size()) {
                i = 0;
            }
        }
        JOptionPane.showMessageDialog(f, queueTreeDecode.nodes.get(i).getCode());
    }
    public void decode(){
        String letters = queueTree.toString().substring(0,queueTree.toString().length()-1);
        String[] split = letters.split("\\.");
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
        String decoded = "";
        int i =0;
        while (!result.equals("")) {
            int length = queueTreeDecode.nodes.get(i).getCode().length();

            if (result.substring(0, length + 1).equals(queueTreeDecode.nodes.get(i).getCode())) {
                decoded = decoded + (queueTreeDecode.nodes.get(i).getStr());
                result =result.substring(length + 2);
                System.out.println(length);
            }
            i++;
            if (i == queueTreeDecode.nodes.size()-1) {
                i = 0;
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