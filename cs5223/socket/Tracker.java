package cs5223.socket;

import java.io.*;
import java.net.*;
import java.util.Arrays;

class Tracker {
	public static int port = 8000;
	public static int N = 20;
	public static int K = 5;
	
	public static int count = 0;
	
	public static int[] players = new int[N*N];
	public static Socket[] playerSockets = new Socket[N*N];
	
	public static String[] playerParameters = new String[N*N+500];
	public static void main(String args[]) {
		try {
			Socket socket = null;
			// Need use args to define the socket port and ip
			ServerSocket serverSocket = new ServerSocket(port);
         
			while (count < N*N + 500) {
				try {
					socket = serverSocket.accept();
					
					String playerName = "Player" + count;
					String playerIP = socket.getInetAddress().toString().replace("/", "");
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
			        while (!in.ready()) {}
			        String playerPort = in.readLine();
			        
			        playerParameters[count] = playerName + "," + count + "," + playerIP + "," + playerPort;
			        count += 1;
			        
			        String[] newPlayerParameters = Arrays.copyOfRange(playerParameters, 0, count);

			        String playersList = String.join(";", newPlayerParameters);
			        
					String message = ""+ N + "," + K + ";" + playersList;
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(message);
					
			        socket.close();
				} catch (IOException e) {
					System.out.println("I/O error: " + e);
				}
			}
			System.out.println("Players Number beyond the limit" + (N * N + 100));
		}
		catch(Exception e) {
			System.out.println("Tracker Crashed!");
		}
	}
}
