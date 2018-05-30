import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

	Socket socket;
	
	String message;
	
	BufferedReader istream;
	BufferedWriter ostream;
	
	ClientHandler(Socket socket){
		this.socket = socket;
	}
	
	void readTextFromInputStream() {
		try {
			istream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			message = istream.readLine();
			
			if(message != "")
				System.out.println("Message Accpeted");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void sendTextBackToClient() {
		try {
			ostream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			ostream.write(message + "\n");
			ostream.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		
		//client.launch();
		readTextFromInputStream(); //Potential to not recieve message
		sendTextBackToClient();
		
		
		try {
			ostream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			istream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
