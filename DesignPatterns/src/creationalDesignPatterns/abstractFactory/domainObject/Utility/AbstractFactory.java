package creationalDesignPatterns.abstractFactory.domainObject.Utility;

import creationalDesignPatterns.abstractFactory.domainObject.Loans.Loan;
import creationalDesignPatterns.abstractFactory.domainObject.Organisations.Bank;

public abstract class AbstractFactory {

	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);

}
