public class Huffman {
    static int all = 0;
    int aR = 0;
    int bR = 0;
    int cR = 0;
    int dR = 0;
    int eR = 0;
    int fR = 0;
    int gR = 0;
    int hR = 0;
    int iR = 0;
    int jR = 0;
    int kR = 0;
    int lR = 0;
    int mR = 0;
    int nR = 0;
    int oR = 0;
    int pR = 0;
    int qR = 0;
    int rR = 0;
    int sR = 0;
    int tR = 0;
    int uR = 0;
    int vR = 0;
    int wR = 0;
    int xR = 0;
    int yR = 0;
    int zR = 0;

    public void getMain() {
        String main = Test.input.nextLine();
        String[] mainSplit = main.split("");
        all += mainSplit.length;
        checkRepetition(mainSplit);


    }

    public void checkRepetition(String[] s) {


        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "a":
                    aR++;
                    break;
                case "b":
                    bR++;
                    break;
                case "c":
                    cR++;
                    break;
                case "d":
                    dR++;
                    break;
                case "e":
                    eR++;
                    break;
                case "f":
                    fR++;
                    break;
                case "g":
                    gR++;
                    break;
                case "h":
                    hR++;
                    break;
                case "i":
                    iR++;
                    break;
                case "j":
                    jR++;
                    break;
                case "k":
                    kR++;
                    break;
                case "l":
                    lR++;
                    break;
                case "m":
                    mR++;
                    break;
                case "n":
                    nR++;
                    break;
                case "o":
                    oR++;
                    break;
                case "p":
                    pR++;
                    break;
                case "q":
                    qR++;
                    break;
                case "r":
                    rR++;
                    break;
                case "s":
                    sR++;
                    break;
                case "t":
                    tR++;
                    break;
                case "u":
                    uR++;
                    break;
                case "v":
                    vR++;
                    break;
                case "w":
                    wR++;
                    break;
                case "x":
                    xR++;
                    break;
                case "y":
                    yR++;
                    break;
                case "z":
                    zR++;
                    break;
                case " ":
                    zR++;
                    break;
            }
        }
        //switch-case
    }

    public void makeTree(String s) {

    }


    public void huffmanTree() {

        //recursive
    }

    public void characterCodding() {

    }

    public void codding() {
        //whit buffer writer
    }

    public void readCodedFile() {
        //whit buffer reader
    }


}
