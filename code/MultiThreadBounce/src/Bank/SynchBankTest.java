package Bank;

import java.util.concurrent.locks.ReentrantLock;

public class SynchBankTest
{
    public static final int NACCOUNTS = 100;
    public static final double INITAL_BALANCE = 1000;
    
    public static void main(String[] args)
    {
        Bank b = new Bank(NACCOUNTS, INITAL_BALANCE);
        ReentrantLock lock = new ReentrantLock();
        int i = 0;
        for(i = 0; i < NACCOUNTS; i++)
        {
            TransferRunnable f = new TransferRunnable(b, i, INITAL_BALANCE, lock);
            Thread t = new Thread(f);
            t.start();
        }
    }
}
