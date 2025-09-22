package com.ucamp.day6;

public class Car extends Product {

	public Car(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		System.out.println("asdf");
		return "차종: "+super.getName();
	}

}
