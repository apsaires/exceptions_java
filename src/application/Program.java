package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert account data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Owner: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Inicial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Insert a withdraw amount: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
        }
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}