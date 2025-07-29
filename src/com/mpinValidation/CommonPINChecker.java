package com.onebanc.mpinValidation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonPINChecker {
	private static final Set<String> common_pins = new HashSet<>(Arrays.asList(
	        // 4-digit weak PINs
	        "0000", "1111", "1234", "2222", "1122", "1212", "7777",
	        "1004", "2000", "4444", "6969", "9999", "3333", "5555",
	        "6666", "1313", "8888", "4321", "1010",

	        // 6-digit weak PINs
	        "123456", "654321", "000000", "111111", "121212", "112233",
	        "222222", "999999", "123123", "789456"
	    ));

	    public boolean isCommon(String mpin) {
	        return common_pins.contains(mpin);
	    }

}
