package threadpropersity;

/**
*
*@author wxt
*@version 
*/
public class InterruptDemo
{
  
    public static final void main(String[] args)
    {
        Runnable task = new ThreadTask();
        Thread  newThread = new Thread(task);
        
        newThread.start();
    }
    
}
