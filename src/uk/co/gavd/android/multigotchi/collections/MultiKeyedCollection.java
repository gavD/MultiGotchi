package uk.co.gavd.android.multigotchi.collections;

import java.util.HashMap;

/**
 * Collection of "things" that can be used. There are always 4 things
 * in the collection, and they can be accessed ("keyed") via either a numerical
 * index (1,2,3,4) or a string (the name of the item in the collection)
 * 
 * This class is hard coded for 4 items only  
 *  
 * @author Gavin Davies
 *
 * @param <E> A type. Should be an implementation of IMultiKeyCollectable
 */
public class MultiKeyedCollection<E extends IMultiKeyCollectable> {
	private HashMap<String, IMultiKeyCollectable> stringMap;
	private String[] indexesForStringMap;
	
	public MultiKeyedCollection() {
		stringMap = new HashMap<String, IMultiKeyCollectable>();
		indexesForStringMap = new String[4];
	}
	
	/**
	 * Initialise this collection
	 * @param collectable1 Item in the collection
	 * @param collectable2 Item in the collection
	 * @param collectable3 Item in the collection
	 * @param collectable4 Item in the collection
	 */
	public void setCollection(IMultiKeyCollectable collectable1,
			IMultiKeyCollectable collectable2,
			IMultiKeyCollectable collectable3,
			IMultiKeyCollectable collectable4)
	{
		stringMap.put(collectable1.getName(), collectable1);
		indexesForStringMap[0] = collectable1.getName();
		
		stringMap.put(collectable2.getName(), collectable2);
		indexesForStringMap[1] = collectable2.getName();
		
		stringMap.put(collectable3.getName(), collectable3);
		indexesForStringMap[2] = collectable3.getName();
		
		stringMap.put(collectable4.getName(), collectable4);
		indexesForStringMap[3] = collectable4.getName();
	}
	
	/**
	 * Find an item by its name
	 * @param key Should match the result of IMultiKeyCollectable.getName()
	 * @return Item matching {key}
	 * @throws ItemNotFoundException
	 */
	public IMultiKeyCollectable findByName(String key) throws ItemNotFoundException {
		if(!stringMap.containsKey(key)) {
			throwItemNotFoundException(key);
		}
		
		return stringMap.get(key);
	}

	/**
	 * Find an item by its numerical index
	 * @param index Should be 1, 2, 3, or 4
	 * @return Item at index {index}
	 * @throws ItemNotFoundException
	 */
	public IMultiKeyCollectable findByIndex(int index) throws ItemNotFoundException {
		if (index < 0 || index > indexesForStringMap.length){
			throwItemNotFoundException(" at index " + index);
		}
		return this.findByName(indexesForStringMap[index - 1]);
	}
	
	public String toString() {
		String r = "";
		for (int i = 1; i <= indexesForStringMap.length; i++) {
			try {
				r = r + findByIndex(i) + "\n";
			} catch (ItemNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return r;
	}
	
	private void throwItemNotFoundException(String itemLabel) throws ItemNotFoundException {
		throw new ItemNotFoundException("Cannot find item " + itemLabel
				+ " in available keys " + stringMap.keySet().toString());
	}
}
