import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MouseListenerDemo extends JFrame // implements MouseListener
{
   public static void main( String [] args )
   {
      new MouseListenerDemo( );
   }
   
   ArrayList<Integer> x = new ArrayList<Integer>( 5 );
   ArrayList<Integer> y = new ArrayList<Integer>( 5 );
   
   public MouseListenerDemo( )
   {
      // configure window
      super( "Mouse Listener Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      this.getContentPane( ).setBackground( Color.LIGHT_GRAY );
      this.addMouseListener( new MouseAdapter( )
         {
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
         }
      );
      this.setSize( 500, 500 );
      this.setVisible( true );
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