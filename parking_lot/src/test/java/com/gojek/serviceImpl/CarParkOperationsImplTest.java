package com.gojek.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import com.gojek.model.Car;



public class CarParkOperationsImplTest {
	
	CarParkOperationsImpl carParkOperationsImplTest;
	
	@Test
	public void buildCarParkWithAvailableSpace()
	{
		carParkOperationsImplTest=new CarParkOperationsImpl();
		HashMap<Integer, Car> myParkingMap=new HashMap<>();
		carParkOperationsImplTest.parkCar(myParkingMap, 1, "White", "KA-01-HH-1234");
		assertEquals(1, myParkingMap.size());
	}
	
	
	@Test
	public void findCarByColour()
	{
		carParkOperationsImplTest=new CarParkOperationsImpl();
		HashMap<Integer, Car> myParkingMap=new HashMap<>();
		carParkOperationsImplTest.parkCar(myParkingMap, 2, "White", "KA-01-HH-1234");
		carParkOperationsImplTest.parkCar(myParkingMap, 2, "Black", "KA-01-HH-9999");
		carParkOperationsImplTest.searchRegistartionNumberByColour(myParkingMap,"Black");
		//assertEquals(1, myParkingMap.size());
	}
	
	@Test
	public void buildCarParkWithNoAvailableSpace()
	{
		carParkOperationsImplTest=new CarParkOperationsImpl();
		HashMap<Integer, Car> myParkingMap=new HashMap<>();
		carParkOperationsImplTest.parkCar(myParkingMap, 0, "white", "1234");
		assertEquals(0, myParkingMap.size());
	}
}
