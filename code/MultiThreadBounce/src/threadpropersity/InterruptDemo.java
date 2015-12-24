package threadpropersity;

import java.util.ArrayList;
import java.util.List;

/**
*
*@author wxt
*@version 
*/
public class InterruptDemo
{
  
    public static final void main(String[] args)
    {
        List<Thread> childTasks = new ArrayList<>();
        
        /* 创建子线程 */
        for(int i = 0; i < 10; i++)
        {
            Thread childTask = new Thread(new ThreadTask(i));
            childTasks.add(childTask);
            childTask.start();
        }
        
        /* 启动监控线程 */
        Thread monitorTask = new Thread(new ThreadMonitor(childTasks));
        monitorTask.start();
        
        /* 启动用户交互线程 */
        Thread inputTask = new Thread(new ThreadInput(monitorTask));
        inputTask.start();
        
        try
        {
            inputTask.join();
        }
        catch(InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("The main progress say goodBye!");
        
    }
    
}
