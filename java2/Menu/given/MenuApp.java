import javax.swing.*;
import java.awt.*;

public class MenuApp extends JFrame
{
   public static void main ( String [] args )
   {
      new MenuApp( );
   }
   
   public MenuApp( )
   { 
      // ** WINDOW
      super( "Menu Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // ** MENU BAR
      JMenuBar menuBar = new JMenuBar( ); // build 
      this.setJMenuBar( menuBar );        // add to window
      // add menus
      FileMenu fileMenu = new FileMenu( );
      EditMenu editMenu = new EditMenu( );
      ColorMenu colorMenu = new ColorMenu( this );
      menuBar.add( fileMenu );
      menuBar.add( editMenu );
      menuBar.add( colorMenu );
      this.getContentPane( ).setBackground( colorMenu.getSelectedColor( ) );
      // Configure window and display
      this.setSize( 600, 300 );
      this.setVisible( true );
   }
}