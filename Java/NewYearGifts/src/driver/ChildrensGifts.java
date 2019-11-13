package driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Candies;
import model.Chocolate;
import model.Sweets;
import utils.Gift;

public class ChildrensGifts {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		Candies eclairs = new Candies("Eclairs", 25.0);
		Candies melody = new Candies("Melody", 38.0);
		Candies gems = new Candies("Gems", 15.0);
		Candies pulse = new Candies("Pulse", 17.0);

		Chocolate silk = new Chocolate("Silk", 220.0);
		Chocolate milkybar = new Chocolate("Milkybar", 180.0);
		Chocolate barone = new Chocolate("BarOne", 190.0);
		Chocolate kitkat = new Chocolate("KitKat", 168.0);
		
		ArrayList<Sweets> sweetsInTheGift = new ArrayList<Sweets>();
		
		System.out.println("Opening the gift...");
		HashMap<Candies, Integer> candies = new HashMap<>();
		HashMap<Chocolate, Integer> chocolates;
		int numberOfSilks;
		int numberOfMilkybars;
		int numberOfBarOnes;
		int numberOfKitKats;
		try {
			System.out.print("Enter no. of Eclairs: ");
			int numberOfEclairs = scanner.nextInt();
			System.out.print("Enter no. of Melody: ");
			int numberOfMelodies = scanner.nextInt();
			System.out.print("Enter no. of Gems: ");
			int numberOfGems = scanner.nextInt();
			System.out.print("Enter no. of Pulse: ");
			int numberOfPulses = scanner.nextInt();
			candies.put(eclairs, numberOfEclairs);
			candies.put(melody, numberOfMelodies);
			candies.put(gems, numberOfGems);
			candies.put(pulse, numberOfPulses);
			
			chocolates = new HashMap<>();
			System.out.print("Enter no. of Silk: ");
			numberOfSilks = scanner.nextInt();
			System.out.print("Enter no. of Milkybar: ");
			numberOfMilkybars = scanner.nextInt();
			System.out.print("Enter no. of BarOne: ");
			numberOfBarOnes = scanner.nextInt();
			System.out.print("Enter no. of KitKats: ");
			numberOfKitKats = scanner.nextInt();
			chocolates.put(silk, numberOfSilks);
			chocolates.put(milkybar, numberOfMilkybars);
			chocolates.put(barone, numberOfBarOnes);
			chocolates.put(kitkat, numberOfKitKats);
			
			for(Candies candiesCount : candies.keySet()) {
				if(candies.get(candiesCount)>0) {
					sweetsInTheGift.add(candiesCount);
				}
			}
			for(Chocolate chocolatesCount : chocolates.keySet()) {
				if(chocolates.get(chocolatesCount)>0) {
					sweetsInTheGift.add(chocolatesCount);
				}
			}
			Gift gift = new Gift(candies, chocolates);
			double weightInGrams = gift.calculateWeight();
			double weight = weightInGrams / 1000;
			System.out.println("Weight of the gift basket: " + weight+ "kgs");
			System.out.print("\n\nEnter weight range(from): ");
			double from = scanner.nextDouble();
			System.out.print("Enter weight range(to): ");
			double to = scanner.nextDouble();
			ArrayList<Sweets> sweetsList = (ArrayList<Sweets>) gift.filterGiftsByWeight(from, to);
			
			System.out.println("\nSweets in the given range:");
			for(Sweets sweets : sweetsList) {
				System.out.println(sweets.getName()+"("+sweets.getType()+")");
			}
			
			System.out.println("\nSweets sorted by weight: ");
			ArrayList<Sweets> sweetsSortedByWeight = (ArrayList<Sweets>) gift.sortByWeight();
			for(Sweets sweets: sweetsSortedByWeight) {
				if(sweetsInTheGift.contains(sweets)) {
					System.out.println(sweets.getName());
				}
				
			}
			System.out.println("Size:"+sweetsInTheGift.size());
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Theek theek likho");
		}
		
		
		
		
		scanner.close();
		

	}

}
