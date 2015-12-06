package atmNode;

import java.util.ArrayList;

public class FIBComposite extends FIBnode {
	ArrayList<FIBnode> children = new ArrayList<FIBnode>();
	public FIBComposite(int val) {
		value = val;
	}
	public FIBComposite() {
		// TODO Auto-generated constructor stub
	}
	ArrayList<FIBnode> getChildren(){
		return children;
	}
	void addChildren(FIBnode node){
		children.add(node);
	}
}
