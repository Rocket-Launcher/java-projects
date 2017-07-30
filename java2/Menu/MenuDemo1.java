import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo1 extends JFrame implements ActionListener
{
   // Declare application commands
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
      new MenuDemo1( );
   }

   public MenuDemo1( )
   { 
      // ** WINDOW
      super( "Menu Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // ** MENU BAR
      JMenuBar menuBar = new JMenuBar( ); // build 
      this.setJMenuBar( menuBar );        // add to window
      // ** FILE MENU
      JMenu fileMenu = new JMenu( "File" ); // build
      fileMenu.setMnemonic( 'F' );        // set ALT-key
      fileMenu.setFont( menufont );       // set font
      menuBar.add( fileMenu );            // add to menu bar
      // ** COLOR MENU
      JMenu colorMenu = new JMenu( "Color" );
      colorMenu.setMnemonic( 'C' );
      colorMenu.setFont( menufont );
      menuBar.add( colorMenu );
      // ** FILE COMMANDS
      // Open
      cmdOpen = new JMenuItem( "Open...", 'O' );
      cmdOpen.setFont( cmdFont );
      fileMenu.add( cmdOpen );
      // Close
      cmdClose = new JMenuItem( "Close", 'C' );
      cmdClose.setFont( cmdFont );
      fileMenu.add( cmdClose );
      // ** Separator
      fileMenu.addSeparator( );
      // Exit
      cmdExit = new JMenuItem( "Exit", 'X' );
      cmdExit.setFont( cmdFont );
      fileMenu.add( cmdExit );
      
      // ** COLOR COMMANDS
      // Set Color
      cmdSet = new JMenuItem( "Set Color", 'S' );
      cmdSet.setFont( cmdFont ); 
      colorMenu.add( cmdSet );
      // Color On/Off
      cmdOnOff = new JCheckBoxMenuItem( "Color On/Off", false );
      cmdOnOff.setFont( cmdFont );
      cmdOnOff.setMnemonic( 'O' ); 
      colorMenu.add( cmdOnOff );
      // Register listener
      cmdSet.addActionListener( this );
      cmdOnOff.addActionListener( this );
      // Configure window and display
      this.setSize( 600, 300 );
      this.setVisible( true );
   }
}