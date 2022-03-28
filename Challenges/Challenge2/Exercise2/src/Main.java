import ProductBuilder.ProductBuilder;

public class Main {
    public static void main(String[] args)    {
        System.out.println("""
           This code is for educational purposes, developed by Andres Felipe Gomez to develop the challenge #2-exercise2.
           """
        + "\n"
        + "\n");
        //this exercise requires an abstract builder and a facade design to hide the logic implementation of the logic.

        Facade facade = new Facade();
        facade.execution();
    }

}
