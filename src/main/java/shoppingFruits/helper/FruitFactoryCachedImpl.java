package shoppingFruits.helper;

import java.util.HashMap;
import java.util.Map;

import shoppingFruits.exception.FruitException;
import shoppingFruits.model.Apple;
import shoppingFruits.model.Banana;
import shoppingFruits.model.Fruit;
import shoppingFruits.model.FruitPool;
import shoppingFruits.model.FruitType;
import shoppingFruits.model.Lemon;
import shoppingFruits.model.Orange;
import shoppingFruits.model.Peache;

import static shoppingFruits.config.FruitConfig.CACHED_FRUITS_MAP_SIZE;


/**
 * CachedFruitFactoryImpl which caches Fruits if we need to improve memory usage
 * I used a flyweight pattern
 */
public class FruitFactoryCachedImpl extends FruitFactory {
	private Map<FruitType, FruitPool> cachedFruits;
	
	private FruitFactoryCachedImpl(){
		cachedFruits = new HashMap<FruitType, FruitPool>(CACHED_FRUITS_MAP_SIZE);
	}
    
	public static FruitFactory getInstance(){
        return SingletonHelper.INSTANCE;
        
    }
	private static class SingletonHelper{
        private static final FruitFactory INSTANCE = new FruitFactoryCachedImpl();
    }
	
	@Override
	public Fruit getFruit(FruitType type, int quantity, double unitPrice) throws FruitException {
		Fruit instance;
		FruitPool pool = cachedFruits.get(type);
		if(pool == null){
			pool = new FruitPool(type);
			cachedFruits.put(type, pool);
		}
		// get an instance of fruit object from the pool
		instance = pool.getFruitFromPool();
		
		if(instance == null){// we create a new fruit
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
			// we add the new fruit to the pool
			pool.addFruitToPool(instance);
		
		}else{// otherwise we update the fruit's data
			instance.setQuantity(quantity);
			instance.setUnitPrice(unitPrice);
		}
	
	return instance;

	}
	
	/*
	 * 
	 */
	@Override
	public void resetCounter() {
		for (FruitPool pool : cachedFruits.values()) {
			pool.resetCounter();
		}
		
		
	}

}
