package com.onebanc.mpinValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MPINAnalyser {
	private final CommonPINChecker commonChecker;
    private final DemographicChecker demographicChecker;

    public MPINAnalyser() {
        this.commonChecker = new CommonPINChecker();
        this.demographicChecker = new DemographicChecker();
    }

    public MPINResult analyze(String mpin, String dobSelf, String dobSpouse, String anniversary) {
        List<String> reasons = new ArrayList<>();

        if (commonChecker.isCommon(mpin)) {
            reasons.add("COMMONLY_USED");
        }

        Set<String> demographicReasons = demographicChecker.getDemographicMatches(mpin, dobSelf, dobSpouse, anniversary);
        reasons.addAll(demographicReasons);

        String strength = reasons.isEmpty() ? "STRONG" : "WEAK";

        return new MPINResult(strength, reasons);
    }

}
