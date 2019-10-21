package classHierarchies;

public class DiplomaWithHonors extends Diploma {
	
	public DiplomaWithHonors(String n, String s) {
		super(n, s);
	}
	
	public String toString() {
		return super.toString() + "\n*** with honors ***"; 
	}

}
