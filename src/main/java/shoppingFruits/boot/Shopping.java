package shoppingFruits.boot;

import shoppingFruits.helper.FruitBuilder;
import shoppingFruits.helper.FruitBuilderImpl;
import shoppingFruits.helper.FruitFactoryType;
import shoppingFruits.model.FruitType;

public class Shopping {

	public static void main(String[] args) throws Exception {
		process();
	}
	
	public static void process() throws Exception {
		// creational patterns: singleton, abstract factory, factory method and builder design patterns
		// structural pattern : Flyweight
		System.out.println("---- Create a shopping basket with fruits ---");
		System.out.println("---- BASIC Fruit Factory ---");
		//Shopping basket using the builder pattern
		FruitBuilder builder = new FruitBuilderImpl();
		// let's use a basic fruit factory
		builder.setFactoryType(FruitFactoryType.BASIC);
		// build basket of fruits using a builder pattern
		builder.buildBasket(FruitType.BANANA, 2, 0.20);
		builder.buildBasket(FruitType.APPLE, 1, 0.30);
		builder.buildBasket(FruitType.ORANGE, 1, 0.40);
		// let’s print the total price of this built basket
		double totalPrice = builder.getTotalePrice();
		System.out.println("Total Price: " + totalPrice);
		//let's add a new fruit to the built basket
		builder.buildBasket(FruitType.PEACHE, 1, 0.90);
		System.out.println("----- After adding a peache fruit to the basket ----");	
		//print the new total price
		totalPrice = builder.getTotalePrice();
		System.out.println("Total Price: " + totalPrice);
		// clear the basket
		builder.clearBasket();
		
		System.out.println("---- Create a new shopping basket with fruits ---");
		System.out.println("---- CACHED Fruit Factory ---");
		// let's us a cached fruit factory
		builder.setFactoryType(FruitFactoryType.CACHED);
		// use the same case as above
		// build basket of same fruits but different prices
		builder.buildBasket(FruitType.BANANA, 2, 0.20);
		builder.buildBasket(FruitType.APPLE, 1, 0.30);
		builder.buildBasket(FruitType.ORANGE, 1, 0.40);
		// let’s print the total price of this built basket
		totalPrice = builder.getTotalePrice();
		System.out.println("Total Price: " + totalPrice);
		//let's add a new fruit to the built basket
		builder.buildBasket(FruitType.PEACHE, 1, 0.90);
		System.out.println("----- After adding a peache fruit to the basket ----");	
		//print the new total price
		totalPrice = builder.getTotalePrice();
		System.out.println("Total Price: " + totalPrice);
		// clear the basket
		builder.clearBasket();
		// here the cached fruits enter the game
		// build basket of fruits using a builder pattern
		builder.buildBasket(FruitType.BANANA, 2, 0.25);
		builder.buildBasket(FruitType.APPLE, 1, 0.35);
		builder.buildBasket(FruitType.ORANGE, 1, 0.45);
		// let’s print the total price of this built basket
		totalPrice = builder.getTotalePrice();
		System.out.println("Total Price: " + totalPrice);
		//let's add a new fruit to the built basket
		builder.buildBasket(FruitType.PEACHE, 1, 0.85);
		System.out.println("----- After adding a peache fruit to the basket ----");
		//print the new total price
		totalPrice = builder.getTotalePrice();
		System.out.println("Total Price: " + totalPrice);
		
	}

}
