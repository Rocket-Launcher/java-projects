import javax.swing.*;
import javax.swing.border.*;
import static javax.swing.BorderFactory.*;
import java.awt.*;

public class BorderFun extends JFrame
{
   public static void main( String [] args )
   {
      new BorderFun( );
   }
   
   public BorderFun( )
   {
      super( "Border Fun" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      JLabel label = new JLabel( "Street Address" );
      label.setFont( new Font( "Dialog", Font.PLAIN, 30 ) );
      this.setLayout( new FlowLayout( ) );
      this.add( label );
      // Border border = createBevelBorder( BevelBorder.LOWERED );      //#1
      // Border border = createBevelBorder( BevelBorder.RAISED );       //#2
      // Border border = createLineBorder( Color.BLUE, 5, true );       //#3
      // Border border = createMatteBorder( 1, 5, 15, 5, Color.RED );   //#4
      // Border border = createEtchedBorder( EtchedBorder.RAISED );     //#5
      // Border border = createEtchedBorder( EtchedBorder.LOWERED );    //#6
      // Border empty10 = createEmptyBorder( 10, 10, 10, 10 );
      // Border outsideBorder = createMatteBorder( 1, 5, 15, 5, Color.RED );
      // Border border = createCompoundBorder( outsideBorder, empty10 );
      Border lBdr = createLineBorder( Color.BLUE, 1, false );
      Border cBdr = createCompoundBorder( lBdr, createEmptyBorder( -3, 6, -3, 6 ) );
      Border border = createTitledBorder( cBdr, "Stree Address", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM );
      
      label.setBorder( border );
      
      // size and display window
      this.setSize( 350, 150 );
      this.setVisible( true );
   }
}