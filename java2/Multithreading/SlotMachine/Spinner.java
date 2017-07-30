import java.awt.*;
import javax.swing.*;

public class Spinner extends Thread
{
   // state values made public so other threads can access
   public static final int BORN    = 0;
   public static final int RUNNING = 1;
   public static final int WAITING = 2;
   public static final int DEAD    = 3;
   // state variable public so other threads can access
   public int state;
   // internal instance variables
   private int counter;
   private int delay;
   // instance variables for image array and display
   private Icon [] image;
   private JLabel display;
   public Spinner( Icon [] pics, JLabel lbl )
   {
      // copy param to instance vars
      image = pics;
      display = lbl;
      // set counter .25 to 1 sec
      counter = 0;
      delay = (int)( Math.random( ) * 750 ) + 250;
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
            if ( counter == image.length ) counter = 0;
            display.setIcon( image[counter] );
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