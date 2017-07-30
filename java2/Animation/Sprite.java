/*
 * Sprite is a base class for animated objects. A sprite moves in a straight 
 * line across the screen, bouncing off the screen edge at an angle. 
 * A health attribute determines when the sprite is removed from the screen.
 */

import java.awt.*;

public class Sprite implements Runnable
{
   private Dimension size;  // (width, height) of sprite
   private Color color;     // color of sprite
   private Rectangle area;  // area the sprite occupies
   private Point pos;       // (x,y) position of sprite's center
   private int interval;    // sprite moves every 'interval' milliseconds
   private int dY, dX;      // sprite's heading is the slope dY/dX
   // The "rise" over the "run". Make it steeper by increasing dY vs. dX
   private int health;      // sprite's health
   private final int FULL_HEALTH = 10;
   private boolean isMoving;// is it moving?
        
   public Sprite( Dimension size, Color color )
   // Create stationary sprite with full health.
   {
      this.size = size;
      this.color = color;
      health = FULL_HEALTH;
      isMoving = false;
   }

   public void setArea( Rectangle area )
   // Set area in which Sprite moves to the given rectangle.
   {
      this.area = area;
   }
   
   public void setPosition( Point pos )
   // Set position of the Sprite.
   {
      this.pos = pos;
   }
   
   public boolean contains( Point mouse )
   // return true if mouse position is inside the sprite
   {
      Rectangle r = new Rectangle( pos.x-(size.width/2), pos.y-(size.height/2), size.width, size.height );
      return r.contains( mouse );
   }
   public void animate( int interval, int dY, int dX )
   // If sprite has an established position then start it moving
   // at the given interval and slope dY/dX.
   {
      if ( pos != null )
      {
         isMoving = true;
         this.interval = interval;
         this.dY = dY;
         this.dX = dX;
         ( new Thread( this ) ).start( );
      }
   }
   
   public void move( )
   // Move the sprite.
   {
      pos.x += dX;
      pos.y += dY;
      if ( pos.y - size.height/2 <= 1 ) // hit top edge
         dY *= -1;
      if ( pos.y + size.height/2 >= area.height-1 ) // hit bottom edge
         dY *= -1;
      if ( pos.x - size.width/2 <= 1 )  // hit left edge
         dX *= -1;
      if ( pos.x + size.width/2 >= area.width-1 )   // hit right edge
         dX *= -1;
   }

   public void paint( Graphics g )
   // If the sprite has an established position, then draw it.
   {
      if ( pos != null )
      {
         g.setColor( color );
         g.fillOval( pos.x-size.width/2, pos.y-size.height/2, size.width, size.height );
      }
   }
   
   public void run( )
   {
      while ( isMoving )
      {
         move( ); 
         try {
            Thread.sleep( interval );
         }
         catch( InterruptedException e ) {
            return;
         }
      }
   }
}