package dequesAndRandomizedQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] i;
	private int size;

	public RandomizedQueue() {
		size = 0;
		i = (Item[]) new Object[2];

	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException();
		} else {
			if (size == i.length) {
				resize(2 * i.length);
			}
			i[size] = item;
			size += 1;


		}
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			if (size > 0 && size == i.length/4) {
				resize(i.length/2);
			}
			int a = StdRandom.uniform(size);
			Item holder = i[a];
			i[a] = i[size-1];
			i[size-1] = null;
			size -= 1;
			return holder;

		}
	}
	
	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			int random = StdRandom.uniform(size);
			return i[random];
		}
		
	}
	
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item> {
		private int pointer = 0;
		private Item[] newI;
		
		private ArrayIterator() {
			newI = (Item[]) new Object[size];
			for(int p = 0; p < size; p++) {
				newI[p] = i[p];
			}
			StdRandom.shuffle(newI);
		}

		@Override
		public boolean hasNext() {
			return pointer < size;
		}
		
		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				Item r = newI[pointer];
				pointer += 1;
				return r;
			}
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
 	private void resize(int capacity) {
 		Item[] copy = (Item[]) new Object[capacity];
 		for (int x = 0; x < size; x++) {
 			copy[x] = i[x];
 		}
 		i = copy; 
 	}

	
	public static void main(String[] args) {
		//
	}
}