package statement;

import java.sql.*;
import java.util.logging.Logger;

public class Statements {

    private static final Logger logger = Logger.getLogger(Statements.class.getName());

    // TODO: read from application.yml
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

            // create statement
            Statement statement = connection.createStatement();
            logger.info("statement created" + statement);

            String insertUserSql = "INSERT user(name, email, country) VALUES"
                    + "('" + name + "','" + email + "','" + country + "')";
            logger.info("execute update: " + insertUserSql);

            // execute
            // INSERT user(name, email, country) VALUES
            // ('?', '?', '?')
            statement.executeUpdate(insertUserSql);

            // close connection
            connection.close();
            logger.info("connection closed");
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    // select - query
    public void queryOperation() {
        try {
            // create connection
            Connection connection = DriverManager.getConnection(url, user, pass);
            logger.info("connection created" + connection);

            // create statement
            Statement statement = connection.createStatement();
            logger.info("statement created" + statement);

            String selectUsersSql = "SELECT id, name, email, country FROM user";
            logger.info("execute select: " + selectUsersSql);

            // execute
            ResultSet rs = statement.executeQuery(selectUsersSql);

            // iterate result set
            while (rs.next()) {
                // save properties from results set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                logger.info(id + ", " + name + ", " + email + ", " + country);
            }

            // close connection
            connection.close();
            logger.info("connection closed");
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    public void updateOperation(int id, String name, String email, String country) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE user SET name = '" + name + "', " +
                    "email = '" + email + "', country = '" + country + "' WHERE id = " + id);
        } catch (SQLException e) {
            // Handle errors for JDBC
            logger.severe("failed to update");
        } catch (Exception e) {
            // Handle errors for Class.forName
            logger.severe("something wrong happened");
        } finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
            } // do nothing

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void deleteOperation(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM user WHERE id = " + id);
        } catch (SQLException e) {
            logger.severe("SQL State: " + e.getSQLState() + " - " + e.getMessage());
        } catch (Exception e) {
            logger.severe("something bad happened");
        }
    }
}
