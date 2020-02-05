package bFS;

import java.util.ArrayList;

public class Node {
	
	private ArrayList<Node> children;
	private int value;
	
	public Node(int v) {
		value = v;
		children = new ArrayList<Node>();
	}
	
	public void addChild(Node n) {
		children.add(n);
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}
	
	public int getValue() {
		return value;
	}
}
