package academy.learnprograming;

public class Main {
	
	// create new instance of StockList
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		
		// create StockItem
		StockItem temp = new StockItem("bread", 86, 100);
		
		// add StockItem to StockList
		stockList.addStock(temp);
		
		temp = new StockItem("cake", 1.10, 7);
		stockList.addStock(temp);
		
		temp = new StockItem("car", 12.50, 2);
		stockList.addStock(temp);
		
		temp = new StockItem("chair", 62.00, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("cup", 0.50, 200);
		stockList.addStock(temp);
		temp = new StockItem("cup", 0.45, 7);
		stockList.addStock(temp);
		
		temp = new StockItem("door", 72.95, 5);
		stockList.addStock(temp); 
		
		temp = new StockItem("juice", 2.50, 36);
		stockList.addStock(temp);
		
		temp = new StockItem("phone", 96.99, 35);
		stockList.addStock(temp);
		
		temp = new StockItem("towel", 2.40, 80);
		stockList.addStock(temp);
		
		temp = new StockItem("vase", 8.76, 40);
		stockList.addStock(temp);	
		
		System.out.println(stockList);
		
		Basket danielsBasket = new Basket("Daniel");
		sellItem(danielsBasket, "car", 1);
		System.out.println(danielsBasket);
		
		sellItem(danielsBasket, "car", 1);
		System.out.println(danielsBasket);
		
		// should fail
		if(sellItem(danielsBasket, "car", 1) != 1){
			System.out.println("There are no more cars in stock");
		}
		sellItem(danielsBasket, "spanner", 5);
		System.out.println(danielsBasket);
		
		sellItem(danielsBasket, "juice", 4);
		sellItem(danielsBasket, "cup", 12);
		sellItem(danielsBasket, "bread", 1);
		System.out.println(danielsBasket);
		
		System.out.println(stockList);
		
//		temp = new StockItem("pen", 1.12);
//		stockList.Items().put(temp.getName(), temp);
		
		stockList.Items().get("car").adjustStock(2000);
		System.out.println(stockList);

	}
	
	public static int sellItem(Basket basket, String item, int quantity) {
		// retrieve item from stock list
		StockItem stockItem = stockList.get(item);
		if(stockItem == null) {
			System.out.println("We dont sell " + item);
			return 0;
		}
		
		// we have a valid quantity 
		if(stockList.sellStock(item, quantity) != 0) {
			// adds to basket
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
