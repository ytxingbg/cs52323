package cs5223.rmi;

public interface IMaze {
	boolean JoinGame(Player player);
	boolean MoveWest(Player player);
	boolean MoveSouth(Player player);
	boolean MoveEast(Player player);
	boolean MoveNorth(Player player);
}
