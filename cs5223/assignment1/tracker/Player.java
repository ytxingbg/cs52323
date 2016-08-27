package cs5223.assignment1.tracker;

import java.io.Serializable;

public class Player implements IPlayer, Serializable{
	private String name;
    private String ip;
    private int port;
    public Player(){

    }
    public Player(String name, String ip, int port){
    	this.name = name;
        this.ip = ip;
        this.port = port;
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
}