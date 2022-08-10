package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Hostel;
import com.chaudq.milktea.model2.Imageroom;
import com.chaudq.milktea.model2.Room;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RoomDatabase {


    public List<Room> getAllRoomByHostelID(String idHostel) {
        try {
            List<Room> rooms = new ArrayList<>();
            String sql = "SELECT * FROM room WHERE hostelid = " + idHostel;

            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String square = resultSet.getString("square");
                String kitchen = resultSet.getString("kitchen");
                String wc = resultSet.getString("wc");
                String bed = resultSet.getString("bed");
                String airconditional = resultSet.getString("airconditional");
                String waterheater = resultSet.getString("waterheater");
                String price = resultSet.getString("price");
                String electric = resultSet.getString("electric");
                String water = resultSet.getString("water");
                String internet = resultSet.getString("internet");
                String status = resultSet.getString("status");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                List<Imageroom> imagerooms = new ImageRoomDatabase().getAllImageByIdRoom(id);
                Room room = new Room(id, square, kitchen, wc, bed, airconditional, waterheater, price, electric, water, internet, status, name, description);
                room.setImageroomList(imagerooms);
                rooms.add(room);
            }
            return rooms;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertRoom(Room room) {

        String sql = "INSERT INTO room (id, hostelid,square, kitchen,wc, bed,airconditional,waterheater,price,electric,water,internet,name,description ,status)" +
                " VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, room.getId());
            ps.setString(2, room.getHostelId().getId());
            ps.setString(3, room.getSquare());
            ps.setString(4, room.getKitchen());
            ps.setString(5, room.getWc());
            ps.setString(6, room.getBed());
            ps.setString(7, room.getAirConditional());
            ps.setString(8, room.getWater());
            ps.setString(9, room.getPrice());
            ps.setString(10, room.getElectric());
            ps.setString(11, room.getWater());
            ps.setString(12, room.getInternet());
            ps.setString(13, room.getName());
            ps.setString(14, room.getDescription());
            ps.setString(15,"Không");
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;


    }

}
