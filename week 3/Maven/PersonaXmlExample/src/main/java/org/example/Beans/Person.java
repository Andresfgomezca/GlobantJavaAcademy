package org.example.Beans;

public class Person {
    int id;
    String Name;
    String Nickname;
    public Person(int id, String name, String nickname) {
        this.id = id;
        Name = name;
        Nickname = nickname;
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String nickname) {
        Nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getNickname() {
        return Nickname;
    }
}