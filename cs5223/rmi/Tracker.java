package cs5223.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker implements Hello {
	private static int portNumber;
	private static int gridSize;
	private static int treasureCount;
	private static List<Player> players;

	public Tracker() {

	}

	public Tracker(int portNumber, int gridSize, int treasureCount) {
		this.portNumber = portNumber;
		this.gridSize = gridSize;
		this.treasureCount = treasureCount;
		this.players = new ArrayList<Player>();
	}

	public static void main(String args[]) {
		Hello stub = null;
		Registry registry = null;
		try {
			int portNumber = Integer.parseInt(args[0]);
			int gridSize = Integer.parseInt(args[1]);
			int treasureCount = Integer.parseInt(args[2]);
			Tracker tracker = new Tracker(portNumber,gridSize,treasureCount);
			stub = (Hello) UnicastRemoteObject.exportObject(tracker, 0);
			registry = LocateRegistry.getRegistry();
			registry.rebind("Hello", stub);
			System.out.println("Tracker ready.");
		} catch (Exception e) {
			System.err.println("Tracker exception: ");
			e.printStackTrace();
		}
	}

	public IPlayer getRandomPlayer(IPlayer callingPlayer) {
		synchronized (this.players) {
			if (this.players.size() == 0) {
				this.players.add((Player)callingPlayer);
				return null;
			} else {
				Random rand = new Random();
				int indexOfPlayer = rand.nextInt(this.players.size());
				this.players.add((Player)callingPlayer);
				return this.players.get(indexOfPlayer);
			}
		}
	}

	@Override
	public String sayHello(){
		// TODO Auto-generated method stub
		return "Hello there";
	}
}