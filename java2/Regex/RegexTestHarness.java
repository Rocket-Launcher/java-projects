import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class RegexTestHarness {

    public static void main(String[] args){
        Scanner console = new Scanner( System.in );
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {
            System.out.print( "Enter your regex: " );
            Pattern pattern = 
            Pattern.compile(console.nextLine( ));
            System.out.print( "Enter input string to search: " );
            Matcher matcher = 
            pattern.matcher(console.nextLine( ));

            boolean found = false;
            while (matcher.find()) {
                System.out.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                System.out.format("No match found.%n");
            }
        }
    }
}

