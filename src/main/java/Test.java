import java.io.IOException;

public class Test {


    public static void main(String[] args) throws IOException{
        Huffman huffman = new Huffman();
        huffman.getMain();
        huffman.huffmanTree();
        huffman.codeForLetter(huffman.queueTree.root);
        huffman.compression();
        huffman.readCodedFile();
    }
}