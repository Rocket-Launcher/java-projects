import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryConverter extends JFrame implements ActionListener
{ 
   
   public static void main ( String [] args )
   {
      new BinaryConverter( );
   }
   
   Font btnFont = new Font( "Dialog", Font.PLAIN, 18 );
   Font txtFont = new Font( "Courier New", Font.PLAIN, 24 );
   JButton [] digitBtn = new JButton[2];
   JButton backSpaceBtn;
   JTextField entry;
   
  public void actionPerformed( ActionEvent e )
   {
       if ( e.getSource( ) == entry )
       {
       // code to handle the entry text field
              if ( ! isBinary( entry.getText( ) ) )
               {
                  JOptionPane.showMessageDialog( this, "Illegal binary string" );
                  entry.setText( "" );
               }

       }
       else if ( e.getSource( ) == backSpaceBtn )
       {
       // code to handle the backspace button
                String s = entry.getText( );
                if ( s.length( ) > 0 )
                entry.setText( s.substring( 0, s.length( ) - 1 ) );

       }
       else // source is a digit button
       {
       // code to handle the digit buttons
                  entry.setText( entry.getText( ) + e.getActionCommand( ) );
       }
   }
          
   public BinaryConverter( )
   {
      // window management  
      super( "Binary Converter" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // configure text field
      entry = new JTextField( 10 );
      entry.setHorizontalAlignment( JTextField.RIGHT ); 
      entry.setFont( txtFont );
      entry.addActionListener( this );
      this.add( entry );
      
      // configure number buttons
      for ( int k = 0; k < 2; k++)
      {
         digitBtn[k] = new JButton( Integer.toString( k ) );
         digitBtn[k].setFont( btnFont );
         digitBtn[k].addActionListener( this );
         this.add( digitBtn[k] ); 
      }
      
      // configure Backspace button
      backSpaceBtn = new JButton( "\u2190" );
      backSpaceBtn.setFont( btnFont );
      backSpaceBtn.addActionListener( this );
      this.add( backSpaceBtn );   
      
       
      // configure window
      this.setLayout( new FlowLayout( ) );
      this.setSize( 400, 150 );
      this.setVisible( true );
   }
   
   private boolean isBinary( String s )
   // Return true if s contains a binary string of 0s and 1s.
   {
      for ( int k = 0; k < s.length( ); k++ )
      {
         if ( s.charAt( k ) != '0' && s.charAt( k ) != '1' ) 
            return false;
      }
      return true;
   }

}

