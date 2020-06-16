package javaPractice1;


public class AbstractClassDemo2 {

	public static void main(String args[]) {
		Iphone obj1=new Iphone();
		
		Samsung obj2=new Samsung();
		obj1.showConfig();
	}
//	public static void show(Phone obj2) {
//		
//		obj2.showConfig();
//	}
}

	abstract class Phone{
	
	abstract public void showConfig();
	}

class Iphone extends Phone
{
	public void showConfig() {
		
		System.out.println("4 GB, Ios 10.1");
}
}
	
	class Samsung extends Phone{
		
		public void showConfig() {
			
			System.out.println("6 GB,Nougat");
		}
	}

