import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
	
	Socket serverConnect;
	BufferedWriter buffWriter;
	BufferedReader buffReader;
	
	
	String messageToServer = "Hello Sir, im connected\n";
	
	

	//Go to sleep, count sheep
	
	public Client(Socket socket) {
		this.serverConnect = socket;
	}
	
	public void launch() {
		try {
			
			buffWriter = new BufferedWriter(new OutputStreamWriter(serverConnect.getOutputStream()));
			buffReader = new BufferedReader(new InputStreamReader(serverConnect.getInputStream()));
			
			Thread.sleep(3000);
			
			
			
			buffWriter.write(messageToServer);
			
			buffWriter.flush();
			
			
			
			String message = buffReader.readLine();
			
			System.out.println(message);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				buffWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				serverConnect.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		String ip = "localhost";
		int port = 13100;
		for(int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Client(new Socket(ip, port)));
			thread.start();
		}

	}

	@Override
	public void run() {
		launch();
	}

}
