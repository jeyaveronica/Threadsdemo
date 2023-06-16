package threaddemo;

public class threaddemo1 extends Thread {
	
	public void run() {
	System.out.println( "Iam Jeya");
	}	

	public static void main(String[] args) {
		threaddemo1 td1 = new threaddemo1();
		td1.start();

	}

}
