package duplicates;

import java.util.ArrayList;

public class Duplicate {
	private static ArrayList<String> letterList;
	public static void main(String[] args) {
		letterList = new ArrayList<String>();
		letterList.add("a");
		letterList.add("a");
		letterList.add("a");
		letterList.add("b");
		letterList.add("c");
		letterList.add("c");
		letterList.add("d");
		letterList.add("d");
		
		System.out.println(letterList);
		removeDuplicates(letterList);
		System.out.println(letterList);
		
	}
	
	public static void removeDuplicates(ArrayList<String> list) {
		if(list.size() > 1) {
			for(int x = 0; x < list.size()-1; x++) {
				String y = list.get(x);
				while(list.subList(x+1, list.size()).contains(y)) {
					list.remove(y);
				}
			}
		}
		
	}

}