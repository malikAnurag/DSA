package creationalDesignPatterns.abstractFactory.domainObject.Utility;

import abstractFactoryPattern.domainObject.Organisations.*;
import creationalDesignPatterns.abstractFactory.domainObject.Loans.Loan;
import creationalDesignPatterns.abstractFactory.domainObject.Organisations.Bank;
import creationalDesignPatterns.abstractFactory.domainObject.Organisations.HDFC;
import creationalDesignPatterns.abstractFactory.domainObject.Organisations.ICICI;
import creationalDesignPatterns.abstractFactory.domainObject.Organisations.SBI;

public class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		if (bank == null) {
			return null;
		}
		if (bank.equalsIgnoreCase("HDFC")) {
			return new HDFC();
		} else if (bank.equalsIgnoreCase("ICICI")) {
			return new ICICI();
		} else if (bank.equalsIgnoreCase("SBI")) {
			return new SBI();
		}
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		return null;
	}

}
