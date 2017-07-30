import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.BorderFactory.*;
import static javax.swing.Box.*;

public class BrowseForm extends JPanel implements ActionListener
{
   // fonts
   Font brwsFont = new Font( "Courier New", Font.BOLD, 14 );
   // colors
   Color lightGrey = new Color( 234, 234, 234 );
   Color darkGrey = new Color( 95, 95, 95 );
   Color mediumGrey  = new Color( 178, 178, 178 );
   // declare buttons as "global"
   private JButton firstBtn, prevBtn, nextBtn, lastBtn;
   private JTextField recordNo;

   public Dimension getPreferredSize( )
   {
      return new Dimension( 320, 40 );
   }
   
   public JButton makeBrowseBtn( String caption, String toolTip )
   {
      final JButton temp = new JButton( caption );
      temp.setFont( brwsFont );
      temp.setToolTipText( toolTip );
      temp.setBackground( lightGrey );
      temp.setForeground( darkGrey );
      temp.setBorder( createEmptyBorder( 10, 15, 10, 15 ) );
      temp.addMouseListener( new MouseAdapter( )
         {
            public void mouseEntered( MouseEvent e )
            {
               temp.setBackground( mediumGrey );
            }
            public void mouseExited( MouseEvent e )
            {
               temp.setBackground( lightGrey );
            }
         }
      );
      return temp;
   }
   
   public BrowseForm( )
   {
      // switch JPanel to Box layout
      this.setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
      this.add( createHorizontalStrut( 3 ) );
      this.add( new JLabel( "Browse:" ) );
      this.add( createHorizontalStrut( 3 ) );
      this.add( firstBtn = makeBrowseBtn( "|<", "First" ) );
      this.add( prevBtn = makeBrowseBtn( "<<", "Previous" ) );
      recordNo = new JTextField( "1 of 9" );
      recordNo.setFont( brwsFont ); 
      recordNo.setToolTipText( "Current Record" );
      this.add( recordNo );  
      this.add( nextBtn = makeBrowseBtn( ">>", "Next" ) );
      this.add( lastBtn = makeBrowseBtn( ">|", "Last" ) );  
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == firstBtn )
      {
      }
      else if ( e.getSource( ) == prevBtn )
      {
      }
      else if ( e.getSource( ) == nextBtn )
      {
      }
      else if ( e.getSource( ) == lastBtn )
      {
      }      
      else
         /* should never happen */ ;
   }
}