import java.util.Scanner;

//This program finds the average of three input values.

public class Arithmeticx
{
   public static void main( String [] args )
   {
      // declare variables
      double number1, number2, number3, average;
      // input data
      Scanner in = new Scanner( System.in );
      System.out.print( "Number 1? " );
      number1 = in.nextDouble();
      System.out.print( "Number 2? " );
      number2 = in.nextDouble();
      System.out.print( "Number 3? " );
      number3 = in.nextDouble();
      // calculate average
      average =  (number1 + number2 + number3) / 3;
      // print results
      System.out.print( number1 + ", " + number2 + " & " + number3 );
      System.out.println( " averages to " + average );
   }
}