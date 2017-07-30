import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyMenu extends JMenu
{
   public MyMenu( String caption, char hotKey )
   {
      super( caption );              // build menu
      this.setMnemonic( hotKey );    // set its ALT-key
      this.setFont( new Font( "Dialog", Font.PLAIN, 22 ) );
   }
}   
      
class FileMenu extends MyMenu implements ActionListener
{
   // Declare file commands
   private JMenuItem cmdOpen, cmdClose, cmdExit;

   public FileMenu( )
   {
      super( "File", 'F' );
      this.add( ( cmdOpen = new MyMenuItem( "Open", 'O' ) ) );
      this.add( ( cmdClose = new MyMenuItem( "Close", 'C' ) ) );
      this.addSeparator( );
      this.add( ( cmdExit = new MyMenuItem( "Exit", 'X' ) ) );
      cmdOpen.addActionListener( this );
      cmdClose.addActionListener( this );
      cmdExit.addActionListener( this );
   }
        
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == cmdOpen )
      {
      }
      else if ( e.getSource( ) == cmdClose )
      {
      }
      else if ( e.getSource( ) == cmdExit )
      {
         System.exit(0);
      }
      else
         /* unrecoverable non-user error */ ;
   }
}

class MyMenuItem extends JMenuItem
{
   public MyMenuItem( String caption, char hotKey )
   {
      super( caption, hotKey );   // build command
      this.setFont( new Font( "Dialog", Font.PLAIN, 18 ) );
   }
}


class ColorMenu extends MyMenu implements ActionListener
{
   // Declare color commands
   private JMenuItem cmdSet;
   private JCheckBoxMenuItem cmdOnOff;
   // internal selected color
   private Color selectedColor = Color.LIGHT_GRAY;
   // application
   MenuApp app;
   
   public ColorMenu( MenuApp app )
   {
      super( "Color", 'C' );
      this.app = app;  // copy parameter to instance variable
      this.add( ( cmdSet = new MyMenuItem( "Set Color", 'S' ) ) );
      cmdSet.addActionListener( this );
      // Color On/Off
      cmdOnOff = new JCheckBoxMenuItem( "Color On/Off", false );
      cmdOnOff.setFont( new Font( "Dialog", Font.PLAIN, 18 ) );
      cmdOnOff.setMnemonic( 'O' ); 
      this.add( cmdOnOff );
      cmdOnOff.addActionListener( this );
   }
        
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == cmdSet )
      {
         if ( cmdOnOff.getState( ) )
         {    
            int cc = (int)( Math.random( ) * Integer.MAX_VALUE );
            selectedColor = new Color( cc );
            app.getContentPane( ).setBackground( selectedColor );
         }
      }
      else if ( e.getSource( ) == cmdOnOff )
      {
         if ( cmdOnOff.getState( ) )
            app.getContentPane( ).setBackground( selectedColor ); 
         else
            app.getContentPane( ).setBackground( Color.LIGHT_GRAY );
      }
      else
         /* unrecoverable non-user error */ ;
   }
   
   public Color getSelectedColor( )
   {
      return selectedColor;
   }
}

class EditMenu extends MyMenu implements ActionListener
{
   // Declare file commands
   private JMenuItem cmdUndo, cmdRedo, cmdCopy, cmdCut, cmdPaste, cmdSelectAll;

   public EditMenu( )
   {
      super( "Edit", 'E' );
      this.add( ( cmdUndo = new MyMenuItem( "Undo", 'U' ) ) );
      this.add( ( cmdRedo = new MyMenuItem( "Redo", 'R' ) ) );
      this.addSeparator( );
      this.add( ( cmdCopy = new MyMenuItem( "Copy", 'C' ) ) );
      this.add( ( cmdCut = new MyMenuItem( "Cut X", 'X' ) ) );
      this.add( ( cmdPaste = new MyMenuItem( "Paste", 'P' ) ) );
      this.addSeparator( );
      this.add( ( cmdSelectAll = new MyMenuItem( "Select All", 'A' ) ) );
      cmdUndo.addActionListener( this );
      cmdRedo.addActionListener( this );
      cmdCopy.addActionListener( this );
      cmdCut.addActionListener( this );
      cmdPaste.addActionListener( this );
      cmdSelectAll.addActionListener( this );
   }
        
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource( ) == cmdUndo )
      {
      }
      else if ( e.getSource( ) == cmdRedo )
      {
      }
      else if ( e.getSource( ) == cmdCopy )
      {
      }
      else if ( e.getSource( ) == cmdCut )
      {
      }
      else if ( e.getSource( ) == cmdPaste )
      {
      }
      else if ( e.getSource( ) == cmdSelectAll )
      {
      }
      else
         /* unrecoverable non-user error */ ;
   }
}