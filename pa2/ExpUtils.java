import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExpUtils<T> {

	public static Queue<Stack<Character>> readExps(String fileName) throws IOException{
		
		Queue<Stack<Character>> fQueue = new LinkedQueue<Stack<Character>>();
		Stack<Character> sq;

		FileReader FR = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(FR);
		
		String text = "";
		String line = reader.readLine();
	    try {
	    	while (line != null) {	
	    		text +=line;
	    		line = reader.readLine();
	    	}
	    } catch(FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    		char charArray[] = text.toCharArray();
		    		for(char c : charArray) {
	    			 sq = new ArrayStack<Character>(charArray.length);
	    			sq.push(c);
			    		fQueue.enqueue(sq);
			    		System.out.print(fQueue.serve().pop());
	    		}
	    	reader.close();
			return fQueue;
	    		

	}
	
	public static Queue<Stack<Character>> match(Queue<Stack<Character>> q, String pattern){
		int length = q.length();
		char[] charP = pattern.toCharArray();
		Queue<Stack<Character>> qs = new LinkedQueue<Stack<Character>>();
		for(int i =0; i<length;i++) {
			Stack<Character> elm1 = q.serve();
			q.enqueue(elm1);
			if(charP.equals(elm1))
				qs.enqueue(elm1);	
			
		}
		
		
		return qs;
		
	}
}
