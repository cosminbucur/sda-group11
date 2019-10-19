package transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ManageTransactions {

    private static final Logger logger = Logger.getLogger(ManageTransactions.class.getName());

    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    // insert - command
    public void insertOperation() {
        try {
            // create connection
            Connection connection = DriverManager.getConnection(url, user, pass);
            logger.info("connection created" + connection);

            // go to manual mode
            connection.setAutoCommit(false);

            String insertUserSql = "INSERT user(name, email, country) VALUES (?, ?, ?)";
            logger.info("execute update: " + insertUserSql);

            // create prepared statement
            PreparedStatement statement = connection.prepareStatement(insertUserSql);

            // read statement params from user input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("enter name: ");
                String name = br.readLine();

                System.out.println("enter email: ");
                String email = br.readLine();

                System.out.println("enter country: ");
                String country = br.readLine();

                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, country);
                logger.info("statement created" + statement);

                statement.executeUpdate();
                System.out.println("commit / rollback");

                String transactionOperation = br.readLine();

                if (transactionOperation.equals("commit")) {
                    connection.commit();
                }
                if (transactionOperation.equals("rollback")) {
                    connection.rollback();
                }

                System.out.println("Want to add more records y/n");
                String answer = br.readLine();
                if (answer.equals("n")) {
                    break;
                }
            }

            // commit
            connection.commit();
            System.out.println("records successfully saved");

            // close connection
            connection.close();
            logger.info("connection closed");
        } catch (SQLException | IOException e) {
            logger.severe("failed to insert");
        }
    }
}
