package creational.abstractFactory.domainObject.Utility;

import creational.abstractFactory.domainObject.Loans.Loan;
import creational.abstractFactory.domainObject.Organisations.Bank;

public abstract class AbstractFactory {

	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);

}
