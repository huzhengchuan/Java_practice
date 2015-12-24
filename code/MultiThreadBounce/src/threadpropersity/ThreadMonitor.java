package threadpropersity;

import java.util.List;

/**
 * 监控线程，监控所有的子线程是否完成，并且等待
 * @author wxt
 *
 */
public class ThreadMonitor implements Runnable
{
    private List<Thread> childThreads = null;
    
    public ThreadMonitor(List<Thread> childThreads)
    {
        // TODO Auto-generated constructor stub
        this.childThreads = childThreads;
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        while(!Thread.currentThread().isInterrupted())
        {
            /* 当monitor线程被要求中断的时候, 通知所有的子线程中断 */
            for(Thread child : childThreads)
            {
             //   System.out.println(childThreads.toString() + "is interrupted.");
                child.interrupt();
            }
            
        }
        for(Thread child : childThreads)
        {
            try
            {
                child.join();
            }
            catch(InterruptedException e)
            {
                // TODO Auto-generated catch block
                System.out.println(e);
            }
        }
        System.out.println("Thread monitor is end!");
    }
}
