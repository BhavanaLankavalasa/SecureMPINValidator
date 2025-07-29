package com.onebanc.mpinValidation;
import java.util.List;

public class MPINResult {
	private final String strength;
    private final List<String> reasons;

    public MPINResult(String strength, List<String> reasons) {
        this.strength = strength;
        this.reasons = reasons;
    }

    public String getStrength() {
        return strength;
    }

    public List<String> getReasons() {
        return reasons;
    }

    @Override
    public String toString() {
        return "Strength: " + strength + ", Reasons: " + reasons;
    }

}
