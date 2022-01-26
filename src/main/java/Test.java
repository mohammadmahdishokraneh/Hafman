import java.io.IOException;
import java.util.Scanner;

public class Test {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Huffman huffman = new Huffman();
//        huffman.getMain();
//        System.out.println(huffman.queueTree.toString());
//        huffman.huffmanTree();
//        huffman.queueTree.inorderTraversal(huffman.queueTree.root);
//        System.out.println();
//        huffman.queueTree.preorderTraversal(huffman.queueTree.root);
//        huffman.codeForLetter(huffman.queueTree.root);
//        System.out.println();
//        System.out.println(huffman.queueTree.toString());
//        huffman.compression();
//        huffman.writeCodedFile((byte) {46, 35});
        huffman.readCodedFile();
    }
}