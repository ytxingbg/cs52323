package cs5223.assignment1.tracker;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITracker extends Remote {
Player getRandomPlayer(Player callingPlayer) throws RemoteException;
}
