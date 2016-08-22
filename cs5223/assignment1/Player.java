package cs5223.assignment1;
public class Player{
    private String ip;
    private int port;
    public Player(){

    }
    public Player(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public String getIp()
    {
        return ip;
    }

    public int getPort(){
        return port;
    }
}