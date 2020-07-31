
public class ArrayCompList < T extends Comparable<T>> implements CompList <T> {
	private T[] data;
	private int current, size, maxSize;
	
	
	public ArrayCompList(int maxSize) {
		current = -1;
		size = 0;
		data = (T[]) new Object[maxSize];
	}
	
	public boolean empty() {
		return size == 0;

	}

	
	public boolean full() {
		return size == maxSize;

	}

	
	public void findFirst() {
		current = 0;
	}

	
	public void findNext() {
		current++;
		
	}

	
	public void findPrevious() {
		current--;
	}

	
	public boolean last() {
		return current == size-1;
	}

	
	public boolean first() {
		return false;
	}

	
	public T retrieve() {
		return data[current];
	}

	
	public void update(T e) {
		data[current]=e;
	}

	
	public void insert(T e) {
		for (int i=size-1; i> current; --i) {
			data[i+1]=data[i];
			
		}
		current++;
	 	data[current]=e;
		size++;
	}

	
	public void remove() {
		for (int i = current + 1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		if (size == 0)
			current = -1;
		else if (current == size)
			current = 0;
}


	
	public void swap() {
		
			T tmp = data[current];
			data[current] = data[current-1];
			data[current-1]= tmp;
			
	}

	
	public int compareToPrevious() {
		
		
		
		return data[current].compareTo(data[current-1]);
	}
	

}
