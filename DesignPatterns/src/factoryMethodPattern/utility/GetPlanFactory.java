package factoryMethodPattern.utility;

import factoryMethodPattern.domainObject.CommercialPlan;
import factoryMethodPattern.domainObject.DomesticPlan;
import factoryMethodPattern.domainObject.InstitutionalPlan;
import factoryMethodPattern.domainObject.Plan;

public class GetPlanFactory {

    public Plan getPlan(String planType) {

        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
            return new CommercialPlan();
        } else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}
