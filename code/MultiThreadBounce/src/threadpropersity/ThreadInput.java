package threadpropersity;

import java.util.Scanner;

public class ThreadInput implements Runnable
{
    
    private Scanner scanner = null;
    private Thread threadMonitor;
    
    ThreadInput(Thread threadMonitor)
    {
        this.threadMonitor = threadMonitor;
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        scanner = new Scanner(System.in);
        boolean isExit = false;
        while(!isExit)
        {
            System.out.println("what are you want?");
           
            String inputKey = scanner.next();
            
            if(inputKey.equalsIgnoreCase("quit"))
            {
                isExit = true;
                System.out.println("Input stop for thread.");
                threadMonitor.interrupt();
                
            }
            System.out.println("you say:" + inputKey);
        }
        
        scanner.close();
        System.out.println("Input thread say goodbye");
        
        
        /* 等待监控线程退出 */
        try
        {
            threadMonitor.join();
        }
        catch(InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
