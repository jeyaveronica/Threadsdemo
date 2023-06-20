package transientdemo;

//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.io.*;
//import java.security.Identity;

class A implements Serializable {
	
	transient int a;
	int a1;
	transient char b;
	transient boolean c;
	transient double d;
	transient String password;
	
	void display() 
	{
	System.out.println(a+ "\t"  +a1+ "\t" +b+ "\t" +c+ "\t" +d+ "\t" +password); 
	//System.out.println(a+ "\n" +b+ "\n" +c); 
	}
}
	
	
  public class transientdemo 
  {
  
  
  public static void main(String[] args) 
  {	  
	  try {		
		A obj = new A();
		obj.a = 10;
		obj.a1 = 20;
		obj.b = 'B';
		obj.c = true;
		obj.d = 1.2;
		obj.password = " ABC";
		obj.display();
		
		// Serialization
		
		  FileOutputStream fos = new FileOutputStream("abcd.txt");  //persistent storage of objects can be accompilshed using file.
		  ObjectOutputStream oos = new ObjectOutputStream(fos); //  ObjectOutputStream - It write object to file
		  oos.writeObject(obj); // (object to stream)// Writes the specified object to the ObjectOutputStream
		  fos.close(); // Closes this file output stream and releases any system resources associated with this stream. 
		                    //This file output stream may no longer be used for writing bytes. 
		  oos.close(); 
		  System.out.println( "Serialization is done"); // The process of converting object to stream. Then, it is saved to a file or db. 
		 
		
		// Deserialization
		  
		FileInputStream fis = new FileInputStream("abcd.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		A obj2 = (A)ois.readObject();  //(stream to object)// It will return object data in 
		                               //object class format. So downcast that into class A format and store that in obj2
		obj2.display();
		fis.close();
		ois.close();
		System.out.println( "Deserialization is done");
		
	  }
	  catch (Exception e) {
		  System.out.println(" File is not found");
		
	}

	}
}
  


