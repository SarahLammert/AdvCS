package shuffler;

import java.util.ArrayList;

public class TestShuffle {
	public static void main(String[] args) {
		
		ArrayList<String> s = new ArrayList<String>();
		s.add("Hi");
		s.add("Howdy");
		s.add("Hallo");
		s.add("Hola");
		s.add("Hello");

		LineList t = new LineList(s);
		t.add("Hey");
		System.out.println(t);
		System.out.println(t.size());
		t.remove(1);
		System.out.println(t);
		t.move(0, 2);
		System.out.println(t);
		t.shuffle();
		System.out.println(t);
		t.shuffle();
		System.out.println(t);
	}

}
