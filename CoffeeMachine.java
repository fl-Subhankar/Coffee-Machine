//package com.subhankar;
package machine;

import java.util.Scanner;

public class CoffeeMachine {

	// Methods : printStats(water, milk, coffee, cups, money);
	public static void printStats(int water, int milk, int coffee, int cups, int money) {
		System.out.println("The coffee machine has:\n" + water + " of water\n" + milk + " of milk\n" + coffee
				+ " of coffee beans\n" + cups + " of disposable cups\n" + "$" + money + " of money\n");
	}

	// Method : haveResource();
	public static void haveResource() {
		System.out.println("I have enough resources, making you a coffee!");
	}

	// Methods : noWater();
	public static void noWater() {
		System.out.println("Sorry, not enough water!");
	}

	// Methods : noMilk();
	public static void noMilk() {
		System.out.println("Sorry, not enough milk!");
	}

	// Methods : noCoffee();
	public static void noCoffee() {
		System.out.println("Sorry, not enough water!");
	}

	// Methods : noCups();
	public static void noCups() {
		System.out.println("Sorry, not enough cups!");
	}

	// Methods : Main ; Starts here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Initialization
		// Stock of materials :
		int water = 400;
		int milk = 540;
		int coffee = 120;
		int cups = 9;
		int money = 550;

		// For Espresso :
		int esWater = 250;
		int esCoffee = 16;
		int esCups = 1;
		int esMoney = 4;

		// For Latte :
		int ltWater = 350;
		int ltMilk = 75;
		int ltCoffee = 20;
		int ltCups = 1;
		int ltMoney = 7;

		// For Cappuccino :
		int cpWater = 200;
		int cpMilk = 100;
		int cpCoffee = 12;
		int cpCups = 1;
		int cpMoney = 6;

		// Boolean :
		boolean exitLoop = false;

		// Print machine statistic :
		// printStats(water, milk, coffee, cups, money);

		// Option Loop :
		while (exitLoop == false) {
			// Option starting bar :
			System.out.println("Write action (buy, fill, take, remaining, exit): ");

			// Option Case :
			switch (sc.next()) {

			case "buy": {
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
				switch (sc.next()) {

				// Option : 1 - Espresso :
				case "1": {
					if (water >= esWater && coffee >= esCoffee && cups >= esCups) {
						water -= esWater;
						coffee -= esCoffee;
						cups -= esCups;
						money += esMoney;
						haveResource();
					} else {
						if (water < esWater) {
							noWater();
						}
						if (coffee < esCoffee) {
							noCoffee();
						}
						if (cups < esCups) {
							noCups();
						}
					}
					break;
				}

				// Option : 2 - latte :
				case "2": {
					if (water >= ltWater && milk >= ltMilk && coffee >= ltCoffee && cups >= ltCups) {
						water -= ltWater;
						milk -= ltMilk;
						coffee -= ltCoffee;
						cups -= ltCups;
						money += ltMoney;
						haveResource();
					} else {
						if (water < ltWater) {
							noWater();
						}
						if (milk < ltMilk) {
							noMilk();
						}
						if (coffee < ltCoffee) {
							noCoffee();
						}
						if (cups < ltCups) {
							noCups();
						}
					}
					break;
				}

				case "3": {
					if (water >= cpWater && milk >= cpMilk && coffee >= cpCoffee && cups >= cpCups) {
						water -= cpWater;
						milk -= cpMilk;
						coffee -= cpCoffee;
						cups -= cpCups;
						money += cpMoney;
						haveResource();
					} else {
						if (water < cpWater) {
							noWater();
						}
						if (milk < cpMilk) {
							noMilk();
						}
						if (coffee < cpCoffee) {
							noCoffee();
						}
						if (cups < cpCups) {
							noCups();
						}
					}
					break;
				}
				
				case "back": {
					break;
				}
			}break;
		}
				

			case "fill": {
				System.out.println("Write how many ml of water do you want to add: ");
				water += sc.nextInt();

				System.out.println("Write how many ml of milk do you want to add: ");
				milk += sc.nextInt();

				System.out.println("Write how many grams of coffee beans do you want to add: ");
				coffee += sc.nextInt();

				System.out.println("Write how many ml of water do you want to add: ");
				cups += sc.nextInt();

			}
				break;

			case "take": {
				System.out.println("I gave you " + money);
				money = 0;
			}
				break;

			case "remaining": {
				printStats(water, milk, coffee, cups, money);
				break;
			}

			case "exit": {
				exitLoop = true;
				break;
			}
			}
		}

		sc.close();
	}
}
