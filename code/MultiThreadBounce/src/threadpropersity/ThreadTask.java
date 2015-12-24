package threadpropersity;

public class ThreadTask implements Runnable
{

    private int id;
    
    public ThreadTask(int id)
    {
        this.id = id;
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        System.out.println("Thread Start working");
        while(true)
        {
            if(Thread.currentThread().isInterrupted())
            {
               System.out.println("The child thread is interrupted and end :" + toString());
               break;
            }
            
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException e)
            {
                // TODO Auto-generated catch block
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public String toString()
    {
        return new StringBuilder().append("Thread task:" + id).toString();
    }
    
}


class node
{
    
}
