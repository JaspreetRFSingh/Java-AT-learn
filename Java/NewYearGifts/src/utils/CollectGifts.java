package utils;

import java.util.List;

import model.Sweets;

public interface CollectGifts {
	double calculateWeight();
	List<Sweets> filterGiftsByWeight(double rangeFrom, double rangeTo);
}
