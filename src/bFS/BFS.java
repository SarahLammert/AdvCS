package bFS;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BFS {
	private ArrayList<Node> list;
	private ArrayDeque<Node> deque;
	private Node root;

	public BFS() {
		list = new ArrayList<Node>();
		deque = new ArrayDeque<Node>();
		root = null;
	}

	public void addNode(Node n) {
		list.add(n);
	}

	public void setRoot(int r) {
		root = list.get(r-1);
	}

	public void setChild(int x, int y) {
		list.get(x-1).addChild(list.get(y-1));
	}

	public ArrayDeque<Node> getDeque() {
		return deque;
	}

	public Node getRoot() {
		return root;
	}
	
	public int getHops(int target) {
		deque.add(root);
		int hops = 0;
		int currentCount = 1;
		int nextCount = 0;
		while(!deque.isEmpty()) {
			Node a = deque.pop();
			if(a.getValue() == target) {
				break;
			}
			for(int i = 0; i < a.getChildren().size(); i++) {
				deque.addLast(a.getChildren().get(i));
			}
			nextCount += a.getChildren().size();
			currentCount -= 1;
			if(currentCount == 0) {
				hops += 1;
				currentCount = nextCount;
				nextCount = 0;
			}
		}
		return hops;
	}

	public static void main(String [] args) {
		System.out.println("# of #s");
		System.out.println("# of Connections");
		System.out.println("Root");
		System.out.println("Target");
		System.out.println("Connections");
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); //Amount of numbers
		int m = s.nextInt(); //Number of connections
		int r = s.nextInt();
		int t = s.nextInt();
		BFS b = new BFS();
		
		for(int x = 1; x <= n; x++) {
			b.addNode(new Node(x));
		}
		
		for(int i = 0; i < m; i++) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			b.setChild(x1, y1);
			b.setChild(y1, x1);
		}
		s.close();
		
		b.setRoot(r);
		
		System.out.println("The answer is " + b.getHops(t) + " hops.");
	}
}