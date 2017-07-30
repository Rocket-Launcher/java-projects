import java.applet.*;
import javax.swing.*;

public class SlotMachineApplet extends Applet
{
   public final int IMAGE_COUNT = 9;
   public Icon [] image = new ImageIcon[IMAGE_COUNT];
   public JLabel s1Display = new JLabel( );

   public void init( )
   {
      initImageList( );
      createGUI( );
      Spinner s1 = new Spinner( image, s1Display );
      s1.start( );
      s1.state = Spinner.RUNNING;
   }
   
   public void initImageList( )
   {
      for ( int k=0; k<IMAGE_COUNT; k++ )
         image[k] = new ImageIcon( getClass( ).getResource( "thumbnail" + k + ".jpg" ) );
   
   }

   public void createGUI( )
   {
      this.add( s1Display );
   
   }

}