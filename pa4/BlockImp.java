public class BlockImp implements Block {
    byte[] miner;
    int nonce;
    Transaction transaction;
    byte[] prevHash;
    byte[] hash;
    KPair kb;    
	public BlockImp() {             
            kb=Utils.getKeyPair();
            miner=kb.publicKey;
            hash=new byte[nonce];
            prevHash=new byte[nonce];
            nonce=0;
            transaction=null;
	}
	@Override
	public void setMiner(byte[] miner) {
            this.miner=miner;
	}
	@Override
	public void setNonce(int nonce) {
            this.nonce=nonce;
	}
	@Override
	public void setTransaction(Transaction transaction) {
            this.transaction=transaction;
	}
	@Override
	public void setPrevHash(byte[] prevHash) {
            this.prevHash=prevHash;
	}

	@Override
	public void setHash(byte[] hash) {
            this.hash=hash;
	}

	@Override
	public byte[] getMiner() {
		return miner;
	}

	@Override
	public int getNonce() {
		return nonce;
	}

	@Override
	public byte[] getHash() {
		return hash;
	}

	@Override
	public byte[] getPrevHash() {
		return prevHash;
	}

	@Override
	public Transaction getTransaction() {
		return transaction;
	}

	@Override
	public void compHash() { 
            byte[] input = toBytes();
            if(transaction==null) 
            	return;		
	        hash = Utils.getHash(input);
	}

	@Override
	public boolean isHashValid() {
            if(transaction==null)
            	return false;
               compHash();
		return Utils.validBlockHash(hash);
	}   
	@Override        
	public void mine() {
            if(transaction==null)return ;
            nonce=0;
            while(!isHashValid())
            {            
               
            nonce++;
            }
          
	}

	@Override
	public byte[] toBytes() {
           if(transaction==null||transaction.toBytes()==null||prevHash==null)return null;
            byte[]a=Utils.concat(Utils.toBytes(nonce), transaction.toBytes());
            byte[]b=Utils.concat(a,prevHash);
		return b;
}
}