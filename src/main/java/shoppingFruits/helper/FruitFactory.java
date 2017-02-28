package shoppingFruits.helper;

import shoppingFruits.exception.FruitException;
import shoppingFruits.model.Fruit;
import shoppingFruits.model.FruitType;

/**
* FruitFactory is responsible for creating Fruit objects like Bananas, Oranges and Apples etc
*/
public abstract class FruitFactory  {

	public abstract Fruit getFruit(FruitType type, int quantity, double unitPrice)
			throws FruitException;
	
	public abstract void resetCounter();
	
}
