package abstractFactoryPattern.domainObject.Utility;

import abstractFactoryPattern.domainObject.Loans.Loan;
import abstractFactoryPattern.domainObject.Organisations.Bank;

public abstract class AbstractFactory {

	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);

}
