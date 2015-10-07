import java.io.*;
import java.net.*;

public class CardTerm {
	public static void main(String argv[]) throws Exception  {
		System.out.println("Enter the account number to fake");

		// Account number ... 
		int acctNum = Utils.getInt("Enter the account number to fake.");
		
		// Card type 2. could be anything though for credit cards etc.
		int acctType = Utils.getInt("Enter the account type to fake.");;

		// Connect the terminal to the ATM core
		Socket clientSocket = new Socket("localhost", 4020);
		
		// Open a stream to the ARM
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		// Send the information.
		outToServer.writeBytes(acctNum+":"+acctType);
		
		// Close the connection
		clientSocket.close();
	}	
}
