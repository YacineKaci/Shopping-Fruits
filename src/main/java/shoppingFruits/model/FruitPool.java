package shoppingFruits.model;

import java.util.ArrayList;
import java.util.List;
import static shoppingFruits.config.FruitConfig.FRUIT_POOL_SIZE;;


public class FruitPool {
	private FruitType fruitPoolType;
	private List<Fruit> pool = null;
	private int counter = -1;
	
	public FruitPool(FruitType fruitPoolType) {
		this.fruitPoolType = fruitPoolType;
		pool = new ArrayList<Fruit>(FRUIT_POOL_SIZE);
	}
	
	public Fruit getFruitFromPool(){
		Fruit fruit = null;
		if(counter != -1){
			pool.get(counter);
			counter--;
		}
		return fruit;
	}
	
	public void addFruitToPool(Fruit fruit){
		counter++;
		pool.add(counter, fruit);
	}
	
	public void resetCounter(){
		counter = -1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fruitPoolType == null) ? 0 : fruitPoolType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FruitPool))
			return false;
		FruitPool other = (FruitPool) obj;
		if (fruitPoolType != other.fruitPoolType)
			return false;
		return true;
	}
	
	

}
