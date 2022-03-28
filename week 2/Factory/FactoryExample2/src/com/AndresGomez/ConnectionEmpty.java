package Factory.FactoryExample2.src.com.AndresGomez;

public class ConnectionEmpty implements IConnection{
    @Override
    public void connect() {
        System.out.println("This is an invalid connection");
    }

    @Override
    public void disconnect() {
        System.out.println("you are now disconnect");
    }

    @Override
    public void search() {

    }

}
