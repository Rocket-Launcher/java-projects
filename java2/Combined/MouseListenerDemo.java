import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MouseListenerDemo extends JPanel implements MouseListener, MouseMotionListener
{
   public static void main( String [] args )
   {
      SwingUtilities.invokeLater(
         new Runnable( )
         {
            public void run( )
            {
               createAndShowGUI( );
            }
         }
      );   
   }
   
   public static void createAndShowGUI( )
   {
      JFrame win = new JFrame( "Jesse's Draw Program" );
      win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      win.getContentPane( ).setBackground( Color.LIGHT_GRAY );
      MouseListenerDemo app = new MouseListenerDemo( );
      win.add( app );
      win.pack( );
      win.setVisible( true );
   }
   ArrayList<Integer> x = new ArrayList<Integer>( 5 );
   ArrayList<Integer> y = new ArrayList<Integer>( 5 );
   
   public Dimension getPreferredSize( )
   {
      return new Dimension( 500, 500 );
   }
      
   public void mouseClicked( MouseEvent e )
   {
      x.add( e.getX( ) ); // add x-coord to array
      y.add( e.getY( ) ); // add y-coord to array
      repaint( );
   }
   
   public void mouseExited( MouseEvent e )
   {
      x.clear( );
      y.clear( );
      repaint( );
   }
   
   // 
   private String msg = "";  // message
   private Color activeColor = new Color( 255, 255, 204 );
      
   public void paint( Graphics g )
   // Inherited from java.awt.Component, this renders the component.
   {
      super.paint( g );
      g.setColor( Color.black );
      for ( int k = 1; k < x.size( ); k++ )
         g.drawLine( x.get( k-1 ), y.get( k-1 ), x.get( k ), y.get( k ) );
   }
}