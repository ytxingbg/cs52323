package cs5223.assignment1;
public class Tracker {
	public Tracker() {

	}

	public static void main(String args[]) {
		int portNumber = Integer.parseInt(args[0]);
		int gridSize = Integer.parseInt(args[1]);
		int treasureCount = Integer.parseInt(args[2]);
		TrackerThread thread = new TrackerThread(portNumber, gridSize, treasureCount);
		thread.start();
	}
}