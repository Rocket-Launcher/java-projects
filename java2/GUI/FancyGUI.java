import javax.swing.*;
import java.awt.*;

public class FancyGUI extends JFrame
{
   Color bgColor = new Color( 33, 33, 33 );
   Color txColor = new Color( 255, 255, 255 );
   
   Font lblFont = new Font( "Times New Roman", Font.PLAIN, 24 );
   Font txtFont = new Font( "Courier New", Font.BOLD, 24 ); 
   Font btnFont = new Font( "Dialog", Font.PLAIN, 24 );
   
   Icon lblIcon = new ImageIcon( "rightarrow.jpg" );
   Icon btnIcon = new ImageIcon( "uparrow.jpg" );


   public static void main( String [] args )
   {
      new FancyGUI( );
   }

   public FancyGUI( )
   {
      //configure window
      super( "GUI Embelishment" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      //configure label
//       JLabel label = new JLabel( "LABEL" ); 
//       label.setOpaque( true );
//       label.setBackground( bgColor );
//       label.setForeground( txColor );
//       label.setFont( lblFont );
      //configure text field
      JTextField textField = new JTextField( 10 ); 
      textField.setText( "0.0" ); 
      textField.setHorizontalAlignment( JTextField.RIGHT ); 
      textField.setFont( txtFont );
      textField.setBackground( bgColor );
      textField.setForeground( txColor );
      //configure button  
      // JButton button = new JButton( "BUTTON" );
//       button.setToolTipText( "Click to increment value" );
//       button.setFont( btnFont );
//       button.setBackground( bgColor );
//       button.setForeground( txColor );
      //add icon button and label
      JLabel label = new JLabel( lblIcon );
      JButton button = new JButton( btnIcon );
      //add
      this.setLayout( new FlowLayout( ) );
      this.add( label );
      this.add(textField );
      this.add( button );
      
      // set size and show
      this.setSize( 500, 150  );
      this.setVisible( true );
   
   }

}