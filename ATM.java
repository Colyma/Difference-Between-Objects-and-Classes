import java.util.Scanner;

public class ATM
{
    // Attributes (fields)
    String accountNumber;
    String accountType;
    double balance;

    // Constructor to initialize the object
    public Account(String accountNumber, String accountType, double balance) 
    {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
    // Method to credit an amount to the account
    public void credit(double amount) 
    {
        balance += amount;
        System.out.println("Credited " + amount + " to account " + accountNumber + ". New balance: " + balance);
    }

    // Method to debit an amount from the account
    public void debit(double amount) 
    {
        if (amount <= balance) 
        {
            balance -= amount;
            System.out.println("Debited " + amount + " from account " + accountNumber + ". New balance: " + balance);
        } 
        else 
        {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    // Method to check the balance
    public void checkBalance() 
    {
        System.out.println("Account " + accountNumber + " has a balance of: " + balance);
    }

    // Main method to simulate an ATM
    public static void main(String[] args) 
    {
        // Creating an object of the Account class
        Account myAccount = new Account("123456789", "Savings", 1000.00);
        
        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) 
        {
            // Display ATM menu
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            // Get user choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Perform actions based on user choice
            switch (choice) 
            {
                case 1: // Check balance
                    myAccount.checkBalance();
                    break;
                case 2: // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    myAccount.credit(depositAmount);
                    break;
                case 3: // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.debit(withdrawAmount);
                    break;
                case 4: // Exit
                    System.out.println("Exiting ATM...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close scanner
        scanner.close();
    }
}
