package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import model.Candies;
import model.Chocolate;
import model.Sweets;

public class Gift implements CollectGifts {
	private HashMap<Candies, Integer> candies;
	private HashMap<Chocolate, Integer> chocolates;

	public Gift(HashMap<Candies, Integer> candies, HashMap<Chocolate, Integer> chocolates) {
		super();
		this.candies = candies;
		this.chocolates = chocolates;
	}

	@Override
	public double calculateWeight() {
		double weight = 0.0;
		for (Candies cs : candies.keySet()) {
			weight += Candies.getWeight(cs.getName()) * candies.get(cs);
		}
		for (Chocolate chs : chocolates.keySet()) {
			weight += Chocolate.getWeight(chs.getName()) * chocolates.get(chs);
		}
		return weight;
	}

	ArrayList<Sweets> sweetsSortedByWeight = new ArrayList<Sweets>();

	@Override
	public List<Sweets> filterGiftsByWeight(double from, double to) {
		List<Sweets> sweets = new ArrayList<Sweets>();
		for (Candies cs : candies.keySet()) {
			double tempWeight = Candies.getWeight(cs.getName());
			sweetsSortedByWeight.add(cs);
			if (tempWeight < to && tempWeight > from) {
				sweets.add(cs);
			}
		}
		for (Chocolate chs : chocolates.keySet()) {
			double tempWeight = Chocolate.getWeight(chs.getName());
			sweetsSortedByWeight.add(chs);
			if (tempWeight < to && tempWeight > from) {
				sweets.add(chs);
			}
		}
		return sweets;
	}

	
	  public ArrayList<Sweets> sortByWeight(){
		  Collections.sort(sweetsSortedByWeight, new Comparator<Sweets>() {
			   

				@Override
				public int compare(Sweets o2, Sweets o1) {
					// TODO Auto-generated method stub
					return Double.compare(o1.getWeight(), o2.getWeight());
					
				}
			});
		  return sweetsSortedByWeight;
	  }
	 
	


}
