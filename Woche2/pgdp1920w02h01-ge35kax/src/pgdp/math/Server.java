package pgdp.math;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server=new ServerSocket(8080);
			System.out.println("win");
		}
		catch(Exception e) {
			System.out.println("fail");
			
		}
		finally {
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
