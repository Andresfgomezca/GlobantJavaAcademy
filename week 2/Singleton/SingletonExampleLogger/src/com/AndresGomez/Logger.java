package Singleton.SingletonExampleLogger.src.com.AndresGomez;

public class Logger {
    private static Logger log;
    private String value;
    private Logger(){


    }
    public static synchronized Logger getInstance(){
        //synchronized will only be executed in 1 thread
        if( log == null){
            log = new Logger();
        }
        return log;
    }
    public void log(String msg){
        System.out.println(msg);
    }

    public void setValue(String msg) {//method to test instances
        this.value = msg;
    }

    public String getValue() {
        return value;
    }
}
