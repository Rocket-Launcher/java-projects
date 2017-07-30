import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo2 extends JFrame implements ActionListener
{
   // Declare application commands
   private JMenuBar menuBar;
   private JMenuItem cmdOpen, cmdClose, cmdExit, cmdSet;
   private JCheckBoxMenuItem cmdOnOff;
   private Font menufont = new Font( "Dialog", Font.PLAIN, 22 );
   private Font cmdFont = new Font( "Dialog", Font.PLAIN, 18 ); 
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == cmdOpen )
      {
      }
      else if ( e.getSource( ) == cmdClose )
      {
      }
      else if ( e.getSource( ) == cmdExit )
      {
      }
      else if ( e.getSource( ) == cmdSet )  
      {
      }
      else if ( e.getSource( ) == cmdOnOff ) 
      {
      }
      else
         /* should never happen */ ;
   }
      
   public static void main ( String [] args )
   {
      new MenuDemo2( );
   }

   private JMenu createMenu( String name, char key )
   {
      JMenu temp = new JMenu( name ); // build
      temp.setMnemonic( key );        // set ALT-key
      temp.setFont( menufont );       // set font
      menuBar.add( temp );            // add to menu bar
      return temp;
   }

   public MenuDemo2( )
   { 
      // ** WINDOW
      super( "Menu Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // ** MENU BAR
      this.setJMenuBar( menuBar ); // add to window

      this.createMenu( "File", 'F' ); 
      this.createMenu( "Color", 'C' );
      
      // ** FILE COMMANDS
      // Open
      cmdOpen = new JMenuItem( "Open...", 'O' );
      cmdOpen.setFont( cmdFont );
      menuBar.getMenu( 0 ).add( cmdOpen );
      // Close
      cmdClose = new JMenuItem( "Close", 'C' );
      cmdClose.setFont( cmdFont );
      menuBar.getMenu( 0 ).add( cmdClose );
      // ** Separator
      menuBar.getMenu( 0 ).addSeparator( );
      // Exit
      cmdExit = new JMenuItem( "Exit", 'X' );
      cmdExit.setFont( cmdFont );
      menuBar.getMenu( 0 ).add( cmdExit );
      
      // ** COLOR COMMANDS
      // Set Color
      cmdSet = new JMenuItem( "Set Color", 'S' );
      cmdSet.setFont( cmdFont ); 
      menuBar.getMenu( 1 ).add( cmdSet );
      // Color On/Off
      cmdOnOff = new JCheckBoxMenuItem( "Color On/Off", false );
      cmdOnOff.setFont( cmdFont );
      cmdOnOff.setMnemonic( 'O' ); 
      menuBar.getMenu( 1 ).add( cmdOnOff );
      // Register listener
      cmdSet.addActionListener( this );
      cmdOnOff.addActionListener( this );
      // Configure window and display
      this.setSize( 600, 300 );
      this.setVisible( true );
   }
}