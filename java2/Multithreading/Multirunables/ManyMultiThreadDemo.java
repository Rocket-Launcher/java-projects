import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManyMultiThreadDemo extends Applet implements ActionListener
{
   Thread [] c = new Thread[10];

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getActionCommand( ) == "GO" )
      {
         for ( int k=0; k<10; k++ )
            c[k].start( );
         JButton b = (JButton)e.getSource( );
         b.setText( "STOP" );
      }
      else if ( e.getActionCommand( ) == "STOP" )
      {
         for ( int k=0; k<10; k++ )
            c[k].suspend( );
         JButton b = (JButton)e.getSource( );
         b.setText( "RESUME" );
      }
      else if ( e.getActionCommand( ) == "RESUME" )
      {
         for ( int k=0; k<10; k++ )
            c[k].resume( );
         JButton b = (JButton)e.getSource( );
         b.setText( "STOP" );
      }
      else
      ;
   }
   public void init( )
   {
      // create GUI
      JTextField [] txt = new JTextField[10];
      for ( int k=0; k<10; k++ )
      {
         txt[k] = new JTextField( 10 );
         txt[k].setFont( new Font( "Couier New", Font.BOLD, 18 ) );
         this.add( txt[k] );
      }
      JButton go = new JButton( "GO" );
      this.add( go );
      go.addActionListener( this );
      // build and start the thread
      for ( int k=0; k<10; k++ )
      {
         Counter runnable1 = new Counter( "Counter " + k, txt[k] );
         c[k] = new Thread( runnable1 );
         // start on button
      }
   }
}