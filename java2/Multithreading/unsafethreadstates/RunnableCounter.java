import java.awt.*;

public class RunnableCounter implements Runnable
{
   private int counter;
   private int delay;
   private Label labDelay;
   private TextField txtCount;
   public static final int BORN = 0;
   public static final int RUNNING = 1;
   public static final int WAITING = 2;
   public static final int DEAD = 3;
   public int state; // the current state of the thread 
   
   public RunnableCounter( Label lab, TextField txt )
   {
      // copy parameters to instance variables
      labDelay = lab;
      txtCount = txt;
      // set counter and .5 to 2 sec., randomly selected, delay
      counter = 0;
      delay = (int)( Math.random( ) * 1500 ) + 500;
      state = BORN;
      // display delay
      labDelay.setText( Integer.toString( delay ) );  
   }

   public void run( )
   {
      try // Thread.sleep can throw InterruptedException
      {
         while ( state != DEAD )
         {
            counter++;              // increment counter
            txtCount.setText( Integer.toString( counter ) ); // display counter
            Thread.sleep( delay );  // sleep
            if ( state != RUNNING )
            { // not supposed to be running
               synchronized( this )
               { // wait for state change
                  while ( state != RUNNING )
                     wait( ); // poss. InterruptedException
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