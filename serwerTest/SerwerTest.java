package serwerTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SerwerTest {

	public static void main(String[] args) {
		try{
		BufferedReader input;
		DataOutputStream output;
		String dataIn;
		String dataOut;
	    Socket soc;
	    ServerSocket ser;
	    Scanner scan = new Scanner(System.in);
	    ser = new ServerSocket(10099);
		soc = ser.accept();
		
		input = new BufferedReader (new InputStreamReader(soc.getInputStream()));
		output = new DataOutputStream (soc.getOutputStream());
		System.out.println(input.readLine());
		while(true){
			while(!((dataOut = scan.nextLine()).equals("SS"))){
			output.writeBytes(dataOut + "\n\r");
			}
			System.out.println("Poszło");
			if(scan.nextLine().equals("REC")){
			while(!((dataIn = input.readLine()).equals("SS"))){
				System.out.println(dataIn);
				}
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	}

