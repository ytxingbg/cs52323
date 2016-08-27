package cs5223.rmi;

import java.io.Serializable;

public class Player implements IPlayer, Serializable{
	private String name;
    private String ip;
    private int port;
    private int score;
    public Player(){

    }
    public Player(String name, String ip, int port){
    	this.name = name;
        this.ip = ip;
        this.port = port;
        this.score = 0;
    }
    
    public String getName()
    {
    	return name;
    }

    public String getIp()
    {
        return ip;
    }

    public int getPort(){
        return port;
    }
	@Override
	public void findTreasure() {
		this.score++;
	}
}