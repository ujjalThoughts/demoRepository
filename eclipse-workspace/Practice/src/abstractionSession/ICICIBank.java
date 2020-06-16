package abstractionSession;

public class ICICIBank extends Finance implements USBank, RBI {//Class can extend only one class 
															//but can implement multiple Interfaces hence multiple Inheritance

	
	//RBI Methods:
	@Override
	public void educationLoan() {
		System.out.println("RBI---education Loan");
		
	}

	@Override
	public void homeLoan() {
		System.out.println("RBI---home Loan");
		
	}

	@Override
	public void carLoan() {
		System.out.println("RBI---Car Loan");
		
	}

	//USBank methods:
	@Override
	public void credit() {
		System.out.println("USBank---Credit");
		
	}

	@Override
	public void debit() {
		System.out.println("USBank---dedit");
		
	}

	@Override
	public void transferMoney() {
		System.out.println("USBank---transfer Money");
	}
		
		//ICICI Bank methods:
		public void mutualFunds()
		{
			System.out.println("ICICI---mutual funds");
		}
		
		public void insurance()
		{
			System.out.println("ICICI---Insurance");
		}
		
	}


