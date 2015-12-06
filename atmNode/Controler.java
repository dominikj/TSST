package atmNode;

import java.util.ArrayList;

public class Controler implements Runnable {
	private Window window;
	private FIBbase base = new FIBbase();
	private ConnectionControler cc = new ConnectionControler(base);
	private TCPconnection tcp = new TCPconnection();
	String[] configuration;
	
Controler(Window win, String[] conf){
	window = win;
	configuration = conf;
}

public void start(){
	ArrayList<String> cell = new ArrayList<String>();

	tcp.connect(configuration[0], Integer.parseInt(configuration[1]), Integer.parseInt(configuration[2]));
	while(true){
	cell = tcp.getData();
	String[] tmp = cell.get(0).split(" ");
	System.out.println(cell.get(0));
	if(tmp[1].equals("C")){
		ArrayList<String> args = new ArrayList<String>();
		for(int i = 2; i < cell.size(); ++i){
			args.add(cell.get(i));
			tmp = cell.get(i).split(" ");
			synchronized(window){
			window.setEntry(tmp[0], tmp[1],tmp[2],tmp[3],tmp[4],tmp[5]);
			window.appendHistory("Odebrano konfigurację od managera\n");
			window.revalidate();
			window.repaint();
			}
		}
		cc.makeCommand(cell.get(1), args);
	}
	else{
		ArrayList<Integer> result = base.getEntry(Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]));
		for(int i : result){
			System.out.println(i);
		}
		cell.set(0, Integer.parseInt(configuration[2]) + " " + result.get(0)+ " " + result.get(1)+ " " + result.get(2));
		synchronized(window){
		window.appendHistory(Integer.parseInt(tmp[1])+" "+Integer.parseInt(tmp[2])+" "+Integer.parseInt(tmp[3])+ "->" + result.get(0)+ " " + result.get(1)+ " " + result.get(2));
		}
		tcp.sendData(cell);
		
	}
	}
}

@Override
public void run() {
	start();
	
}

}