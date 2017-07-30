import javax.swing.*;

public class AnimationApp
{
   public static void createAndShowGUI( )
   {
      // build the JFrame that is the application's GUI window
      JFrame win = new JFrame( "Animation" );
      win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      // build a JPanel to use as the window's content pane
      JComponent winContentPane = new AnimationPanel( );
      win.setContentPane( winContentPane );
      // size and display the window
      win.pack( );
      win.setVisible( true );
   }
   
   public static void main ( String [] args )
   {
      // schedule the frame creation on the event dispatch thread
      SwingUtilities.invokeLater(
         new Runnable( ) 
         {
            public void run( ) 
            {
               createAndShowGUI( );
            }
         }
      );
   }
}