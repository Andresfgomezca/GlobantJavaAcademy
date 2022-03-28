package org.example;


import org.example.Beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext();

        Person per = (Person) appContext.getBean("person");

        System.out.println(per.getId() + " " + per.getName() + " " +per.getNickname());

        //((ConfigurableApplicationContext) appContext).close();

    }
}
