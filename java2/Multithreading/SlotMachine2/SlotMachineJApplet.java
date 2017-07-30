import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.Box.*;
 


public class SlotMachineJApplet extends JApplet implements ActionListener
{
   public final int IMAGE_COUNT = 9;
   public Icon [] image1 = new ImageIcon[IMAGE_COUNT];
   public Icon [] image2 = new ImageIcon[IMAGE_COUNT];
   public Icon [] image3 = new ImageIcon[IMAGE_COUNT];
   JLabel s1Display;
   JLabel s2Display;
   JLabel s3Display;
   Spinner s1;
   Spinner s2;
   Spinner s3;
   
   JButton playBtn = makeBtn( "Play", true );
   JButton stopBtn1 = makeBtn( "Stop", false );
   JButton stopBtn2 = makeBtn( "Stop", false );
   JButton stopBtn3 = makeBtn( "Stop", false );
   JButton stompBtn = makeBtn( "STOMP BAR", false );
   JButton statusBtn = makeBtn( "STATE STATUS", true );
     
   public void init( )
   {
      initImageList( );
      try
      {
         SwingUtilities.invokeAndWait(
            new Runnable( ) 
            {
               public void run( ) 
               {
                  createGUI( );
               }
            }
         );
      }
      catch ( Exception e )
      {
         e.printStackTrace();
      }
      s1 = new Spinner( image1, s1Display );
      s1.start( );
      s1.state = Spinner.WAITING;
      
      s2 = new Spinner( image2, s2Display );
      s2.start( );
      s2.state = Spinner.WAITING;
      
      s3 = new Spinner( image3, s3Display );
      s3.start( );
      s3.state = Spinner.WAITING;
   }

   public void initImageList( )
   {
      for ( int k=0; k<IMAGE_COUNT; k++ )
         image1[k] = new ImageIcon( getClass( ).getResource( "thumbnail"+k+".png" ) );
      for ( int k=0; k<IMAGE_COUNT; k++ )
         image2[k] = new ImageIcon( getClass( ).getResource( "thumbnail"+k+".png" ) );
      for ( int k=0; k<IMAGE_COUNT; k++ )
         image3[k] = new ImageIcon( getClass( ).getResource( "thumbnail"+k+".png" ) );
   }
   
   public JButton makeBtn( String caption, boolean enabled )
   {
      JButton temp = new JButton( caption );
      
      temp.setFont( new Font( "Roboto", Font.PLAIN, 25 ) );
      temp.setBackground( null );
      temp.setBorder( null );
      temp.setPreferredSize(new Dimension(100, 40));
      
      temp.setEnabled( enabled );
      temp.addActionListener( this );
      return temp;
   }
   
   public void createGUI( )
   {    
      this.setLayout( new FlowLayout( ) );
      int w;
      w = this.getWidth( )/3-10;
      getContentPane().setBackground( new Color( 236, 239, 241 ) );
      this.setSize( 450, 250 );
      
      s1Display = new JLabel( );
      s2Display = new JLabel( );
      s3Display = new JLabel( );
      
      
      s1Display.setPreferredSize(new Dimension(w, 100));
      s2Display.setPreferredSize(new Dimension(w, 100));
      s3Display.setPreferredSize(new Dimension(w, 100));
      
      playBtn.setPreferredSize(new Dimension(getWidth( ), 40));

      stopBtn1.setPreferredSize(new Dimension(w, 40));
      stopBtn2.setPreferredSize(new Dimension(w, 40));
      stopBtn3.setPreferredSize(new Dimension(w, 40));
      stompBtn.setPreferredSize(new Dimension(getWidth( ), 40));
      
      this.add( playBtn );
      this.add( s1Display );
      this.add( s2Display );
      this.add( s3Display );
      this.add( stopBtn1 );
      this.add( stopBtn2 );
      this.add( stopBtn3 );
      this.add( stompBtn );
      
      //to test spinner state
      //this.add( statusBtn );
   
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == playBtn )
      {
         s1.state = Spinner.RUNNING;
         s2.state = Spinner.RUNNING;
         s3.state = Spinner.RUNNING;
         playBtn.setEnabled( false );
         stopBtn1.setEnabled( true );
         stopBtn2.setEnabled( true );
         stopBtn3.setEnabled( true );
         stompBtn.setEnabled( true );
         System.out.println( "play btn" );
         
         synchronized ( s1 )
         {
            s1.notify( );
         }
         synchronized ( s2 )
         {
            s2.notify( );
         }
         synchronized ( s3 )
         {
            s3.notify( );
         }
      }
      else if ( e.getSource( ) == stopBtn1 )
      {
         s1.state = Spinner.WAITING;
         stopBtn1.setEnabled( false );
         System.out.println( "stop btn1" );
      }
      else if ( e.getSource( ) == stopBtn2 )
      {
         s2.state = Spinner.WAITING;
         stopBtn2.setEnabled( false );
         System.out.println( "stop btn2" );
      }
      else if ( e.getSource( ) == stopBtn3 )
      {
         s3.state = Spinner.WAITING;
         stopBtn3.setEnabled( false );
         System.out.println( "stop btn3" );
      }
      else if ( e.getSource( ) == stompBtn )
      {
         s1.state = Spinner.WAITING;
         s2.state = Spinner.WAITING;
         s3.state = Spinner.WAITING;
         playBtn.setEnabled( true );
         stopBtn1.setEnabled( false );
         stopBtn2.setEnabled( false );
         stopBtn3.setEnabled( false );
         stompBtn.setEnabled( false );
         System.out.println( "stomp btn" );
      }
      else if ( e.getSource( ) == statusBtn )
      {
         System.out.println( "s1 = " + s1.getMyState( ) );
         System.out.println( "s2 = " + s2.getMyState( ) );
         System.out.println( "s3 = " + s3.getMyState( ) );
         System.out.println( this.getWidth( )/3-3 );
      }
      else
      {
      // should never happen
      }
   }
}