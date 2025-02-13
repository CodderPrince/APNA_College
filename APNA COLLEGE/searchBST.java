
public class searchBST {

    // Define a static class to represent each Node of the Binary Search Tree (BST)
    static class Node {

        int data;     // Value stored in the node
        Node left;    // Pointer to the left child
        Node right;   // Pointer to the right child

        // Constructor to initialize a node with a value
        Node(int data) {
            this.data = data;
        }
    }

    // In-order traversal of the BST (Left, Root, Right)
    public static void inorder(Node root) {
        // Base case: if root is null, return
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorder(root.left);

        // Print the root's data
        System.out.print(root.data + " ");

        // Traverse the right subtree
        inorder(root.right);
    }

    // Insert a value into the BST
    public static Node insert(Node root, int val) {
        // If root is null, create a new node with the value and return it
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If value is less than the root's data, insert into the left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        } // If value is greater than or equal to the root's data, insert into the right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return the root node after insertion
        return root;
    }

    // Search for a key in the BST
    public static boolean search(Node root, int key) {
        // Base case: if root is null, the key is not found
        if (root == null) {
            return false;
        }

        // If the key is smaller, search in the left subtree
        if (key < root.data) {
            return search(root.left, key);
        } // If the key is greater, search in the right subtree
        else if (key > root.data) {
            return search(root.right, key);
        } // If the key matches the root's data, return true
        else {//key == root.data
            return true;
        }
    }

    // Main method to run the BST search
    public static void main(String[] args) {
        // Array of values to be inserted into the BST
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert each value from the array into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Perform in-order traversal to print the values in sorted order
        inorder(root);
        System.out.println();  // Print a new line after traversal

        // Search for the key '1'
        if (search(root, 1)) {
            System.out.println("Found Key!");
        } else {
            System.out.println("Not found!");
        }
    }
}
