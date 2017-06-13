import java.util.Scanner;

public class Multiplierx
{
   public static void main( String [] args )
   {
      // declare data
      double firstnum;
      double secondnum;
      double product;
      // input data
      Scanner in = new Scanner( System.in );
      System.out.print( "Enter first number to multiply: " );
      firstnum = in.nextDouble( );
      System.out.print( "Enter second number to multiply: " );
      secondnum = in.nextDouble( );
      // calculate result
      product = secondnum * firstnum;
      // output results
      System.out.print( firstnum + " * " );
      System.out.print( secondnum + " = " );
      System.out.println( product );
   }
}