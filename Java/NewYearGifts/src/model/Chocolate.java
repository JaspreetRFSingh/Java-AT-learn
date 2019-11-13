package model;

import java.util.HashMap;

public class Chocolate extends Sweets {

	private String name;
	private double weight;
	private static final String SWEET_TYPE = "CHOCOLATE";
	private static HashMap<String, Double> weightsofChocolates = new HashMap<>();
	
	public Chocolate(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
		setWeight();
		super.setType(SWEET_TYPE);
		super.setWeight(weight);
		setName(name);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setWeight() {
		weightsofChocolates.put(name,weight);
	}

	public static double getWeight(String chocolate) {
		return weightsofChocolates.get(chocolate);
	}
	

	

}
