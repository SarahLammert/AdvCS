package harryPotterReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCounter {
	
	//ArrayList to hold all unique words
	private ArrayList<Word> uniqueWords = new ArrayList<Word>(80000);
	
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
		String newW = w;
		newW = newW.toLowerCase();
		
		//Finds the first letter and places the start of the substring there
		//Then finds the last letter
		if(newW.length() > 1) {
			int s = 0;
			int f = 1;
			boolean first = true;
			for(int i = 0; i < newW.length(); i++) {
				if(Character.isLetter(newW.charAt(i))) {
					if(first) {
						s = i;
						first = false;
					}
					else if(i > f) {
						f = i;
					}
				}
			}
			newW = newW.substring(s, f+1);
		}
		
		return newW;
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

	public void printAllWords() {
		for(Word w: uniqueWords) {
			System.out.println(w.getWord() + ": " + w.getCount());
		}
	}
	
	public void printAWord(int i) {
		Word w = uniqueWords.get(i);
		System.out.println(w.getWord() + ": " + w.getCount());
	}
	
	public static void main(String[] args) {
		WordCounter wC = new WordCounter();
		wC.openFile("harryPotter");
	}

}
