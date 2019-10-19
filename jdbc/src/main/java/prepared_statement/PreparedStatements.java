package prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PreparedStatements {

    private static final Logger logger = Logger.getLogger(PreparedStatements.class.getName());

    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    // CRUD

    // insert - command
    public void insertOperation(String name, String email, String country) {
        try {
            // create connection
            Connection connection = DriverManager.getConnection(url, user, pass);
            logger.info("connection created" + connection);

            String insertUserSql = "INSERT user(name, email, country) VALUES (?, ?, ?)";
            logger.info("execute update: " + insertUserSql);

            // create prepared statement
            PreparedStatement statement = connection.prepareStatement(insertUserSql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, country);
            logger.info("statement created" + statement);

            // execute
            // INSERT user(name, email, country) VALUES
            // ('?', '?', '?')
            int result = statement.executeUpdate();
            logger.info("Insert return: " + (result == 1 ? "OK" : "ERROR"));

            // close connection
            connection.close();
            logger.info("connection closed");
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    public void deleteOperation(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            String deleteSql = "DELETE FROM user WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1, id);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
