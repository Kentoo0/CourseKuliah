/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihab;

/**
 *
 * @author Erlang Anggara
 */
public class StrukDatBinaryTree {

    class Node {

        char label;
        Node left, right, parent;
    }
    Node root, newNode;

    void createNewTree(char label) {
        if (root != null) {
            System.out.println("Tree Sudah Dibuat");
        } else {
            root = new Node();
            root.label = label;
            root.left = null;
            root.right = null;
            root.parent = null;

            System.out.println("\nNode" + label + " Berhasil Dibuat Menjadi Root");
        }
    }

    public Node InsertLeft(char label, Node node) {
        if (root == null) {
            System.out.println("Buat Tree Terlebih Dahulu");
            return null;
        } else {
            if (node.left != null) {
                System.out.println("\nNode" + node.label + "Sudah ada anak di kiri");
                return null;
            } else {
                Node newNode = new Node();
                newNode.label = label;
                newNode.left = null;
                newNode.right = null;
                newNode.parent = node;
                node.left = newNode;

                System.out.println("\nNode" + label + " berhasil ditambahkan ke anak kiri" + newNode.parent.label);
                return newNode;
            }
        }
    }

    public Node InsertRight(char label, Node node) {
        if (root == null) {
            System.out.println("Buat Tree Terlebih Dahulu");
            return null;
        } else {
            if (node.right != null) {
                System.out.println("Node" + node.label + "Sudah ada anak kanan");
                return null;
            } else {
                Node newNode = new Node();
                newNode.label = label;
                newNode.left = null;
                newNode.right = null;
                newNode.parent = node;
                node.right = newNode;

                System.out.println("Node" + label + "Berhasil ditambahkan ke anak kanan " + newNode.parent.right);
                return newNode;

            }
        }
    }
    
    public void preOrder(Node node){
        if (root == null){
            System.out.println("Buat tree terlebih dahulu");
        }else{
            if(node != null){
                System.out.println(node.label+", ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }
    }
    
    public void inOrder(Node node){
        if(root == null){
            System.out.println("Buat tree terlebih dahulu");
        }else{
            if (node != null){
                inOrder(node.left);
                System.out.println(node.label+", ");
                inOrder(node.right);
            }
        }
    }
    
    public void postOrder(Node node){
        if(root == null){
            System.out.println("Buat tree terlebih dahulu");
        }else{
            if(node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.label+", ");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StrukDatBinaryTree tree = new StrukDatBinaryTree();
        tree.createNewTree('A');

        Node nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeJ;
        
        nodeB = tree.InsertLeft('B', tree.root);
        nodeC = tree.InsertRight('C', tree.root);
        nodeD = tree.InsertLeft('D', nodeB);
        nodeE = tree.InsertRight('E', nodeB);
        nodeF = tree.InsertLeft('F', nodeC);
        nodeG = tree.InsertLeft('G', nodeE);
        nodeH = tree.InsertRight('H', nodeE);
        nodeI = tree.InsertLeft('I', nodeG);
        nodeJ = tree.InsertRight('J', nodeG);

        System.out.println("Preorder");
        tree.preOrder(tree.root);   
        System.out.println("\n");
        
        System.out.println("InOrder");
        tree.inOrder(tree.root);
        System.out.println("\n");
        
        System.out.println("PostOrder");
        tree.postOrder(tree.root);
        System.out.println("\n");
    }

}
