package classesObjects;

import java.text.DecimalFormat;

public class MenuItem {
		
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private String item;
	private double price;
	private int calories;
	private boolean seasonal;
	
	public MenuItem() {
		this.item = "cheeseburger";
		this.price = 2.79;
		this.calories = 300;
		this.seasonal = false;
	}
	
	public MenuItem(String item, double price, int calories) {
		this.item = item;
		this.price = price;
		this.calories = calories;
		this.seasonal = false;
	}
	
	public MenuItem(String item, double price, int calories, boolean seasonal) {
		this.item = item;
		this.price = price;
		this.calories = calories;
		this.seasonal = seasonal;
	}
	
	// Getter methods
	public String getItem() {
		return this.item;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getCalories() {
		return this.calories;
	}
	
	public boolean isSeasonal() {
		return this.seasonal;
	}
	
	// Setter methods
	public void setItem(String item) {
		this.item = item;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public void setSeasonal() {
		this.seasonal = !this.seasonal;
	}
	
	// Miscellaneous methods!
	public boolean isCustomizable() {
		// In this program, customizable items have a lower base price to compensate for add-ons.
		// Not that there's a method for including add-ons just yet...
		if (this.seasonal || this.price > 5) {
			return false;
		} else {
			return true;
		}
	}
	
	public String customRequest() {
		if (this.isCustomizable()) {
			return "Yeah, we can modify that!";
		} else {
			return "Sorry, we can't make changes to that item.";
		}
	}
	
	public static void main(String[] args) {
		MenuItem burger = new MenuItem();
		MenuItem bubbleTea = new MenuItem("milk tea", 5.25, 200);
		MenuItem doleWhip = new MenuItem("Soft Serve - Pineapple", 4.00, 110, true);
		
		System.out.println("Helen: Oh, hey Michael! Welcome to my diner!");
		System.out.printf("We have a %s, %s, and our special %s today.\n", burger.getItem(), bubbleTea.getItem(), doleWhip.getItem());
		System.out.println("What would you like?\n");
		
		System.out.printf("Michael: Hmmm, $%s for %s? Sounds a bit expensive...\n", df.format(bubbleTea.getPrice()), bubbleTea.getItem());
		System.out.printf("%d calories isn't too bad, though.\n", bubbleTea.getCalories());
		System.out.println("Wait, is the ice cream seasonal?\n");
		
		if (doleWhip.isSeasonal()) {
			System.out.println("Helen: Yeah, it won't stick around for long.");
		} else {
			System.out.println("Helen: Actually, no! I'm glad. People really like it.");
		}
		
		System.out.printf("Wait... $%s... %d calories? That's not right!\n", df.format(burger.getPrice()), burger.getCalories());
		System.out.println("Sorry, Michael. I haven't updated the menu in a bit, gimme a sec.");
		burger.setItem("hamburger");
		burger.setPrice(2.59);
		burger.setCalories(250);
		System.out.printf("We ran out of cheese, so it's a %d-calorie, $%s %s now.\n\n", burger.getCalories(), df.format(burger.getPrice()), burger.getItem());
		
		System.out.println("Michael: ... huh.");
		System.out.println("Don't suppose the ice cream's permanent, then.");
		System.out.println("I was gonna ask for some of the bubble tea bubbles on top, too.\n");
		
		System.out.printf("Helen: %s\n", doleWhip.customRequest());
		System.out.println("... wait.");
		System.out.println("It's already September, isn't it.\n");
		
		System.out.println("Michael: Yup.\n");
		
		System.out.println("Helen: Lemme just...");
		doleWhip.setSeasonal();
		System.out.printf("Okay! %s\n", doleWhip.customRequest());
		
	}
	
}
