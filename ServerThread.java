import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        super("ServerThread");
        this.socket = socket;
    }

    /**
     * 
     */
    public static int render(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }
    
    public void run() {
        try (
            PrintWriter toClient = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String input;

            while ((input= fromClient.readLine()) != null) {
                //render

                //break;
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
