package chatBot;
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";

		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);

		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

		//  Try other methods here:
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
		
		int foundPsn = sample.indexOf("quick", 5);
		System.out.println("sample.indexOf(\"quick\", 5) = " + foundPsn);
		foundPsn = sample.indexOf("quick", 2);
		System.out.println("sample.indexOf(\"quick\", 2) = " + foundPsn);

	}

}