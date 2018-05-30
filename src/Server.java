import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	Thread thread = new Thread();
	ServerSocket server;
	Socket clientSocket;
	
	ArrayList<Thread> clientList = new ArrayList<Thread>();
	
	private int port = 13100;
	
	
	
	public void launch() {
		try {
			server = new ServerSocket(port);
			int count = 0;
			boolean running = true;
			
			while(running){
				
			Socket client = server.accept();
			System.out.println("Client connected");
			count += 1;
			
			Thread currentClient = new Thread(new ClientHandler(client));
			clientList.add(currentClient);
			currentClient.start();
			
			if(count >= 10) {
				running = false;
				server.close();
			}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.launch();
	}

}
