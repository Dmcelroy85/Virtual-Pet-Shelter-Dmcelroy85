package Virtual_Pet_Shelter;
import java.util.Scanner;
public class VirtualPetApp {
    public static void main(String[] args) {
    VirtualPetShelter petShelter = new VirtualPetShelter();
    Scanner input = new Scanner(System.in);
//The Welcome
    System.out.println("Welcome to Scornakira's Menagerie of Misfit Pets!");
    System.out.println("Let's begin by securing our first rescue!");
    System.out.println("What is the pet's name?");
    String petName = input.nextLine().trim(); //Trim added to remove spaces from input, avoids issues later in calling names for play and adoption
    System.out.println("What kind of pet is " + petName + ".");
    String petDescription = input.nextLine();
//Here, I give the player the opportunity to tell me the pets custom stats. Because Sometimes, Karen just KNOWS how fluffy is feeling
//This idea brought to you by my 'caring and concerned girlfriend of the pets being abandoned'
//Hunger, thirst, and bored are given ratings of 1-10, and only accepted if given a valid value in that range
    System.out.println(
        "Having taken care of " + petName + ", would you like to tell me how \nHungry, Thirsty, or Bored " + petName + " is?  (y/n)");
    String entryChoice = input.nextLine();
    boolean validHunger = false;
    int hungerEntry = 0;
    int thirstEntry = 0;
    int boredomEntry = 0;
    if (entryChoice.equalsIgnoreCase("y")) {
        while (!validHunger) {
            System.out
                .println("Since you last fed " + petName + " how hungry do you feel they are,\n on a scale of 1-10, with 10 being extremely hungry.");
        hungerEntry = input.nextInt();
            if (hungerEntry >= 1 && hungerEntry <= 10) {
            validHunger = true;
            } else {
                System.out.println("Please enter a valid number");
            }
        }
    boolean validThirst = false;
    while (!validThirst) {
        System.out
            .println("Since you last hydrated " + petName + " how thirsty do you feel they are,\n on a scale of 1-10, with 10 being extremely thirsty.");
    thirstEntry = input.nextInt();
        if (thirstEntry >= 1 && thirstEntry <= 10) {
            validThirst = true;
        } else {
            System.out.println("Please enter a valid number");
        }
    }
    boolean validBoredom = false;
    while (!validBoredom) {
        System.out
            .println("Since you last played with " + petName + " how bored do you feel they are,\n on a scale of 1-10, with 10 being extremely bored.");
        boredomEntry = input.nextInt();
            if (boredomEntry >= 1 && boredomEntry <= 10) {
                validBoredom = true;
            } else {
            System.out.println("Please enter a valid number");
        }
    }
    input.nextLine();
//Pets are now created. If 'Y' was chosen, pet is created with custom stats.
//If 'N' was chosen, pet is created with base stats defined in VirtualPet.Java Hunger=3, Thirst=2, Boredom=1
    VirtualPetShelter.put(petName, new VirtualPet(petName, petDescription, hungerEntry, thirstEntry, boredomEntry));
    } else if (entryChoice.equalsIgnoreCase("n")) {
        VirtualPetShelter.put(petName, new VirtualPet(petName, petDescription));
    }
//The Menu choice, their printouts, actions, and comments when selected
    String menuChoice = "0";
    while (!menuChoice.equals("6")) {
        System.out.println(petShelter.shelterStatus());
        System.out.println(petShelter.suggestion());
        System.out.println(generalMenu());
        menuChoice = input.nextLine();
        if (menuChoice.equals("1")) {
            petShelter.feedAllPets();
            System.out.println("Great job feeding all of the pets!");
        } else if (menuChoice.equals("2")) {
            petShelter.waterAllPets();
            System.out.println("Thank you for keeping the pets Hydrated");
        } else if (menuChoice.equals("3")) {
            System.out.println("These are the current pets in the Shelter\n");
            System.out.println(petShelter.petList());
            System.out.println("Which pet would you like to play with?\n Pet names are case sensitive");
            String petChoice = input.nextLine();
            while (!petShelter.nameCheck(petChoice)) {
                System.out.println("Please enter a valid pet");
                petChoice = input.nextLine();
            }
            petShelter.playWith(petChoice);                System.out.println(petChoice + " had so much fun!");
        } else if (menuChoice.equalsIgnoreCase("4")) {    //Like above, when adopting a new pet, will give the user the choice to bring in custom stats
            System.out.println("What is the pet's name?");
            petName = input.nextLine().trim();                while (petShelter.nameCheck(petName)) {   //Only unique names in my menagerie!! make the user change name before dropping off
                System.out.println("We already have a pet on site by that name,\n please choose another name for your pet");
                petName = input.nextLine().trim();
            }
            System.out.println("what kind of pet is " + petName + ".");
            petDescription = input.nextLine();
            System.out.println("Would you like to tell us " + petName + "'s recent conditions,\n like hunger, thirst, or boredom? (y/n)");
            entryChoice = input.nextLine();
            validHunger = false;
            hungerEntry = 0;
            thirstEntry = 0;
            boredomEntry = 0;
            if (entryChoice.equalsIgnoreCase("y")) {
                while (!validHunger) {
                    System.out.println(    //Custom Hunger for drop off
                            "Please enter the hunger level, on a scale of 1-10, with 10 being extremely hungry.");
                    hungerEntry = input.nextInt();
                    if (hungerEntry >= 1 && hungerEntry <= 10) {
                        validHunger = true;
                    } else {
                        System.out.println("Please enter a valid number");
                    }
                }
                boolean validThirst = false;
                while (!validThirst) {
                    System.out.println(   //Custom Thirst for drop off
                            "Please enter the thirst level, on a scale of 1-10, with 10 being extremely thirsty.");
                    thirstEntry = input.nextInt();
                    if (thirstEntry >= 1 && thirstEntry <= 10) {
                        validThirst = true;
                    } else {
                        System.out.println("Please enter a valid number");
                    }
                }
                boolean validBoredom = false;
                while (!validBoredom) {
                    System.out.println(    //Custom Boredom for drop off
                            "Please enter the boredom level, on a scale of 1-10, with 10 being extremely bored.");
                    boredomEntry = input.nextInt();
                    if (boredomEntry >= 1 && boredomEntry <= 10) {
                        validBoredom = true;
                    } else {
                        System.out.println("Please enter a valid number");
                    }
                }
                input.nextLine();
                VirtualPetShelter.put(petName,     //New Pet Adopted, and added to shelter... er.. menagerie!!
                    new VirtualPet(petName, petDescription, hungerEntry, thirstEntry, boredomEntry));
            } else if (entryChoice.equalsIgnoreCase("n")) {
                VirtualPetShelter.put(petName, new VirtualPet(petName, petDescription));
            }
        } else if (menuChoice.equalsIgnoreCase("5")) {   //Get list of pets on site to adopt out and give a forever home
            System.out.println("These are the current misfits in the menagerie\n");
            System.out.println(petShelter.petList());
            System.out.println("Which pet has found a forever home?");
            String petChoice = input.nextLine();   //can't figure out how to make this not care about case sensitive, in addition of name check
            while (!petShelter.nameCheck(petChoice)) {
                System.out.println(
                    "There is currently no pet by that name in the menagerie. Please enter a valid name, Case sensitive.");
                petChoice = input.nextLine().trim();
            }
            petShelter.adoptPet(petChoice);
            System.out.println(petChoice + " has found a forever home!\n" + petShelter.adoptedPets.values().size()
                + " pets have found a new home thanks to your care and support!");
        } else if (!menuChoice.equals("6")) {
            System.out.println("That is not a valid menu option.");
        }
        petShelter.tick();
    }
    System.out.println("Thank's for your help today at Scornakira's Menagerie of Misfit Pets!\n" + petShelter.adoptedPets.values().size() + 
        " pets have found forever homes! See you Next time!");
    System.exit(0);
//HAH!!! close thou inputs! So there shall be no memory leaks!!!!
    input.close();
}
//Game Menu
    public static String generalMenu() {
    return "How would you like to help us next?\n" + "1  Feed all the pets\n" + "2  Water all the pets\n"
        + "3  Play with a pet\n" + "4  Admit another pet to the menagerie\n"
        + "5  Adopt a pet out of the menagerie\n" + "6  Exit";
    }
}