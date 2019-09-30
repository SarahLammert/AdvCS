package balloonTest;

public class FakeBalloonTest {
	public static FakeBalloon b;

	public static void main(String[] args) {
		b = new FakeBalloon(3);
		b.nextPage();
		System.out.println(b.getCurrentPage());
		b.nextPage();
		System.out.println(b.getCurrentPage());
		b.nextPage();
		System.out.println(b.getCurrentPage());
		
	}
}
