import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import static javax.swing.JOptionPane.*;

public class UserForm extends JFrame implements ActionListener
{
   public static void main ( String [] args )
   {
      new UserForm( );
   }
   
   // declare labels and text fields as "global"
   private JLabel firstLbl, lastLbl, addLbl, cityLbl, stateLbl, zipLbl, phoneLbl, emailLbl;
   private JTextField firstTxt, lastTxt, addTxt, cityTxt, stateTxt, zipTxt, phoneTxt, emailTxt;
   private Font font = new Font( "Dialog", Font.PLAIN, 18 );
   
   // declare our gridlayout
   private GridLayout grid = new GridLayout( 8, 2, 5, 3 );
   
   // declare the input validation patterns
   private Pattern wordPtn, addPtn, statePtn, zipPtn, phonePtn, emailPtn;
   
   public JLabel makeLbl( String text )
   {
      JLabel temp = new JLabel( text, SwingConstants.RIGHT );
      temp.setFont( font );
      this.add( temp );
      return temp;
   } 
   
   public JTextField makeTxt( )
   {
      JTextField temp = new JTextField( 10 );
      temp.setFont( font );
      this.add( temp );
      temp.addActionListener( this );
      return temp;
   } 
   
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == firstTxt )
      {
         if ( wordPtn.matcher( firstTxt.getText( ) ).matches( ) )
         {
            firstTxt.setForeground( Color.GREEN );  
         }
         else
         {
            showMessageDialog( this, "Bad first" );
            firstTxt.setForeground( Color.RED );
         }
      }
      else if ( e.getSource( ) == lastTxt )
      {
         if ( wordPtn.matcher( lastTxt.getText( ) ).matches( ) )
         {
            lastTxt.setForeground( Color.GREEN );  
         }
         else
         {
            showMessageDialog( this, "Bad last" );
            lastTxt.setForeground( Color.RED );
         }
      }
      else if ( e.getSource( ) == addTxt )
      {
         if ( addPtn.matcher( addTxt.getText( ) ).matches( ) )
         {
            addTxt.setForeground( Color.GREEN );  
         }
         else
         {
            showMessageDialog( this, "Bad add" );
            addTxt.setForeground( Color.RED );
         }
      }
      else if ( e.getSource( ) == cityTxt )
      {
         if ( wordPtn.matcher( cityTxt.getText( ) ).matches( ) )
         {
            cityTxt.setForeground( Color.GREEN );  
         }
         else
         {
            showMessageDialog( this, "Bad city" );
            cityTxt.setForeground( Color.RED );
         }
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
         if ( zipPtn.matcher( zipTxt.getText( ) ).matches( ) )
         {
            zipTxt.setForeground( Color.GREEN );  
         }
         else
         {
            showMessageDialog( this, "Bad zip" );
            zipTxt.setForeground( Color.RED );
         }
      }
      else if ( e.getSource( ) == phoneTxt )
      {
         if ( phonePtn.matcher( phoneTxt.getText( ) ).matches( ) )
         {
            phoneTxt.setForeground( Color.GREEN );  
         }
         else
         {
            showMessageDialog( this, "Bad phone" );
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
            showMessageDialog( this, "Bad email" );
            emailTxt.setForeground( Color.RED );
         }

      }
      else
         /* should never happen */;
   }
   
   public UserForm( )
   {
      super( "Address Book" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      this.setLayout( grid );
      // create labels
      firstLbl = makeLbl( "First Name" ); firstTxt = makeTxt( );
      lastLbl  = makeLbl( "Last Name" );  lastTxt  = makeTxt( );
      addLbl   = makeLbl( "Address" );    addTxt   = makeTxt( );
      cityLbl  = makeLbl( "City" );       cityTxt  = makeTxt( );
      stateLbl = makeLbl( "State" );      stateTxt = makeTxt( );
      zipLbl   = makeLbl( "Zip" );        zipTxt   = makeTxt( );
      phoneLbl = makeLbl( "Phone" );      phoneTxt = makeTxt( );
      emailLbl = makeLbl( "Email" );      emailTxt = makeTxt( );
      // create patterns
      // wordPtn, addPtn, statePtn, zipPtn, phonePtn, emailPtn;
      wordPtn  = Pattern.compile( "^[A-Za-z]+$" );
      addPtn   = Pattern.compile( "^[0-9]+[\\ A-Za-z]+$" );
      statePtn = Pattern.compile( "^[A-Z]{2}$" );
      zipPtn   = Pattern.compile( "^[0-9]{5}(-[0-9]{4})?" );
      phonePtn = Pattern.compile( "^\\(?[0-9]{3}\\)?[\\s.-]?[0-9]{3}[\\s.-]?[0-9]{4}$" );
      emailPtn = Pattern.compile( "^[\\w\\.]+@[A-Za-z0-9\\-\\.]+\\.[a-z]+$" );
      // configure window
      this.setSize( 400, 600 );
      this.setVisible( true );
   }

}