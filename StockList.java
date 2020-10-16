/**
 * 
 */
package academy.learnprograming;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Will store StockItems in a map
 * @author Daniel McAuley
 *
 */
public class StockList {
	
	// vars
	private final Map<String, StockItem> list;
	
	/**
	 * Constructor
	 * Creates a new HashMap when the StockList object is created
	 */
	public StockList() {
		this.list = new LinkedHashMap<>();
	}
	
	/**
	 * Add's the item to the stock lists and updates stock quantity 
	 * @param item
	 * @return the quantity of the item in stock
	 */
	public int addStock(StockItem item) {
		if(item != null) {
			// check if already have quantities of item
			StockItem inStock = list.getOrDefault(item.getName(), item);
			// if already stock of this item, adjust the quantity
			if(inStock != item) {
				item.adjustStock(inStock.quantityInStock());
			}
			
			list.put(item.getName(), item);
			return item.quantityInStock();
		}
		return 0;	
	}
	
	/**
	 * Checks if the item is in stock, if so makes sure there is enough quantity in stock to sell
	 * @param item
	 * @param quantity
	 * @return quantity of the item after it has been sold
	 */
	public int sellStock(String item, int quantity) {
		StockItem inStock = list.getOrDefault(item, null);
		
		if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)) {
			inStock.adjustStock(-quantity);
			return quantity;
		}
		
		return 0;
	}
	
	/**
	 * Gets StockItem value using the key passed
	 * @param key
	 * @return null if StockItem does not exist
	 */
	public StockItem get(String key) {
		return list.get(key);
	}
	
	/**
	 * @return an unmodifiable view of the StockList map
	 */
	public Map<String, StockItem> Items(){
		return Collections.unmodifiableMap(list);
	}

	/**
	 * Prints a list of all the stock items, their value and the total stock value
	 * Returns a string
	 */
	@Override
	public String toString() {
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for(Map.Entry<String , StockItem> item : list.entrySet()) {
			StockItem stockItem = item.getValue();
			
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			
			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items : ";
			s = s + String.format("%.2f",itemValue) + "\n";
			totalCost += itemValue;
		}
		
		return s + "\nTotal stock value " + totalCost + "\n";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
