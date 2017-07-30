import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;
import static javax.swing.JOptionPane.*;
import java.sql.*;


class MyMenu extends JMenu
{
   protected JComponent contentPane;  // application's content pane
   
   public MyMenu( JComponent contentPane, String caption, char hotKey )
   {
      // call JMenu constructor to build menu with given caption
      super( caption );
      // copy application's content pane to instance variable
      this.contentPane = contentPane;
      // set menu ALT-key and font
      this.setMnemonic( hotKey );
      this.setFont( new Font( "Dialog", Font.PLAIN, 22 ) );
   }
}   
      
class FileMenu extends MyMenu implements ActionListener
{
   // contentPane is inherited from MyMenu
   // declare file commands
   private JMenuItem cmdOpen, cmdClose, cmdExit;
   public JFileChooser fileChooser = new JFileChooser( new File( "." ) );
   private String DATABASE_URL;
   private Connection conn;
   private Statement stmt;

   public FileMenu( JComponent contentPane )
   {
      // call MyMenu constructor to initialize object
      super( contentPane, "File", 'F' );
      // add the commands to the menu
      this.add( ( cmdOpen = new MyMenuItem( "Open", 'O' ) ) );
      this.add( ( cmdClose = new MyMenuItem( "Close", 'C' ) ) );
      this.addSeparator( );
      this.add( ( cmdExit = new MyMenuItem( "Exit", 'X' ) ) );
      // register this menu object to listen to the commands
      cmdOpen.addActionListener( this );
      cmdClose.addActionListener( this );
      cmdExit.addActionListener( this );
   }
        
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == cmdOpen )
      {
       File file = browseForInput( fileChooser );
         if ( file == null ) return;
         DATABASE_URL = "jdbc:ucanaccess:" + file.getPath( );
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
      else
         /* unrecoverable non-user error */ ;
   }
   
   FileNameExtensionFilter fnef = new FileNameExtensionFilter( "Access Database", "accdb" );
   
   public File browseForInput( JFileChooser fileChooser )
   // Use the open file dialog to browse for a file.
   // Return the file or null if the operation is unsuccessful.
   {
      File file;     // file selected by user
      while ( true ) // input error trap
      {
         // display the file open dialog and grab user's response
         fileChooser.setFileFilter( fnef );
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


class MyMenuItem extends JMenuItem
{
   public MyMenuItem( String caption, char hotKey )
   {
      // call JMenuItem constructor to set command caption, ALT-key and font.
      super( caption, hotKey );
      this.setFont( new Font( "Dialog", Font.PLAIN, 18 ) );
   }
}