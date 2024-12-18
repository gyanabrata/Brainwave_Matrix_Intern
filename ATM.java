package brainWaveMatrixSolutions;

import java.util.Scanner;

public class ATM 
{

    private static double balance = 5000.00; // Initial bank balance
    private static final int PIN = 1234; // Default PIN

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("         WELCOME TO ATM!!    ");
        System.out.println("=================================");
        
        if (!authenticate(scanner))
        {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        while (!exit)
        {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static boolean authenticate(Scanner scanner) 
    {
        int attempts = 0;
        while (attempts < 3) 
        {
            System.out.print("\nEnter your 4-digit PIN: ");
            int enteredPin = scanner.nextInt();
            if (enteredPin == PIN) 
            {
                System.out.println("Authentication successful.");
                return true;
            }
            else 
            {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }
        return false;
    }

    private static void checkBalance()
    {
        System.out.printf("\nYour current balance is: $%.2f\n", balance);
    }

    private static void depositMoney(Scanner scanner) 
    {
        System.out.print("\nEnter the amount to deposit: $ ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0)
        {
            balance += depositAmount;
            System.out.printf("$%.2f deposited successfully.\n", depositAmount);
            checkBalance();
        } 
        else
        {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdrawMoney(Scanner scanner) 
    {
        System.out.print("\nEnter the amount to withdraw: $ ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0) 
        {
            if (withdrawAmount <= balance)
            {
                balance -= withdrawAmount;
                System.out.printf("$%.2f withdrawn successfully.\n", withdrawAmount);
                checkBalance();
            } 
            else 
            {
                System.out.println("Insufficient balance. Please try a smaller amount.");
            }
        } 
        else 
        {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}
