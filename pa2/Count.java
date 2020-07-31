
public class Count {
	
	
	public static <T> int count(Queue<T> l){
		int count = l.length();
		
		int b = 0;
		for(int i=0;i<count;i++) {
			T elm = l.serve();
			if(!elm.equals(l.serve()))
				b++;
			l.enqueue(l.serve());
		}
		for(int i=0;i<count;i++) {
			l.serve();
			
			}
		
		
		
		
		
		
		
		
		
		
		return b;
		
	}

}
