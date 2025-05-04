package creational.abstractFactory.domainObject.Utility;

import creational.abstractFactory.domainObject.Loans.BusinessLoan;
import creational.abstractFactory.domainObject.Loans.EducationLoan;
import creational.abstractFactory.domainObject.Loans.HomeLoan;
import creational.abstractFactory.domainObject.Loans.Loan;
import creational.abstractFactory.domainObject.Organisations.Bank;

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
