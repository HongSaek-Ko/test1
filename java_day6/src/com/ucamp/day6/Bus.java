package com.ucamp.day6;

public class Bus extends Car{

	private String type;

	public Bus(String name, int price, String type) {
		// TODO Auto-generated constructor stub
		super(name, price);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append(super.toString()) // 차종:
			.append("("+type+")"); // 유형
		return builder.toString();
	}
	
	
}
