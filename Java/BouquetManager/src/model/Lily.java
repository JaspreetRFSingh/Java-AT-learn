package model;

public class Lily extends Flower{
	private final static String FLOWER_NAME = "LILY";
	private final static double FLOWER_COST = 25.0;

	public Lily() {
		super.hasThorns=true;
		super.cost=FLOWER_COST;
	}
	
	@Override
	public String getFlowerName() {
		return FLOWER_NAME;
	}

}
