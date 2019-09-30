package bookTest;
public class book {
	private int numPages;
	private int currentPage;
	public book(int n) {
		setNumPages(n);
		setCurrentPage(1);
		
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNumPages() {
		return numPages;
	}
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public void nextPage() {
		if(currentPage < getNumPages()) {
			currentPage++;
		}
	}
}
