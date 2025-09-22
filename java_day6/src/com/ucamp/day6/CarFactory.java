package com.ucamp.day6;

import java.util.ArrayList;
import java.util.HashMap;

public class CarFactory implements Factory {
	
//	private ArrayList<Car> carList;
	private HashMap<String, ArrayList<Car>> carList;
	public CarFactory() {
		this.carList = new HashMap<String, ArrayList<Car>>();
		carList.put("승용차", new ArrayList<Car>());
		carList.put("버스", new ArrayList<Car>());
	}
	@Override
	public Product create(String name, int price) {
		// TODO Auto-generated method stub
		Car car = new Car(name, price);
		carList.get("승용차").add(car);
		return car;
	}
	@Override
	public Product create(String name, int price, String type) {
		// TODO Auto-generated method stub
		Bus bus = new Bus(name, price, type);
		carList.get("버스").add(bus);
		return bus;
	}
	public void printAllProduct() {
		for(ArrayList<Car> car : carList.values()) {
			for(Car i : car) {				
				System.out.println(i);
			}
		}
		
		// 혹은 key 사용
//		for(String key : carList.keySet()) {
//			for(Car car : carList.get(key)) {
//				System.out.println(car);
//			}
//		}
		
	}
	@Override
	public ArrayList<Car> getCarsByType(String type) {
		return carList.get(type);
	}
}
