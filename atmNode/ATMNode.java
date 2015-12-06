package atmNode;

import javax.swing.SwingUtilities;

public class ATMNode {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				Window win = new Window();
				Thread th = new Thread(new Controler(win, args));
				th.start();
				
				
			}
			
		});

	}

}
