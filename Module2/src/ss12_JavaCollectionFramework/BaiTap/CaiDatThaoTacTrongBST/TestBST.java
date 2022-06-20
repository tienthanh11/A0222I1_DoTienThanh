package ss12_JavaCollectionFramework.BaiTap.CaiDatThaoTacTrongBST;

public class TestBST {
    public static void main(String[] args) {
        BST<String> treeInorder = new BST<>();
        treeInorder.insert("George");
        treeInorder.insert("Michael");
        treeInorder.insert("Tom");
        treeInorder.insert("Adam");
        treeInorder.insert("Jones");
        treeInorder.insert("Peter");
        treeInorder.insert("Daniel");
        System.out.println("Inorder (sorted): ");
        treeInorder.inorder();
        System.out.println("\nThe number of nodes is: " + treeInorder.getSize());

        System.out.println("===============================================");

        BST<Integer> treePostorder = new BST<>();
        treePostorder.insert(20);
        treePostorder.insert(10);
        treePostorder.insert(17);
        treePostorder.insert(41);
        treePostorder.insert(55);
        treePostorder.insert(5);
        treePostorder.insert(60);
        treePostorder.insert(72);
        treePostorder.insert(4);
        treePostorder.insert(18);
        treePostorder.insert(27);
        treePostorder.insert(35);
        System.out.println("Postorder (sorted): ");
        treePostorder.postorder();
        treePostorder.deleteNode(72);
        System.out.println("\nAfter delete the node is: " );
        treePostorder.postorder();
        System.out.println("\nThe number of nodes is: " + treePostorder.getSize());

        System.out.println("===============================================");

        BST<Integer> treePreorder = new BST<>();
        treePreorder.insert(27);
        treePreorder.insert(11);
        treePreorder.insert(5);
        treePreorder.insert(29);
        treePreorder.insert(24);
        treePreorder.insert(26);
        treePreorder.insert(3);
        treePreorder.insert(4);
        treePreorder.insert(10);
        treePreorder.insert(16);
        treePreorder.insert(13);
        System.out.println("Preorder (sorted): ");
        treePreorder.preorder();
        System.out.println("\nThe number of the node to find is: " + treePreorder.search(11));
        System.out.println("\nThe number of nodes is: " + treePreorder.getSize());
    }
}
