
public class SearchHistoryUtils {
	public static int countWordOnly(SearchHistory h, List<String> words) {
		int c = 0;

		if(words.empty()) {
			return c;
		}
		else {
			words.findFirst();
			while(!words.last()) {
				if(h.findWord(words.retrieve()))
					c+=1;
				words.findNext();
				
				
			}
			if(h.findWord(words.retrieve()))
				c+=1;
		}	

		
		
		return c;
		
	}
	public static int countPrefixOnly(SearchHistory h, List<String> prefixes) {
		int c = 0;

		if(prefixes.empty()) {
			return c;
		}
		if(prefixes == null ) 
			return c;

		
		else {
			prefixes.findFirst();
			while(!prefixes.last()) {
				if(h.findWord(prefixes.retrieve()))
					c+=1;
				prefixes.findNext();
				
				
			}
			if(h.findWord(prefixes.retrieve()))
	 			c+=1;
		}	

		
		
		return c;
		
	}
		
	
}
