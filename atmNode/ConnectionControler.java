package atmNode;

import java.util.ArrayList;
import java.util.HashMap;

public class ConnectionControler {
	private FIBbase base;
	private HashMap<String,Command> ComTable = new HashMap<String, Command>();
	private ComSetTable setTable;
	
	ConnectionControler(FIBbase b){
		base = b;
		setTable = new ComSetTable(base);
		ComTable.put("SETTABLE", setTable);
	}
	
	public void makeCommand(String command, ArrayList<String> args){
		ComTable.get(command).arguments = args;
		ComTable.get(command).make();
	}	
}
