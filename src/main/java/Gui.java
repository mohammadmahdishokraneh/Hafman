import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Gui extends WindowAdapter {

    public void choose() throws IOException {
        String inp = JOptionPane.showInputDialog("choose: 1.encode  2.decode  3.encode then decode ");
        Huffman huffman = new Huffman();

        if(inp.equals("1")){

            huffman.getMain();
            huffman.huffmanTree();
            huffman.codeForLetter(huffman.queueTree.root);
            huffman.compression();
        }
        if(inp.equals("2")){
            huffman.readCodedFile();
        }
        if (inp.equals("3")){
            huffman.getMain();
            huffman.huffmanTree();
            huffman.codeForLetter(huffman.queueTree.root);
            huffman.compression();
            huffman.decode();
        }
    }


}