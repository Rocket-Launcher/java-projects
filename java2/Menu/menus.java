import javax.swing.*;
import java.awt.*;

class MyJMenu extends JMenu
{
   public MyJMenu( JMenuBar bar, String name, char key )
   {
      super( name );
      this.setFont( new Font( "Dialog", Font.PLAIN, 22 ) );
      this.setMnemonic( key );
      bar.add( this );
   }   
}

class FileMenu extends MyJMenu
{
   public FileMenu( JMenuBar bar )
   {
      super( bar, "File", 'F' );
   }
}

class ColorMenu extends MyJMenu
{
   public ColorMenu( JMenuBar bar )
   {
      super( bar, "Color", 'C' );
   }
}      