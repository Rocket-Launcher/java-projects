import java.util.Scanner;

public class CircleFacts
{
   public static void main( String [] args )
   {
      Scanner in = new Scanner( System.in );
      System.out.print( "Enter radius of a circle: " );
      double radius = in.nextDouble( );
      
      double diameter = 2 * radius;
      double circumference = 2 * Math.PI * radius;
      double area = Math.PI * Math.pow( radius, 2 );
   
      System.out.println( "CIRCLE DATA:" );
      System.out.println( "Radius = " + radius );
      System.out.println( "Diameter = " + diameter );
      System.out.println( "Circumference = " + circumference );
      System.out.println( "Area = " + area );
   }  
}   