package model;

import java.util.HashMap;


import interfaces.BouquetMaker;

public class Order implements BouquetMaker{
	HashMap<Flower, Integer> flowers = new HashMap<>();

	public Order(HashMap<Flower, Integer> flowers) {
		super();
		this.flowers = flowers;
	}

	@Override
	public double calculateCost() {
		double cost = BASE_COST;
		for (Flower key : flowers.keySet() ) {
		    cost += key.cost*flowers.get(key);
		    if(key.hasThorns) {
		    	cost -= 3*flowers.get(key);
		    }
		}
		return cost;
	}
	
	
}
