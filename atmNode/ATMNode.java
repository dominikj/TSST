package atmNode;

import java.util.ArrayList;

public class ATMNode {

	public static void main(String[] args) {
		FIBbase base = new FIBbase();
		ArrayList<Integer> entry = new ArrayList<Integer>();
		ArrayList<Integer> result;
		entry.add(3);
		entry.add(5);
		entry.add(0);
		base.addNode(2, 3, 1, entry);
		entry.clear();
		entry.add(0); entry.add(9); entry.add(9);
		base.addNode(2, 8, 2, entry);
		
		result = base.getEntry(2, 8, 2);
		for(int i : result){
			System.out.println(i);
		}

	}

}
