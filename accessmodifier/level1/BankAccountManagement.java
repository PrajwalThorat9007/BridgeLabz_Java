/*Problem 3: Bank Account Management
Create a BankAccount class with:
accountNumber (public).
accountHolder (protected).
balance (private).
Write methods to:
Access and modify balance using public methods.
Create a subclass SavingsAccount to demonstrate access to accountNumber and accountHolder. */
// Base class representing a bank account
class BankAccount {

    // Public account number accessible everywhere
    public String accountNumber;

    // Protected account holder name accessible to subclasses
    protected String accountHolder;

    // Private balance to ensure data encapsulation
    private double balance;

    // Constructor to initialize bank account details
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to safely access balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit amount into account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw amount if sufficient balance exists
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}

// Derived class representing a savings account
class SavingsAccount extends BankAccount {

    // Interest rate specific to savings account
    double interestRate;

    // Constructor to initialize savings account details
    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to display savings account details
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate);
    }
}

// Main class to manage bank account operations
public class BankAccountManagement {
    public static void main(String[] args) {

        // Create a savings account object
        SavingsAccount sa = new SavingsAccount("SB1001", "Prajwal", 5000, 4.5);

        // Display initial account details
        sa.displayDetails();

        // Perform deposit and withdrawal operations
        sa.deposit(2000);
        sa.withdraw(1500);

        // Display updated balance
        System.out.println("Updated Balance: " + sa.getBalance());
    }
}
