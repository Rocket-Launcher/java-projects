// To run, use the Data Sources (ODBC) Control Panel in Windows
// (it may be located under Administrative Tools)
// to create a data source named FitnessDS and link it to the
// MS Access database in FITNESS.accdb.

import java.sql.*;
import static javax.swing.JOptionPane.*;

public class TouchData
{
   // data source as registered in the JDBC
   private final String DATABASE_URL = "jdbc:ucanaccess://FITNESS-1.accdb";
   // example SQL query
   private String query = "SELECT * FROM PERSON";
   // metadata of the result set (i.e. column names, etc.)
   private ResultSetMetaData metaData;
   private int [] colWdth = { 0, 4, 10, 9, 14, 21, 10, 12 };
   
   public static void main ( String args [] )
   {
      new TouchData( );
   }
   
   public TouchData( )
   {
      // connect to the data source
      // perform the query
      try (
         Connection conn = DriverManager.getConnection( DATABASE_URL );
         Statement stmt = conn.createStatement( );   
         ResultSet rs = stmt.executeQuery( query );
      )
      {
         System.out.println( "Execute query:" );
         System.out.println( query );
         System.out.println( "Results:" );
         // process the query results, first get meta data
         metaData = rs.getMetaData( );
         // from meta data get column count
         int colCount = metaData.getColumnCount( );
         // from meta data get name of each column and print them
         for ( int i = 1; i <= colCount; i++ )
            System.out.printf( "%-"+colWdth[i]+"s ", metaData.getColumnName( i ) );
         System.out.printf( "\n" );
         // for each row print the data within it
         while ( rs.next( ) )
         {
            for ( int i = 1; i <= colCount; i++ )
               System.out.printf( "%-"+colWdth[i]+"s ", rs.getObject( i ) );
            System.out.printf( "\n" );
         }
      }
      // detect any query problems
      catch ( SQLException e )
      {
         showMessageDialog( null, e.getMessage( ), "Database Error", ERROR_MESSAGE );
         System.exit( 0 );
      }
   }
}
