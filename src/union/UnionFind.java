package union;

import java.io.File;
import java.util.Scanner;

public class UnionFind {
	
	private int[] data;
	
	public UnionFind(int N) {
		data = new int[N];
		for(int x = 0; x < N; x++) {
			data[x] = x;
		}
	}
	
	public void union(int p, int q) {
		int pValue = data[p];
		int qValue = data[q];
		for(int x = 0; x < data.length; x++) {
			if(data[x] == pValue) {
				data[x] = qValue;
			}
		}
	}
	
	public boolean connected(int p, int q) {
		return data[p] == data[q];
	}
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("tinyTest.txt"));
			int N = s.nextInt();
			
			System.out.println("Number of objects: " + N);
			
			UnionFind uN = new UnionFind(N);
			
			while(s.hasNext()) {
				int p = s.nextInt();
				int q = s.nextInt();
				uN.union(p, q);
				System.out.println("Pair: [" + p + ", " + q + "]");
			}
			s.close();
			for(int x = 0; x < N-1; x++) {
				for(int y = x+1; y < N; y++) {
					System.out.println("(" + x + ", " + y + ") "
									  + " is connected: " + uN.connected(x, y));
				}
			}
		} catch(Exception e) {
			System.out.println("Can't open the file");
		}
	}
}
