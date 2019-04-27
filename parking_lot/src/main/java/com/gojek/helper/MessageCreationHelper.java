package com.gojek.helper;

import java.util.List;
import com.gojek.constants.ParkingLotConstants;

public class MessageCreationHelper  {

    public static void displayMessage(String message, int slot) {
	System.out.println(message + slot);
    }

    public static void displayMessage(String message) {
	System.out.println(message);
    }

    public static void displayMessage(int message) {
	System.out.println(message);
    }

    public static void displayMessage(String message1, int slot, String message2) {
	System.out.println(message1 + slot + message2);
    }

    public static void displayMessage(String... message) {
	StringBuilder sb = new StringBuilder();
	for (String s : message) {
	    sb.append(s);
	}
	System.out.println(sb.toString());
    }

    public static void displayMessage(List<String> dataList) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < dataList.size(); i++) {
	    if (i != dataList.size() - 1) {
		sb.append(dataList.get(i));
		sb.append(ParkingLotConstants.COMMA);
	    } else {
		sb.append(dataList.get(i));

	    }
	}
	System.out.println(sb.toString());
    }

}