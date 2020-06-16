package abstractClassSession;

public class Test extends Shape{

	Test()
	{
		System.out.println("Test Class Constructor");
	}
	public static void main(String[] args) {
		
			Shape s=new Test();
			s.drawing();
			s.fill();
	System.out.println("****************************************");
			Test t=new Test();//Parent class constructor will be called first then the child class constructor
	}

	@Override
	void drawing() {
		System.out.println("Test---Drawing");
		
	}

}
