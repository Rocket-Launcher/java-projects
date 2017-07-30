import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.BorderFactory.*;
import static javax.swing.Box.*;

public class BrowseFriends extends JPanel
{
   public Dimension getPreferredSize( )
   {
      return new Dimension( 300, 250 );
   }
   public BrowseFriends( )
   {
      this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      this.add( new FriendsDataForm( ) );
      this.add( createVerticalStrut( 25 ) );
      this.add( new BrowseForm( ) );
   
   }
}