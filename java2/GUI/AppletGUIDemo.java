import java.applet.Applet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;


public class AppletGUIDemo extends Applet
{
   // init( ) method builds the GUI
   public void init( )
   {
      Icon rightIcon = new ImageIcon( "rightarrow.png" );
      Icon leftIcon = new ImageIcon( "leftarrow.png" );
      
      Font textFont = new Font( "Calibri", Font.BOLD, 18 );
      Color bgColor = new Color( 97, 97, 97 );
      Color left = new Color( 33, 150, 243);
      Color right = new Color( 255, 87, 34);
      Color txtColor = new Color( 255, 255, 255 );
      
      this.setBackground( bgColor );
      
      // build a JLabel for displaying static text
      JLabel fLabel = new JLabel( "°F" );
      JLabel cLabel = new JLabel( "°C" );
      
      fLabel.setFont( textFont );
      cLabel.setFont( textFont );
      fLabel.setForeground( Color.WHITE );
      cLabel.setForeground( Color.WHITE );
      
      // build a button 
      JButton toC = new JButton( rightIcon );
      JButton toF = new JButton( leftIcon );
      
      toC.setBackground( left );
      toF.setBackground( right );
      
      toC.setToolTipText( "Click to convert degrees Fahrenheit to Celsius." );
      toF.setToolTipText( "Click to convert degrees Celsius to Fahrenheit." );
      
      // build a text field for user entry
      JTextField fField = new JTextField( 10 );
      JTextField cField = new JTextField( 10 );
      
      cField.setFont( textFont );
      fField.setFont( textFont );
      
      fField.setBackground( left );
      cField.setBackground( right );
      fField.setForeground( Color.WHITE );
      cField.setForeground( Color.WHITE );
      
      // functionality
      
      
      toC.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if ( e.getSource( ) == toC ){
               if (!isDouble(fField.getText()) || fField.getText().length() == 0) {
                  JOptionPane.showMessageDialog(null, "Illegal Entry. Double Required.");
                  fField.setText("");
                  cField.setText("");
                  return;
               }
               double f = Double.parseDouble(fField.getText());
               Double convert = (f - 32) * 5 / 9;
               BigDecimal rounded = new BigDecimal(String.valueOf( convert )).setScale(2, BigDecimal.ROUND_HALF_UP);
               //System.out.println(rounded);
               cField.setText( rounded.toString() );
            }
         }
      });
      
      fField.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if ( e.getSource( ) == fField ){
               if (!isDouble(fField.getText()) || fField.getText().length() == 0) {
                  JOptionPane.showMessageDialog(null, "Illegal Entry. Double Required.");
                  fField.setText("");
                  cField.setText("");
                  return;
               }
               double f = Double.parseDouble(fField.getText());
               Double convert = (f - 32) * 5 / 9;
               BigDecimal rounded = new BigDecimal(String.valueOf( convert )).setScale(2, BigDecimal.ROUND_HALF_UP);
               cField.setText( rounded.toString() );
            }
         }
      });
      
      toF.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if ( e.getSource( ) == toF ){
               if (!isDouble(cField.getText()) || cField.getText().length() == 0) {
                  JOptionPane.showMessageDialog(null, "Illegal Entry. Double Required.");
                  cField.setText("");
                  fField.setText("");
                  return;
               }
               double c = Double.parseDouble(cField.getText());
               Double convert = c * 9 / 5 + 32;
               BigDecimal rounded = new BigDecimal(String.valueOf( convert )).setScale(2, BigDecimal.ROUND_HALF_UP);
               fField.setText( rounded.toString() );
            }
         }
      });
      
      cField.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if ( e.getSource( ) == cField ){
               if (!isDouble(cField.getText()) || cField.getText().length() == 0) {
                  JOptionPane.showMessageDialog(null, "Illegal Entry. Double Required.");
                  cField.setText("");
                  fField.setText("");
                  return;
               }
               double c = Double.parseDouble(cField.getText());
               Double convert = c * 9 / 5 + 32;
               BigDecimal rounded = new BigDecimal(String.valueOf( convert )).setScale(2, BigDecimal.ROUND_HALF_UP);
               fField.setText( rounded.toString() );
            }
         }
      });
      
      
      // add the components to 'this' applet object
      add( fField );
      add( fLabel );
      add( toC );
      add( toF );
      add( cField );
      add( cLabel );
      
      setSize( 500, 150 );
   }
   
   public static boolean isDouble(String s){
      try {
         Double.parseDouble(s);
         return true;
      }  
      catch ( NumberFormatException e ){
         return false;
      } 
   }
   
}
