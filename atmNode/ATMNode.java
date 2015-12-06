package atmNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ATMNode {

	public static void main(String[] args) {
		FIBbase base = new FIBbase();
		ConnectionControler cc = new ConnectionControler(base);
		ArrayList<String> table = new ArrayList<String>();
		table.add("2 3 4 5 6 7");
		cc.makeCommand("SETTABLE", table);
		
		ArrayList<Integer> result;
		
		
		result = base.getEntry(4,2,3);
		for(int i : result){
			System.out.println(i);
		}

	}

}
