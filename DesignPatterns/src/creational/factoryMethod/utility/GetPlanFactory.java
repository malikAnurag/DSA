package creational.factoryMethod.utility;

import creational.factoryMethod.domainObject.CommercialPlan;
import creational.factoryMethod.domainObject.DomesticPlan;
import creational.factoryMethod.domainObject.InstitutionalPlan;
import creational.factoryMethod.domainObject.Plan;

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
