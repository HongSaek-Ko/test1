package com.ucamp.day6;

public class SummaryMain {

	public static void main(String[] args) {
		Factory factory = new CarFactory();
		Product p1 = factory.create("소나타", 2000);
		Product p2 = factory.create("버스", 4000, "대형");
		factory.printAllProduct();
		for(Car car : factory.getCarsByType("승용차")) {
			// 버스만 출력, null 입력 시 승용차만 출력
			System.out.println(car);
		}
	}

}
