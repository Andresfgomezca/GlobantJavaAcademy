package source.exercise1;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
       This code is for educational purposes, developed by Andres Felipe Gomez to develop the challenge #2-exercise 1.
           """
                + "\n"
                + "\n");
        //this exercise requires an abstract builder and a facade design to hide the logic implementation of the logic.
        GeniusDirector director = new GeniusDirector();
        //INSTANTIATE DIRECTOR CLASS //director will also be a facade class
        //This director will request the information from the client to build the device with a builders.
        director.Execution();
    }
}
