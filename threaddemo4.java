package threaddemo4;  //Program for deposit and withdrawal 


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class threaddemo4 {
// public class BankAccount {	

	  private double balance;
	  private Lock lock;

	  public threaddemo4() {
	    balance = 0.0;
	    lock = new ReentrantLock();
	  }

	  public void deposit(double amount) {
	    lock.lock();
	    try {
	      balance += amount;
	      System.out.println("Deposit: " + amount);
	      System.out.println("Balance after deposit: " + balance);
	    } finally {
	      lock.unlock();
	    }
	  }

	  public void withdraw(double amount) {
	    lock.lock();
	    try {
	      if (balance >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawal: " + amount);
	        System.out.println("Balance after withdrawal: " + balance);
	      } else {
	        System.out.println("Try to Withdraw: " + amount);
	        System.out.println("Insufficient funds. Withdrawal cancelled.");
	      }
	    } finally {
	      lock.unlock();
	    }
	  }

	  public static void main(String[] args) {
		  threaddemo4 account = new threaddemo4();
		  
		  // Thread evenn = new Thread(() -> obj.even());

	    Thread depositThread1 = new Thread(() -> account.deposit(2000));
	    Thread depositThread2 = new Thread(() -> account.deposit(500));
	    Thread withdrawalThread1 = new Thread(() -> account.withdraw(100));
	    Thread withdrawalThread2 = new Thread(() -> account.withdraw(1000));

	    depositThread1.start();
	    depositThread2.start();
	    withdrawalThread1.start();
	    withdrawalThread2.start();
	  }
	}
	
	
	


