package com.gojek.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.gojek.constants.ParkingLotConstants;
import com.gojek.helper.InputDataProcessHelper;
import com.gojek.model.Car;

public class DriverClass {

    public static void main(String[] args) {

	InputDataProcessHelper inputHelper = new InputDataProcessHelper();
	HashMap<Integer, Car> carMap = new HashMap<>();
	int size = 0;


	if (0 < args.length) {
	    String filename = args[0];
	    File file = new File(filename);


	    String readLine = "";
	    try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((readLine = br.readLine()) != null) {
		    String[] inputArr = readLine.split(" ");

		    if (inputArr[0].equals(ParkingLotConstants.CREATE_PARKING_LOT)) {
			size = Integer.parseInt(inputArr[1]);
			inputHelper.creataCarParkingSpace(inputArr[0], carMap, size);
		    } else {
			inputHelper.processCarParkOperations(readLine, carMap, size);
		    }
		} // end while
	    } // end try
	    catch (IOException e) {
		System.err.println("Error Happened: " + e);
	    }

	
	}

	else {
	    Scanner scanner = new Scanner(System.in);
	    String input1 = scanner.nextLine();
	    String[] inputArr = input1.split(" ");
	    size = Integer.parseInt(inputArr[1]);
	    inputHelper.creataCarParkingSpace(inputArr[0], carMap, size);

	    while (scanner.hasNextLine()) {
		String input2 = scanner.nextLine();
		inputHelper.processCarParkOperations(input2, carMap, size);

	    }
	} 
    }

}
