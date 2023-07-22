package Virtual_Pet_Shelter;

public class VirtualPet {
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;

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

	public VPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public VPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = 3;
		this.thirst = 2;
		this.boredom = 1;
	}

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

	public void boreder() {
		boredom += 1;
	}

}