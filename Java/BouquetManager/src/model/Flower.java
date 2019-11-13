package model;

public abstract class Flower {
	
	public boolean hasThorns;
	public double cost;
	public abstract String getFlowerName();
	public boolean hasThorns() {
		return hasThorns;
	}
	public void setHasThorns(boolean hasThorns) {
		this.hasThorns = hasThorns;
	}
	public double getCost() {
		return cost;
	}
	public void setColour(double cost) {
		this.cost = cost;
	}
	
}
