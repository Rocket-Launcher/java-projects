import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameDemo1Test
{ 

   public static void main ( String [] args )
   {
      Icon downIcon = new ImageIcon( "downarrow.png" );
      Icon upIcon = new ImageIcon( "uparrow.png" );
      Font txtFont = new Font( "Courier New", Font.BOLD, 24 );
      Color bgColor = new Color( 97, 97, 97 );
      Color btnColor = new Color( 33, 150, 243);
      Color txtColor = new Color( 255, 255, 255 );
      
      // build the application window
      
      // the argument is the window title
      JFrame win = new JFrame( "Counter" );
      win.getContentPane().setBackground( bgColor );
      
      // set what happens when user clicks the Close button
      win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      // label
      JLabel label = new JLabel( "X =" );
      label.setForeground( txtColor );

      
      // button 
      JButton upBtn = new JButton( upIcon );
      upBtn.setBackground( btnColor );
      upBtn.setToolTipText( "Click to increment value" );
      
      JButton downBtn = new JButton( downIcon );
      downBtn.setBackground( btnColor );
      downBtn.setToolTipText( "Click to decrement value" );
      
      // text field
      JTextField textField = new JTextField( 10 );
      String current = "0";
      textField.setText( current ); 
      textField.setHorizontalAlignment( JTextField.RIGHT ); 
      textField.setFont( txtFont );
      textField.setBackground( bgColor );
      textField.setForeground( txtColor );      
      textField.setToolTipText( "Current counter value." );
      
      // functionality
      downBtn.setEnabled(false);
      
      upButton.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int x;
            try {
               int current = Integer.parseInt(textField.getText());
               if ( x < 0 )
                  throw new RuntimeException( );
               textField.setText(Integer.toString(current++));
               downButton.setEnabled( current > 0 );
            }
            catch ( NumberFormatException err )
            {
               JOptionPane.showMessageDialogue(win, "illegal decimal string");
               textField.setText("");
               return;
            }
            catch ( RuntimeException err )
            {
               JOptionPane.showMessageDialogue();
            }
         }
      });
      downBtn.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if ( e.getSource( ) == downBtn ){
               if (!isInteger(textField.getText()) || textField.getText().length() == 0) {
                  JOptionPane.showMessageDialog(win, "Illegal Entry. Integer Required.");
                  textField.setText("");
                  return;
               }
            int v = Integer.parseInt(textField.getText());
            textField.setText(Integer.toString(v - 1));
            }
            downBtn.setEnabled(Integer.parseInt(textField.getText()) > 0);
         }   
      });
      
      textField.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if ( e.getSource( ) == textField ){
                if (!isInteger(textField.getText()) || textField.getText().length() == 0 || Integer.parseInt(textField.getText()) < 0) {
                  JOptionPane.showMessageDialog(win, "Illegal Entry. Integer Required.");
                  textField.setText("");
                  return;
               }
            }
         downBtn.setEnabled(Integer.parseInt(textField.getText()) > 0);
         }
      });     
            
      
      // flow layout
      win.setLayout( new FlowLayout( ) );
      
      // add components
      win.add( downBtn );
      win.add( label );
      win.add( textField );
      win.add( upBtn );
      
        
      
      // set the size of the frame and display it
      win.setSize( 500, 150 );
      win.setVisible( true );
   }
   
   public static boolean isInteger(String s){
      try {
         Integer.parseInt(s);
         return true;
      }
      catch ( NumberFormatException e ){
         return false;
      } 
   }
   
}