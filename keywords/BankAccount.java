class BankAccount{
    static String bankName="HDFC";
    static int NoAccounts=0;
    
    private String AccHolder;
    private final int AccNumber;
    
    BankAccount(String AccHolder,int AccNumber){
        this.AccHolder=AccHolder;
        this.AccNumber=AccNumber;
        NoAccounts++;
    }
    
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
    
    public static void main(String[] args){
        BankAccount customer1=new BankAccount("Rohan",4567);
        
        ShowDetails(customer1);
    }
}