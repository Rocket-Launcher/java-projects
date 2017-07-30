import java.awt.*;
import java.awt.event.*;

public class UnsafeThreadStatesApp extends Frame implements ActionListener
{
   Label lab1;
   TextField txt1;
   Button start, pause, resume, quit;
   Thread thread1;
   RunnableCounter counter;
   
   public static void main( String [] args )
   {
      new UnsafeThreadStatesApp( );
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
      lab1 = makeLabel( );
      txt1 = makeTextField( );
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
      this.add( lab1 );
      this.add( txt1 );
      this.add( start );
      this.add( pause );
      this.add( resume );
      this.add( quit );
      // set size and display
      this.setSize( 150, 250 );
      this.setVisible( true );
   }

   public Thread createThread( Label lab, TextField txt )
   {
      // build runnable object
      counter = new RunnableCounter( lab, txt );
      // build the thread object from the runnable
      Thread thread = new Thread( counter );
      return thread;
   }
   
   public UnsafeThreadStatesApp( )
   {
      super( "Unsafe Thread States App" );
      // build GUI
      buildGUI( );
      // start thread
      thread1 = createThread( lab1, txt1 );
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == start )
      {
         counter.state = RunnableCounter.RUNNING; // start counter
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