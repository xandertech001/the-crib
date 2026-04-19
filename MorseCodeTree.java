import java.util.ArrayList;

/**
 * A linked binary tree used to convert Morse code into English letters.
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root;

    /**
     * Constructor - calls the buildTree method
     */
    public MorseCodeTree() {
        root = new TreeNode<>("");
        buildTree();
    }

    /**
     * Returns a reference to the root
     * @return reference to root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root of the Tree
     * @param newNode a TreeNode that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    /**
     * Adds result to the correct position in the tree based on the code
     * @param code the code for the new node to be added
     * @param letter the letter to be added
     */
    @Override
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    /**
     * Fetch the data in the tree based on the code
     * @param code the code that describes the traversals within the tree
     * @return the result that corresponds to the code
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * This is a recursive method that adds element to the correct position
     * in the tree based on the code. '.' goes left, '-' goes right.
     * @param current the root of the tree for this recursive instance
     * @param code the code for this recursive instance
     * @param letter the data of the new TreeNode to be added
     */
    public void addNode(TreeNode<String> current, String code, String letter) {
        if (code.length() == 0) {
            current.setData(letter);
            return;
        }

        if (code.charAt(0) == '.') {
            if (current.getLeft() == null)
                current.setLeft(new TreeNode<>(""));
            addNode(current.getLeft(), code.substring(1), letter);
        } else {
            if (current.getRight() == null)
                current.setRight(new TreeNode<>(""));
            addNode(current.getRight(), code.substring(1), letter);
        }
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode
     * that corresponds with the code
     * @param current the root of the tree for this recursive instance
     * @param code the code for this recursive instance
     * @return the data corresponding to the code
     */
    public String fetchNode(TreeNode<String> current, String code) {
        if (code.length() == 0) {
            return current.getData();
        }

        if (code.charAt(0) == '.') {
            return fetchNode(current.getLeft(), code.substring(1));
        } else {
            return fetchNode(current.getRight(), code.substring(1));
        }
    }

    /**
     * This method builds the LinkedConverterTree by inserting TreeNodes
     * into their proper locations
     */
    @Override
    public void buildTree() {
        insert(".-", "a");
        insert("-...", "b");
        insert("-.-.", "c");
        insert("-..", "d");
        insert(".", "e");
        insert("..-.", "f");
        insert("--.", "g");
        insert("....", "h");
        insert("..", "i");
        insert(".---", "j");
        insert("-.-", "k");
        insert(".-..", "l");
        insert("--", "m");
        insert("-.", "n");
        insert("---", "o");
        insert(".--.", "p");
        insert("--.-", "q");
        insert(".-.", "r");
        insert("...", "s");
        insert("-", "t");
        insert("..-", "u");
        insert("...-", "v");
        insert(".--", "w");
        insert("-..-", "x");
        insert("-.--", "y");
        insert("--..", "z");
    }

    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList LNR (Inorder)
     * @param node the root of the tree for this recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    public void LNRoutputTraversal(TreeNode<String> node, ArrayList<String> list) {
        if (node != null) {
            LNRoutputTraversal(node.getLeft(), list);
            list.add(node.getData());
            LNRoutputTraversal(node.getRight(), list);
        }
    }

    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        // NOT IMPLEMENTED
        return null;
    }
    
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        // NOT IMPLEMENTED
        return null;
    }
}