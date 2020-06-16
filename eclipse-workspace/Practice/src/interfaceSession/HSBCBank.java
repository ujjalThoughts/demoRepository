package interfaceSession;

public class HSBCBank implements USBank, BrazilBank{//Attaining Multiple Inheritance, Interface to class relationship, implements keyword involved
	
	//If a class is implementing any Interface, it's mandatory to define/override all the methods declared in that Interface.
	
	//Overriding from USBank
	public void credit() {
		System.out.println("hsbc---credit");
	}
	
	public void debit() {
		System.out.println("hsbc---debit");
	}
	
	public void transferMoney() {
		System.out.println("hsbc---transferMoney");
	}
	
	//Seprate methods of HSBCBank
	public void educationLoan() {
		System.out.println("hsbc---educatioLoan");
	}
	
	public void carLoan() {
		System.out.println("hsbc---carLoan");
	}
	
	//BrazilBank interface Methods
	//Overriding from BrazilBank
	
public void mutualFund() {
	System.out.println("BrazilBank---mutualFund");
}

}