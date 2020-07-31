public class LinkedQueue<T> implements Queue<T>{
	
	
	private Node<T> head, tail;
	private int size;
	
	public LinkedQueue() {
		head = tail = null;
		size = 0;
	}
	public boolean full() {
		return false;
	}
	public int length() {
		return size;
	}
	public void enqueue(T e) {
		if (tail == null) {
			head = tail = new Node<T>(e);
		}
		else
		{
			tail.next = new Node<T>(e);
					tail = tail.next;
		}
		size++;
	}
	public T serve() {
		T x = head.data;
		head = head.next;
		size--;
		if( size == 0) 
			tail = null;
		 	return x;
		
	}
	public int multiEnqueue(T[] els, int k) {
		
		int l=0; 
		for(int i=0; i<k;i++) {
			enqueue(els[i]);
			l++;
		}
		return l;
	}
	
class Node <E>{
		
		public E data;
		public  Node<E> next;
		
		public Node() {
			data = null;
			next = null;
			
		}
		public Node(E val) {
			data = val;
			next = null;
		}
	}

}