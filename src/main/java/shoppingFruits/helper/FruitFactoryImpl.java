package shoppingFruits.helper;

import shoppingFruits.exception.FruitException;
import shoppingFruits.model.Apple;
import shoppingFruits.model.Banana;
import shoppingFruits.model.Fruit;
import shoppingFruits.model.FruitType;
import shoppingFruits.model.Lemon;
import shoppingFruits.model.Orange;
import shoppingFruits.model.Peache;

/** 
 * I use a Bill Pugh Singleton Implementation
 */

public class FruitFactoryImpl extends FruitFactory {

	private FruitFactoryImpl(){
	}
    
	public static FruitFactory getInstance(){
        return SingletonHelper.INSTANCE;
    }
	private static class SingletonHelper{
        private static final FruitFactory INSTANCE = new FruitFactoryImpl();
    }
	
	@Override
	public Fruit getFruit(FruitType type, int quantity, double unitPrice) throws FruitException {
		Fruit instance;
		
		switch (type) {
	        case BANANA:
	        	instance = new Banana(quantity, unitPrice);
	            break;
	                
	        case ORANGE:
	        	instance = new Orange(quantity, unitPrice);
	            break;
	            
	        case APPLE:
	        	instance = new Apple(quantity, unitPrice);
	        	break;
	        	
	        case LEMON:
	        	instance = new Lemon(quantity, unitPrice);
	        	break;
	        	
	        case PEACHE:
	        	instance = new Peache(quantity, unitPrice);
	        	break;
	                                    
	        default:
	            throw new FruitException("This fruit is not emplemented yet");
		}
	
	return instance;

	}
	
	public void resetCounter(){
		//nothing to do cause we don't manage cach here
	}

}
