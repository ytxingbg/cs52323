package cs5223.assignment1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TrackerThread extends Thread {
	private int portNumber;
	private List<Player> players;

	public TrackerThread() {

	}

	public TrackerThread(int portNumber) {
		this.portNumber = portNumber;
		this.players = new ArrayList<Player>();
	}

	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
			while (true) {
				System.out.println("listing on port " + portNumber);
				try (Socket clientSocket = serverSocket.accept();) {
					String clientAddress = clientSocket.getRemoteSocketAddress().toString();
					int clientPort = clientSocket.getPort();
					System.out.println("client " + clientAddress + ":" + clientPort + " accepted.");
					Player lastPlayer = players.get(players.size() - 1);

					OutputStream out = clientSocket.getOutputStream();
					try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));) {
						if (lastPlayer != null) {
							writer.write(lastPlayer.getIp() + ":" + lastPlayer.getPort());
						}
						writer.newLine();
						writer.flush();
						writer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

					players.add(new Player(clientAddress, clientPort));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}