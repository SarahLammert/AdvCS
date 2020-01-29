package dequesAndRandomizedQueues;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private class Node {
		private Item item;
		private Node back;
		private Node front;
	}
	
	private Node first = null;
	private Node last = null;
	
	private int size;
	
	public Deque() {
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		} else {
			size += 1;
			if (first != null) {
				Node oldfirst = first;
				first = new Node();
				first.item = item;
				first.back = oldfirst;
				oldfirst.front = first;
			} else {
				first = new Node();
				first.item = item;
			}
			if (last == null) {
				last = first;
			}
		}
	}
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		} else {
			size += 1;
			if (last != null) {
				Node oldlast = last;
				last = new Node();
				last.item = item;
				last.front = oldlast;
				oldlast.back = last;
			} else {
				last = new Node();
				last.item = item;
			}
			if (first == null) {
				first = last;
			}
		}
	}

	public Item removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			Item item;
			size -= 1;
			if (first.back != null) {
				item = first.item;
				first = first.back;
				first.front = null;
			} else {
				item = first.item;
				first = null;
				last = null;
			}
			return item;
		}
	}

	public Item removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			Item item;
			size -= 1;
			if (last.front != null) {
				item = last.item;
				last = last.front;
				last.back = null;
				return item;
			} else {
				item = last.item;
				last = null;
				first = null;
			}
			return item;
		}
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
				
			} else {
				Item item = current.item;
				current = current.back;
				return item;
			}
		}
	}
	public static void main(String[] args) {
		//Nothing
	}
}