package abstractionSession;

public class TestBank {

	public static void main(String[] args) {
		
		ICICIBank a=new ICICIBank();
		a.educationLoan();
		a.homeLoan();
		a.carLoan();
		a.stock();
		
		System.out.println("*****************************************");
		
		a.credit();
		a.debit();
		a.transferMoney();
		
		System.out.println("*****************************************");
		
		a.mutualFunds();
		a.insurance();
		
		System.out.println("*****************************************");
		
		USBank b=new ICICIBank();// 'b' is the reference variable and "new ICICIBank" is the object
		b.credit();
		b.debit();
		b.transferMoney();
		//No other methods from RBI is accessible as object is created with USBank reference variable. 

	}

}
