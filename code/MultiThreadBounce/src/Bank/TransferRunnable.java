package Bank;

import java.util.concurrent.locks.ReentrantLock;

public class TransferRunnable implements Runnable
{
    private Bank bank;
    private int fromAccount;
    private double maxAccount;
    private int DELAY = 10;
    private ReentrantLock lock;
    
    public TransferRunnable(Bank b, int from, double max, ReentrantLock lock)
    {
        bank = b;
        fromAccount =  from;
        maxAccount = max;
        this.lock = lock; //对象引用的拷贝，能够保证功能的实现
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        lock.lock();
        
        try
        {
            int toAccount = (int) (bank.size() * Math.random());
            double amount = maxAccount * Math.random();
            
            bank.transfer(fromAccount, toAccount, amount);
            Thread.sleep((int)(DELAY * Math.random()));
        }
        catch(InterruptedException e)
        {
            
        }finally
        {
            lock.unlock();
        }
        
    }
    
    
}
