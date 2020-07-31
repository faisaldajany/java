public class TreeSearchHistory implements SearchHistory {	
	public TSHNode root; // Do not change
	public int n; // Do not change

	public TreeSearchHistory() {  // Do not change
		root = new TSHNode();
		n = 0;
	}
	
	// Change the code staring from this point

	@Override
	public int size() {
		return n;
	}

	@Override
	public void add(String word) {
        addRec(root,word,0);
        n++;
    }
	private void addRec(TSHNode p,String word,int i){
		List<Pair<Character, TSHNode>> l = p.children;        
				if(i>=word.length()){
					return;
					} 
				if(l.empty()){            
						Character char1 = word.charAt(i);
						Pair<Character, TSHNode> pair1 =new  Pair<Character, TSHNode>(char1,new TSHNode());
							l.insert(pair1);
						}
						else
							{                    
							boolean f =false;
								l.findFirst();
							while(!l.last()){
								if(l.retrieve().first.equals(word.charAt(i))){ 
									f= true;
									break;
								}
								l.findNext();
							}
							if(l.retrieve().first.equals(word.charAt(i)))
								f = true;            
							if(!f){
								Character char2 = word.charAt(i);
								Pair<Character, TSHNode> pair2 = new  Pair<Character, TSHNode>(char2,new TSHNode());
								l.insert(pair2);             
								}
							}
    
				addRec(l.retrieve().second, word, i+1);
		}
	@Override
    public boolean findWord(String word){
		
	if(root.children.empty() || word.length() < 0)
					return false;
			else
					return findWordRec(root,word, 0);
	}
	private boolean findWordRec(TSHNode p,String word,int i) {
		
		List<Pair<Character, TSHNode>>l=p.children;

			
            if(!p.end || i < word.length()) 
            	return true;
						
							if(l.empty())
							return false;
						
							boolean f=false;
							l.findFirst();
							while(!l.last()){			
								if(l.retrieve().first.equals(word.charAt(i))) {
									f = true;
								break;
							}
							if(l.retrieve().first.equals(word.charAt(i))) 
								f = true;           
   
							if(!f) 
								return false;
							l.findFirst();

							}
        	 	return findWordRec(l.retrieve().second, word, i+1);
       
   
	}
		
	
	@Override
	  public boolean findPrefix(String prefix){
		if(root.children.empty() || prefix.length()<1) {
			return false;
		}
		else
			return findPrefixRec(root,prefix, 0);
}
private boolean findPrefixRec(TSHNode p,String prefix,int i){
	
	List<Pair<Character, TSHNode>>l=p.children;
		
        if(!p.end || i < prefix.length()) 
        	return true;
					
						if(l.empty())
						return false;
					
						boolean f=false;
						l.findFirst();
			 			while(!l.last()){			
							if(l.retrieve().first.equals(prefix.charAt(i))) {
								f = true;
							break;
						}
						if(l.retrieve().first.equals(prefix.charAt(i))) 
							f = true;           

						if(!f) 
							return false; 
						l.findNext();

						}
    	 	return findPrefixRec(l.retrieve().second, prefix, i+1);
   
}

  
	@Override
	public List<String> complete(String prefix) {
		return null;
	}

 
}
