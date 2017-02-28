package shoppingFruits.model;

import shoppingFruits.helper.FruitHelper;

public class Peache implements Fruit {

	private int quantity;
	private double unitPrice;
	
	public Peache(int quantity, double unitPrice) {
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
		return "Peache [quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	

}
