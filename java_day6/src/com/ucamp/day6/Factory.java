package com.ucamp.day6;

import java.util.ArrayList;

public interface Factory {
	Product create(String name, int price);
	
	Product create(String name, int price, String type);

	public void printAllProduct();

	ArrayList<Car> getCarsByType(String type);

}
