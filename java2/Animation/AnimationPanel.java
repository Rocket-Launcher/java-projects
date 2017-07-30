import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AnimationPanel extends JPanel implements ActionListener
{
   Sprite [] s = new Sprite[20];
   Random rng = new Random( );
   boolean firstClick = true;

   public AnimationPanel( )
   {
      // create new sprites
      for ( int k=0; k<20; k++ )
      {
         int w = 10 + rng.nextInt( 40 );
         int r = rng.nextInt( 256 );
         int g = rng.nextInt( 256 );
         int b = rng.nextInt( 256 );
         s[k] = new Sprite( new Dimension( w, w ), new Color( r, g, b ) );
         s[k].setArea( new Rectangle( 0, 0, 500, 500 ) );
      }
      // create javax.swing.Timer object that "goes off" every 10 milliseconds
      // this ActionListener responds when the timer goes off
      Timer timer = new Timer( 10, this );
      // don't start animation until user clicks mouse
      this.addMouseListener( new MouseAdapter( )
      {
         public void mouseReleased( MouseEvent e )
         {
            if ( firstClick )
            {
               // place sprite at mouse position       
               for ( int k=0; k<20; k++ )
               {
                  s[k].setPosition( new Point( e.getX( ), e.getY( ) ) );
                  s[k].animate( rng.nextInt( 20 )+5, rng.nextInt( 6 )-2, rng.nextInt( 7 )-3 );
               }
               timer.start( );
               firstClick = false;
            }
            else
            {
               for ( int k=0; k<20; k++ )
               {
                  if ( s[k] != null )
                     if ( s[k].contains( new Point( e.getX( ), e.getY( ) ) ) )
                        s[k] = null;
                        
               }
            }
        }
     });
   }
   
   public Dimension getPreferredSize( )
   {
      return new Dimension( 500, 500 );
   }
 
   public void paintComponent( Graphics g )
   // Draw the sprite onto the panel.
   {
      super.paintComponent( g );
      for ( int k=0; k<20; k++ )
      {
         if ( s[k] != null )
         {
            s[k].setArea( new Rectangle( 0, 0, this.getWidth( ), this.getHeight( ) ) );
            s[k].paint( g );
         }
      }
   }
      
   public void actionPerformed( ActionEvent e )
   // Repaint whenever the javax.swing.Timer object "goes off."
   {
       this.repaint( );
   }
}