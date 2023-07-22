package Virtual_Pet_Shelter;
//Instance Variables
public class VirtualPet {
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;
//Getters
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getHunger() {
		return hunger;
	}
	public int getThirst() {
		return thirst;
	}
	public int getBoredom() {
		return boredom;
	}
// Constructors to accept Name and Description, aka, to admit a new pet to the shelter
	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = 3;
		this.thirst = 2;
		this.boredom = 1;
	}
//Ticks to increase/decrease stats
	public void feed() {
		hunger -= 5;
		thirst += 1;
	}
	public void water() {
		thirst -= 5;
	}
	public void play() {
		boredom -= 7;
		thirst += 1;
	}
	public void hungrier() {
		hunger += 1;
	}
	public void thirstier() {
		thirst += 1;
	}
	public void bored() {
		boredom += 1;
	}
}