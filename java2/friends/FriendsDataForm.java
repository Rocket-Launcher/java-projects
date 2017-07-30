import javax.swing.*;
import java.awt.*;
import static javax.swing.Box.*;

public class FriendsDataForm extends JPanel
{
   // fonts
   Font txtFont  = new Font( "Courier New", Font.BOLD, 24 );
   Font lblFont  = new Font( "Dialog", Font.PLAIN, 24 );
   // colors
   Color lightGrey = new Color( 136, 136, 136 );
   Color darkGrey = new Color( 45, 45, 45 );
   // declare record text fields as "global"
   private JTextField idTxt, nameTxt, dobTxt, genderTxt;
   
   public JLabel makeLbl( Box box, String text )
   {
      JLabel temp = new JLabel( text, SwingConstants.RIGHT );
      temp.setFont( lblFont );
      temp.setForeground( lightGrey );
      box.add( temp );
      return temp;
   }
   
   public JTextField makeTxt( Box box )
   {
      JTextField temp = new JTextField( 15 );
      temp.setFont( lblFont );
      temp.setForeground( darkGrey );
      box.add( temp );
      return temp;
   }
   
   public FriendsDataForm()
   {
      // switch JPanel to Box layout
      this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
      //this.setBackground( Color.WHITE );
      // id box
      Box idBox = createHorizontalBox( );
       
      idBox.add( makeLbl( idBox, "ID" ) );
      idBox.add( createHorizontalStrut ( 5 ) );
      idBox.add( idTxt = makeTxt( idBox ) );
      // name box
      Box nameBox = createHorizontalBox( );
      nameBox.add( makeLbl( nameBox, "Name" ) );
      nameBox.add( createHorizontalStrut ( 5 ) );
      nameBox.add( nameTxt = makeTxt( idBox ) );
      // dob box
      Box dobBox = createHorizontalBox( );
      dobBox.add( makeLbl( dobBox, "Birth Date" ) );
      dobBox.add( createHorizontalStrut ( 5 ) );
      dobBox.add( dobTxt = makeTxt( idBox ) );
      // gender box
      Box genderBox = createHorizontalBox( );
      genderBox.add( makeLbl( genderBox, "Gender" ) );
      genderBox.add( createHorizontalStrut ( 5 ) );
      genderBox.add( genderTxt = makeTxt( idBox ) );
      
      this.add( createVerticalStrut( 5 ) );
      this.add( idBox );
      this.add( createVerticalStrut( 5 ) );
      this.add( nameBox );
      this.add( createVerticalStrut( 5 ) );
      this.add( dobBox );
      this.add( createVerticalStrut( 5 ) );
      this.add( genderBox );
      this.add( createVerticalStrut( 5 ) );

   
   }
}