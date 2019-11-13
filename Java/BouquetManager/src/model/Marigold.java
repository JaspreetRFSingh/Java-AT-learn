package model;

public class Marigold extends Flower{
	private final static String FLOWER_NAME = "MARIGOLD";
	private final static double FLOWER_COST = 30.0;

	public Marigold() {
		super.hasThorns=false;
		super.cost=FLOWER_COST;
	}
	
	@Override
	public String getFlowerName() {
		return FLOWER_NAME;
	}
	
}
