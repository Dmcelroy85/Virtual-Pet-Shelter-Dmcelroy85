package Virtual_Pet_Shelter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class VirtualPetShelter {
    
    static Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
    Map<String, VirtualPet> adoptedPets = new HashMap<String, VirtualPet>();
    private int dupeCount = 1;
    // returns all the VirtualPets
    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }
    // returns all the adopted pets
    public Collection<VirtualPet> getAllAdpotedPets() {
        return adoptedPets.values();
    }
//Adopting a pet removes it from the game
    public void adoptPet(String name) {
        if (adoptedPets.containsKey(name)) {
            name = name + dupeCount;
            dupeCount++;
        }
        adoptedPets.put(name, pets.get(name));
        removePet(name);
    }
    public void removePet(String name) {
        pets.remove(name);
    }
//Taking Care of your Pet 101
//Not Really "How to Raise A Dragon" per say, but all the work to make the little fellas work
    public void feedAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.feed();
        }
    }
    public int getHungerLevel(String name) {
        int hungerLevel = pets.get(name).getHunger();
        return hungerLevel;
    }
    public String getDescription(String name) {
        return (pets.get(name).getDescription());
    }
    public static void put(String name, VirtualPet VPet) {
        pets.put(name, VPet);
    }
    public void waterAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.water();
        }
    }
    public int getThirstLevel(String name) {
        int thirstLevel = pets.get(name).getThirst();
        return thirstLevel;
    }
    public void playWith(String name) {
        pets.get(name).play();
    }
    public int getBoredomLevel(String name) {
        int boredomLevel = pets.get(name).getBoredom();
        return boredomLevel;
    }
    public void tick() {
        increaseHunger();
        increaseThirst();
        increaseBoredom();
    }
    private void increaseThirst() {
        for (VirtualPet pet : pets.values()) {
            pet.thirstier();
        }
    }
    private void increaseBoredom() {
        for (VirtualPet pet : pets.values()) {
            pet.bored();
        }
    }
    private void increaseHunger() {
        for (VirtualPet pet : pets.values()) {
            pet.hungrier();
        }
    }
    public boolean nameCheck(String name) {
        return pets.containsKey(name);
    }
//An awesome way I found to display levels of needs via a visual, rather than numbers. ASCII FTW!
    public String shelterStatus() {
        String status = "\n\t\t\s\s\s\s\s Scornakira's Misfit Pets\n\n\t\t\tMisfit's Condition\n" + "\t\tHunger\t\tThirst\t\tBoredom\n";
        for (VirtualPet pet : pets.values()) {
            String name = pet.getName();
            status += "\n" + name + "\t\t " + showLevel(getHungerLevel(name)) + "\t" + showLevel(getThirstLevel(name))
                    + "\t" + showLevel(getBoredomLevel(name));
        }
        return status;
    }
//the code the space out the | and the . for the visual display
    public String showLevel(int quality) {
        String level = "";
        for (int i = 0; i < quality; i++) {
            level = level + "|";
        }
        for (int i = 0; i < 10 - quality; i++) {
            level = level + ".";
        }
        return level;
    }
//Warning to the player, should care levels begin to get to high
    public String suggestion() {
        String suggestion = "";
        int hungerMax = 0;
        for (VirtualPet pet : pets.values()) {
            if (pet.getHunger() > hungerMax) {
                hungerMax = pet.getHunger();
            }
        }
        int thirstMax = 0;
        for (VirtualPet pet : pets.values()) {
            if (pet.getThirst() > thirstMax) {
                thirstMax = pet.getThirst();
            }
        }
        int boredomMax = 0;
        String boredestPet = "";
        for (VirtualPet pet : pets.values()) {
            if (pet.getBoredom() > boredomMax) {
                boredomMax = pet.getBoredom();
                boredestPet = pet.getName();
            }
        }
        if (hungerMax >= 8) {
            suggestion += "One of your pets is crying loudly, perhaps you should feed them all";
        }
        if (thirstMax >= 8) {
            suggestion += "\nOh no! One of your pets is extremely thirsty! Don't forget to keep all your pets Hydrated.";
        }
        if (boredomMax >= 8) {
            suggestion += "\n" + boredestPet + " looks very bored. You should play with them";
        }
        return suggestion;
    }
    public String petList() {
        String list = "";
        for (VirtualPet pet : pets.values()) {
            list += (pet.getName() + "\t\t" + pet.getDescription() + "\n");
        }
        return list;
    }
}