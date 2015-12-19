package bounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * shows an animated bounding ball.
 * @author wxt
 *
 */
public class Bounce
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new BounceFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
            
        });
    }
    
    
    
}

/**
 * The frame with ball component and buttons.
 */
class BounceFrame extends JFrame
{
   private BallComponent comp;
   public static final int STEPS = 1000;
   public static final int DELAY = 3;

   /**
    * Constructs the frame with the component for showing the bouncing ball and Start and Close
    * buttons
    */
   public BounceFrame()
   {
      setTitle("Bounce");

      comp = new BallComponent();
      add(comp, BorderLayout.CENTER);
      JPanel buttonPanel = new JPanel();
      addButton(buttonPanel, "Start", new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               addBall();
            }
         });

      addButton(buttonPanel, "Close", new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }

   /**
    * Adds a button to a container.
    * @param c the container
    * @param title the button title
    * @param listener the action listener for the button
    */
   public void addButton(Container c, String title, ActionListener listener)
   {
      JButton button = new JButton(title);
      c.add(button);
      button.addActionListener(listener);
   }

   /**
    * Adds a bouncing ball to the panel and makes it bounce 1,000 times.
    */
   public void addBall()
   {
      Ball ball = new Ball();
      comp.add(ball);
      Runnable r = new BallRunnable(ball, comp);
      Thread t = new Thread(r);
      t.start();
    }
    
}

class BallRunnable implements Runnable
{
    private Ball ball;
    private BallComponent comp;
    
    public BallRunnable(Ball ball, BallComponent comp)
    {
        this.ball = ball;
        this.comp = comp;
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        try
        {
            for(int i = 1; i <= BounceFrame.STEPS; i++)
            {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(BounceFrame.DELAY);
            }
        }
        catch(InterruptedException e)
        {
            
        }
    }
}
