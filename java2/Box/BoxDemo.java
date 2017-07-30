import javax.swing.*;
import java.awt.*;
import static javax.swing.Box.*;
import static javax.swing.BorderFactory.*;

public class BoxDemo extends JFrame
{ 
   public static void main ( String [] args )
   {
      new BoxDemo( );
   }
   
   public BoxDemo( )
   {
      // configure window
      super( "Box Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // create labels
      JLabel label1 = new JLabel( "0123456789" );
      label1.setOpaque( true );
      label1.setBackground( Color.RED );
      label1.setForeground( Color.WHITE );
      JLabel label2 = new JLabel( "0123456789" );
      label2.setOpaque( true );
      label2.setBackground( Color.BLUE );
      label2.setForeground( Color.WHITE );
      JLabel label3 = new JLabel( "0123456789" );
      label3.setOpaque( true );
      label3.setBackground( Color.MAGENTA );
      label3.setForeground( Color.WHITE );
      JLabel label4 = new JLabel( "0123456789" );
      label4.setOpaque( true );
      label4.setBackground( Color.BLACK );
      label4.setForeground( Color.WHITE );
      JLabel label5 = new JLabel( "0123456789" );
      label5.setOpaque( true );
      label5.setBackground( Color.GREEN );
      label5.setForeground( Color.WHITE );
      // create vertical box
      Box vBox = createVerticalBox( );
      // vBox.add( createHorizontalStrut( 200 ) );
      vBox.setBorder( createLineBorder( Color.BLACK, 2 ) );
      vBox.createGlue( );
      vBox.add( label1 );
      vBox.add( createVerticalStrut( 10 ) );
      label1.setAlignmentX( LEFT_ALIGNMENT );
      vBox.add( label2 );
      vBox.add( createVerticalStrut( 10 ) );
      label2.setAlignmentX( CENTER_ALIGNMENT );
      vBox.add( label3 );
      vBox.createGlue( );
      label3.setAlignmentX( RIGHT_ALIGNMENT );
      // create horizontal box
      Box hBox = createHorizontalBox( );
      // hBox.add( createVerticalStrut( 100 ) );
      hBox.setBorder( createLineBorder( Color.BLACK, 2 ) );
      hBox.createGlue( );
      hBox.add( label4 );
      hBox.add( createHorizontalStrut( 10 ) );
      label4.setAlignmentY( TOP_ALIGNMENT );
      hBox.add( label5 );
      hBox.createGlue( );
      label5.setAlignmentY( BOTTOM_ALIGNMENT );


      // set the size of the frame and make it visible
      Box bigBox = createHorizontalBox( );
      bigBox.add( vBox );
      bigBox.add( hBox );
      this.setLayout( new FlowLayout( ) );
      this.add( bigBox );
      this.setSize( 500, 150 );
      this.setVisible( true );
   }
}