package model;

import java.util.HashMap;

public class Rose extends Flower{
	
	private final static String FLOWER_NAME = "ROSE";
	HashMap<String, Double> costToTypes = new HashMap<>(); 
	private String gColour;
	
	public Rose(String colour) {
		costToTypes.put("Red", 20.0);
		costToTypes.put("White", 28.0);
		costToTypes.put("Blue", 35.0);
		costToTypes.put("Pink", 40.0);
		gColour = colour;
		
		super.hasThorns=true;
		super.cost = costToTypes.get(colour);
	}
	
	@Override
	public String getFlowerName() {
		return gColour + FLOWER_NAME;
	}
	
}
