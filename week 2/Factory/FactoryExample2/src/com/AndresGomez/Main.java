package Factory.FactoryExample2.src.com.AndresGomez;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //This example I will implement a fabric to select a connection a database to implement the
        // pattern of GoF fabric

        //Creation of the fabric
        ConnectionFabric fabric = new ConnectionFabric();

        //the code will now simulate the connection to 3 using the method of the fabric
        IConnection cx1 = fabric.getConnection("ORACLE");
        System.out.println("You submitted ORACLE");
        cx1.connect();
        cx1.search();
        cx1.disconnect();

        IConnection cx2 = fabric.getConnection("MySql");
        System.out.println("You submitted MySql");
        cx2.connect();
        cx2.search();
        cx2.disconnect();

        IConnection cx3 = fabric.getConnection("SqlServer");
        System.out.println("You submitted SqlServer");
        cx3.connect();
        cx3.search();
        cx3.disconnect();
        //there is also an object that will simulate any other attempt of connection
        IConnection cx4 = fabric.getConnection(" ?");
        System.out.println(" ?");
        cx4.connect();
        cx4.search();
        cx4.disconnect();
    }
}
