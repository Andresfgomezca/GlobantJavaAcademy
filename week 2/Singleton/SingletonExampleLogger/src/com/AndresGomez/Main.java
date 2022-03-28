package Singleton.SingletonExampleLogger.src.com.AndresGomez;

public class Main {

    public static void main(String[] args) {
	// write your code here\
        Logger logger1 = Logger.getInstance();
        logger1.log("Testing method of this singleton");
        Logger logger2 = Logger.getInstance();

        logger1.setValue("test1");//test that the instance of logger 1 will print the same value for value 2
        System.out.println(logger2.getValue());
        }
}
