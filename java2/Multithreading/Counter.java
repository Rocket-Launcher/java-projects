import java.awt.*;
import javax.swing.*;
import static javax.swing.BorderFactory.*;

public class Counter extends Thread
{
   private int counter;
   private int delay;
   private JTextField txt;
   
   public Counter ( String name, JTextField t )
   {
      super( name );
      // set counter and delay
      counter = 0;
      delay = (int)( Math.random( ) * 1500 ) + 500;
      // save the text field in an instance variable
      txt = t;
      txt.setBorder( createTitledBorder ( createEtchedBorder( ), Integer.toString( delay ) ) );
   }
   
   public void run( )
   {
      try //need for Thread.sleep
      {
         while ( true )
         {
            counter++;
            txt.setText( Integer.toString( counter ) );
            Thread.sleep( delay );
            // sleep can throw InterruptedException
         }
      }
      catch ( InterruptedException e )
      {  // never happens probably
         System.err.println( Thread.currentThread( ).getName( ) + "HALTED during run" );
      }
      
   }
} 