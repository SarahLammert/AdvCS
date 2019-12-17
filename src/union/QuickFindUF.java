package union;

public class QuickFindUF {
	
	private int[] data;
	
	public QuickFindUF(int N) {
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

}
