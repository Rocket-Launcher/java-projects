import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.*;
import javax.swing.filechooser.*;

class JFileChooserDemo
{
   // instantiate the JFileChooser object with a starting
   // folder of "." (the same as where class file is)
   public static JFileChooser fileChooser = new JFileChooser( new File( "." ) );
   
   public static void main( String [] args )
   {
      do
      {
         File file = browseForInput( fileChooser );
         if ( file != null )    // we got a file
            showMessageDialog( null, "Got " + file.getName( ) );
         else
            showMessageDialog( null, "User cancelled" );
         }
      while ( showConfirmDialog( null, "Go again?" ) == YES_OPTION );
   }

   public static File browseForInput( JFileChooser fileChooser )
   // Use the open file dialog to browse for a file.
   // Return the file or null if the operation is unsuccessful.
   {
      File file;     // file selected by user
      while ( true ) // input error trap
      {
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
