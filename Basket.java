/**
 * 
 */
package academy.learnprograming;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Daniel McAuley
 *
 */
public class Basket {
	
	// vars 
	private final String name;
	private final Map<StockItem, Integer> list;
	
	/**
	 * Constructor of Basket
	 */
	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<>();
	}
	
	/**
	 * Adds quantity of item to Basket list
	 * @param item
	 * @param quantity
	 * @return the value of items in basket
	 */
	public int addToBasket(StockItem item, int quantity) {
		if((item != null) && (quantity > 0)) {
			int inBasket = list.getOrDefault(item, 0);
			list.put(item, inBasket + quantity);
			return inBasket;
		} 
		return 0;
	}
	
	/**
	 * @return an unmodifiable veiw of the basket
	 */
	public Map<StockItem, Integer> items(){
		return Collections.unmodifiableMap(list);
	}

	/**
	 * Shows the size of the shopping basket, each item & its value and the total basket cost
	 */
	@Override
	public String toString() {
		String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item\n" : " items\n");
		double totalCost = 0.0;
		// loop through all entries in shopping basket
		for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
			s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
			totalCost += item.getKey().getPrice() * item.getValue();
		}
		return s + "Total cost " + totalCost;
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
