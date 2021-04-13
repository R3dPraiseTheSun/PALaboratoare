import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/test" ;
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        String sqlcmd = "CREATE TABLE MOVIES" +
                "(id INTEGER not NULL, " +
                " title VARCHAR(255), " +
                " release_date DATE(), " +
                " duration INTEGER, " +
                " score INTEGER";
        statement.executeUpdate(sqlcmd);

        sqlcmd = "CREATE TABLE GENRES" +
                 "(id INTEGER not NULL, " +
                 " name VARCHAR(255), ";
        statement.executeUpdate(sqlcmd);

        sqlcmd = "CREATE TABLE CEVA";
        statement.executeUpdate(sqlcmd);

        connection.close();
    }
}
