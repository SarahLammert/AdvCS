package harryPotterReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCounter {
	
	private ArrayList<Word> uniqueWords = new ArrayList<Word>(80000);
	
	
	public WordCounter() {
		
	}
	
	//This will open any file passed to this method
	public void openFile(String fileName) {
		try {
			Scanner s = new Scanner(new File(fileName + ".txt"));
			System.out.println("File is open");
			
			while(s.hasNext()) {
				String newWord = s.next();
				System.out.println(newWord);
			}
			s.close();
		} catch (Exception e) {
			System.out.println("Problem opening file");
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}
