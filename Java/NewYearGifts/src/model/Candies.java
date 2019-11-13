package model;

import java.util.HashMap;

public class Candies extends Sweets{

	private double weight;
	private static final String SWEET_TYPE = "CANDY";
	private static HashMap<String, Double> weightsofCandies = new HashMap<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Candies(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
		setWeight();
		super.setType(SWEET_TYPE);
		super.setWeight(weight);
		setName(name);
	}

	public void setWeight() {
		// TODO Auto-generated method stub
		weightsofCandies.put(name, weight);
	}

	public static double getWeight(String candy) {
		return weightsofCandies.get(candy);
	}
	

}
