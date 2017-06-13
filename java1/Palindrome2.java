import java.util.Scanner;

public class Palindrome2
{
   public static void main( String [] args )
   {
      Scanner in = new Scanner( System.in );
      System.out.print( "Enter a word: ");
      String word = in.nextLine( );
      int left = 0;
      int right = word.length() - 1;
      boolean isPalindrome = true;
      while( left < right )
      {
         if ( word.charAt(left) == word.charAt(right) )
         {
            left++;
            right--;
         }
         else 
         {
            isPalindrome = false;
            break;
         }      
      }
      if ( isPalindrome )
         System.out.println( word + " is a palindrome." );
      else
         System.out.println( word + " is not a palindrome." );      
   }
}      