package BST;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder:");
        tree.inorder();

        System.out.println("Preorder:");
        tree.preorder();

        System.out.println("Postorder:");
        tree.postorder();

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 100: " + tree.search(100));

        tree.delete(20);
        System.out.println("After delete 20:");
        tree.inorder();
    }
}