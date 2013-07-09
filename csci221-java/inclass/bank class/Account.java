import java.text.NumberFormat;

/**
 * class Account - a simple bank account
 * 
 * @author Pharr
 * @version 2009/09/27; modified 2010/01/19
 */
public class Account
{
    private int number;       // account number
    private double balance;   // cash o hand
    private double interest;  // interest rate paid on account
    private String name;      // owner's number

    /**
     * Constructor for objects of class Account
     */
    public Account(int acctNumber, String customerName, double openingBalance)
    {
        number = acctNumber;
        name = customerName;
        if (openingBalance < 0.0) {
            balance = 0.0;
        }
        else {
            balance = openingBalance;
        }
        interest = 0.035;
    }
    
    /**
     * Constructor for objects of class Account
     */
    public Account(int acctNumber, String customerName, double openingBalance, double intRate)
    {
        number = acctNumber;
        name = customerName;
        balance = 0.0;
        deposit(openingBalance);
        if (intRate < 0.0) {
            interest = 0.0;
        }
        else {
            interest = intRate / 100.0;
        }
    }
    
    /**
     * getAccountNumber
     * 
     * @param  none
     * @return int account number 
     */
    public int getAccountNumber()
    {
        return number;
    }

    /**
     * getName
     * 
     * @param  none
     * @return String name 
     */
    public String getName()
    {
        return name;
    }

    /**
     * getBalance
     * 
     * @param  none
     * @return double balance 
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * deposit
     * 
     * @param  amount   amount to be deposited
     * @return double balance - new balance
     */
    public void deposit(double amount)
    {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    /**
     * withdraw
     * 
     * @param  amount   amount to be withdrawn
     * @return double balance - new balance
     */
    public void withdraw(double amount)
    {
        if (amount > 0) {
            balance = balance - amount;
        }
    }
    
    /**
     * addInterest
     * 
     * @param  none
     * @return double balance - new balance
     */
    public double addInterest()
    {
        balance = balance + balance * interest;
        return balance;
    }

    /**
     * print
     * 
     * @param  none
     * @return none
     */
    public void print()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Account number: " + number);
        System.out.println("Name:           " + name);
        System.out.println("Balance:        " + fmt.format(balance));        
    }
}
