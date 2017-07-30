import javax.swing.*;
import java.awt.*;

public class FriendsDatabaseAccess
{
   public static void createAndShowGUI( )
   {
      // build the JFrame
      JFrame win = new JFrame( "Friends Database Access" );
      win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // build a JPanel to use as the window's content pane
      JComponent winContentPane1 = new JPanel( )
      {
         public Dimension getPreferredSize( )
         {
            return new Dimension( 400, 400 );
         }
      };
      JComponent winContentPane2 = new BrowseFriends( );
      win.setContentPane( winContentPane1 );
      // build and configure the window's menu bar
      JMenuBar winMenuBar = new JMenuBar( );
      win.setJMenuBar( winMenuBar );
      winMenuBar.add( new FileMenu( winContentPane2 ) );
      // size and display the window
      win.pack( );
      win.setVisible( true );
   }
   
   public static void main ( String [] args )
   {
      // schedule the frame creation on the event dispatch thread
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
}