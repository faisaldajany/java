
public class CompListUtils<T extends Comparable<T>> {
	public static <T extends Comparable<T>> void bubbleSort(CompList<T> l) {
		
	if(!l.empty()) {
		int count =1;
		l.findFirst();	
			while(!l.last()) {
			count++;
			l.findNext();
			}
			l.findFirst();
			l.findNext();
			for(int i=0 ; i<count; i++ ) {
				l.findFirst();
				while(!l.last()) {
					l.findNext();
					if(l.compareToPrevious()<0) 
							l.swap();

			}
					
		}
	}	
}




		
	


	public static <T extends Comparable<T>> CompList<T> combine(CompList<T> l1, CompList <T> l2, int k){
		
	 	LinkedCompList<T> l = new LinkedCompList<T>();
	 	
	 	if(k<=0) {
	 		return null;
	 	}
		
			
	 	int count=1;
	 	l1.findFirst();
		while(!l1.last()) {
			count++;
			l1.findNext();
		}
		int count1=1;
	 	l1.findFirst();
		while(!l1.last()) {
			count1++;
			l1.findNext();
		}
		if(count>k) {
			l1.findFirst();
			for(int i = 0; i<k; i++) {
				l.insert(l1.retrieve());
				l1.findNext();
			}
			
		}
		
		if(count1>k) {
			while(!l.last()) {
				l.findNext();
			}
			for(int i = count1; i>count1-k; i--) {
				l.insert(l2.retrieve());
				l2.findPrevious();
			}
			
		}
		
		if(count<=k && count1<=k) {
			l1.findFirst();
			while(!l1.last()) {
				l.insert(l1.retrieve());
				l1.findNext();
			}
			l.insert(l1.retrieve());
			
			l2.findFirst();
			while(!l2.last()) {
				l.insert(l2.retrieve());
				l2.findNext();
			}
			l.insert(l2.retrieve());

		}
			
			
	 	
		

		return l;
	}
}
