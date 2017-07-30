import java.awt.*;
import java.awt.event.*;

public class SafeThreadStatesApp extends Frame implements ActionListener
{
   Label lab;
   TextField txt;
   Button start, pause, resume, quit;
   RunnableCounter counter;
   Thread thread;
   
   public static void main( String [] args )
   {
      new SafeThreadStatesApp( );
   }

   public Label makeLabel( )
   {
      Label temp = new Label( );
      temp.setFont( new Font( "Dialog", Font.PLAIN, 14 ) );
      return temp;
   }
      
   public TextField makeTextField( )
   {
      TextField temp = new TextField( 10 );
      temp.setFont( new Font( "Courier New", Font.BOLD, 20 ) );
      return temp;
   }
   
   public Button makeButton( String caption, boolean enabled )
   {
      Button temp = new Button( caption );
      temp.setFont( new Font( "Dialog", Font.PLAIN, 20 ) );
      temp.setEnabled( enabled );
      temp.addActionListener( this );
      return temp;
   }
      
   public void buildGUI( )
   {
      // create GUI components
      lab = makeLabel( );
      txt = makeTextField( );
      start =  makeButton( "START", true );
      pause =  makeButton( "PAUSE", false );
      resume = makeButton( "RESUME", false );
      quit =   makeButton( "QUIT", false );
      // set frame's layout
      this.setLayout( new FlowLayout( ) );
      // set window action when user clicks Close button
      this.addWindowListener( new WindowAdapter( )
      {
         public void windowClosing( WindowEvent e )
         {
            e.getWindow( ).setVisible( false );
            System.exit( 0 );
         }
      } );
      // add the components
      this.add( lab );
      this.add( txt );
      this.add( start );
      this.add( pause );
      this.add( resume );
      this.add( quit );
      // set size and display
      this.setSize( 250, 250 );
      this.setVisible( true );
   }

   public SafeThreadStatesApp( )
   {
      super( "Safe Thread States App" );
      // build GUI
      buildGUI( );
      // build counter and thread
      counter = new RunnableCounter( lab, txt );
      thread = new Thread( counter );
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == start )
      {
         counter.state = RunnableCounter.RUNNING; // start counter
         thread.start( );
         start.setEnabled( false );
         pause.setEnabled( true );
         quit.setEnabled( true );
      }
      else if ( e.getSource( ) == pause )
      {
         counter.state = RunnableCounter.WAITING; // suspend counter
         pause.setEnabled( false );
         resume.setEnabled( true );
      }
      else if ( e.getSource( ) == resume )
      {
         counter.state = RunnableCounter.RUNNING; // resume counter
         synchronized ( counter )
         {
            counter.notify( );
         }
         pause.setEnabled( true );
         resume.setEnabled( false );
      }
      else if ( e.getSource( ) == quit )
      {
         counter.state = RunnableCounter.DEAD; // stop counter
         pause.setEnabled( false );
         resume.setEnabled( false );
         quit.setEnabled( false );
      }
   } 
}