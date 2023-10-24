import java.util.HashMap;
import java.util.Scanner;

//import com.sun.xml.internal.stream.Entity.ScannedEntity;

public class ATM {

	public static void main(String[] args) {
		ATMop obj = new ATMop();
//		System.out.println();

	}

}

class Data {
	float balance;

}

class ATMop {

	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Data> map = new HashMap<>();

	ATMop() {
		System.out.println("***********************************************");
		System.out.println("Welcome to our ATM");
		op();
	}

	public void op() {
		System.out.println("***********************************************");
		System.out.println("Enter Your Pin Code");
		int pincode = sc.nextInt();

		if (map.containsKey(pincode) == true) {
			Data obj = map.get(pincode);
			menu(obj);

		} else {
			System.out.println("*******************************************");
			System.out.println("Please create account first");
			System.out.println("Set your pincode");
			int pin = sc.nextInt();
			Data obj = new Data();
			map.put(pin, obj);
			menu(obj);

		}

	}

	public void menu(Data obj) {
		System.out.println("************************************************");

		System.out.println("Please ENter a valid number ");
		System.out.println("1. Check Balance");
		System.out.println("2. deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. check another account");
		System.out.println("5. Exit");
		int x = sc.nextInt();
		if (x == 1) {
			check_balance(obj);
		} else if (x == 2) {
			deposit(obj);

		} else if (x == 3) {
			withdraw(obj);
		} else if (x == 4) {
			op();
		} else if (x == 5) {
			System.out.println("Thank you");
		} else {
			System.out.println("Please enter valid number");
			menu(obj);
		}

	}

	public void check_balance(Data obj) {
//		System.out.println("********************************************"); 
		System.out.println("Your Balance" + obj.balance);
		System.out.println("***********************************************");
		menu(obj);

	}

	public void deposit(Data obj) {
		System.out.println("Enter Your Ammount");
		float a = sc.nextFloat();
		obj.balance = obj.balance + a;
		System.out.println("Ammount Deposited Successfully");
		System.out.println("***********************************************");
		menu(obj);

	}

	public void withdraw(Data obj) {
		System.out.println("Withdraw Ammount");
		float a = sc.nextFloat();
		if (obj.balance >= a) {
			obj.balance = obj.balance - a;
			System.out.println("Amount withdraw Successfully");
		} else {
			System.out.println("Insufficient Balance");
		}

		System.out.println("***********************************************");
		menu(obj);

	}

}