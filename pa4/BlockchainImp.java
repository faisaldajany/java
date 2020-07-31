public class BlockchainImp implements Blockchain {
	
		private int n;
		private List<Block> l;
	
	public BlockchainImp() {
		n = 0;
		l = new LinkedList<Block>();
	}

	@Override
	public int length() {
		return n;
	}

	@Override
	public List<Block> getBlocks() {
		return l;
	}
	private boolean myMethod(byte[]first, byte[]second) {
		if(first.length<0 || second.length<0)
			return false;
		if(first.length!=second.length) 
			return false;
		for(int i=0;i<first.length;i++) {
			if(first[i]!=second[i])
        	return false;
        }
		return true;
	}
	
	@Override
	
	public int getBalance(byte[] pbk) {		
		if(l.empty())
			return 0;
		int r = 0;
	l.findFirst();
			while(!l.last()) {
				if(myMethod(l.retrieve().getMiner(),pbk))
					r+=minerReward;
					if(l.retrieve().getTransaction()!=null) {
						if(myMethod(l.retrieve().getTransaction().getSender(),pbk)) 
							r-= l.retrieve().getTransaction().getAmount();
						
						if(myMethod(l.retrieve().getTransaction().getReceiver(),pbk)) 
							r+= l.retrieve().getTransaction().getAmount();
					}
					
				if(r<0)
					return-1;
				l.findNext();
				
			}
			if(myMethod(l.retrieve().getMiner(),pbk))
				r+=minerReward;
				if(l.retrieve().getTransaction()!=null) {
					if(myMethod(l.retrieve().getTransaction().getSender(),pbk)) 
							 r-= l.retrieve().getTransaction().getAmount();
					
				if(myMethod(l.retrieve().getTransaction().getReceiver(),pbk)) 
					 r+= l.retrieve().getTransaction().getAmount();
				}
		return r;
	}
	@Override
	public boolean addBlock(Block b) {
		
		
		if(l.empty()) {
			b.setPrevHash(initHash);
			l.insert(b);
			n++;
			return true;
		}
		else
		if(l.last()) {
			b.setHash(getLastBlockHash());
			l.insert(b);
			n++;
			return true;

		
		}
		else
        if(b.getTransaction()==null)  
        	return false;

		l.findFirst();
		while(!l.last()){
			l.findNext();
			b.setHash(getLastBlockHash());
			l.insert(b);
			n++;
			return true;
		
		}
		return false;
	}
	@Override
	public void removeInvalid() {
		
	}

	
	@Override
	public byte[] getLastBlockHash() {   
		if(l.empty())
		return null;
		    else
    {
    l.findFirst();
    while(!l.last()){
    l.findNext();
    }
    return l.retrieve().getHash();
    }
}
}
