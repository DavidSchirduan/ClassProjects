/**
 * class Driver - executes the Bank class's methods
 * 
 * @author Pharr
 * @version 2010/01/19
 */
public class Driver
{
    public static void main(String [] args)
    {
        Bank b = new Bank();
        System.out.println("Opening account for Smith with $1000 balance");
        System.out.println("and interest rate of 2.5%.");
        b.addAccount("Smith", 1000, 2.5);
        b.printAccounts();
        System.out.println("\nApplying interest");
        b.applyInterest();
        b.printAccounts();
        System.out.println("\nDepositing $100");
        b.deposit(100);
        b.printAccounts();
        System.out.println("\nWithdrawing $200");
        b.withdraw(200);
        b.printAccounts();
        System.out.println("\nDepositing $-500 (negtive deposit)");
        b.deposit(-500);
        b.printAccounts();
                
    }
}
