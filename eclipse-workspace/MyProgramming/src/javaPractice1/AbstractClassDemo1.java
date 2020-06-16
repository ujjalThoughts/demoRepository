package javaPractice1;


public class AbstractClassDemo1 {

	public static void main(String args[]) {
		KamleshPhone obj1=new KamleshPhone();
		obj1.call();
		obj1.song();
		obj1.camera();
		obj1.video();
	}
}
//Abtract Class
abstract class MaheshPhone
{
	public void call()
	{
		System.out.println("calling...");
	}
	abstract public void song();//Abstract Methods
	abstract public void camera();
	abstract public void video();	
}
//Abtract Class
abstract class SureshPhone extends MaheshPhone
{
	public void song() {
		
		System.out.println("Singing...");
	}
	abstract public void camera();
	abstract public void video();
	
}
//concrete class
class KamleshPhone extends SureshPhone{
	
	public void camera() {
		
		System.out.println("Photo...");
	}
	public void video() {
		
		System.out.println("Videography...");
		
		
	}
}