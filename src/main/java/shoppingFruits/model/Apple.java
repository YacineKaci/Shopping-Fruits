package shoppingFruits.model;

import shoppingFruits.helper.FruitHelper;

public class Apple implements Fruit {

	private int quantity;
	private double unitPrice;
	
	public Apple(int quantity, double unitPrice) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public double getPrice() {
		return FruitHelper.calculate(this.quantity, this.unitPrice);
	}

	@Override
	public String toString() {
		return "Apple [quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
