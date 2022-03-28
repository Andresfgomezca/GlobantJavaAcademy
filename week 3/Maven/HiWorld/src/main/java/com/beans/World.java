package com.beans;

import org.springframework.beans.factory.annotation.Value;

import javax.management.ConstructorParameters;

public class World{
    @Value(value = "Hi World")
    private String greeting;

@ConstructorParameters(value = "10")
    public World(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    //now we need to define the container that will manage this bean it can be developed with @ but in this
    //example it will be with xml file

}
