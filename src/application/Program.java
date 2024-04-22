package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.ValueError;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balence = sc.nextDouble();
			System.out.print("withdrawLimit: ");
			double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, balence, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			acc.withdraw(amount);
			System.out.println();
			System.out.println(acc.toString());

			sc.close();
		} catch (ValueError e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}
}
