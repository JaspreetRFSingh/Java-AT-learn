package driver;

import java.util.HashMap;

import model.Flower;
import model.Marigold;
import model.Order;
import model.Rose;

public class BouquetManager{

	public static void main(String[] args) {
		Flower f1 = new Rose("Blue");
		Flower f2 = new Rose("White");
		Flower f3 = new Marigold();
		HashMap<Flower, Integer> flowers = new HashMap<>();
		flowers.put(f1, 4);
		flowers.put(f2, 3);
		flowers.put(f3, 5);
		Order order = new Order(flowers);
		System.out.println(order.calculateCost());
		
	}
}
