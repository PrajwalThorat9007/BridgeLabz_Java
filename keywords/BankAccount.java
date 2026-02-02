/*
Create a BankAccount class with the following features:
Static:
A static variable bankName shared across all accounts.
A static method getTotalAccounts() to display the total number of accounts.
This:
Use this to resolve ambiguity in the constructor when initializing accountHolderName and accountNumber.
Final:
Use a final variable accountNumber to ensure it cannot be changed once assigned.
Instanceof:
Check if an account object is an instance of the BankAccount class before displaying its details.
 */
package keywords;

class BankAccount{
    static String bankName="HDFC";
    static int NoAccounts=0;
    
    private String AccHolder;
    private final int AccNumber;
    
    //Constructor using this keyword
    BankAccount(String AccHolder,int AccNumber){
        this.AccHolder=AccHolder;
        this.AccNumber=AccNumber;
        NoAccounts++;
    }
    
    //Static method to show total accounts
    static void ShowDetails(Object obj){
        if(obj instanceof BankAccount){
            BankAccount acc=(BankAccount) obj;
            System.out.println("Bank Name: "+bankName);
            System.out.println("Holder: "+acc.AccHolder);
            System.out.println("Bank Account Number: "+acc.AccNumber);
            System.out.println("No of Total Accounts: "+NoAccounts);
        }
        else{
            System.out.println("Incorrect Object");
        }
    }

    //Main method
    public static void main(String[] args){
        BankAccount customer1=new BankAccount("Rohan",4567);
        
        ShowDetails(customer1);
    }
}