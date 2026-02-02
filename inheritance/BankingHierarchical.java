/*
Description: Model a banking system with different account types using hierarchical inheritance. BankAccount is the superclass, with SavingsAccount, CheckingAccount, and FixedDepositAccount as subclasses.
Tasks:
Define a base class BankAccount with attributes like accountNumber and balance.
Define subclasses SavingsAccount, CheckingAccount, and FixedDepositAccount, each with unique attributes like interestRate for SavingsAccount and withdrawalLimit for CheckingAccount.
Implement a method displayAccountType() in each subclass to specify the account type.
Goal: Explore hierarchical inheritance, demonstrating how each subclass can have unique attributes while inheriting from a shared superclass.
 */
//
package inheritance;
class BankAccount {
    String accountNumber; // account number
    double balance; // account balance

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber; // initializing account number
        this.balance = balance; // initializing balance
    }

    // method to display common account details
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    // method to be overridden
    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    double interestRate; // interest rate

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // calling parent constructor
        this.interestRate = interestRate; // initializing interest rate
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    int withdrawalLimit; // withdrawal limit per day

    CheckingAccount(String accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance); // calling parent constructor
        this.withdrawalLimit = withdrawalLimit; // initializing withdrawal limit
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    int tenure; // deposit tenure in years

    FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance); // calling parent constructor
        this.tenure = tenure; // initializing tenure
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenure + " years");
    }
}

// Main class
public class BankingHierarchical {
    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SB101", 50000, 4.5);
        BankAccount acc2 = new CheckingAccount("CA202", 30000, 20000);
        BankAccount acc3 = new FixedDepositAccount("FD303", 100000, 5);

        acc1.displayDetails();
        acc1.displayAccountType();
        System.out.println();

        acc2.displayDetails();
        acc2.displayAccountType();
        System.out.println();

        acc3.displayDetails();
        acc3.displayAccountType();
    }
}
