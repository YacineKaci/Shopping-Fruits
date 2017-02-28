package shoppingFruits.helper;

import shoppingFruits.exception.FruitException;

/** 
 * I use a Bill Pugh Singleton Implementation
 */
public class FruitAbstractFactory {
	
	private FruitAbstractFactory(){
	}
    
    public static FruitAbstractFactory getInstance(){
        return SingletonHelper.INSTANCE;
    }
	private static class SingletonHelper{
        private static final FruitAbstractFactory INSTANCE = new FruitAbstractFactory();
    }
	
	public FruitFactory getFruitFactory(FruitFactoryType type) throws FruitException{
		FruitFactory instance;
		switch (type) {
	        case BASIC:
	        	instance = FruitFactoryImpl.getInstance();
	            break;
	                
	        case CACHED:
	        	instance = FruitFactoryCachedImpl.getInstance();
	            break;
	                                    
	        default:
	            throw new FruitException("This fruit factory is not emplemented yet");
			}
		
		return instance;
	}

}
