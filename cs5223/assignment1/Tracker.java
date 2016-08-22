package cs5223.assignment1;
public class Tracker {
	public Tracker() {

	}

	public static void main(String args[]) {
		int portNumber = Integer.parseInt(args[0]);
		TrackerThread thread = new TrackerThread(portNumber);
		thread.start();
	}
}