Client Handler
===
Create a ServerSocket that accepts Socket connections. After accepting the Socket connection, pass the Socket to a new ClientHandler thread and start that Thread. The ServerSocket will then begin awaiting a new connection. The client will wait 3 seconds then send a message to the server, to which the server will respond with “Message Accepted: {message}”. Create a test case that will spawn 10 client requests, and wait 5 seconds to receive responses from each of the client requests.

## Task List
- [ ] Create a ClientHandler class that will read text from a Socket’s InputStream and respond to the Socket’s OutputStream with “Message Accepted: {message}” where {message} is the text input received from the InputStream
- [ ] Create a main method that will start a ServerSocket that continuously listens for incoming connections
- [ ] When a connection is received, instantiate a ClientHandler and pass the received Socket to that ClientHandler
Resume listening for incoming connections while the ClientHandler waits for a message from the connected Socket
- [ ] Create a test that will spawn 10 Sockets that connect to the server
- [ ] Ensure that each Socket will connect to the server, wait 3 seconds, then send a message of your choosing
- [ ] Ensure that responses are received for all 10 messages sent within 10 seconds
