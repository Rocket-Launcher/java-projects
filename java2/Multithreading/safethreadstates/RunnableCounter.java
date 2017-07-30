import java.awt.*;

public class RunnableCounter implements Runnable
{
   // state values made public so other threads can access
   public static final int BORN    = 0;
   public static final int RUNNING = 1;
   public static final int WAITING = 2;
   public static final int DEAD    = 3;
   // state variable public so other threads can access
   // made volatile so multiple threads access it 
   // with mutual exclusion
   public volatile int state;
   // internal instance variables
   private int counter;
   private int delay;
   private Label labDelay;
   private TextField txtCount;
   
   public RunnableCounter( Label lab, TextField txt )
   {
      // copy parameters to instance variables
      labDelay = lab;
      txtCount = txt;
      // set counter and .5 to 2 sec., randomly selected, delay
      counter = 0;
      delay = (int)( Math.random( ) * 500 ) + 500;
      // display delay
      labDelay.setText( Integer.toString( delay ) );  
      // set state to BORN
      state = BORN;
   }

   public void run( )
   {
      try // Thread.sleep can throw InterruptedException
      {
         while ( state != DEAD )
         {
            counter++; // increment counter display it
            txtCount.setText( Integer.toString( counter ) );
            Thread.sleep( delay );  // sleep
            if ( state != RUNNING )
            {  // not supposed to be running
               synchronized( this ) 
               {  // wait for state change
                  while ( state != RUNNING )
                     wait( );
               }
            }
         }
      }
      catch ( InterruptedException e )
      {  // this will probably never happen but we can't use a
         // throws construct on run because we're morphing it
         System.err.println( "Thread's sleep interrupted" );
      }
   }
}