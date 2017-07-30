import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class FriendsForm extends JPanel implements ActionListener
{
   // fonts
   Font txtFont  = new Font( "Courier New", Font.BOLD, 24 );
   Font lblFont  = new Font( "Dialog", Font.PLAIN, 24 );
   Font titFont  = new Font( "Garamond", Font.PLAIN, 18 ); 
   Font brwsFont = new Font( "Arial", Font.BOLD, 10 );
   // declare record text fields as "global"
   private JTextField firstTxt, lastTxt, adrs1Txt, adrs2Txt, cityTxt, 
           stateTxt, zipTxt, phoneTxt, emailTxt, dobTxt;
   // declare buttons as "global:
   private JButton firstBtn, prevBtn, nextBtn, lastBtn, newBtn, undoLastBtn, undoAllBtn, saveBtn;
   private JTextField recordNo;
   
   public JLabel makeLbl( Box box, String text )
   {
      JLabel temp = new JLabel( text, SwingConstants.RIGHT );
      temp.setFont( lblFont );
      box.add( temp );
      return temp;
   }

   public JTextField makeTxt( Box box )
   {
      JTextField temp = new JTextField( 10 );
      temp.setFont( txtFont );
      box.add( temp );
      temp.addActionListener( this );
      return temp;
   }

   public JButton makeBtn( Box box, String caption, Font font, String toolTip, Boolean on )
   {
      JButton temp = new JButton( caption );
      temp.setFont( font );
      temp.setToolTipText( toolTip );
      box.add( temp );
      return temp;
   }
   
   public Box makeBrowsePanel( )
   {
      Box temp = createHorizontalBox( );
      temp.add( new JLabel( "Browse:" ) );
      temp.add( firstBtn = makeBtn( this, "|<", brwsFont, "First", false ) );
      temp.add( prevBtn = makeBtn( this, "<<", brwsFont, "Previous", false ) );
      recordNo = new JTextField( "1 of 9" );
      recordNo.setFont( brwsFont ); 
      temp.add( recordNo );  
      temp.add( nextBtn = makeBtn( this, ">>", brwsFont, "Next", false ) );
      temp.add( lastBtn = makeBtn( this, ">|", brwsFont, "Last", false ) );          
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == firstTxt )
      {
      }
      else if ( e.getSource( ) == lastTxt )
      {
      }
      else if ( e.getSource( ) == addTxt )
      {
      }
      else if ( e.getSource( ) == cityTxt )
      {
      }      
      else if ( e.getSource( ) == stateTxt )
      {
         if ( statePtn.matcher( stateTxt.getText( ) ).matches( ) )
         {
            stateTxt.setForeground( Color.GREEN );
         }
         else
         {
            showMessageDialog( this, "Bad state" );
            stateTxt.setForeground( Color.RED );
         }
      }
      else if ( e.getSource( ) == zipTxt )
      {
      }
      else if ( e.getSource( ) == phoneTxt )
      {
         if ( phonePtn.matcher( phoneTxt.getText( ) ).matches( ) )
         {
            phoneTxt.setForeground( Color.GREEN );
         }
         else
         {
            showMessageDialog( this, "Bad state" );
            phoneTxt.setForeground( Color.RED );
         }
      }
      else if ( e.getSource( ) == emailTxt )
      {
         if ( emailPtn.matcher( emailTxt.getText( ) ).matches( ) )
         {
            emailTxt.setForeground( Color.GREEN );
         }
         else
         {
            showMessageDialog( this, "Bad state" );
            emailTxt.setForeground( Color.RED );
         }
      }
      else
         /* should never happen */ ;
   }
   
   public UserForm( )
   {
      super( "Address Book" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      this.setLayout( new FlowLayout( ) );
      // create labels
      firstLbl = makeLbl( "First Name" ); firstTxt = makeTxt( );
      lastLbl = makeLbl( "Last Name" );   lastTxt = makeTxt( );      
      addLbl = makeLbl( "Address" );      addTxt = makeTxt( );
      cityLbl = makeLbl( "City" );        cityTxt = makeTxt( );
      stateLbl = makeLbl( "State" );      stateTxt = makeTxt( );
      zipLbl = makeLbl( "Zip" );          zipTxt = makeTxt( );   
      phoneLbl = makeLbl( "Phone" );      phoneTxt = makeTxt( );
      emailLbl = makeLbl( "Email" );      emailTxt = makeTxt( );
      // create patterns
      statePtn = Pattern.compile( "^[A-Z][A-Z]$" );
      phonePtn = Pattern.compile( "^((\\(\\d{3}\\)\\s)|(\\d{3}\\-))(\\d{3}\\-)(\\d{4})$" );
      emailPtn = Pattern.compile( "^[\\w\\.]+@[A-Za-z0-9\\-\\.]+\\.[a-z]+$" );

      // configure window
      this.setSize( 350, 500 );
      this.setVisible( true );
   }
}