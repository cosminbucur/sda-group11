package statement;

import java.sql.*;
import java.util.logging.Logger;

public class Statements {

    private static final Logger logger = Logger.getLogger(Statements.class.getName());

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

}
