import java.util.Scanner;
 class InsufficientFundsException extends Exception
{
    InsufficientFundsException(String errorMessage)
    {
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception
{
    InvalidAmountException(String errorMessage)
    {
        super(errorMessage);
    }
}
class AccountBalance
{
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance=5000;

}


public class AtmMachineSimulation {
    static void withdraw(int withdrawAmount,int balance) throws InvalidAmountException,InsufficientFundsException
    {
        try
        {
            if(withdrawAmount>balance)
                throw new InsufficientFundsException("Account Balance is less than the withdrawal amount");
            if (withdrawAmount<=0)
            {
                throw new InvalidAmountException("Withdrawal amount is less than zero or in negative number");
            }
            else
            {
                balance-=withdrawAmount;
                System.out.println("Amount withdrawal successful!");
                System.out.println("Current Balance: "+balance);
            }
        }
        catch(InsufficientFundsException errorMessage)
        {
            System.out.println("Insufficient Funds Exception Caught");
        }
        catch (InvalidAmountException errorMessage)
        {
            System.out.println(errorMessage);
        }
    }
    static void deposit(int depositAmount,int balance)
    {
        balance+=depositAmount;
        System.out.println("Amount deposit successful!");
        System.out.println("Current Balance: "+balance);
    }
    static void checkBalance(int balance)
    {
        System.out.println("Balance: "+balance);
    }

    public static void main(String[] args) throws InvalidAmountException, InsufficientFundsException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the operation you want to do? 1.withdraw or 2.deposit or 3.check balance(W/D/C)");
        String operation=scanner.next();
        AccountBalance accountBalance=new AccountBalance();
        if(operation.equals("W"))
        {
            System.out.println("Enter the amount you want to withdraw:");
            int withdrawal_amount=scanner.nextInt();
            withdraw(withdrawal_amount,accountBalance.getBalance());
        }
        else if(operation.equals("D"))
        {
            System.out.println("Enter the amount you want to deposit:");
            int deposit_amount=scanner.nextInt();
            deposit(deposit_amount,accountBalance.getBalance());
        }
        else if (operation.equals("C"))
        {
            checkBalance(accountBalance.getBalance());
        }
        else
        {
            System.out.println("Invalid operation!!");
        }

    }
}
