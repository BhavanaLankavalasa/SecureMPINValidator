package com.onebanc.mpinValidation;

import java.util.Arrays;
import java.util.List;

public class TestCases {

	public static void main(String[] args) {
		MPINAnalyser analyzer = new MPINAnalyser();

        System.out.println("========== TEST CASES ==========");

        // === Category 1: Commonly Used MPINs Only ===
        test(analyzer, "1234", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));
        test(analyzer, "0000", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));
        test(analyzer, "1111", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));
        test(analyzer, "1212", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));
        test(analyzer, "123456", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));
        test(analyzer, "789456", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));

        // === Category 2: Demographic Matches Only ===
        test(analyzer, "0201", "02-01-1998", "", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF"));
        test(analyzer, "0304", "", "03-04-1997", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SPOUSE"));
        test(analyzer, "1402", "", "", "14-02-2015", "WEAK", Arrays.asList("DEMOGRAPHIC_ANNIVERSARY"));
        test(analyzer, "1998", "02-01-1998", "", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF"));
        test(analyzer, "9802", "02-01-1998", "", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF"));
        test(analyzer, "2015", "", "", "14-02-2015", "WEAK", Arrays.asList("DEMOGRAPHIC_ANNIVERSARY"));
        test(analyzer, "14022015", "", "", "14-02-2015", "WEAK", Arrays.asList("DEMOGRAPHIC_ANNIVERSARY"));

        // === Category 3: Both Common and Demographic Weak ===
        test(analyzer, "2000", "01-01-2000", "", "", "WEAK", Arrays.asList("COMMONLY_USED", "DEMOGRAPHIC_DOB_SELF"));
        test(analyzer, "1122", "11-12-1990", "", "", "WEAK", Arrays.asList("COMMONLY_USED", "DEMOGRAPHIC_DOB_SELF"));
        test(analyzer, "1010", "", "10-10-1990", "", "WEAK", Arrays.asList("COMMONLY_USED", "DEMOGRAPHIC_DOB_SPOUSE"));
        test(analyzer, "1313", "13-01-1990", "", "", "WEAK", Arrays.asList("COMMONLY_USED", "DEMOGRAPHIC_DOB_SELF"));

        // === Category 4: Strong PINs ===
        test(analyzer, "9876", "", "", "", "STRONG", Arrays.asList());
        test(analyzer, "6543", "01-01-2000", "02-02-1999", "03-03-1998", "STRONG", Arrays.asList());
        test(analyzer, "998877", "", "", "", "STRONG", Arrays.asList());
        test(analyzer, "7654", "", "", "", "STRONG", Arrays.asList());
        test(analyzer, "541278", "", "", "", "STRONG", Arrays.asList());

        // === Category 5: Empty Demographics ===
        test(analyzer, "4444", "", "", "", "WEAK", Arrays.asList("COMMONLY_USED"));
        test(analyzer, "020198", "", "", "", "STRONG", Arrays.asList());  // Demographics missing
        test(analyzer, "2020", "", "", "", "STRONG", Arrays.asList());

        // === Category 6: Multiple Demographic Matches ===
        test(analyzer, "0201", "02-01-1998", "01-02-1998", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF", "DEMOGRAPHIC_DOB_SPOUSE"));
        test(analyzer, "1402", "14-02-1995", "", "14-02-2015", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF", "DEMOGRAPHIC_ANNIVERSARY"));

        // === Category 7: Edge formats ===
        test(analyzer, "020198", "02-01-1998", "", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF"));
        test(analyzer, "199801", "", "", "", "STRONG", Arrays.asList());
        test(analyzer, "010203", "01-02-2003", "", "", "WEAK", Arrays.asList("DEMOGRAPHIC_DOB_SELF"));
    }

    public static void test(MPINAnalyser analyzer, String mpin, String dobSelf, String dobSpouse, String anniversary,
                            String expectedStrength, List<String> expectedReasons) {
        MPINResult result = analyzer.analyze(mpin, dobSelf, dobSpouse, anniversary);
        boolean pass = result.getStrength().equals(expectedStrength) &&
                result.getReasons().containsAll(expectedReasons) &&
                expectedReasons.containsAll(result.getReasons());

        System.out.println("Test MPIN: " + mpin + " --> " + (pass ? " PASS" : " FAIL"));
        if (!pass) {
            System.out.println("  Expected: " + expectedStrength + ", Reasons: " + expectedReasons);
            System.out.println("  Got:      " + result.getStrength() + ", Reasons: " + result.getReasons());
        }

	}

}
