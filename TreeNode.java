/**
 * A generic node for a binary tree.
 */
public class TreeNode<T> {

	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;

	/**
	 * Creates a node with the given data and no children.
	 * @param data the value to store
	 */
	public TreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	/**
	 * Creates a node with the given data and left/right children.
	 * @param data the value to store
	 * @param left the left child
	 * @param right the right child
	 */
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the data stored in this node.
	 * @return the node's data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns the left child.
	 * @return the left child node
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Returns the right child.
	 * @return the right child node
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * Sets the data stored in this node.
	 * @param data the new value
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the left child.
	 * @param left the new left child node
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Sets the right child.
	 * @param right the new right child node
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
}