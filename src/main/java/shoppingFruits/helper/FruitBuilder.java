package shoppingFruits.helper;

import shoppingFruits.exception.FruitException;
import shoppingFruits.model.FruitType;

public interface FruitBuilder {
	
	public void buildBasket(FruitType type, int quantity, double unitPrice)
			throws FruitException;
	
	public void setFactoryType(FruitFactoryType factoryType);
	public double getTotalePrice() throws FruitException;
	public void clearBasket() throws FruitException;

}
