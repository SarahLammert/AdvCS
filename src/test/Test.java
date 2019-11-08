package test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		String s = new String("Hi");
		ArrayList<String> b = new ArrayList<String>();
		b.add(s);
		b.remove(0);
		System.out.println(s);
	}
}
