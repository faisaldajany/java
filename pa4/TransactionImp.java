
public class TransactionImp implements Transaction {
	private byte[] sender;
	private byte[] receiver;
	private byte[] signature;
	private int amount;
	

	public TransactionImp() {
		KPair k1 = Utils.getKeyPair();
		KPair k2 = Utils.getKeyPair();
		sender = k1.publicKey;
		receiver = k2.publicKey;
		signature = new byte[64];
		amount = 0;
	}



	public byte[] getSender() {
		return sender;
	}

	public void setSender(byte[] sender) {
		this.sender = sender;
	}

	public byte[] getReceiver() {
		return receiver;
	}

	public void setReceiver(byte[] receiver) {
		this.receiver = receiver;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public void sign(byte[] pvk) {
		if(getSender() == null || getReceiver() == null) {
			return;
		}
		else {
			if (pvk == null) {
				return;
			}
		}
		
		byte[] sr = Utils.concat(getSender(), getReceiver());
			byte[] a = Utils.toBytes(amount);
		signature = Utils.sign(Utils.concat(a, sr), pvk);
	}

	@Override
	public boolean isSignatureValid() {
		if(getSender() == null || getReceiver() == null) {
			return false;
		}
		else {
			if (signature == null) {
				return false;
			}
		}
		byte[] sr = Utils.concat(getSender(), getReceiver());
			byte[] a = Utils.toBytes(amount);
					return	Utils.isSignatueValid(Utils.concat(a, sr), signature , getSender());
		 
	}

	@Override
	public byte[] toBytes() {
		if(getSender() == null || getReceiver() == null) {
			return null;
		}
		else {
			if (signature == null) {
				return null;
			}
		}
		byte[] sr = Utils.concat(getSender(), getReceiver());
		byte[] a = Utils.toBytes(amount);
				byte[] aSr = Utils.concat(sr, a);
					byte[] s = Utils.concat(aSr, signature);
		
					return s; 
		
	}

	@Override
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}


	@Override
	public byte[] getSignature() {
		return signature;
	}
	
}
