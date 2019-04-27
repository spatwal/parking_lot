package com.gojek.service;

import java.util.HashMap;
import com.gojek.model.Car;

public interface CarParkOpertaions {

    public HashMap<Integer, Car> createParkingLot(int size);

    public void parkCar(HashMap<Integer, Car> parkingMap, int sizeOfLot, String colour, String registartionNumber);

    public void leaveLot(HashMap<Integer, Car> parkingMap, String parkingSlot);

    public void checkParkingLotStatus(HashMap<Integer, Car> parkingMap);

    public void searchRegistartionNumberByColour(HashMap<Integer, Car> parkingMap, String colour);

    public void searchSlotNumberByColor(HashMap<Integer, Car> parkingMap, String color);

    public void searchSlotNumberByRegistration(HashMap<Integer, Car> parkingMap, String registrationNumber);

}
