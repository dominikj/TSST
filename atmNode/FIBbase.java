package atmNode;

import java.util.ArrayList;

public class FIBbase {

	private FIBComposite root = new FIBComposite();

	
	public void addNode(int port, int VP, int VC, ArrayList<Integer> value){
		FIBComposite node;
		FIBentry entry = new FIBentry();
		entry.entry = value;
		entry.set(VC);	
		
		node = selectOrCreate(root, port);
		node = selectOrCreate(node, VP);
		node.addChildren(entry);
		
	}
	public ArrayList<Integer> getEntry(int port, int VP, int VC){
		for(FIBnode _port : root.getChildren()){
			if (_port.getValue() == port){
				for(FIBnode _VP : ((FIBComposite)_port).getChildren()){
					if (_VP.getValue() == VP){
						for(FIBnode _VC : ((FIBComposite)_VP).getChildren()){
							if (_VC.getValue() == VC){
								return ((FIBentry)_VC).entry;
							}
						}
					}
				}
			}
		}
		System.err.println("Nie ma takiego wpisu");
		return null;
	}
	
	private FIBComposite selectOrCreate(FIBComposite comp, int value){
		for(FIBnode f : comp.getChildren()){
			if(f.getValue() == value){
				FIBComposite node = (FIBComposite)f;
				return node;
			}
		}
		FIBComposite node = new FIBComposite(value);
		comp.addChildren(node);
		return node;
	}
	
} 
