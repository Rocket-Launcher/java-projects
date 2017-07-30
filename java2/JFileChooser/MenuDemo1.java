import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.sql.*;
import static javax.swing.JOptionPane.*;


public class MenuDemo1 extends JFrame implements ActionListener
{
   // Declare application commands
   private JMenuItem cmdOpen, cmdClose, cmdExit, cmdSet;
   private JCheckBoxMenuItem cmdOnOff;
   private Font menufont = new Font( "Dialog", Font.PLAIN, 22 );
   private Font cmdFont = new Font( "Dialog", Font.PLAIN, 18 ); 
   // internal data
   private Color selectedColor = Color.LIGHT_GRAY;
   public JFileChooser fileChooser = new JFileChooser( new File( "." ) );
   private String DATABASE_URL;
   private Connection conn;
   private Statement stmt;
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == cmdOpen )
      {
         File file = browseForInput( fileChooser );
         DATABASE_URL = "jdbc:ucanaccess:" + file.getPath();
         try
         {
            conn = DriverManager.getConnection( DATABASE_URL );
            stmt = conn.createStatement( );
         }
         catch( SQLException ex )
         {
            showMessageDialog( this, ex.getMessage( ) );
         }
      }
      else if ( e.getSource( ) == cmdClose )
      {
      }
      else if ( e.getSource( ) == cmdExit )
      {
      }
      else if ( e.getSource( ) == cmdSet )  
      {
         if ( cmdOnOff.getState( ) )
         {    
            int cc = (int)( Math.random( ) * Integer.MAX_VALUE );
            selectedColor = new Color( cc );
            this.getContentPane( ).setBackground( selectedColor );
         } 
      }
      else if ( e.getSource( ) == cmdOnOff ) 
      {
         if ( cmdOnOff.getState( ) )
            this.getContentPane( ).setBackground( selectedColor ); 
         else
            this.getContentPane( ).setBackground( Color.LIGHT_GRAY );
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
      this.getContentPane( ).setBackground( Color.LIGHT_GRAY );
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
      cmdOpen.addActionListener( this );
      cmdOnOff.addActionListener( this );
      // Configure window and display
      this.setSize( 600, 300 );
      this.setVisible( true );
   }
   
   FileNameExtensionFilter fnef = new FileNameExtensionFilter( "Access Database", "accdb" );
   
   public File browseForInput( JFileChooser fileChooser )
   // Use the open file dialog to browse for a file.
   // Return the file or null if the operation is unsuccessful.
   {
      File file;     // file selected by user
      while ( true ) // input error trap
      {
         fileChooser.setFileFilter(fnef);
         // display the file open dialog and grab user's response
         int r = fileChooser.showOpenDialog( null );
         // if user cancelled the dialog then return null
         if ( r == fileChooser.CANCEL_OPTION ) return null;
         // user didn't cancel, get the file name entered by user
         file = fileChooser.getSelectedFile( );
         // user may have typed name wrong, so check that it exists
         if ( file.exists( ) ) return file;
         // file doesn't exist, complain and cycle to try again
         showMessageDialog( null, file.getName( ) + " is not found" );
      }
   }
}