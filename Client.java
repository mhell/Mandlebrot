import java.io.*;   
import java.net.*;  
import java.nio.file.*;
import java.util.Scanner;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * 
 */
public class Client {
    
    public static void main(String[] args) throws Exception {
    	List<ServerHandle> list_of_servers = new ArrayList<ServerHandle>();
		Stack<Sector> sectors = null;
		int serverArg = 8;

    	try {
	    	double min_c_re = Double.parseDouble(args[0]);
	    	double min_c_im = Double.parseDouble(args[1]);
	    	double max_c_re = Double.parseDouble(args[2]);
	    	double max_c_im = Double.parseDouble(args[3]);
	    	int max_n = Integer.parseInt(args[4]);
	    	int x = Integer.parseInt(args[5]);
	    	int y = Integer.parseInt(args[6]);
	    	int divisions = Integer.parseInt(args[7]);
	        
	        try {
	        	// create servers
	        	for ( ; serverArg < args.length; serverArg++) {
	        		String[] adress = args[serverArg].split(":");
        			list_of_servers.add(new ServerHandle(adress[0], Integer.parseInt(adress[1])));
        		}

		        sectors = Sector.makeSectors(min_c_re, max_c_re, min_c_im, max_c_im, x, y, divisions);

		        // assign one sector to each available server to render
		        for (ServerHandle server : list_of_servers) {
		        	server.renderCall(sector.pop());
		        }

		        // check for finished renders and assign new sectors to available servers
		        /*
		        	for each server
		        		if input recieved
		        			read input
							if more sectors
								pop and asign to this server
							if no more sectors
								close & pop server
						
				*/

		        // assemble picture
				

        	} catch (UnknownHostException e) {
                System.err.println("Unknown host: " + args[serverArg]);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't open connection to " + args[serverArg]);
                System.exit(1);
            } finally {
            	// close servers
            	for (ServerHandle h : list_of_servers) {
            		h.close();
            	}
            }
        } catch (Exception e) {
            System.out.println("Invalid input."+ System.getProperty("line.separator") +
            	"Usage: min_c_re min_c_im max_c_re max_c_im max_n x y divisions list-of-servers [host:port]");
            System.exit(1);
        }
    }
}   

/*
min_c_re 		min_c_im 		max_c_re 		max_c_im		max_n 		x 		y 		divisions 	list-of-servers
-1 		 		-1.5 		 	2	 	 		1.5				1024		10000	10000 	4 			localhost:4444 localhost:3333 192.168.33.3:4444
*/
