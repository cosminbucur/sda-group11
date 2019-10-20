package images;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
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

            String insertImageSql = "INSERT INTO images VALUES (?, ?, ?)";

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

    public InputStream downloadImage(String imageName) {
        String sql = "SELECT * FROM images where name = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            Path pathToImage = Paths.get("jdbc\\src\\main\\resources\\image-from-db.png");
            OutputStream fos = Files.newOutputStream(pathToImage);

            statement.setString(1, imageName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                // 3 means 3nd column data
                Blob blob = rs.getBlob(3);
                // 1 means first byte
                byte[] content = blob.getBytes(1, (int) blob.length());
                fos.write(content);
                fos.close();
                return new ByteArrayInputStream(content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
