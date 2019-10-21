package classHierarchies;

public class Diploma {
	private String name;
	private String subject;
	
	public Diploma(String n, String s) {
		name = n;
		subject = s;
	}

	public String toString() {
		return "This certifies that " + name + "\nhas completed MOOC in " + subject;
		
	}
}
