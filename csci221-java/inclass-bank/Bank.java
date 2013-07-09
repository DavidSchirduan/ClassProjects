import java.util.ArrayList;

/**
 * class Bank - a small bank with simple accounts
 * 
 * @author Pharr
 * @version 2010/01/14
 */
public class Bank
{
    private int nextAccount;
    private Account customer;
    // Interest Rate   currently set at 2.5 percent
    private double interest = 2.5;

    /**
     * Constructor for objects of class Bank
     */
    public Bank()
    {
        nextAccount = 101;
    }

    /**
     * addAccount
     * 
     * @param  String name
     *         double beginning balance
     *         
     * @return     void 
     */
    public void addAccount(String name, double balance)
    {
        // Account Number   determined from nextAccount
        int accNumber = nextAccount;
        nextAccount++;
        customer = new Account(accNumber, name, balance);
    }
        
    /**
     * addAccount
     * 
     * @param  String name
     *         double beginning balance
     *         double beginning interest rate
     *         
     * @return     void 
     */
    public void addAccount(String name, double balance, double interest)
    {
        // Account Number   determined from nextAccount
        int accNumber = nextAccount;
        nextAccount++;
        customer = new Account(accNumber, name, balance, interest);
    }
        
    /**
     * deposit
     * 
     * @param  double amount    amount being deposited
     *         
     * @return     double new balance 
     */
    public void deposit(double amount)
    {
        customer.deposit(amount);
    }
    
    /**
     * withdraw
     * 
     * @param  double amount    amount being deposited
     *         
     * @return     double new balance 
     */
    public void withdraw(double amount)
    {
        customer.withdraw(amount);
    }
    
    /**
     * printAccounts
     * 
     * @param  none
     *         
     * @return none
     */
    public void printAccounts()
    {
        customer.print();
    }
    
    /**
     * applyInterest
     * 
     * @param  none
     *         
     * @return none
     */
    public void applyInterest()
    {
        customer.addInterest();
    }
}
