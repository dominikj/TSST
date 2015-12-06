package atmNode;

import java.util.ArrayList;

public abstract class Command {
	
	protected FIBbase base;
	public ArrayList<String> arguments;
	public abstract void make();
	
	Command(FIBbase b){
		base = b;
	}
}
