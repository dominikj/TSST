package atmNode;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class TCPconnection {
	
	private BufferedReader input;
	private DataOutputStream output;
	private String dataIn;
    public  Socket soc;
    
	public void connect(String address, int port, int id) {
		 try {
			soc = new Socket(address, port);
	
			input = new BufferedReader (new InputStreamReader(soc.getInputStream()));
			output = new DataOutputStream (soc.getOutputStream());
			
			output.writeBytes("HELLO " + id + "\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
	public ArrayList<String> getData(){
		ArrayList<String> data = new ArrayList<String>();
		try {
			while (!((dataIn = input.readLine()).equals("."))){
				data.add(dataIn);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public void sendData(ArrayList<String> data){
		for(String s: data){
			try {
				output.writeBytes(s + "\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(){
		try {
			soc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
