package shoppingFruits.model;

import shoppingFruits.helper.FruitHelper;

public class Banana implements Fruit {

	private int quantity;
	private double unitPrice;
	
	public Banana(int quantity, double unitPrice) {
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
		return "Banana [quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
