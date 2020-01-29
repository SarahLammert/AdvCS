package doItYourselfBST;

public class TreeNode {
	private Object value;
	private TreeNode left;
	private TreeNode right;
	
	TreeNode(Object v) {
		value = v;
		left = null;
		right = null;
	}
	TreeNode(String v, TreeNode l, TreeNode r) {
		value = v;
		left = l;
		right = r;
	}
	
	Object getValue() {
		return value;
	}
	
	TreeNode getLeft() {
		return left;
	}
	
	TreeNode getRight() {
		return right;
	}
	
	void setValue(Object v) {
		value = v;
	}
	
	void setLeft(TreeNode l) {
		left = l;
	}
	
	void setRight(TreeNode r) {
		right = r;
	}
}