package shuffler;

import java.util.ArrayList;

public class LineList {
	
	private ArrayList<String> a; 
	
	public LineList() {
		a = new ArrayList<String>();
 	}
	public LineList(ArrayList<String> b) {
		a = b;
	}
	
	public int size() {
		return a.size();
	}
	
	public String get(int k) {
		return a.get(k);
	}
	
	public void add(String line) {
		a.add(line);
	}
	
	public String remove(int k) {
		a.remove(k);
		return a.get(k);
	}
	
	public void move(int index, int newIndex) {
		String temp = a.get(index);
		a.remove(index);
		a.add(newIndex, temp);
		
	}
	
	public void shuffle() {
		for(int n = a.size(); n >= 2; n--)
		{
			int k = (int)(Math.random() * n);
			String temp = a.get(k);
			a.set(k, a.get(n-1));
			a.set(n-1, temp);
		}
		
	}
	public String toString() {
		return a.toString();
	}
	
}
