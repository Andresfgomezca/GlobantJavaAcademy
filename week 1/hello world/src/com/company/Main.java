package com.company;

public class Main {
    /*
    public static void main(String[] args) {
        System.out.println("prueba1");
        System.out.println("Hello World");

        String carName = "Volvo";
        int x = 5;
        int y = 10;
        System.out.println(x + y);
        int z = x + y;
        System.out.println(z);
        int j = 4, k = 3;
        System.out.println(j + k);
        final int l = 4; // this variable can not be overwrite.
        // ejemplos de variables
        int myNum = 9;
        float myFloatNum = 8.99f;
        char myLetter = 'A';
        boolean myBool = false;
        String myText = "Hello World";
        //interpretar double como int
        int myInt = (int) myDouble;

        //ejemplos de string
        String prueba = "";
        int tamaño = prueba.length();

        //--------------------------------------------------------------------------------------------
        //JAVA BASE
        /* metodos de conversion de string
        toUpperCase() and toLowerCase():
        indexOf("ejemplo") sirve para buscar en la cadena
        concatenacion + " " +
        comillas dentro de una cadena \"

         */
        /*
        System.out.println("nombre".concat("apellido"));//otra forma de concatenar
        */

        /*
        math
        Math.max(x, y); devuelve max
        Math.min(x, y); devuelve min
        Math.sqrt(x); devuelve raiz
        Math.abs(-4.3); devuelve el valor absoluto
        Math.random(); devuelve random entre 0.0 y 1.0
        int x = (int)(Math.random() * 101);  // random entre 1 y 100
         */


        //BOOLEANS
        /*
        ==	Equal to	x == y
        !=	Not equal	x != y
        >	Greater than	x > y
        <	Less than	x < y
        >=	Greater than or equal to	x >= y
        <=	Less than or equal to	x <= y

         */

        //IF
        /*
        else if has a second condition and the final else will operate is the second
        condition was false

        another way to write an if operation
        int time = 20;
        String result = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

         */


        //Switch case
        /*
        switch(expression) {
          case x:
            // code block
            break;
          case y:
            // code block
            break; OPTIONAL
          default: OPTIONAL
            // code block

         }

         */


        //while
        /*
        int i = 0;
        while (i < 5) {
          System.out.println(i);
          i++;
        }
         */

        //For
        /*
                       i <= 4  ----> 0 to 4
        for (int i = 0; i < 5; i++) { ----------> print 0 to 4
          System.out.println(i);
        }

         */


        //for-each
        /*
        used for arrays
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String i : cars) {
          System.out.println(i);
        }

         */

        //break and continue
        /*
        break interrupts current loop

        continue skips the current loop and continues with the next one

         */

        //arrays
        /*

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        int[] myNum = {10, 20, 30, 40};

        change value
        cars[0] = "Opel";
        .length size of the array
        for (int i = 0; i < cars.length; i++) {   loop with array
          System.out.println(cars[i]);
        }

        this loop will outputs all the items of the array

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String i : cars) {
          System.out.println(i);
        }

        multidimensional array

        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

        access to the array data will be describe by [x][y] where both variables starts from 0
        and the first one define the column and the second one the position
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        int x = myNumbers[1][2];
        System.out.println(x); // Outputs 7


        example to ready the multidimensional array
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        for (int i = 0; i < myNumbers.length; ++i) {
          for(int j = 0; j < myNumbers[i].length; ++j) {
            System.out.println(myNumbers[i][j]);
          }
        }
         */
        //---------------------------------------------------------------------------------------------

        //METHODS
        //methods are build inside the main and are identify with the ()
        //method main is different than class Main
        class Main2 {
            static void myMethod() {
                // code to be executed
            }
        }
        //this is the way that the method is going to be call to excecute its function.
        //All the code inside the class
        /*
        static void myMethod () {
            System.out.println("I just got executed!");
        }

        public static void main (String[]args){
            myMethod();
        }


         */

        //parameters

        //Are the variables used in the method and needs to be described as the variable used for its
        //functions
        /*
        static void myMethod (String fname){
            System.out.println(fname + " Refsnes");
        }
        //this example will print all the names with the last name "Refsnes"
        public static void main (String[]args){
            myMethod("Liam");
            myMethod("Jenny");
            myMethod("Anja");
        }
        */
        //example with multiple parameters
        //it will concatenate a name with its age
        //the method needs the same parameters in the same order to operate
        /*
        static void myMethod (String fname,int age){
            System.out.println(fname + " is " + age);
        }

        //return will be described in the method as void(without return), int, char, etc...
        //example of a method that returns an int
        static int myMethod ( int x){
            return 5 + x;
        }
         */
        //it can be process with 2 parameters
        /*
        static int myMethod ( int x, int y){
            return x + y;
        }
         */

        //methods with if
        //this method will compare the parameter in the method to provide a response in the console
        //that is why it can be void
        static void checkAge ( int age){

            // If age is less than 18, print "access denied"
            if (age < 18) {
                System.out.println("Access denied - You are not old enough!");

                // If age is greater than, or equal to, 18, print "access granted"
            } else {
                System.out.println("Access granted - You are old enough!");
            }

        }

        //Method overloading
        //We can create multiple methods with the same name with different parameters
        /*
        public void myMethod1 (int k)
        float myMethod1 (float x){};
        double myMethod1 (double x, double y){};


         */

        //java scope
        //variables can only be accessible inside the region where they are created.
        //example of where a variable can be used.
        public static void main (String[]args){

            // Code here CANNOT use x

            { // This is a block

                // Code here CANNOT use x

                int x = 100;

                // Code here CAN use x
                System.out.println(x);

            } // The block ends here

            // Code here CANNOT use x

        }

        //Java recursion ****************************************************************************************
        /* recursion is the way that you call a method inside the same method
        on this example the method sum() calls sum(k-1) to add all numbers smallers to the parameter
        entered, this could be interpretared as a loop because it will add all numbers until it stops with
        the k=0 */
    /*
        public static void main (String[]args){
            int result = sum(10);
            System.out.println(result);
        }

     */
        public static int sum ( int k){
            if (k > 0) {
                return k + sum(k - 1);
            } else {
                return 0;
            }
        }

        //Halting condition
        /*
        this condition is used when there is an infinite recursion that is calling itself infinite times,
        every recursion should have a halting condition that will stop this infinite loop
        the next example has a halting condition to stop adding numbers when one of the parameters is
        equal to each other
         */
    /*
        public static void main (String[]args){
            int result = sum(5, 10);
            System.out.println(result);
        }

     */
        public static int sum ( int start, int end){
            if (end > start) {
                return end + sum(start, end - 1);
            } else {
                return end;
            }
        }

        //-------------------------------------------------------------------------------------------------

        //JAVA OOP ****************************************************************************************
        /*
        This part educates about the object-oriented programming
        - OOP is faster and easier to execute
        - OOP provides a clear structure for the programs
        - OOP helps to keep the Java code DRY "Don't Repeat Yourself", and makes the code easier to maintain,
        modify and debug
        - OOP makes it possible to create full reusable applications with less code and shorter development
        time
         */

        /*
        Example to differenciate classes and objects to understand the concept easier
        ----------------------------------------|-----------------------------------
        Class                                   |Object
        ----------------------------------------|-----------------------------------
        fruit                                   |apple, banana, orange, etc...
        ----------------------------------------|-----------------------------------
        Car                                     |Volve, Mazda, Toyota, etc..
        ----------------------------------------|-----------------------------------
         */


        /*
        Ejemplo de como se crea una clase, el nombre siempre con mayuscula

        public class Main {
          int x = 5;
        }
        Asi se crea un objeto de una clase y se pueden crear varios a la vez
        Tambien pueden crearse si la clase esta en otro archivo .java pero este ha sido
        copilado

        public class Main {
          int x = 5;

          public static void main(String[] args) {
            Main myObj1 = new Main();   // Object 1
            Main myObj2 = new Main();  // Object 2
            System.out.println(myObj.x);
          }
        }
         */

        //CLASSES ATRIBUTES ****************************************************************************************

        /*
        Tomando esta base como ejemplo
        public class Main {
          int x = 5;
        }

        Con . Despues del objeto cleado se puede operar con las variables del objeto
        public static void main(String[] args) {
            Main myObj = new Main();
            System.out.println(myObj.x);
          }

          Modificar (setear o sobreescribir el valor)
            Main myObj = new Main();
            el tipo del nuevo objeto es el nombre de la clase

            myObj.x = 40;

        Evitar que se modifiquen las variables de la clase se puede hacer con "final"

        public class Main {
        final int x = 10;

        MULTIPLES ATRIBUTOS EN UNA CLASE

          String fname = "John";
          String lname = "Doe";
          int age = 24;

         */

        /*
        Methods in classes

        Methods from 1 class can be called

        public static void main(String[] args) {
            myMethod(); // metodo llamado de una clase
        }

        Static vs. Non-Static ****************************************************************************************

        public - non-static needs to create an object to call the method.

        Main myObj = new Main(); // Create an object of Main ( class)
        myObj.myPublicMethod(); // Call the public method on the object

        //Example of an object calling methods of a class

        public class Main {

          // Create a fullThrottle() method
          public void fullThrottle() {
            System.out.println("The car is going as fast as it can!");
          }

          // Create a speed() method and add a parameter, This method accepts int
          public void speed(int maxSpeed) {
            System.out.println("Max speed is: " + maxSpeed);
          }

          // Inside main, call the methods on the myCar object
          public static void main(String[] args) {
            Main myCar = new Main();   // Create a myCar object
            myCar.fullThrottle();      // Call the fullThrottle() method
            myCar.speed(200);          // Call the speed() method
          }
        }

         */

        /*
        //CONSTRUCTORS ****************************************************************************************
        It is a special method in java to initialize object, It has the same name than the created class.

        public class Main {
          int x;  // Create a class attribute

          // Create a class constructor for the Main class
          public Main() {
            x = 5;  // Set the initial value for the class attribute x
          }

          public static void main(String[] args) {
            Main myObj = new Main(); // Create an object of class Main (This will call the constructor)
            System.out.println(myObj.x); // Print the value of x
          }
        }


        This constructors can be use to create an object with variables added to the constructor
        on this case we added int y to create a variable x
        public class Main {
          int x;

          public Main(int y) {
            x = y;
          }

        On this example we add 2 variables (it is not required to inizialize the variables in the constructor if
        they were added like in this example

        public class Main {
          int modelYear;
          String modelName;

          public Main(int year, String name) {
            modelYear = year;
            modelName = name;
          }


         */

        // MODIFIERS ****************************************************************************************
        /*
        access modifiers: Controls the access level
            For classes:

            -PUBLIC: can be accessed by another class

            -defaul: class can be accessed by another classes in the same package.

            For attributes, methods and constructors:

            -PUBLIC: The code is accessible for all classes

            -defaul: The code is only accessible in the same package.

            -Private: The code is only accessible within the declared class

            -Protected: The code is accessible in the same package and subclasses.

        Non-access modifiers: does not control access levels but they can provide different funcionalities
            For classes:

            -final: The class cannot be inherited by other classes

            -abstract: The class cannot be used to create objects (To access an abstract class,
            it must be inherited from another class)

            For attributes and methods:

            -final: Attributes and methods cannot be overridden/modified

            -static: Attributes and methods belongs to the class, rather than an object

            -abstract: Can only be used in an abstract class, and can only be used on methods.
            The method does not have a body, for example abstract void run();.
            The body is provided by the subclass (inherited from).

            -transient: Attributes and methods are skipped when serializing the object containing them

            -synchronized: Methods can only be accessed by one thread at a time

            -volatile: The value of an attribute is not cached thread-locally, and is always read from the "main memory"


        the body of an abstract method is provided in the constructor. not in the class.


         */

        //Java Encapsulation ****************************************************************************************

        /*

        Encapsulation is to hidde sensitive information, we need to declare the variables as private and use
        "get" and "set" methods to access and update the value of a private variable.
        this methods needs to be public to have access to this information.

        public class Person {
          private String name; // private = restricted access

          // Getter
          public String getName() {
            return name;
          }

          // Setter
          public void setName(String newName) {
            this.name = newName;
          }
        }

        this process increases the security of the data managed in the code.


         */

        //JAVA PACKAGES AND APY ****************************************************************************************
        /*
        Packages are use to avoid name conflicts

        -Built-in Packages (packages from the Java API)
        -User-defined Packages (create your own packages)

        // Built-in Packages

        To use a package or a class from the library we need to use the keyword "import"
        example of how to import:
        import package.name.Class;   // Import a single class
        import package.name.*;   // Import the whole package

        example of a real class, the Scanner class, which is used to get user input
        import java.util.Scanner;

        Java.util. is a package

        To use the Scanner class, create an object of the class and use any of the available methods found
        in the Scanner class documentation. In our example, we will use the nextLine() method, which is used
        to read a complete line

        Example:
        import java.util.Scanner;

        class MyClass {
          public static void main(String[] args) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter username");

            String userName = myObj.nextLine();
            System.out.println("Username is: " + userName);
          }
        }

        if we want to import the complete package we use the instruction import with an * at the end

        import java.util.*;

        // User-defined Packages

        To create your own package, you need to understand that Java uses a file system directory to store them.
        Just like folders on your computer:

        └── root
          └── mypack
            └── MyPackageClass.java

        To create a pack we use the keyword "package"

        package mypack;
        class MyPackageClass {
          public static void main(String[] args) {
            System.out.println("This is my package!");
          }
        }




         */

        //Java Inheritance (Subclass and Superclass) ****************************************************************

        /*
        The inheritance is the way that we can inherits attributes and methods from one class to another
        subclass (child) - the class that inherits from another class
        superclass (parent) - the class being inherited from
        To inherit from a class, use the extends keyword.

        class Vehicle {
          protected String brand = "Ford";        // Vehicle attribute
          public void honk() {                    // Vehicle method
            System.out.println("Tuut, tuut!");
          }
        }

        class Car extends Vehicle {
          private String modelName = "Mustang";    // Car attribute
          public static void main(String[] args) {

            // Create a myCar object
            Car myCar = new Car();

            // Call the honk() method (from the Vehicle class) on the myCar object
            myCar.honk();
          }
        }
        brand attribute was defined as  protected, it can be accessed by the subclasses
        It is useful for code reusability: reuse attributes and methods of an existing class
        when you create a new class.

        /final keyword will generate an error because it can not be inherit

        final class Vehicle {
          ...
        }

        class Car extends Vehicle {
          ...
        }

         */

        //Java Polymorphism ****************************************************************************************

        /*
        Polymorphism uses those methods to perform different tasks.
        This allows us to perform a single action in different ways.


        Example of polymorphism with the method animalSound(): that is the way that the method is changed to be use
        on different forms.
        class Animal {
          public void animalSound() {
            System.out.println("The animal makes a sound");
          }
        }

        class Pig extends Animal {
          public void animalSound() {
            System.out.println("The pig says: wee wee");
          }
        }

        class Dog extends Animal {
          public void animalSound() {
            System.out.println("The dog says: bow wow");
          }
        }

        class Main {
          public static void main(String[] args) {
            Animal myAnimal = new Animal();  // Create a Animal object
            Animal myPig = new Pig();  // Create a Pig object
            Animal myDog = new Dog();  // Create a Dog object
            myAnimal.animalSound();
            myPig.animalSound();
            myDog.animalSound();
          }
        }

         */

        //Java Inner Classes

        /*

        The purpose of nested classes is to group classes that belong together,
        which makes your code more readable and maintainable.

        To access the inner class, create an object of the outer class, and then create an object of the inner class:

        class OuterClass {
          int x = 10;

          class InnerClass {
            int y = 5;
          }
        }

        public class Main {
          public static void main(String[] args) {
            OuterClass myOuter = new OuterClass();
            OuterClass.InnerClass myInner = myOuter.new InnerClass();
            System.out.println(myInner.y + myOuter.x);
          }
        }

        // Outputs 15 (5 + 10)

        The inner class can also be private or protected to avoid the use of the class by outside objects
        Example:

        class OuterClass {
          int x = 10;

          private class InnerClass {
            int y = 5;
          }
        }

        public class Main {
          public static void main(String[] args) {
            OuterClass myOuter = new OuterClass();
            OuterClass.InnerClass myInner = myOuter.new InnerClass(); //ERROR, PRIVATE INNER CLASS CAN NOT BE ACCESSED
            System.out.println(myInner.y + myOuter.x);
          }
        }

        //Static Inner Class
        An inner class can also be static, which means that you can access it
        without creating an object of the outer class:
        This example shows hoy the object myInner can use the variable of the innerclass
        class OuterClass {
          int x = 10;

          static class InnerClass {
            int y = 5;
          }
        }
                public class Main {
          public static void main(String[] args) {
            OuterClass.InnerClass myInner = new OuterClass.InnerClass();
            System.out.println(myInner.y);
          }
        }
        // Outputs 5


        //Access Outer Class From Inner Class
        One advantage of inner classes, is that they can access attributes and methods of the outer class:
        On this example the method of the inner class return the variable x of the outerClass, It is required to
        create the object of the outer class if  the inner is not static
        class OuterClass {
          int x = 10;

          class InnerClass {
            public int myInnerMethod() {
              return x;
            }
          }
        }

        public class Main {
          public static void main(String[] args) {
            OuterClass myOuter = new OuterClass();
            OuterClass.InnerClass myInner = myOuter.new InnerClass();
            System.out.println(myInner.myInnerMethod());
          }
        }

        // Outputs 10

         */

        //Java Abstraction ****************************************************************************************

        /*

        Abstract Classes and Methods

        Data abstraction is used to hide certain information and showing only the essential to the user
        Abstraction can be achieved with either abstract classes or interfaces

        The "abstract" keyword is a non-access modifier
            *Abstract class: is a restricted class that cannot be used to create objects
            (to access it, it must be inherited from another class).

            *Abstract method: can only be used in an abstract class, and it does not have a body.
            The body is provided by the subclass (inherited from).

        Example of a class that has methods abstract and normal ones

        abstract class Animal {
          public abstract void animalSound();
          public void sleep() {
            System.out.println("Zzz");
          }
        }

        how the class is abstract, we can not create object of this class, we have to  do a polymorphism

        Example using extends to create object of a inherit class from an abstract class:

        // Abstract class
        abstract class Animal {
          // Abstract method (does not have a body)
          public abstract void animalSound();
          // Regular method
          public void sleep() {
            System.out.println("Zzz");
          }
        }

        // Subclass (inherit from Animal)
        class Pig extends Animal {
          public void animalSound() {
            // The body of animalSound() is provided here
            System.out.println("The pig says: wee wee");
          }
        }

        class Main {
          public static void main(String[] args) {
            Pig myPig = new Pig(); // Create a Pig object, Now we can create the object because pig extends the abstract
                                      Class
            myPig.animalSound();
            myPig.sleep();
          }
        }

        Why is this process done?
        To achieve security - hide certain details and only show the important details of an object.

         */

        //Java Interface ****************************************************************************************

        /*
        An interface is a completely "abstract class" that is used to group related methods with empty bodies:
        // interface
        interface Animal {
          public void animalSound(); // interface method (does not have a body)
          public void run(); // interface method (does not have a body)
        }

        To access to these methods, the interface needs to be "implemented" in the class that will use those methods
        the key word used is "implements" instead of "extends" in inherited classes.

        Example:

        // Interface
        interface Animal {
          public void animalSound(); // interface method (does not have a body)
          public void sleep(); // interface method (does not have a body)
        }

        // Pig "implements" the Animal interface
        class Pig implements Animal {
          public void animalSound() {
            // The body of animalSound() is provided here
            System.out.println("The pig says: wee wee");
          }
          public void sleep() {
            // The body of sleep() is provided here
            System.out.println("Zzz");
          }
        }

        class Main {
          public static void main(String[] args) {
            Pig myPig = new Pig();  // Create a Pig object
            myPig.animalSound();
            myPig.sleep();
          }
        }

        Notes on Interfaces:
            *Like abstract classes, interfaces cannot be used to create objects (in the example above,
            it is not possible to create an "Animal" object in the MyMainClass)
            *Interface methods do not have a body - the body is provided by the "implement" class
            *On implementation of an interface, you must override all of its methods
            *Interface methods are by default abstract and public
            *Interface attributes are by default public, static and final
            *An interface cannot contain a constructor (as it cannot be used to create objects)


        Java does not support multiple inheritance in the classes, a class can only extend 1 superclass, but the
        classes can implement multiple interfaces.

        Example of a class using multiple interfaces:

        interface FirstInterface {
          public void myMethod(); // interface method
        }

        interface SecondInterface {
          public void myOtherMethod(); // interface method
        }

        class DemoClass implements FirstInterface, SecondInterface {
          public void myMethod() {
            System.out.println("Some text..");
          }
          public void myOtherMethod() {
            System.out.println("Some other text...");
          }
        }

        class Main {
          public static void main(String[] args) {
            DemoClass myObj = new DemoClass();
            myObj.myMethod();
            myObj.myOtherMethod();
          }
        }



         */
        //Java Enums ****************************************************************************************

        /*
        enum is a special class that represents a group of "constants" (unchangeable variables, like final variables).

        example:

        enum Level {
          LOW,
          MEDIUM,
          HIGH
        }

        You can access enum constants with the dot syntax:

        Level myVar = Level.MEDIUM;

        enum can be used inside a class

        public class Main {
          enum Level {
            LOW,
            MEDIUM,
            HIGH
          }

          public static void main(String[] args) {
            Level myVar = Level.MEDIUM;
            System.out.println(myVar);
          }
        }

        ENUM is commonly used in Switch statements

        example:

        enum Level {
          LOW,
          MEDIUM,
          HIGH
        }

        public class Main {
          public static void main(String[] args) {
            Level myVar = Level.MEDIUM;

            switch(myVar) {
              case LOW:
                System.out.println("Low level");
                break;
              case MEDIUM:
                 System.out.println("Medium level");
                break;
              case HIGH:
                System.out.println("High level");
                break;
            }
          }
        }

        The enum type has a method called "values()", this one return an array with all enum constants, it is usefull
        when we want to loop    through the constants of an enum

        example:

        for (Level myVar : Level.values()) {
            System.out.println(myVar);
        }
        The output will be:

        LOW
        MEDIUM
        HIGH

        */

        //Java User imput ****************************************************************************************

        /*
        Java User Input (Scanner)

        The Scanner class is used to get user input, and it is found in the java.util package.
        To use the Scanner class, create an object of the class and use any of the available methods found
        in the Scanner class documentation. In our example, we will use the nextLine() method,
        which is used to read Strings:

        Example:

        import java.util.Scanner;  // Import the Scanner class

        class Main {
          public static void main(String[] args) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter username");

            String userName = myObj.nextLine();  // Read user input
            System.out.println("Username is: " + userName);  // Output user input
          }
        }

        There are multiple methods to read the next input

        Method	        Description
        nextBoolean()	Reads a boolean value from the user
        nextByte()	    Reads a byte value from the user
        nextDouble()	Reads a double value from the user
        nextFloat()	    Reads a float value from the user
        nextInt()	    Reads a int value from the user
        nextLine()	    Reads a String value from the user
        nextLong()	    Reads a long value from the user
        nextShort()	    Reads a short value from the user

        This is an example of how to read multiple data of different types:
        class Main {
          public static void main(String[] args) {
            Scanner myObj = new Scanner(System.in);

            System.out.println("Enter name, age and salary:");

            // String input
            String name = myObj.nextLine();

            // Numerical input
            int age = myObj.nextInt();
            double salary = myObj.nextDouble();

            // Output input by user
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Salary: " + salary);
          }
        }

         */

        //JAVA DATE AND TIME****************************************************************************************

        /*
        Java does not have a built-in Date class, but we can import the java.time package
        to work with the date and time API. The package includes many date and time classes.
        For example:

        Class	            Description
        LocalDate	        Represents a date (year, month, day (yyyy-MM-dd))
        LocalTime	        Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
        LocalDateTime	    Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
        DateTimeFormatter	Formatter for displaying and parsing date-time objects


        import java.time.LocalDate; // import the LocalDate class

        public class Main {
          public static void main(String[] args) {
            LocalDate myObj = LocalDate.now(); // Create a date object
            System.out.println(myObj); // Display the current date
          }
        }

        FORMATING THE DATE AND TIME

        We can use DateTimeFormatter class with the ofPattern() method in the same package to format or
        parse date-time objects. The following example will remove both the "T" and nanoseconds from the date-time:

        import java.time.LocalDateTime; // Import the LocalDateTime class
        import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

        public class Main {
          public static void main(String[] args) {
            LocalDateTime myDateObj = LocalDateTime.now();
            System.out.println("Before formatting: " + myDateObj);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String formattedDate = myDateObj.format(myFormatObj);
            System.out.println("After formatting: " + formattedDate);
          }
        }
        //OUTPUT
        Before Formatting:  2022-01-03T21:53:48.571382
        After Formatting:   03-01-2022 21:53:48

        The different formats that we can use are this ones:

        Value	        Example
        yyyy-MM-dd	    "1988-09-29"
        dd/MM/yyyy	    "29/09/1988"
        dd-MMM-yyyy	    "29-Sep-1988"
        E, MMM dd yyyy	"Thu, Sep 29 1988"

         */

        //JAVA ARRAY LIST**************************************************************************************

        /*
        The ArrayList class is a resizable array, which can be found in the java.util package.
        This package allow us to create an array and we can modify it with different methods.
        The syntax is also slightly different:

        import java.util.ArrayList;                         // import the ArrayList class
        ArrayList<String> cars = new ArrayList<String>();   // Create an ArrayList object

        //Add items
        import java.util.ArrayList;

        public class Main {
          public static void main(String[] args) {
            ArrayList<String> cars = new ArrayList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            System.out.println(cars);
          }
        }

        //Access an item

        cars.get(0);

        //Change an item

        cars.set(0, "Opel");

        //Remove an item

        cars.remove(0);

        //Remove all elements

        cars.clear();

        //Array list size

        This method is to find how many item are in the array

        car.size();

        //Loop Through an ArrayList

        we need to do the loop with a for and the size() method in order to loop through an array.

        public class Main {
          public static void main(String[] args) {
            ArrayList<String> cars = new ArrayList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            for (int i = 0; i < cars.size(); i++) {
              System.out.println(cars.get(i));
            }
          }
        }

        You can also loop through an ArrayList with the for-each loop:

        public class Main {
          public static void main(String[] args) {
            ArrayList<String> cars = new ArrayList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            for (String i : cars) {
              System.out.println(i);
            }
          }
        }

        //Other types

        Elements in an ArrayList are actually objects. In the examples above,
        we created elements (objects) of type "String". Remember that a String in
        Java is an object (not a primitive type). To use other types, such as int,
        you must specify an equivalent wrapper class: Integer. For other primitive
        types, use: Boolean for boolean, Character for char, Double for double, etc:

        import java.util.ArrayList;

        public class Main {
          public static void main(String[] args) {
            ArrayList<Integer> myNumbers = new ArrayList<Integer>();
            myNumbers.add(10);
            myNumbers.add(15);
            myNumbers.add(20);
            myNumbers.add(25);
            for (int i : myNumbers) {
              System.out.println(i);
            }
          }
        }

        //sort an arraylist
        Another useful class in the java.util package is the Collections class,
        which include the sort() method for sorting lists alphabetically or numerically:

        Example:

        import java.util.ArrayList;
        import java.util.Collections;  // Import the Collections class

        public class Main {
          public static void main(String[] args) {
            ArrayList<String> cars = new ArrayList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            Collections.sort(cars);  // Sort cars
            for (String i : cars) {
              System.out.println(i);
            }
          }
        }

        Sort an array of integers

        example:

        import java.util.ArrayList;
        import java.util.Collections;  // Import the Collections class

        public class Main {
          public static void main(String[] args) {
            ArrayList<Integer> myNumbers = new ArrayList<Integer>();
            myNumbers.add(33);
            myNumbers.add(15);
            myNumbers.add(20);
            myNumbers.add(34);
            myNumbers.add(8);
            myNumbers.add(12);

            Collections.sort(myNumbers);  // Sort myNumbers

            for (int i : myNumbers) {
              System.out.println(i);
            }
          }
        }

         */

        //Java LinkedList

        /*
        Linkedlist is almost the same as arraylist, both has the same methods because they implement the list interface.


        // Import the LinkedList class
        import java.util.LinkedList;

        public class Main {
          public static void main(String[] args) {
            LinkedList<String> cars = new LinkedList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            System.out.println(cars);
          }
        }

        This linkedlist stores its items in "containers", the list has a link to the first container and each container
        has a link for the next container. if we add an element, it will be placed into a new container and
        this container is linked to one of the other containers in the list.

        //When To Use
        Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.

        //Linkedlist methods

        Method	        Description
        addFirst()	    Adds an item to the beginning of the list.
        addLast()	    Add an item to the end of the list
        removeFirst()	Remove an item from the beginning of the list.
        removeLast()	Remove an item from the end of the list
        getFirst()	    Get the item at the beginning of the list
        getLast()	    Get the item at the end of the list

         */

        //JAVA HASHMAP********************************************************************************************

        /*

        A hash maps store items  in "key/value" pairs, and you can access them by an index
        of another type (e.g. a String).

        It can store different types: String keys and Integer values, or the same type,
        like: String keys and String values:

        In the next example, I'll create a hashmap that will store string keys and string values

        import java.util.HashMap; // import the HashMap class

        HashMap<String, String> capitalCities = new HashMap<String, String>();

        //add an item
        To add an item we need to call the method "put()".

        // Import the HashMap class
        import java.util.HashMap;

        public class Main {
          public static void main(String[] args) {
            // Create a HashMap object called capitalCities
            HashMap<String, String> capitalCities = new HashMap<String, String>();

            // Add keys and values (Country, City)
            capitalCities.put("England", "London");
            capitalCities.put("Germany", "Berlin");
            capitalCities.put("Norway", "Oslo");
            capitalCities.put("USA", "Washington DC");
            System.out.println(capitalCities);
          }
        }

        //access an item

        To access a value in the HashMap, use the get() method and refer to its key:

        capitalCities.get("England");

        //remove an item

        To remove an item, use the remove() method and refer to the key:

        capitalCities.remove("England");

        To remove all items we use "clear()"

        //Hashmap Size

        To find out how many item there are in the hashmap, we use the "size()" method

        capitalCities.size();

        //Loop Through a HashMap

        we can create a loop through a hashmap using a for-each loop
        Use the keySet() method if you only want the keys, and use the values() method if you only want the values:
        Examples:

        // Print keys
        for (String i : capitalCities.keySet()) {
          System.out.println(i);
        }

        // Print values
        for (String i : capitalCities.values()) {
          System.out.println(i);
        }

        // Print keys and values
        for (String i : capitalCities.keySet()) {
          System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }

        //Other Types

        To use other types, such as int, you must specify an equivalent wrapper class: Integer. For other primitive
        types, use: Boolean for boolean, Character for char, Double for double, etc:

        Example of a Hashmap with key string and int values

        // Import the HashMap class
        import java.util.HashMap;

        public class Main {
          public static void main(String[] args) {

            // Create a HashMap object called people
            HashMap<String, Integer> people = new HashMap<String, Integer>();


            // Add keys and values (Name, Age)
            people.put("John", 32);
            people.put("Steve", 30);
            people.put("Angie", 33);

            for (String i : people.keySet()) {
              System.out.println("key: " + i + " value: " + people.get(i));
            }
          }
        }

         */

        //JAVA HASHSET **********************************************************************************

        /*
        A HashSet is a collection of items where every item is unique, and it is found in the java.util package:

        import java.util.HashSet; // Import the HashSet class

        HashSet<String> cars = new HashSet<String>();

        //Adding method
        Example of the adding method.
        // Import the HashSet class
        import java.util.HashSet;

        public class Main {
          public static void main(String[] args) {
            HashSet<String> cars = new HashSet<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("BMW");
            cars.add("Mazda");
            System.out.println(cars);
          }
        }

        How BMW is twice, the hashset will only record 1 of those

        //Check If an Item Exists

        We use the contains() method to verify if an item exists in the hashset.
        cars.contains("Mazda");

        //Remove an item

        To remove an item, use the remove() method:

        cars.remove("Volvo");

        To remove all items, use the clear() method.

        //HashSet Size

        To find out how many items there are, use the size method:

        //Loop Through a HashSet

        Loop through the items of an HashSet with a for-each loop:

        Example:
        for (String i : cars) {
          System.out.println(i);
        }

        //Other types

        To use other types, such as int, you must specify an equivalent wrapper class: Integer.
        For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc:
        Example of a hashset to storage Integer Objects.

        import java.util.HashSet;

        public class Main {
          public static void main(String[] args) {

            // Create a HashSet object called numbers
            HashSet<Integer> numbers = new HashSet<Integer>();

            // Add values to the set
            numbers.add(4);
            numbers.add(7);
            numbers.add(8);

            // Show which numbers between 1 and 10 are in the set
            for(int i = 1; i <= 10; i++) {
              if(numbers.contains(i)) {
                System.out.println(i + " was found in the set.");
              } else {
                System.out.println(i + " was not found in the set.");
              }
            }
          }
        }

        //Java Iterators******************************************************************************************
        An Iterator is an object that can be used to loop through collections, like ArrayList and HashSet.
        It is called an "iterator" because "iterating" is the technical term for looping.
        To use an Iterator, you must import it from the java.util package.

        Getting an iterator****

        The iterator() method can be used to get an Iterator for any collection:

        // Import the ArrayList class and the Iterator class
        import java.util.ArrayList;
        import java.util.Iterator;

        public class Main {
          public static void main(String[] args) {

            // Make a collection
            ArrayList<String> cars = new ArrayList<String>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");

            // Get the iterator
            Iterator<String> it = cars.iterator();

            // Print the first item
            System.out.println(it.next());
          }
        }

        //Looping Through a Collection

        To loop through a collection, use the hasNext() and next() methods of the Iterator:

        while(it.hasNext()) {
          System.out.println(it.next());
        }

        //Removing items from a collection

        Iterators are design to easily change the collections that they loop through. The remove method can
        remove items while looping.

        Example of how an iterator removes items less than 10 from the collection:
        *We need to use a while because the size of the collection will change every time it removes an item

        import java.util.ArrayList;
        import java.util.Iterator;

        public class Main {
          public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(12);
            numbers.add(8);
            numbers.add(2);
            numbers.add(23);
            Iterator<Integer> it = numbers.iterator();
            while(it.hasNext()) {
              Integer i = it.next();
              if(i < 10) {
                it.remove();
              }
            }
            System.out.println(numbers);
          }
        }

        */

        //Java Wrapper Classes*************************************************************************************


        /*
        Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.

        Primitive Data Type	    Wrapper Class
        byte	                Byte
        short	                Short
        int	                    Integer
        long	                Long
        float	                Float
        double	                Double
        boolean	                Boolean
        char	                Character

        The next example will show the correct way to implement a collection with a wrapper class(objects)

        ArrayList<int> myNumbers = new ArrayList<int>();            // Invalid
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();    // Valid

        //Creating Wrapper Objects

        To create a wrapper object, use the wrapper class instead of the primitive type.
        To get the value, you can just print the object:

        public class Main {
          public static void main(String[] args) {
            Integer myInt = 5;
            Double myDouble = 5.99;
            Character myChar = 'A';
            System.out.println(myInt);
            System.out.println(myDouble);
            System.out.println(myChar);
          }
        }
        Since you're now working with objects, you can use certain methods to get information about the specific object.
        For example, the following methods are used to get the value associated with the corresponding wrapper object:
        intValue(), byteValue(), shortValue(), longValue(), floatValue(), doubleValue(), charValue(), booleanValue().
        This example will output the same result as the example above:

        Example of the methods use to get the value for each wrapper object:
        public class Main {
          public static void main(String[] args) {
            Integer myInt = 5;
            Double myDouble = 5.99;
            Character myChar = 'A';
            System.out.println(myInt.intValue());
            System.out.println(myDouble.doubleValue());
            System.out.println(myChar.charValue());
          }
        }

        Another useful method is .toString(), this method can change a wrapper object to strings.


        public class Main {
          public static void main(String[] args) {
            Integer myInt = 100;
            String myString = myInt.toString(); // this method will change the object myInt into a String
            System.out.println(myString.length()); //This method will print the lenght of the string
          }
        }


         */

        // Java Exceptions - Try...Catch ************************************************************************

        /*
        When executing Java code, different errors can occur: coding errors made by the programmer,
        errors due to wrong input, or other unforeseeable things. When an error occurs, Java will normally
        stop and generate an error message. The technical term for this is: Java will throw an exception
        (throw an error).

        The try statement allows you to define a block of code to be tested for errors while it is being executed.
        The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.

        Example:

        try {
          //  Block of code to try
        }
        catch(Exception e) {
          //  Block of code to handle errors
        }

        The try and catch keywords come in pairs:

        If an error occurs, we can use try...catch to catch the error and execute some code to handle it:

        Example of an error by calling a position on a collection that doesn't exists:

        public class Main {
          public static void main(String[ ] args) {
            try {
              int[] myNumbers = {1, 2, 3};
              System.out.println(myNumbers[10]);
            } catch (Exception e) {
              System.out.println("Something went wrong."); //Error will show this message in console.
            }
          }
        }

        //Finally

        The finally statement will allow us to excecute code after the try catch, regardless the results:

        public class Main {
          public static void main(String[] args) {
            try {
              int[] myNumbers = {1, 2, 3};
              System.out.println(myNumbers[10]);
            } catch (Exception e) {
              System.out.println("Something went wrong.");
            } finally {
              System.out.println("The 'try catch' is finished.");
            }
          }
        }

        //The throw keyword

        The throw statement is used together with an exception type. There are many exception types available in Java:
        ArithmeticException, FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException, etc:

        example:
        public class Main {
          static void checkAge(int age) {
            if (age < 18) {
              throw new ArithmeticException("Access denied - You must be at least 18 years old.");
            }
            else {
              System.out.println("Access granted - You are old enough!");
            }
          }

          public static void main(String[] args) {
            checkAge(15); // Set age to 15 (which is below 18...)
          }
        }

        the output will be:

        Exception in thread "main" java.lang.ArithmeticException: Access denied - You must be at least 18 years old.
        at Main.checkAge(Main.java:4)
        at Main.main(Main.java:12)
         */

        //Java Regular Expressions************************************************************************************

        /*
        Regular expressions can be used to perform all types of text search and text replace operations.
        Java does not have a built-in Regular Expression class, but we can import the java.util.regex package
        to work with regular expressions. The package includes the following classes:
        Pattern Class - Defines a pattern (to be used in a search)
        Matcher Class - Used to search for the pattern
        PatternSyntaxException Class - Indicates syntax error in a regular expression pattern

        Example:

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

        public class Main {
          public static void main(String[] args) {
            Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher("Visit W3Schools!");
            boolean matchFound = matcher.find();
            if(matchFound) {
              System.out.println("Match found");
            } else {
              System.out.println("Match not found");
            }
          }
        }
        // Outputs Match found


        //Flags

        Flags in the compile() method change how the search is performed. Here are a few of them:

            -Pattern.CASE_INSENSITIVE - The case of letters will be ignored when performing a search.
            -Pattern.LITERAL - Special characters in the pattern will not have any special meaning and
            will be treated as ordinary characters when performing a search.
            -Pattern.UNICODE_CASE - Use it together with the CASE_INSENSITIVE flag to also ignore the case
            of letters outside of the English alphabet

         */

        //Java Threads**********************************************************************************************

        /*
        Threads allows a program to operate more efficiently by doing multiple things at the same time.
        Threads can be used to perform complicated tasks in the background without interrupting the main program.


        //Creating a threads

        It can be created by extending the Thread class and overriding its run() method:

        public class Main extends Thread {
          public void run() {
            System.out.println("This code is running in a thread");
          }
        }

        Another way to create a thread is to implement the Runnable interface:

        public class Main implements Runnable {
          public void run() {
            System.out.println("This code is running in a thread");
          }
        }

        //Running threads
        If the class extends the Thread class, the thread can be run by creating an instance of the
        class and call its start() method:

        public class Main extends Thread {
          public static void main(String[] args) {
            Main thread = new Main();
            thread.start();
            System.out.println("This code is outside of the thread");
          }
          public void run() {
            System.out.println("This code is running in a thread");
          }
        }

        If the class implements the Runnable interface, the thread can be run by passing an instance of the class
        to a Thread object's constructor and then calling the thread's start() method:

        public class Main implements Runnable {
          public static void main(String[] args) {
            Main obj = new Main();
            Thread thread = new Thread(obj);
            thread.start();
            System.out.println("This code is outside of the thread");
          }
          public void run() {
            System.out.println("This code is running in a thread");
          }
        }

        //Concurrency Problems

        This problems are unpredictable changes in variables when the value of those variables is changed
        in the threads and in the main program, there is no way to know how the program will run.

        This is an example of a variable that is unpredictable because it is changed in the thread and in the main
        code:

        public class Main extends Thread {
          public static int amount = 0;

          public static void main(String[] args) {
            Main thread = new Main();
            thread.start();
            System.out.println(amount);
            amount++;
            System.out.println(amount);
          }

          public void run() {
            amount++;
          }
        }

        We can avoid concurrency problems by using the method isAlive(), The next example will show how to implement
        the isAlive() method to wait for the response of the thread.

        public class Main extends Thread {
          public static int amount = 0;

          public static void main(String[] args) {
            Main thread = new Main();
            thread.start();
            // Wait for the thread to finish
            while(thread.isAlive()) {
            System.out.println("Waiting...");
          }
          // Update amount and print its value
          System.out.println("Main: " + amount);
          amount++;
          System.out.println("Main: " + amount);
          }
          public void run() {
            amount++;
          }
        }
         */

        //Java Lambda Expressions**********************************************************************************
        /*
        Lambda expressions were added in java 8 and it is a short block of code which takes in parameters and
        returns a value.

        The simplest lambda expression:
        parameter -> expression

        To use more than one parameter, wrap them in parentheses:

        (parameter1, parameter2) -> expression

        It can not contain variables, assignments or statements such as if or for. If the lambda needs to return a value
        it will contain a return statement.

        (parameter1, parameter2) -> { code block }

        //Using Lambda Expressions

        Lambda expressions are usually passed as parameters to a function:

        In the next example we use a lamba expression in the ArrayList's forEach() method to print
        every item in the list:

        import java.util.ArrayList;

        public class Main {
          public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(5);
            numbers.add(9);
            numbers.add(8);
            numbers.add(1);
            numbers.forEach( (n) -> { System.out.println(n); } ); //Here is the lambda expression
          }
        }

        Lambda expressions can be stored in variables if the variable's type is an interface which only has 1 method.
        The lambda expression should have the same number of parameters and the same return type as that method.

        Example of a lambda expression in a variable using the interface consumer:

        import java.util.ArrayList;
        import java.util.function.Consumer;

        public class Main {
          public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(5);
            numbers.add(9);
            numbers.add(8);
            numbers.add(1);
            Consumer<Integer> method = (n) -> { System.out.println(n); };
            numbers.forEach( method );
          }
        }

        To use a lambda expression in a method, the method should have a parameter with a single-method
        interface as its type. Calling the interface's method will run the lambda expression:

        Example:

        Create a method which takes a lambda expression as a parameter:

        interface StringFunction { //we create an interface that only has 1 method
          String run(String str);
        }

        public class Main {
          public static void main(String[] args) {
            StringFunction exclaim = (s) -> s + "!";
            StringFunction ask = (s) -> s + "?";
            printFormatted("Hello", exclaim);
            printFormatted("Hello", ask);
          }
          public static void printFormatted(String str, StringFunction format) {
            String result = format.run(str);
            System.out.println(result);
          }
        }





         */
}

