import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SingleButton extends JFrame
{ 
   public static void main ( String [] args )
   {
      new SingleButton( );
   }
   
   // declare here to increase scope to entire application
   JButton button;
   
   private class MyListener implements ActionListener
   {
      // step 3: make the handler method do what I need.
      public void actionPerformed( ActionEvent e )
      {
         // get text from button and parse into a double
         double x = Double.parseDouble( button.getText( ) );
         // increment it and put it back
         button.setText( Double.toString( ++x ) );
      }
   }

   
   public SingleButton( )
   {
      // window management  
      super( "Single Button" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // button configuration
      button = new JButton( "0.0" );
      button.setToolTipText( "Click to increment" );
      MyListener listener = new MyListener( );
      button.addActionListener( listener );
      // window configuration
      this.setLayout( new FlowLayout( ) );
      this.add( button );
      this.setSize( 300, 150 );
      this.setVisible( true );
   }
}