package academy.learnprograming;

import java.lang.Comparable;

/**
 * StockItem class that will be added to the StockList map
 * @author Daniel McAuley
 *
 */
public class StockItem implements Comparable<StockItem>{
	
	// vars
	private final String name;
	private double price;
	private int quantityStock;
	
	/**
	 * Constructor of StockItem object
	 * @param name
	 * @param price
	 */
	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0;
	}
	
	/**
	 * Overloaded constructor of StockItem object
	 * @param name
	 * @param price
	 * @param quantityStock
	 */
	public StockItem(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	/**
	 * @return the price of the StockItem
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * Sets the price of the StockItem
	 * @param price
	 */
	public void setPrice(double price) {
		if(price > 0.0) {
			this.price = price;
		}
	}

	/**
	 * @return the quantity of stock
	 */
	public int quantityInStock() {
		return quantityStock;
	}

	/**
	 * Adjusts the quantity of stock by adding or removing stock
	 * @param quantity
	 */
	public void adjustStock(int quantity) {
		int newQuantity = this.quantityStock + quantity;
		if(newQuantity >= 0) {
			this.quantityStock = newQuantity;
		}
	}

	/**
	 * @return the name of the StockItem
	 */
	public String getName() {
		return name;
	}

	/**
	 * Compares the parameter "o" to this current StockItem
	 * Returns 0 if the objects are equal
	 */
	@Override
	public int compareTo(StockItem o) {
		System.out.println("Entering StockItem.compareTo");
		if(this == o) {
			return 0;
		}
		
		if(o != null) {
			return this.name.compareTo(o.getName());
		}
		
		throw new NullPointerException();
	}

	/**
	 * Indicates whether some other object is equal to this one
	 * Returns true if this object is the same as the obj parameter
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println("Entering StockItem.equals");
		if(obj == this) {
			return true;
		}
		
		if((obj == null) || (obj.getClass() != this.getClass())){
			return false;
		}
		
		String objName = ((StockItem) obj).getName();
		return this.name.equals(objName);
	}

	/**
	 * Returns a hash code value for the object
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode() + 31;
	}
	
	/**
	 * Returns a String representation of the object
	 */
	@Override
	public String toString() {
		return this.name + " : price " + this.price;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
