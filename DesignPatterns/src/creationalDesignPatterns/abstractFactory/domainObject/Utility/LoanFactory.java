package creationalDesignPatterns.abstractFactory.domainObject.Utility;

import abstractFactoryPattern.domainObject.Organisations.*;
import abstractFactoryPattern.domainObject.Loans.*;
import creationalDesignPatterns.abstractFactory.domainObject.Loans.BusinessLoan;
import creationalDesignPatterns.abstractFactory.domainObject.Loans.EducationLoan;
import creationalDesignPatterns.abstractFactory.domainObject.Loans.HomeLoan;
import creationalDesignPatterns.abstractFactory.domainObject.Loans.Loan;
import creationalDesignPatterns.abstractFactory.domainObject.Organisations.Bank;

public class LoanFactory extends AbstractFactory{

	@Override
	public Bank getBank(String bank) {
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		if (loan == null) {
			return null;
		}

		if (loan.equalsIgnoreCase("Home")) {
			return new HomeLoan();
		} else if (loan.equalsIgnoreCase("Business")) {
			return new BusinessLoan();
		} else if (loan.equalsIgnoreCase("Education")) {
			return new EducationLoan();
		}
		return null;
	}

}
