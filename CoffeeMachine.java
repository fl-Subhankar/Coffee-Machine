package machine;

import java.util.Scanner;

public class CoffeeMachine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Ingredients stock = new Ingredients(400, 540, 120, 9, 550);
		Ingredients espresso = new Ingredients(250, 0, 16, 1, 4);
		Ingredients latte = new Ingredients(350, 75, 20, 1, 7);
		Ingredients cappuccino = new Ingredients(200, 100, 12, 1, 6);

		boolean exitLoop = false;
		while (exitLoop == false) {
			System.out.println("Write action (buy, fill, take, remaining, exit): ");

			switch (scanner.next()) {
			case "buy": {
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
				switch (scanner.next()) {
				case "1":
					Operation.makeCoffee(stock, espresso);
					break;
				case "2":
					Operation.makeCoffee(stock, latte);
					break;
				case "3":
					Operation.makeCoffee(stock, cappuccino);
					break;
				case "back" :
					break;
				}
				break;
			}
			case "fill":
				Operation.addIngredients(stock);
				break;
			case "take":
				Operation.takeMoney(stock);
				break;
			case "remaining":
				Operation.printStats(stock);
				break;
			case "exit": {
				exitLoop = true;
				break;
			}
			}
		}
		scanner.close();
	}
}

class Ingredients {
	int water;
	int milk;
	int coffee;
	int cups;
	int money;

	public Ingredients(int water, int milk, int coffee, int cups, int money) {
		this.water = water;
		this.milk = milk;
		this.coffee = coffee;
		this.cups = cups;
		this.money = money;
	}

// Getters & Setters:
	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}

class Operation {
	Scanner scanner = new Scanner(System.in);

	public static void makeCoffee(Ingredients stock, Ingredients coffeeType) {

		boolean hasWater = false;
		boolean hasMilk = false;
		boolean hasCoffee = false;
		boolean hasCups = false;

		// Stock Check:
		if (stock.water >= coffeeType.water)
			hasWater = true;
		else
			System.out.println("Sorry, not enough water!");

		if (stock.milk >= coffeeType.milk)
			hasMilk = true;
		else
			System.out.println("Sorry, not enough milk!");

		if (stock.coffee >= coffeeType.coffee)
			hasCoffee = true;
		else
			System.out.println("Sorry, not enough coffee!");

		if (stock.cups >= coffeeType.cups)
			hasCups = true;
		else
			System.out.println("Sorry, not enough cups!");

		// Final:
		if (hasWater && hasMilk && hasCoffee && hasCups) {
			stock.water -= coffeeType.water;
			stock.milk -= coffeeType.milk;
			stock.coffee -= coffeeType.coffee;
			stock.cups -= coffeeType.cups;
			stock.money += coffeeType.money;
			System.out.println("I have enough resources, making you a coffee!");
		}
	}

	@SuppressWarnings("resource")
	public static void addIngredients(Ingredients stock) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Write how many ml of water do you want to add: ");
		stock.water += scanner.nextInt();

		System.out.println("Write how many ml of milk do you want to add: ");
		stock.milk += scanner.nextInt();

		System.out.println("Write how many grams of coffee beans do you want to add: ");
		stock.coffee += scanner.nextInt();

		System.out.println("Write how many numbers of cup do you want to add: ");
		stock.cups += scanner.nextInt();

	}

	public static void printStats(Ingredients stats) {
		System.out.println("The coffee machine has:\n" + stats.getWater() + " of water\n" + stats.getMilk()
				+ " of milk\n" + stats.getCoffee() + " of coffee beans\n" + stats.getCups() + " of disposable cups\n"
				 + stats.getMoney() + " of money\n");
	}

	public static void takeMoney(Ingredients stats) {
		System.out.println("I gave you " + stats.getMoney());
		stats.setMoney(0);
	}
}
