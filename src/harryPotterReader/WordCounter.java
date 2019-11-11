package harryPotterReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCounter {
	
	//ArrayList to hold all unique words
	private ArrayList<Word> uniqueWords = new ArrayList<Word>(1000);
	
	public WordCounter() {
		System.out.println("This is a new word counter");
	}
	
	//This will open any file passed to this method
	public void openFile(String fileName) {
		try {
			
			//Scans the file
			Scanner s = new Scanner(new File(fileName + ".txt"));
			System.out.println("File is open");
			
			//Reads each string
			while(s.hasNext()) {
				String newWord = s.next();
				
				//Strips special characters from the string
				newWord = stripSpecialChars(newWord);
				
				//If the word is unique, then the a new word is created
				if(isUnique(newWord)) {
					uniqueWords.add(new Word(newWord));
				}
			}
			s.close();
		} catch (Exception e) {
			System.out.println("Problem opening file");
		}
		
	}
	
	public static String stripSpecialChars(String w) {
		w = w.toLowerCase();
		
		//Finds the first letter and places the start of the substring there
		//Then finds the last letter
		if(w.length() > 1) {
			int startIndex = 0;
			int endIndex = 1;
			boolean first = true;
			for(int i = 0; i < w.length(); i++) {
				if(Character.isLetter(w.charAt(i))) {
					if(first) {
						startIndex = i;
						first = false;
					}
					else if(i > endIndex) {
						endIndex = i;
					}
				}
			}
			w = w.substring(startIndex, endIndex+1);
		}
		
		return w;
	}
	
	public boolean isUnique(String aW) {
		boolean numIsUnique = true;
		for(Word w: uniqueWords) {
			if(w.getWord().equals(aW)) {
				numIsUnique = false;
				w.addCount();
				break;
			}
		}
		return numIsUnique;
	}

	public void printAllWordsLineByLine() {
		for(Word w: uniqueWords) {
			System.out.println(w.toString());
		}
	}
	
	public void printAllWordsArrayStyle() {
		System.out.println(uniqueWords);
	}
	public void printAWord(int i) {
		Word w = uniqueWords.get(i);
		System.out.println(w.getWord() + ": " + w.getCount());
	}
	
	public static void main(String[] args) {
		WordCounter wC = new WordCounter();
		wC.openFile("harryPotter");
		//wC.printAllWordsArrayStyle();
		wC.printAllWordsLineByLine();
	}

}
