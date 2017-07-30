import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class MultiThreadDemo extends Applet
{
   public void init( )
   {
      // create GUI
      JTextField txt1 = new JTextField( 10 );
      txt1.setFont( new Font( "Couier New", Font.BOLD, 18 ) );
      this.add( txt1 );
      JTextField txt2 = new JTextField( 10 );
      txt2.setFont( new Font( "Couier New", Font.BOLD, 18 ) );
      this.add( txt2 );
      // build and start the thread
      Counter runnable1 = new Counter( "Counter 1", txt1 );
      Thread c1 = new Thread( runnable1 );
      c1.start( );
      Counter runnable2 = new Counter( "Counter 2", txt2 );
      Thread c2 = new Thread( runnable2 );
      c2.start( );
   }
}