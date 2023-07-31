package classesObjects;

public class Pet {
	
	// Variables (with a little bonus, because any program should allow you to give pets).
	private String name;
	private int age;
	private String location;
	private String type;
	private boolean hasBeenPetted = false;
	
	
	// Constructors: empty, and all attributes. I made age an int (years) for simplicity.
	public Pet() {
		this.name = "Laika";
		this.age = 12;
		this.location = "kitchen";
		this.type = "dog";
	}
	
	public Pet(String name, int age, String location, String type) {
		this.name = name;
		this.age = age;
		this.location = location;
		this.type = type;
	}
	
	// Getter methods. didGetPets() prints directly to the console, so it has a return type of void.
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void didGetPets() {
		if (!hasBeenPetted) {
			System.out.printf("%s needs pets!\n", this.name);
		} else {
			System.out.printf("You could always give %s more pets...\n", this.name);
		}
		return;
	}
	
	// Setter methods. Yes, hasBeenPetted remains true and there's no way to make it false again.
	// Pets remember forever once you've petted them in this program, heh.
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public void setLocation(String newLoc) {
		this.location = newLoc;
	}
	
	public void givePets() {
		System.out.printf("Who's a good %s?\n", this.type);
		this.hasBeenPetted = true;
	}
	
	// Testing code. Cheating a little bit and using this.location in lieu of a getter method because everything's in the same class, but the getter and setter methods work!
	public static void main(String[] args) {
		Pet pet1 = new Pet();
		Pet pet2 = new Pet("Choptop", 0, "vet's office", "cat");
		
		System.out.printf("%s is a %s! She's %d year(s) old and she's in the %s right now.\n", pet1.getName(), pet1.getType(), pet1.getAge(), pet1.location);
		System.out.printf("%s is a %s! They're %d year(s) old. They're at the %s for a checkup.\n", pet2.getName(), pet2.getType(), pet2.getAge(), pet2.location);
		
		pet2.setName("Sawyer");
		pet2.setAge(1);
		pet2.setLocation("home");
		
		System.out.printf("\n%s is %s now. We have a surprise for her!\n", pet2.getName(), pet2.location);
		System.out.printf("Happy birthday, %s! You're %d!\n\n", pet2.getName(), pet2.getAge());
		pet2.didGetPets();
		pet2.givePets();
		System.out.printf("You too, %s, come here!\n", pet1.getName());
		pet1.givePets();
		
		System.out.println("\nThere we go. Now everyone's been petted.");
		pet2.didGetPets();
		pet1.didGetPets();
	}
}
