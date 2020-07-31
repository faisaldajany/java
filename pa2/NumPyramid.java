
public class NumPyramid<T>{
	
	public static<T> Stack<Queue<Integer>> build(Queue<Integer> q){
	
		 Stack<Queue<Integer>> sq = new  ArrayStack<Queue<Integer>>(q.length()*q.length());
		 Queue<Integer> sq1 = new  LinkedQueue<Integer>();
		 int length = q.length();
		 int r = length;
		 int c = length;
		 int arr[][] = new int [r][c];
		 
		 for(int i=0; i<r; i++) {
			  arr[i][0]=q.serve();
			  q.enqueue(arr[i][0]);
		 }
		  for(int i=1; i<c;i++) {
			  for(int j=i; j<c;j++) {
				  arr[j][i]= arr[j-1][i-1]-arr[j][i-1];
			  } 
		  }
		 for(int i =0; i<r; i++){
		     for(int j=0 ; j<c; j++) {
		    	 sq1.enqueue(arr[j][i]);
		    	 sq.push(sq1);

		     }
		    }
		
			return sq;
		 
		 }
}
