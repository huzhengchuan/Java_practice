package threadpropersity;

import java.util.List;

/**
 * ����̣߳�������е����߳��Ƿ���ɣ����ҵȴ�
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
            /* ��monitor�̱߳�Ҫ���жϵ�ʱ��, ֪ͨ���е����߳��ж� */
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
