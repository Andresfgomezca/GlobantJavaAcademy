package Factory.FactoryExample2.src.com.AndresGomez;

import com.sun.jdi.connect.spi.Connection;

public class ConnectionOracle implements IConnection{
    private String host;
    private String port;
    private String user;
    private String password;
    private Connection conn;

    public ConnectionOracle(){
        this.host="localhost";
        this.port="3302";
        this.user="admin";
        this.password="admin123";
    }
    @Override
    public void connect(){
        System.out.println("You are now connect to ORACLE");
    }

    @Override
    public void disconnect() {
        System.out.println("You are now out of ORACLE");
    }

    @Override
    public void search() {
        System.out.println("Searching data.... UPS! Try again later...");
    }
}
