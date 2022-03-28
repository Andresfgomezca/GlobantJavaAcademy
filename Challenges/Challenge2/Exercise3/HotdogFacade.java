package Exercise3;

import Exercise3.HotDog.Ingredients.*;
import Exercise3.HotDog.HotDog;
import Exercise3.HotDog.HotDogBase;
import Exercise3.HotDog.RemoveLast;
import Exercise3.HotDog.Toppings.*;

import java.util.Scanner;

public class HotdogFacade {
    public void exerciseExecution(){
        int END = 0;//this variable will control the end of the program
        int temporalVariable = 0; //This variable will assist with the logic of the app
        HotDogBase base = null; //A hot dog initialize
        while (END == 0) {
            printMenu();
            temporalVariable = NextStep();
            switch (temporalVariable) {
                case 1 -> {
                    System.out.println("""
                            Your hot dog is now created!
                            """);
                    base = new HotDogBase("HotDog", "0");
                    base.printHotdogInfo();
                }
                case 2 -> {
                    try {
                        base.printHotdogInfo();
                    }catch (Exception e) {
                        System.out.println("The dog is not created yet.");
                        System.out.println("A new Hot-Dog is now created");
                        base = new HotDogBase("HotDog", "0");
                    }
                }
                case 3 -> { //this case will show the options to add a new ingredient to the hotdog
                    try {
                        base.getIngredient();
                    }catch (Exception e) {
                        System.out.println("The dog is not created yet.");
                        System.out.println("A new Hot-Dog is now created");
                        base = new HotDogBase("HotDog", "0");
                    }
                    ingredientMenu();
                    temporalVariable=NextStep();
                    switch (temporalVariable) {
                            case 1 -> {
                                HotDog withCheese = new Cheese(base);
                                withCheese.addIngredientUpdate();
                            }
                            case 2 -> {
                                HotDog withBacon = new Bacon(base);
                                withBacon.addIngredientUpdate();

                            }
                            case 3 -> {
                                HotDog withChicken = new Chicken(base);
                                withChicken.addIngredientUpdate();

                            }
                            case 4 -> {
                                HotDog withSweetCorn = new SweetCorn(base);
                                withSweetCorn.addIngredientUpdate();
                            }
                            case 5 -> {
                                HotDog withGroundBeef = new GroundBeef(base);
                                withGroundBeef.addIngredientUpdate();
                            }
                            case 6 -> {
                                HotDog withLetucce = new Lettuce(base);
                                withLetucce.addIngredientUpdate();
                            }
                            case 7 -> {
                                HotDog withMexicanBeans = new MexicanBeans(base);
                                withMexicanBeans.addIngredientUpdate();
                            }
                            case 8 -> {
                                HotDog withAvocado = new Avocado(base);
                                withAvocado.addIngredientUpdate();
                            }
                            case 9 -> {
                                System.out.println("Ingredients were not added to the Hot-Dog");
                            }
                            default -> {
                                System.out.println("Invalid input, back to the previous menu");
                            }
                        }
                    }
                case 4 -> {//this case will show the options to add a new topping to the hotdog
                    toppingMenu();
                    temporalVariable=NextStep();
                    switch (temporalVariable) {
                        case 1 -> {
                            HotDog withKetchup = new Ketchup(base);
                            withKetchup.addIngredientUpdate();
                        }
                        case 2 -> {
                            HotDog withMayo = new Mayo(base);
                            withMayo.addIngredientUpdate();

                        }
                        case 3 -> {
                            HotDog withMustard = new Mustard(base);
                            withMustard.addIngredientUpdate();

                        }
                        case 4 -> {
                            HotDog withSauerkraut = new Sauerkraut(base);
                            withSauerkraut.addIngredientUpdate();
                        }
                        case 5 -> {
                            HotDog withPickles = new Pickles(base);
                            withPickles.addIngredientUpdate();
                        }
                        case 6 -> {
                            HotDog withChipSticks = new ChipStricks(base);
                            withChipSticks.addIngredientUpdate();
                        }
                        case 7 -> {
                            HotDog withChoppedOnion = new ChoppedOnion(base);
                            withChoppedOnion.addIngredientUpdate();
                        }
                        case 8 -> {
                            HotDog withChoppedTomato = new ChoppedTomato(base);
                            withChoppedTomato.addIngredientUpdate();
                        }
                        case 9 -> {
                            System.out.println("Ingredients were not added to the Hot-Dog");
                        }
                        default -> {
                            System.out.println("Invalid input, back to the previous menu");
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Submit the desired name for your Hot-Dog");
                    String temporalNameForTheHotDog=NextStepString();
                    base.setName(temporalNameForTheHotDog);
                    System.out.println("The name of your Hot-Dog Will be: "+temporalNameForTheHotDog);
                }
                case 6 -> {
                    HotDog remove = new RemoveLast(base);
                    remove.addIngredientUpdate();
                }
                case 7 -> {
                    System.out.println("""
                            
                            Thank you for testing my Exercise 3
                            """);

                    END++;
                }
                default -> {
                    System.out.println("Your input was invalid");
                }
            }
        }
    }
    public void printMenu () {
        System.out.println("""
                    
                    Monster HOT-DOGS
                    
                    Menu
                                        
                    1. Create your hot dog
                    2. See current hot dog
                    3. add an ingredient
                    4. add a topping or a sauce
                    5. Name your Hot-Dog
                    6. Remove last ingredient or topping
                    7. Close
                                                                                    
                    """);
    }
    public void toppingMenu () {
        System.out.println("""
                    
                    Monster HOT-DOGS
                    
                    Topping Menu
                    
                    Select 1 of the toppings                    
                    1. Ketchup
                    2. Mayo
                    3. Mustard
                    4. Sauerkraut
                    5. Pickles
                    6. Chip Sticks 
                    7. Chopped Onion
                    8. Chopped Tomato
                    9. back
                                                                                                                          
                    """);
    }
    public void ingredientMenu () {
        System.out.println("""
                    
                    Monster HOT-DOGS
                    
                    Ingredients Menu
                    
                    Select 1 of the ingredients     
                                   
                    1. Cheese
                    2. Bacon
                    3. Chicken
                    4. Sweet Corn
                    5. Ground beef
                    6. Lettuce
                    7. Mexican beans
                    8. Avocado
                    9. back
                                                                                                                          
                    """);
    }

    public static int NextStep () {
        //this process will stop the terminal until a new process is created
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    public static String NextStepString () {
        //this process will stop the terminal until a new process is created
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
