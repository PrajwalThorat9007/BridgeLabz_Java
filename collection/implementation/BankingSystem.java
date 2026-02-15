package collection.implementation;

/*
 * Question 5: Implement a Banking System
 *
 * Description:
 * - HashMap stores customer accounts (AccountNumber -> Balance)
 * - TreeMap sorts customers by balance
 * - Queue processes withdrawal requests
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankingSystem {

    // Customer class representing a bank customer
    static class Customer {
        private String customerId;
        private String name;
        private String email;
        private String phone;

        public Customer(String customerId, String name, String email, String phone) {
            this.customerId = customerId;
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        public String getCustomerId() {
            return customerId;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return String.format("%s (%s)", name, customerId);
        }
    }

    // Account class representing a bank account
    static class Account {
        private String accountNumber;
        private Customer customer;
        private double balance;
        private String accountType;
        private LocalDateTime createdDate;
        private List<Transaction> transactionHistory;

        public Account(String accountNumber, Customer customer, double initialBalance, String accountType) {
            this.accountNumber = accountNumber;
            this.customer = customer;
            this.balance = initialBalance;
            this.accountType = accountType;
            this.createdDate = LocalDateTime.now();
            this.transactionHistory = new ArrayList<>();

            // Record initial deposit
            if (initialBalance > 0) {
                addTransaction(new Transaction("DEPOSIT", initialBalance, "Initial deposit"));
            }
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public Customer getCustomer() {
            return customer;
        }

        public double getBalance() {
            return balance;
        }

        public String getAccountType() {
            return accountType;
        }

        public LocalDateTime getCreatedDate() {
            return createdDate;
        }

        public List<Transaction> getTransactionHistory() {
            return transactionHistory;
        }

        public void deposit(double amount) {
            this.balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount > balance) {
                return false;
            }
            this.balance -= amount;
            return true;
        }

        public void addTransaction(Transaction transaction) {
            transactionHistory.add(transaction);
        }

        @Override
        public String toString() {
            return String.format("Account[%s, %s, Type: %s, Balance: $%.2f]",
                    accountNumber, customer.getName(), accountType, balance);
        }
    }

    // Transaction class to track all transactions
    static class Transaction {
        private String type;
        private double amount;
        private String description;
        private LocalDateTime timestamp;
        private String transactionId;

        public Transaction(String type, double amount, String description) {
            this.type = type;
            this.amount = amount;
            this.description = description;
            this.timestamp = LocalDateTime.now();
            this.transactionId = "TXN" + System.currentTimeMillis();
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public String getDescription() {
            return description;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getTransactionId() {
            return transactionId;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
            return String.format("[%s] %s: $%.2f - %s (%s)",
                    transactionId, type, amount, description, timestamp.format(formatter));
        }
    }

    // Withdrawal Request class for queue processing
    static class WithdrawalRequest {
        private String accountNumber;
        private double amount;
        private String reason;
        private LocalDateTime requestTime;
        private String requestId;

        public WithdrawalRequest(String accountNumber, double amount, String reason) {
            this.accountNumber = accountNumber;
            this.amount = amount;
            this.reason = reason;
            this.requestTime = LocalDateTime.now();
            this.requestId = "REQ" + System.currentTimeMillis();
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getAmount() {
            return amount;
        }

        public String getReason() {
            return reason;
        }

        public LocalDateTime getRequestTime() {
            return requestTime;
        }

        public String getRequestId() {
            return requestId;
        }

        @Override
        public String toString() {
            return String.format("Request[%s, Account: %s, Amount: $%.2f, Reason: %s]",
                    requestId, accountNumber, amount, reason);
        }
    }

    // Bank Manager class
    static class BankManager {
        private Map<String, Account> accounts; // HashMap: AccountNumber -> Account
        private Map<String, Double> accountBalances; // HashMap: AccountNumber -> Balance
        private Queue<WithdrawalRequest> withdrawalQueue; // Queue for processing withdrawals
        private Map<String, Customer> customers; // Store customer information

        public BankManager() {
            this.accounts = new HashMap<>();
            this.accountBalances = new HashMap<>();
            this.withdrawalQueue = new LinkedList<>();
            this.customers = new HashMap<>();
        }

        // Register customer
        public void registerCustomer(Customer customer) {
            customers.put(customer.getCustomerId(), customer);
            System.out.println("Registered customer: " + customer);
        }

        // Create account
        public void createAccount(String accountNumber, String customerId, double initialBalance, String accountType) {
            Customer customer = customers.get(customerId);

            if (customer == null) {
                System.out.println("Error: Customer not found!");
                return;
            }

            if (accounts.containsKey(accountNumber)) {
                System.out.println("Error: Account number already exists!");
                return;
            }

            Account account = new Account(accountNumber, customer, initialBalance, accountType);
            accounts.put(accountNumber, account);
            accountBalances.put(accountNumber, initialBalance);

            System.out.println("Account created: " + account);
        }

        // Get account by number
        public Account getAccount(String accountNumber) {
            return accounts.get(accountNumber);
        }

        // Get balance from HashMap (fast lookup)
        public Double getBalance(String accountNumber) {
            return accountBalances.get(accountNumber);
        }

        // Deposit money
        public boolean deposit(String accountNumber, double amount, String description) {
            Account account = accounts.get(accountNumber);

            if (account == null) {
                System.out.println("Error: Account not found!");
                return false;
            }

            if (amount <= 0) {
                System.out.println("Error: Invalid deposit amount!");
                return false;
            }

            account.deposit(amount);
            accountBalances.put(accountNumber, account.getBalance());

            Transaction transaction = new Transaction("DEPOSIT", amount, description);
            account.addTransaction(transaction);

            System.out.printf("Deposit successful: $%.2f to %s. New Balance: $%.2f%n",
                    amount, accountNumber, account.getBalance());

            return true;
        }

        // Submit withdrawal request (adds to queue)
        public void submitWithdrawalRequest(String accountNumber, double amount, String reason) {
            Account account = accounts.get(accountNumber);

            if (account == null) {
                System.out.println("Error: Account not found!");
                return;
            }

            if (amount <= 0) {
                System.out.println("Error: Invalid withdrawal amount!");
                return;
            }

            WithdrawalRequest request = new WithdrawalRequest(accountNumber, amount, reason);
            withdrawalQueue.add(request);

            System.out.println("Withdrawal request submitted: " + request);
            System.out.println("Position in queue: " + withdrawalQueue.size());
        }

        // Process withdrawal requests from queue
        public void processWithdrawalRequests() {
            System.out.println("\n=== Processing Withdrawal Requests ===");

            if (withdrawalQueue.isEmpty()) {
                System.out.println("No withdrawal requests in queue.");
                return;
            }

            int processed = 0;
            int failed = 0;

            while (!withdrawalQueue.isEmpty()) {
                WithdrawalRequest request = withdrawalQueue.poll();
                System.out.println("\nProcessing: " + request);

                Account account = accounts.get(request.getAccountNumber());

                if (account.withdraw(request.getAmount())) {
                    accountBalances.put(account.getAccountNumber(), account.getBalance());

                    Transaction transaction = new Transaction("WITHDRAWAL",
                            request.getAmount(), request.getReason());
                    account.addTransaction(transaction);

                    System.out.printf("✓ Withdrawal approved: $%.2f from %s. New Balance: $%.2f%n",
                            request.getAmount(), account.getAccountNumber(), account.getBalance());
                    processed++;
                } else {
                    System.out.printf("✗ Withdrawal denied: Insufficient funds. Balance: $%.2f, Requested: $%.2f%n",
                            account.getBalance(), request.getAmount());
                    failed++;
                }
            }

            System.out.println("\n--- Processing Summary ---");
            System.out.println("Processed: " + processed);
            System.out.println("Failed: " + failed);
            System.out.println("Total: " + (processed + failed));
        }

        // Process single withdrawal request
        public void processNextWithdrawalRequest() {
            if (withdrawalQueue.isEmpty()) {
                System.out.println("No withdrawal requests in queue.");
                return;
            }

            WithdrawalRequest request = withdrawalQueue.poll();
            System.out.println("Processing: " + request);

            Account account = accounts.get(request.getAccountNumber());

            if (account.withdraw(request.getAmount())) {
                accountBalances.put(account.getAccountNumber(), account.getBalance());

                Transaction transaction = new Transaction("WITHDRAWAL",
                        request.getAmount(), request.getReason());
                account.addTransaction(transaction);

                System.out.printf("Withdrawal approved: $%.2f. New Balance: $%.2f%n",
                        request.getAmount(), account.getBalance());
            } else {
                System.out.printf("Withdrawal denied: Insufficient funds. Balance: $%.2f%n",
                        account.getBalance());
            }
        }

        // Transfer money between accounts
        public boolean transfer(String fromAccount, String toAccount, double amount, String description) {
            Account from = accounts.get(fromAccount);
            Account to = accounts.get(toAccount);

            if (from == null || to == null) {
                System.out.println("Error: One or both accounts not found!");
                return false;
            }

            if (from.withdraw(amount)) {
                to.deposit(amount);

                accountBalances.put(fromAccount, from.getBalance());
                accountBalances.put(toAccount, to.getBalance());

                from.addTransaction(new Transaction("TRANSFER_OUT", amount,
                        "Transfer to " + toAccount + " - " + description));
                to.addTransaction(new Transaction("TRANSFER_IN", amount,
                        "Transfer from " + fromAccount + " - " + description));

                System.out.printf("Transfer successful: $%.2f from %s to %s%n",
                        amount, fromAccount, toAccount);
                return true;
            } else {
                System.out.println("Transfer failed: Insufficient funds in source account!");
                return false;
            }
        }

        // Display all accounts sorted by balance (TreeMap)
        public void displayAccountsSortedByBalance() {
            System.out.println("=== Accounts Sorted by Balance ===");

            // Create TreeMap with custom comparator for sorting by balance
            TreeMap<String, Account> sortedAccounts = new TreeMap<>((acc1, acc2) -> {
                int balanceCompare = Double.compare(
                        accounts.get(acc2).getBalance(),
                        accounts.get(acc1).getBalance()
                );

                // If balances are equal, compare by account number
                if (balanceCompare == 0) {
                    return acc1.compareTo(acc2);
                }

                return balanceCompare;
            });

            sortedAccounts.putAll(accounts);

            int rank = 1;
            for (Account account : sortedAccounts.values()) {
                System.out.printf("%d. %s - Balance: $%.2f%n",
                        rank, account.getCustomer().getName(), account.getBalance());
                rank++;
            }
        }

        // Display all accounts from HashMap
        public void displayAllAccounts() {
            System.out.println("=== All Bank Accounts ===");

            if (accounts.isEmpty()) {
                System.out.println("No accounts in system.");
                return;
            }

            for (Account account : accounts.values()) {
                System.out.println(account);
            }
        }

        // Display pending withdrawal requests
        public void displayPendingWithdrawals() {
            System.out.println("=== Pending Withdrawal Requests ===");

            if (withdrawalQueue.isEmpty()) {
                System.out.println("No pending withdrawal requests.");
                return;
            }

            int position = 1;
            for (WithdrawalRequest request : withdrawalQueue) {
                System.out.println(position + ". " + request);
                position++;
            }
        }

        // Display account statement
        public void displayAccountStatement(String accountNumber) {
            Account account = accounts.get(accountNumber);

            if (account == null) {
                System.out.println("Error: Account not found!");
                return;
            }

            System.out.println("=== Account Statement ===");
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Customer: " + account.getCustomer().getName());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.printf("Current Balance: $%.2f%n", account.getBalance());
            System.out.println("\n--- Transaction History ---");

            List<Transaction> transactions = account.getTransactionHistory();
            if (transactions.isEmpty()) {
                System.out.println("No transactions.");
            } else {
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }
            }
        }

        // Get bank statistics
        public void displayBankStatistics() {
            System.out.println("=== Bank Statistics ===");
            System.out.println("Total Accounts: " + accounts.size());
            System.out.println("Total Customers: " + customers.size());
            System.out.println("Pending Withdrawal Requests: " + withdrawalQueue.size());

            double totalBalance = 0;
            for (Account account : accounts.values()) {
                totalBalance += account.getBalance();
            }

            System.out.printf("Total Bank Balance: $%.2f%n", totalBalance);

            if (!accounts.isEmpty()) {
                System.out.printf("Average Account Balance: $%.2f%n",
                        totalBalance / accounts.size());
            }

            // Find highest and lowest balance accounts
            if (!accounts.isEmpty()) {
                Account highest = null;
                Account lowest = null;

                for (Account account : accounts.values()) {
                    if (highest == null || account.getBalance() > highest.getBalance()) {
                        highest = account;
                    }
                    if (lowest == null || account.getBalance() < lowest.getBalance()) {
                        lowest = account;
                    }
                }

                System.out.println("\nHighest Balance: " + highest.getCustomer().getName() +
                        " - $" + String.format("%.2f", highest.getBalance()));
                System.out.println("Lowest Balance: " + lowest.getCustomer().getName() +
                        " - $" + String.format("%.2f", lowest.getBalance()));
            }
        }

        // Search accounts by balance range
        public List<Account> searchAccountsByBalanceRange(double minBalance, double maxBalance) {
            List<Account> result = new ArrayList<>();

            for (Account account : accounts.values()) {
                if (account.getBalance() >= minBalance && account.getBalance() <= maxBalance) {
                    result.add(account);
                }
            }

            result.sort((a1, a2) -> Double.compare(a2.getBalance(), a1.getBalance()));

            return result;
        }

        // Get number of pending requests
        public int getPendingRequestCount() {
            return withdrawalQueue.size();
        }
    }

    public static void main(String[] args) {
        BankManager bank = new BankManager();

        System.out.println("=== BANKING SYSTEM ===\n");

        // Register customers
        System.out.println("--- Registering Customers ---");
        bank.registerCustomer(new Customer("C001", "John Doe", "john@email.com", "555-0001"));
        bank.registerCustomer(new Customer("C002", "Jane Smith", "jane@email.com", "555-0002"));
        bank.registerCustomer(new Customer("C003", "Bob Johnson", "bob@email.com", "555-0003"));
        bank.registerCustomer(new Customer("C004", "Alice Brown", "alice@email.com", "555-0004"));
        bank.registerCustomer(new Customer("C005", "Charlie Davis", "charlie@email.com", "555-0005"));

        System.out.println();

        // Create accounts
        System.out.println("--- Creating Accounts ---");
        bank.createAccount("ACC001", "C001", 5000.00, "Savings");
        bank.createAccount("ACC002", "C002", 15000.00, "Checking");
        bank.createAccount("ACC003", "C003", 3000.00, "Savings");
        bank.createAccount("ACC004", "C004", 25000.00, "Premium");
        bank.createAccount("ACC005", "C005", 8000.00, "Checking");

        System.out.println();

        // Display all accounts
        bank.displayAllAccounts();
        System.out.println();

        // Perform deposits
        System.out.println("--- Deposits ---");
        bank.deposit("ACC001", 1000.00, "Salary deposit");
        bank.deposit("ACC003", 500.00, "Gift money");

        System.out.println();

        // Submit withdrawal requests (adds to queue)
        System.out.println("--- Submitting Withdrawal Requests ---");
        bank.submitWithdrawalRequest("ACC001", 500.00, "ATM withdrawal");
        bank.submitWithdrawalRequest("ACC002", 2000.00, "Bill payment");
        bank.submitWithdrawalRequest("ACC003", 5000.00, "Large purchase"); // Should fail
        bank.submitWithdrawalRequest("ACC004", 3000.00, "Travel expenses");
        bank.submitWithdrawalRequest("ACC005", 1500.00, "Shopping");

        System.out.println();

        // Display pending withdrawals
        bank.displayPendingWithdrawals();

        // Process withdrawal requests from queue
        bank.processWithdrawalRequests();

        System.out.println();

        // Display accounts sorted by balance (TreeMap)
        bank.displayAccountsSortedByBalance();

        System.out.println();

        // Transfer money
        System.out.println("--- Money Transfer ---");
        bank.transfer("ACC004", "ACC003", 2000.00, "Financial help");

        System.out.println();

        // Display updated balances sorted
        bank.displayAccountsSortedByBalance();

        System.out.println();

        // Display account statement
        bank.displayAccountStatement("ACC001");

        System.out.println();

        // Bank statistics
        bank.displayBankStatistics();

        System.out.println();

        // Search by balance range
        System.out.println("--- Accounts with Balance $5000-$15000 ---");
        List<Account> rangeAccounts = bank.searchAccountsByBalanceRange(5000, 15000);
        for (Account account : rangeAccounts) {
            System.out.println(account);
        }
    }
}