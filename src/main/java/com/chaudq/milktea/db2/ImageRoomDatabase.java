package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Imageroom;
import com.chaudq.milktea.model2.Room;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ImageRoomDatabase {
    public static Connection conn = null;

    List<Imageroom> getAllImageByIdRoom(String idRoom) {
        try {
            List<Imageroom> imagerooms = new ArrayList<>();
            String sql = "SELECT * FROM imageroom WHERE roomid=?";
            PreparedStatement preparedStatement = LandladyDatabase.conn.prepareStatement(sql);
            preparedStatement.setString(1, idRoom);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String link = resultSet.getString("link");
                Imageroom imageroom = new Imageroom();
                imageroom.setId(id);
                imageroom.setLink(link);
                imagerooms.add(imageroom);
            }
            return imagerooms;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
