package com.onebanc.mpinValidation;
import java.util.HashSet;
import java.util.Set;


public class DemographicChecker {
	public Set<String> getDemographicMatches(String mpin, String dobSelf, String dobSpouse, String anniversary) {
        Set<String> reasons = new HashSet<>();

        if (matchesDemographic(mpin, dobSelf)) {
            reasons.add("DEMOGRAPHIC_DOB_SELF");
        }
        if (matchesDemographic(mpin, dobSpouse)) {
            reasons.add("DEMOGRAPHIC_DOB_SPOUSE");
        }
        if (matchesDemographic(mpin, anniversary)) {
            reasons.add("DEMOGRAPHIC_ANNIVERSARY");
        }

        return reasons;
    }
	private boolean matchesDemographic(String mpin, String date) {
        if (date == null || date.isEmpty()) return false;

        String[] parts = date.split("-"); // Expected format: dd-MM-yyyy
        if (parts.length != 3) return false;

        String dd = parts[0];
        String mm = parts[1];
        String yyyy = parts[2];
        String yy = yyyy.length() >= 4 ? yyyy.substring(2) : "";

        Set<String> possiblePins = new HashSet<>();

        // 4-digit and 6-digit combinations
        possiblePins.add(dd + mm);
        possiblePins.add(mm + dd);
        possiblePins.add(yy + dd);
        possiblePins.add(dd + yy);
        possiblePins.add(mm + yy);
        possiblePins.add(yy + mm);
        possiblePins.add(yyyy);
        possiblePins.add(dd + yyyy.substring(2));
        possiblePins.add(yyyy.substring(2) + dd);
        possiblePins.add(dd + mm + yy);
        possiblePins.add(mm + dd + yy);
        possiblePins.add(yy + mm + dd);

        return possiblePins.contains(mpin);
    }

}
