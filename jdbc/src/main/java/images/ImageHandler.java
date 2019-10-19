package images;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ImageHandler {

    private static final Logger logger = Logger.getLogger(ImageHandler.class.getName());

    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    public void uploadImage() {
        // create connection
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            String insertImageSql = "INSERT INTO images VALUES (?, ?,?)";

            // get name of image
            String name = "save-me.png";
            Path pathToImage = Paths.get("D:\\cosmin\\dev\\sda-group11\\jdbc\\src\\main\\resources\\save-me.png");
//            Path pathToImage = Paths.get(getClass().getClassLoader().getResource("save-me.png").toString());

            PreparedStatement preparedStatement;
            InputStream fis = Files.newInputStream(pathToImage);

            // create statement
            preparedStatement = connection.prepareStatement(insertImageSql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, name);
            preparedStatement.setBinaryStream(3, fis, fis.available());

            // execute statement
            preparedStatement.executeUpdate();

            fis.close();
            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
