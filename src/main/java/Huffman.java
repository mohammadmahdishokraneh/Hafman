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
    int spaceR = 0;

    public void getMain() {
        String main = Test.input.nextLine();
        String[] mainSplit = main.split("");
        all += mainSplit.length;
        checkRepetition(mainSplit);


    }

    public void checkRepetition(String[] s) {


        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "a" -> aR++;
                case "b" -> bR++;
                case "c" -> cR++;
                case "d" -> dR++;
                case "e" -> eR++;
                case "f" -> fR++;
                case "g" -> gR++;
                case "h" -> hR++;
                case "i" -> iR++;
                case "j" -> jR++;
                case "k" -> kR++;
                case "l" -> lR++;
                case "m" -> mR++;
                case "n" -> nR++;
                case "o" -> oR++;
                case "p" -> pR++;
                case "q" -> qR++;
                case "r" -> rR++;
                case "s" -> sR++;
                case "t" -> tR++;
                case "u" -> uR++;
                case "v" -> vR++;
                case "w" -> wR++;
                case "x" -> xR++;
                case "y" -> yR++;
                case "z" -> zR++;
                case " " -> spaceR++;
            }
        }
        //switch-case
    }
    public void makeNodes(){
        Node a = new Node("a",aR);
        Node b = new Node("b",bR);
        Node c = new Node("c",cR);
        Node d = new Node("d",dR);
        Node e = new Node("e",eR);
        Node f = new Node("f",fR);
        Node g = new Node("g",gR);
        Node h = new Node("h",hR);
        Node i = new Node("i",iR);
        Node j = new Node("j",jR);
        Node k = new Node("k",kR);
        Node l = new Node("l",lR);
        Node m = new Node("m",mR);
        Node n = new Node("n",nR);
        Node o = new Node("o",oR);
        Node p = new Node("p",pR);
        Node q = new Node("q",qR);
        Node r = new Node("r",rR);
        Node s = new Node("s",sR);
        Node t = new Node("t",tR);
        Node u = new Node("u",uR);
        Node v = new Node("s",vR);
        Node w = new Node("w",wR);
        Node x = new Node("x",xR);
        Node y = new Node("y",yR);
        Node z = new Node("z",zR);
        Node space = new Node(" ",spaceR);
        //___________________________________________
        Tree aTree = new Tree(a);
        Tree bTree = new Tree(b);
        Tree cTree = new Tree(c);
        Tree dTree = new Tree(d);
        Tree eTree = new Tree(e);
        Tree fTree = new Tree(f);
        Tree gTree = new Tree(g);
        Tree hTree = new Tree(h);
        Tree iTree = new Tree(i);
        Tree jTree = new Tree(j);
        Tree kTree = new Tree(k);
        Tree lTree = new Tree(l);
        Tree mTree = new Tree(m);
        Tree nTree = new Tree(n);
        Tree oTree = new Tree(o);
        Tree pTree = new Tree(p);
        Tree qTree = new Tree(q);
        Tree rTree = new Tree(r);
        Tree sTree = new Tree(s);
        Tree tTree = new Tree(t);
        Tree uTree = new Tree(u);
        Tree vTree = new Tree(v);
        Tree wTree = new Tree(w);
        Tree xTree = new Tree(x);
        Tree yTree = new Tree(y);
        Tree zTree = new Tree(z);
        Tree spaceTree = new Tree(space);

    }
    public void makeQueues(){

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
