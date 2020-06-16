package interfaceSession;

public interface USBank  {

	int min_bal=1000;//Static and final in nature
	public void credit();
	
	public void debit();
	
	public void transferMoney();
	
	//Only Method Declaration
	//No Method Body-Only method Prototype-only method is defined
	//We can declare Variables here and they are static by default
	//Variable values are Final/Constant in nature
	//No static method can be defined in Interface
	//No Main Method can be defined as Main methods are Static by Default
	//We cannot create the object of interface
	//Interface are Abstract by Nature
	//Constructors cannot be created in an interface.
	
}
