package com.gojek.model;

public class ParkingLot {
	
	private int slotNumber;
	private Car car;
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public ParkingLot(int slotNumber, Car car) {
		super();
		this.slotNumber = slotNumber;
		this.car = car;
	}
	

}
