package com.AndresGomez;

public class Main {

    public static void main(String[] args) {
        /*
        Factory Method Design Pattern
        The components of the factory method pattern in the context of the pizza store can be summarized as:

        -Product (Pizza): Is an interface or an abstract class whose subclasses are instantiated by
        the factory method.
        -ConcreteProduct (CheesePizza, PepperoniPizza, and VeggiePizza): Are the concrete subclasses
        that implement/extend Product. The factory method instantiates these subclasses.
        -Creator (BasePizzaFactory): Is an interface or an abstract class that declares the factory method,
        which returns an object of type Product.
        -ConcreteCreator (PizzaFactory): Is a concrete class that implements the factory method to create
        and return a ConcreteProduct to Client.
        -Client: Asks the Creator for a Product.



         */
        /*
        The GoF Design Patterns are broken into threee categories:
            -Creational patterns for the creation of objects
                -Abstract Factory. Allows the creation of objects without specifying their concrete type.
                -Builder. Uses to create complex objects.
                -Factory Method. Creates objects without specifying the exact class to create.
                -Prototype. Creates a new object from an existing object.
                -Singleton. Ensures only one instance of an object is created.
            -Structure patterns to provide relationship between objects
                -Adapter. Allows for two incompatible classes to work together by wrapping an interface
                around one of the existing classes.
                -Bridge. Decouples an abstraction so two classes can vary independently.
                -Composite. Takes a group of objects into a single object.
                -Decorator. Allows for an object’s behavior to be extended dynamically at run time.
                -Facade. Provides a simple interface to a more complex underlying object.
                -Flyweight. Reduces the cost of complex object models.
                -Proxy. Provides a placeholder interface to an underlying object to control access,
                reduce cost, or reduce complexity.
            -Behavioral patterns to help define how objects interact
                -Chain of Responsibility. Delegates commands to a chain of processing objects.
                -Command. Creates objects which encapsulate actions and parameters.
                -Interpreter. Implements a specialized language.
                -Iterator. Accesses the elements of an object sequentially without exposing its underlying
                 representation.
                -Mediator. Allows loose coupling between classes by being the only class that has detailed
                 knowledge of their methods.
                -Memento. Provides the ability to restore an object to its previous state.
                -Observer. Is a publish/subscribe pattern which allows a number of observer objects to see
                 an event.
                -State. Allows an object to alter its behavior when its internal state changes.
                -Strategy. Allows one of a family of algorithms to be selected on-the-fly at run-time.
                -Template Method. Defines the skeleton of an algorithm as an abstract class, allowing its
                sub-classes to provide concrete behavior.
                -Visitor. Separates an algorithm from an object structure by moving the hierarchy of methods
                into one object.
         */
        /*
        1. Abstract Factory Design Pattern:

         */
    }
}
