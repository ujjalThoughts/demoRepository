package interfaceSession;

public class TestBank {

	public static void main(String[] args) {
		
		System.out.println(USBank.min_bal);//Since min_bal is static in nature, need to call it using interface name.
		HSBCBank a=new HSBCBank();
		a.credit();
		a.debit();
		a.transferMoney();
		a.educationLoan();
		a.carLoan();
		System.out.println("**********************************************");
		
		//Dynamic Polymorphism
		//Child class object can b referred by parent Interface reference variable
		USBank b=new HSBCBank();
		b.credit();
		b.debit();
		b.transferMoney();
		//b.educationLoan();  cannot be referred as only those methods which are defined in child class can be referred by parent interface
		//b.carLoan();
		
		System.out.println("****************************************");
		BrazilBank c= new HSBCBank();
		c.mutualFund();
	}

}
