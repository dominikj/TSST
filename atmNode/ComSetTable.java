package atmNode;

import java.util.ArrayList;


public class ComSetTable extends Command {

	ComSetTable(FIBbase b) {
		super(b);
	}

	@Override
	public void make() {
		ArrayList<Integer> entry = new ArrayList<Integer>();
		for(String s : arguments){
			entry.clear();
			String[] fields = s.split(" ");
			entry.add(Integer.parseInt(fields[5]));
			entry.add(Integer.parseInt(fields[3]));
			entry.add(Integer.parseInt(fields[4]));
			System.out.println(s);
			base.addNode(Integer.parseInt(fields[2]), Integer.parseInt(fields[0]),Integer.parseInt(fields[1]), entry);
		}
		
	}
	

}
