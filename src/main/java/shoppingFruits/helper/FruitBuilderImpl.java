package shoppingFruits.helper;

import java.util.ArrayList;
import java.util.List;

import shoppingFruits.exception.FruitException;
import shoppingFruits.model.Fruit;
import shoppingFruits.model.FruitType;

public class FruitBuilderImpl implements FruitBuilder {
	private FruitFactoryType factoryType;
	private List<Fruit> listFruits = null;
	
	private void addFruit(Fruit fruit) {
		if (listFruits == null) {
			listFruits = new ArrayList<Fruit>(25);
		}
		listFruits.add(fruit);
	}
	/**
	 * Set the Factory type
	 */
	public void setFactoryType(FruitFactoryType factoryType){
		this.factoryType = factoryType;
	}
	/**
	* builds a fruits basket
	*/
	@Override
	public void buildBasket(FruitType fruitType, int quantity, double unitPrice) throws FruitException {
		//get the single instance of FruitFactory using the singleton pattern
		FruitFactory factory = FruitAbstractFactory.getInstance().getFruitFactory(factoryType);
		//use factory method pattern to create fruit objects, based on fruitType supplied to it.
		Fruit fruit = factory.getFruit(fruitType, quantity, unitPrice);
		this.addFruit(fruit); //adds the item to the basket
	}

	/**
	* get the total price on the fruits in the built basket
	*/
	@Override
	public double getTotalePrice() throws FruitException {
		if (listFruits == null) {
			throw new FruitException("No fruits in the basket");
		}
		
		double totalPrice = 0.0;
		
		for (Fruit fruit : listFruits) {
			totalPrice += fruit.getPrice();
		}
		
		return totalPrice;
	}

	@Override
	public void clearBasket() throws FruitException {
		if(listFruits != null){
			// clear the fruits basket
			listFruits.clear();
			// reset the counter to 0 for the cached fruit factory
			FruitFactory factory = FruitAbstractFactory.getInstance().getFruitFactory(factoryType);
			factory.resetCounter();
			
		}

	}

}
