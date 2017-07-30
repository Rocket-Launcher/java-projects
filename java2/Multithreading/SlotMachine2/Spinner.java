import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Spinner extends Thread
{
   // state values made public so other threads can access
   public static final int BORN    = 0;
   public static final int RUNNING = 1;
   public static final int WAITING = 2;
   public static final int DEAD    = 3;
   // state variable public so other threads can access
   public volatile int state;
   // internal instance variables
   private int counter;
   private int delay;
   // instance variables for the image array and display
   private Icon [] image;
   private JLabel display;
   
   public synchronized void setMyState( int s )
   {
       state = s;
   }
   public synchronized int getMyState( )
   {
      return state;
   }
   
   public Spinner( Icon [] pics, JLabel lbl )
   {
      // copy parameters to the instance variables
      image = pics;
      display = lbl;
      // set counter and .25 to 1 sec., randomly selected, delay
      counter = 0;
      delay = (int)( Math.random( ) * 600 ) + 100;   
      //delay = 2000;
      // set state to BORN
      state = BORN;
      randomizeImages( );
   }
   
   public void run( )
   {
      try // Thread.sleep can throw InterruptedException
      {
         while ( state != DEAD )
         {
            counter++; // increment counter display image
            if ( counter == image.length ) counter = 0;
            display.setIcon( image[counter] );
            Thread.sleep( delay );  // sleep
            if ( state != RUNNING )
            {  // not supposed to be running
               synchronized( this ) 
               {  // wait for sta change
                  while ( state != RUNNING )
                     wait( );
               }
               randomizeImages( );
            }
         }
      }
      catch ( InterruptedException e )
      {  // this will probably never happen but we can't use a
         // throws construct on run because we're morphing it
         System.err.println( "Thread's sleep interrupted" );
      }
   }
   
   
   Random rng = new Random( );
   public void randomizeImages( )
   {
      for ( int k = image.length; k>1; k-- )
      {
         int r = rng.nextInt( k );
         Icon temp = image[r];
         image[r] = image[k-1];
         image[k-1] = temp;
         
      }
   
   }
}