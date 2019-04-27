package com.gojek.helper;

import java.util.HashMap;

import com.gojek.constants.ParkingLotConstants;
import com.gojek.model.Car;
import com.gojek.service.CarParkOpertaions;
import com.gojek.serviceImpl.CarParkOperationsImpl;

public class InputDataProcessHelper {

    public void creataCarParkingSpace(String input, HashMap<Integer, Car> carMap, int size) {

	CarParkOpertaions carParkService = new CarParkOperationsImpl();

	switch (input) {
	case ParkingLotConstants.CREATE_PARKING_LOT:
	    // size = Integer.parseInt(inputArr[1]);
	    carMap = carParkService.createParkingLot(size);
	    MessageCreationHelper.displayMessage(
		    ParkingLotConstants.SUSCCESSFUL_CRETAION_1 + size + ParkingLotConstants.SUSCCESSFUL_CRETAION_2);
	    break;

	default:
	    System.out.println(ParkingLotConstants.NO_PARKING_LOT);

	}

    }

    public void processCarParkOperations(String input, HashMap<Integer, Car> carMap, int size) {

	CarParkOpertaions carParkService = new CarParkOperationsImpl();
	String[] input2Arr = input.split(" ");
	String registrationNumber;
	String colour;
	String message;
	switch (input2Arr[0]) {
	case ParkingLotConstants.PARK:
	    carParkService.parkCar(carMap, size, input2Arr[2], input2Arr[1]);

	    break;

	case ParkingLotConstants.LEAVE:
	    carParkService.leaveLot(carMap, input2Arr[1]);

	    break;

	case ParkingLotConstants.STATUS:
	    carParkService.checkParkingLotStatus(carMap);
	    break;

	case ParkingLotConstants.REGISTRTION_ENQUIRY_FOR_COLOUR:
	    carParkService.searchRegistartionNumberByColour(carMap, input2Arr[1]);
	    break;
	case ParkingLotConstants.SLOT_ENQUIRY_FOR_COLOR:
	    carParkService.searchSlotNumberByColor(carMap, input2Arr[1]);
	    break;
	case ParkingLotConstants.SLOT_ENQUIRY_FOR_REGISTARTION_NUMBER:
	    carParkService.searchSlotNumberByRegistration(carMap, input2Arr[1]);
	    break;
	default:
	    System.out.println(ParkingLotConstants.WRONG_INPUT);

	}

    }

}
