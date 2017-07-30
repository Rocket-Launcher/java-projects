import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;

public class JFrameDemo2 extends JFrame implements ActionListener
{ 
   JTextField textField = new JTextField( 10 );
   JButton goButton = new JButton( "GO" );
   JLabel ageLabel = new JLabel( "" );
   JLabel bDayLabel = new JLabel( "" ); 
      
   public static void main ( String [] args )
   {
      new JFrameDemo2( ); // call app constructor
   }
   
   public JFrameDemo2( )  // app constructor
   {
      // call JFrame constructor
      super( "Birthday" );
      
      Font txtFont = new Font( "Calibri", Font.BOLD, 24 );
      Color bgColor = new Color( 97, 97, 97 );
      Color btnColor = new Color( 33, 150, 243);
      Color txtColor = new Color( 255, 255, 255 );
      
      // set what happens when user clicks the Close button
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      this.getContentPane().setBackground( bgColor );

      
      JLabel label = new JLabel( "Enter your birthday" );
       
      label.setFont( txtFont );
      label.setForeground( txtColor );
      ageLabel.setForeground( txtColor );
      ageLabel.setFont( txtFont );
      bDayLabel.setForeground( txtColor );
      bDayLabel.setFont( txtFont );
      
      goButton.setFont( txtFont );
      goButton.setForeground( txtColor );
      goButton.setBackground( btnColor );
      goButton.setToolTipText( "Click to show age and next birthday." );
      
      textField.setFont( txtFont );
      textField.setBackground( Color.BLACK );
      textField.setForeground( Color.WHITE );
      textField.setText( "mm/dd/yyyy" );
      textField.setHorizontalAlignment( JTextField.RIGHT ); 
      
      this.setLayout( new FlowLayout( ) );
      
      this.add( label );
      this.add( textField );
      this.add( goButton );
      this.add( ageLabel );
      this.add( bDayLabel );
      
      goButton.addActionListener( this );
      textField.addActionListener( this );
      // set the size of the frame and display it
      this.setSize( 500, 150 );
      this.setVisible( true );
   }
   
      public void actionPerformed(ActionEvent e) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy");
         LocalDate today = LocalDate.now();
         LocalDate bDay;
         try{
            bDay = LocalDate.parse(textField.getText(), formatter);
         }
         catch ( DateTimeParseException err ) {
            JOptionPane.showMessageDialog(null, "Illegal Date Format");
            return;
         }
         
         Period p = Period.between(bDay, today);
         ageLabel.setText(Integer.toString(p.getYears()));
         if ( bDay.getDayOfYear() == today.getDayOfYear() ){
            bDayLabel.setText( "Happy Birthday!" );
         }
      }     
}