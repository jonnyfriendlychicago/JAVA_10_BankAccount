import java.lang.Math; 
public class BankAccountTest {

    public static void main (String[] args) {

        BankAccount bankAccountObj1 = new BankAccount("123ABC"); 

        bankAccountObj1.processFinAcctTransaction("SAV", 201.00); 
        bankAccountObj1.processFinAcctTransaction("SAV", -1.00); 

        bankAccountObj1.getCustomerAccountStatement(); 
        // bankAccountObj2.getCustomerAccountStatement(); 



        // bankAccountObj1.getCountOfCustomerAccounts(); 
        
    
    }
}