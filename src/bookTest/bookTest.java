package bookTest;

public class bookTest {
	public static book b;

	public static void main(String[] args) {
		b = new book(3);
		b.nextPage();
		System.out.println(b.getCurrentPage());
		b.nextPage();
		System.out.println(b.getCurrentPage());
		b.nextPage();
		System.out.println(b.getCurrentPage());
		
	}
}
