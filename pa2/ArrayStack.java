public class ArrayStack<T> implements Stack<T> {
	private int maxsize;
	private int top;
	private T[] nodes;
	public ArrayStack(int n) {
		maxsize = n;
		top = -1;
		nodes = (T[]) new Object[n];
	}
	public boolean empty(){
		return top == -1;
	}
	public boolean full(){
		return top == maxsize - 1;
	}
	public void push(T e){
		nodes[++top] = e;
	}
	public T pop(){
		return nodes[top--];
	}
	public void multiPush(T q1[], int k){	
			
		for(int i =0; i<k; i++) {
			if(!full())
				push(q1[i]);
		}
				
	}
	public void reverse() {

		
		Stack<T> tmp1 = new ArrayStack<T>(maxsize);
		Stack<T> tmp2 = new ArrayStack<T>(maxsize);

		while(top!=-1) {
			T elm = pop();
			tmp1.push(elm);
			
		}
		while(!tmp1.empty()) {
			tmp2.push(tmp1.pop());
			
	}
		while(!tmp2.empty()) {
			push(tmp2.pop());
		}
	}
	
	public Stack<T> copy() {
		
		Stack<T> ns1 = new ArrayStack<T>(maxsize);
		Stack<T> ns2 = new ArrayStack<T>(maxsize);

			while(top!=-1) {
			T elm = pop();
			ns1.push(elm);
			ns2.push(elm);

		}
			while(!empty()) {
			push(ns1.pop());
		}
			while(!empty()) {
			ns1.push(ns2.pop());
		}
		return ns1;
	}
}
	