package org.example;

import com.beans.Config;
import com.beans.World;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //Spring allow us to instantiate an object dynamically
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
        //ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //it is not working with the package's path of the AppConfig
        World m = appContext.getBean(World.class);//this container will manage the bean created
        System.out.println(m.getGreeting());

    }
}
