package cs5223.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Game {
	public static void main(String args[]) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String trackerIp = args[0];
			int trackerPort = Integer.parseInt(args[1]);
			String playerId = args[2];
			Registry registry = LocateRegistry.getRegistry(trackerIp);
			ITracker stub = (ITracker) registry.lookup("ITracker");

		} catch (Exception e) {
			System.err.println("ComputePi exception:");
			e.printStackTrace();
		}
	}
}
