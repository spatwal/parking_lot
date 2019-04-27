package com.gojek.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gojek.constants.ParkingLotConstants;
import com.gojek.helper.MessageCreationHelper;
import com.gojek.model.Car;
import com.gojek.service.CarParkOpertaions;

public class CarParkOperationsImpl extends MessageCreationHelper implements CarParkOpertaions {

    static int lotSequence = 0;

    @Override
    public HashMap<Integer, Car> createParkingLot(int size) {
	return new HashMap<Integer, Car>(size);

    }

    @Override
    public void parkCar(HashMap<Integer, Car> parkingMap, int sizeOfLot, String colour, String registartionNumber) {

	Car car = new Car(colour, registartionNumber);
	int lotNumber = 0;
	boolean inserted = false;
	if (parkingMap.size() != 0) {

	    for (int i = 1; i <= parkingMap.size(); i++)
		if (parkingMap.get(i) == null) {
		    parkingMap.put(i, car);
		    inserted = true;
		    displayMessage(ParkingLotConstants.ALLOCATION_COMMENT, i);
		}

	}
	if (!inserted) {
	    if (parkingMap.size() < sizeOfLot) {
		lotNumber = parkingMap.size();
		parkingMap.put(++lotNumber, car);
		displayMessage(ParkingLotConstants.ALLOCATION_COMMENT, lotNumber);

	    } else {
		displayMessage(ParkingLotConstants.FULL_PARKING_LOT);

	    }
	}
    }

    @Override
    public void leaveLot(HashMap<Integer, Car> parkingMap, String parkingSlot) {

	parkingMap.put(Integer.parseInt(parkingSlot), null);
	displayMessage(ParkingLotConstants.SUSCCESSFUL_LEAVE_1 + parkingSlot + ParkingLotConstants.SUSCCESSFUL_LEAVE_2);

    }

    @Override
    public void checkParkingLotStatus(HashMap<Integer, Car> parkingMap) {

	if (parkingMap.size() > 0) {
	    displayMessage(ParkingLotConstants.SLOT_NUMBER + ParkingLotConstants.SPACE
		    + ParkingLotConstants.REGISTRATION_NUMBER + ParkingLotConstants.SPACE + ParkingLotConstants.COLOUR);
	}

	for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {

	    if (entry.getValue() != null)
		displayMessage(entry.getKey() + ParkingLotConstants.SPACE + ParkingLotConstants.SPACE
			+ entry.getValue().getRegistrationNumber() + ParkingLotConstants.SPACE
			+ entry.getValue().getColor());

	}

    }

    @Override
    public void searchRegistartionNumberByColour(HashMap<Integer, Car> parkingMap, String colour) {

	List<String> registrationList = new ArrayList<>();
	for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {

	    if (entry.getValue().getColor().equals(colour))
		registrationList.add(entry.getValue().getRegistrationNumber());
	}
	if (registrationList.size() != 0)
	    displayMessage(registrationList);
	else
	    displayMessage(ParkingLotConstants.NOT_FOUND);
    }

    @Override
    public void searchSlotNumberByColor(HashMap<Integer, Car> parkingMap, String colour) {

	List<String> slotList = new ArrayList<>();
	for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {

	    if (entry.getValue().getColor().equals(colour))
		slotList.add(entry.getKey() + "");
	}
	if (slotList.size() != 0)
	    displayMessage(slotList);
	else
	    displayMessage(ParkingLotConstants.NOT_FOUND);

    }

    @Override
    public void searchSlotNumberByRegistration(HashMap<Integer, Car> parkingMap, String registrationNumber) {

	int slot = 0;
	for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {

	    if (entry.getValue().getRegistrationNumber().equals(registrationNumber))
		slot = entry.getKey();

	}

	if (slot != 0)
	    displayMessage(slot);
	else
	    displayMessage(ParkingLotConstants.NOT_FOUND);
    }

}
