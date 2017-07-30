import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class SingleThreadDemo extends Applet
{
   public void init( )
   {
      // create GUI
      JTextField txt1 = new JTextField( 10 );
      txt1.setFont( new Font( "Couier New", Font.BOLD, 18 ) );
      this.add( txt1 );
      // build and start the thread
      Counter runnable1 = new Counter( "Counter 1", txt1 );
      Thread c1 = new Thread( runnable1 );
      c1.start( );
   }
}