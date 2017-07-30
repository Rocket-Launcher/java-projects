import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo3 extends JFrame 
{
   // Declare application commands
      
   public static void main ( String [] args )
   {
      new MenuDemo3( );
   }

   private JMenu createMenu( String name, char key )
   {
      JMenu temp = new JMenu( name ); // build
      temp.setMnemonic( key );        // set ALT-key
      temp.setFont( menufont );       // set font
      menuBar.add( temp );            // add to menu bar
      return temp;
   }

   public MenuDemo3( )
   { 
      // ** WINDOW
      super( "Menu Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // ** MENU BAR
      JMenuBar.setJMenuBar( menuBar ); // add to window
      this.add( menuBar );

      // Configure window and display
      this.setSize( 600, 300 );
      this.setVisible( true );
   }
}