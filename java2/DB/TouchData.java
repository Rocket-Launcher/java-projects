// To run, use the Data Sources (ODBC) Control Panel in Windows
// (it may be located under Administrative Tools)
// to create a data source named FitnessDS and link it to the
// MS Access database in FITNESS.accdb.

import java.sql.*;
import static javax.swing.JOptionPane.*;

public class TouchData
{
   // JDBC driver
   // private final String JDBC_DRIVER  = "sun.jdbc.odbc.JdbcOdbcDriver";  
   // data source as registered in the ODBC data sources Windows Control Panel
   private final String DATABASE_URL = "jdbc:sqlserver://10.136.212.38/Fitness_DB_TEM";
   // data source connection
   private Connection conn;
   // statement for querying the database
   private Statement stmt;
   // example SQL query
   private String query = "SELECT * FROM PERSON";
   // result set (i.e. table) resulting from query
   private ResultSet rs;
   // metadata of the result set (i.e. column names, etc.)
   private ResultSetMetaData metaData;
   
   public static void main ( String args [] )
   {
      new TouchData( );
   }
   
   public TouchData( )
   {
      // connect to the data source
      try
      {
         // test driver
         // Class.forName( JDBC_DRIVER );
         // connect to data source or throw SQLException
         conn = DriverManager.getConnection( DATABASE_URL, "admin", "cmst;420" );
      }
      // detect problem connecting to data source
      catch ( SQLException e )
      {
         showMessageDialog( null, e.getMessage( ), "Connection Problem", ERROR_MESSAGE );
         System.exit( 0 );
      }
      // perform the query
      try
      {
         // create the statement for querying the database
         stmt = conn.createStatement( );
         // perform the query
         rs = stmt.executeQuery( query );
         // print explanation
         System.out.println( "Execute query:" );
         System.out.println( query );
         System.out.println( "Results:" );
         // process the query results, first get meta data
         metaData = rs.getMetaData( );
         // from meta data get column count
         int colCount = metaData.getColumnCount( );
         // from meta data get name of each column and print them
         for ( int i = 1; i <= colCount; i++ )
            System.out.printf( "%-14s ", metaData.getColumnName( i ) );
         System.out.printf( "\n" );
         // for each row print the data within it
         while ( rs.next( ) )
         {
            for ( int i = 1; i <= colCount; i++ )
               System.out.printf( "%-14s ", rs.getObject( i ) );
            System.out.printf( "\n" );
         }
      }
      // detect any query problems
      catch ( SQLException e )
      {
         showMessageDialog( null, e.getMessage( ), "Query Error", ERROR_MESSAGE );
         System.exit( 0 );
      }
      // no matter what happens, disconnect the DB and exit
      finally
      {
         disconnect( );
      }
   }

   public void disconnect( )
   {
      try
      {
         stmt.close( );
         conn.close( ); 
      }
      // handle disconnection problems
      catch ( SQLException e )
      {
         showMessageDialog( null, e.getMessage( ), "Problems Disconnecting", ERROR_MESSAGE );
         System.exit( 0 );
      }
   }  // end disconnect
}
