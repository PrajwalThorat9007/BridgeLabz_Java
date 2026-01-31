/*
Problem 2: Bank and Account Holders (Association)
Description: Model a relationship where a Bank has Customer objects associated with it. A Customer can have multiple bank accounts, and each account is linked to a Bank.
Tasks:
Define a Bank class and a Customer class.
Use an association relationship to show that each customer has an account in a bank.
Implement methods that enable communication, such as openAccount() in the Bank class and viewBalance() in the Customer class.
Goal: Illustrate association by setting up a relationship between customers and the bank.
 */
import java.util.ArrayList;

class Bank {
    private String bankName;
    private ArrayList<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // Association-based communication
    public Account openAccount(Customer customer, double initialBalance) {
        Account account = new Account(customer, this, initialBalance);
        accounts.add(account);
        System.out.println("Account opened for " + customer.getName() +
                " in " + bankName);
        return account;
    }

    public String getBankName() {
        return bankName;
    }
}
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Communication with Account
    public void viewBalance(Account account) {
        System.out.println("Customer: " + name +
                ", Balance: ₹" + account.getBalance());
    }
}
class Account {
    private Customer customer;
    private Bank bank;
    private double balance;

    public Account(Customer customer, Bank bank, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
public class AssociationBankAccountDemo {
    public static void main(String[] args) {

        Bank sbi = new Bank("State Bank of India");
        Customer prajwal = new Customer("Prajwal");

        Account account1 = sbi.openAccount(prajwal, 5000.00);

        prajwal.viewBalance(account1);
    }
}
