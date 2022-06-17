import java.lang.Math; 
class BankAccount {

    private String customerAccountNumber; 
    private double checkingBalance; 
    private double savingsBalance; 
    public static int numberOfBankAccountObjects = 0; 
    public static double totalDollarsHeldInAllAcctObj = 0; 

    public double checkingBalanceGetter() {return checkingBalance;}
    public void checkingBalanceSetter(double checkingBalance) {checkingBalance = this.checkingBalance;}

    public double savingsBalanceGetter() {return savingsBalance;}
    public void savingsBalanceSetter( double savingsBalance) {savingsBalance = this.savingsBalance;} 

    public String customerAccountNumberGetter() {return customerAccountNumber;}
    public void customerAccountNumberSetter( String customerAccountNumber) {customerAccountNumber = this.customerAccountNumber;}

    public BankAccount(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
        numberOfBankAccountObjects += 1; 
        System.out.printf("::: New Customer Account initiated.\n    New Customer Account created.\n    Customer Acct#: " + customerAccountNumber + "\n"); 
        }
    
    public void processFinAcctTransaction(String acctType, double transAmt) {
        
        // below are default values that get changed depending on incoming data
        String acctTypePrintVers = "Savings"; 
        double acctBalancePrintVers = 0.00; 
        String transTypePrintVers = "Deposit"; 

        System.out.println("::: Transaction initiated."); 

        if (acctType != "SAV" && acctType != "CHK") {
            System.out.println("    Invalid AcctType submitted.  Transaction cancelled."); 
        // above tested and proven    
        } else if (transAmt == 0.0) {
            System.out.println("    Invalid $0.00 transaction amount submitted.  Transaction cancelled."); 
        // above tested and proven
        } else if (transAmt <0 &&  ( (acctType == "SAV" && savingsBalance < Math.abs(transAmt)) || (acctType == "CHK" && checkingBalance < Math.abs(transAmt))    ) ) {
                
                if (acctType == "CHK" ) acctTypePrintVers = "Checking";

                System.out.println("    $" + Math.abs(transAmt) + " withdrawl attempted from " + acctTypePrintVers + " account."); 
                System.out.println("    Insufficient Funds."); 
                System.out.println("    Current Savings Balance: $" + savingsBalance); 
                System.out.println("    Current Checking Balance: $" + checkingBalance); 
                System.out.println("    Transaction cancelled."); 
        } else {
                totalDollarsHeldInAllAcctObj += transAmt;
                
                if (acctType == "SAV" ) {
                    savingsBalance += transAmt; 
                    acctBalancePrintVers = savingsBalance; 
                } else  {
                    checkingBalance += transAmt; 
                    acctBalancePrintVers = checkingBalance;
                    acctTypePrintVers = "Checking";
                }

                if (transAmt < 0) {transTypePrintVers = "Withdrawl"; }

                System.out.println("    Customer Acct: " + customerAccountNumber); 
                System.out.println("    Account Type: " + acctTypePrintVers); 
                System.out.println("    Transaction Type: " + transTypePrintVers); 
                System.out.println("    Amt: " + transAmt); 
                System.out.println("    New " + acctTypePrintVers + " Acct Bal: $" + acctBalancePrintVers); 
        } 
    } 
        // } 
        // else if (transAmt >0 ) {
        //     if (acctType == "SAV") {
        //         savingsBalance += transAmt; 
        //         acctBalancePrintVers = savingsBalance; 
        //     } else {
        //         checkingBalance += transAmt; 
        //         acctTypePrintVers = "Checking";
        //         acctBalancePrintVers = checkingBalance;
        //     }
        // System.out.println("::: Deposit made for Customer Acct: " + customerAccountNumber); 
        // System.out.println("Account Type: " + acctTypePrintVers); 
        // System.out.println("Deposit Amt: " + transAmt); 
        // System.out.println("New " + acctTypePrintVers + " Acct Bal: $" + acctBalancePrintVers); 
        // // above tested and proven
        // else  {
        //     System.out.println("Error: exceptional circumstances encountered that are not supported."); 
        // }
    
    

    public void getCustomerAccountStatement () {
        System.out.println("::: Statement for Customer Acct#: " + customerAccountNumber); 
        System.out.println("    Checking Acct Bal: $" + checkingBalance); 
        System.out.println("    Savings Acct Bal: $" + savingsBalance); 
    }

    public void getCountOfCustomerAccounts() {
        System.out.println("Count of Customer Accounts: " + numberOfBankAccountObjects); 
    }
}