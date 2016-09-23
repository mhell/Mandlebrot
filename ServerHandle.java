/**
 * Class representing a server connection
 */
public class ServerHandle implements AutoCloseable {
	private BufferedInputStream fromServer;
	private PrintWriter toServer;
	private Socket socket;

	/**
	 * 
	 */
	public ServerHandle(String host, int port) throws UnknownHostException, IOException {
		// connect to server and retrieve input and output streams
        socket = new Socket(host, port); 
        fromServer = new BufferedInputStream(socket.getInputStream());
        toServer = new PrintWriter(socket.getOutputStream(), true);            
	}

	//public getInputStream() {

	//}

	/**
	 * 
	 */
	public renderCall(Sector sector) {
		toServer.println(); 
	}

	/**
	 * Closes this server connection
	 */
	public void close() throws Exception {
		fromServer.close();
		toServer.close();
		socket.close();
	}
}

//GET /mandelbrot/{min_c_re}/{min_c_im}/{max_c_re}/{max_c_im}/{x}/{y}/{inf_n}