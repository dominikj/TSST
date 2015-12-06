package atmNode;

import java.util.ArrayList;

public class Controler {
	private Window window;
	private FIBbase base = new FIBbase();
	private ConnectionControler cc = new ConnectionControler(base);
	private TCPconnection tcp = new TCPconnection();
Controler(String[] configuration){
	window = new Window();
	
	ArrayList<String> cell = new ArrayList<String>();
	cell.add("M C 0 0");
	cell.add("SETTABLE");
	cell.add("0 1 2 3 4 5");
	cell.add(".");
	tcp.connect(configuration[0], Integer.parseInt(configuration[1]), Integer.parseInt(configuration[2]));
	String[] tmp = cell.get(0).split(" ");
	if(tmp[1].equals("C")){
		ArrayList<String> args = new ArrayList<String>();
		for(int i = 2; i < cell.size()-1; ++i){
			args.add(cell.get(i));
			tmp = cell.get(i).split(" ");
			window.setEntry(tmp[0], tmp[1],tmp[2],tmp[3],tmp[4],tmp[5]);
			window.appendHistory("Odebrano konfigurację od managera\n");
		}
		cc.makeCommand(cell.get(1), args);
	}
	else{
		ArrayList<Integer> result = base.getEntry(Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]));
		for(int i : result){
			System.out.println(i);
		}
	}
}
}
