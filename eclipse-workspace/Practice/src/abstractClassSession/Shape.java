package abstractClassSession;

public abstract class Shape {

	Shape(){
		System.out.println("Shape Class Constructor");
	}
	
	int color;
	
	abstract void drawing();
	
	public void fill()
	{
		System.out.println("Shape---Fill");
	}
}

//We can create the constructor of Abstract class but we cannot create a constructor of an interface. 
