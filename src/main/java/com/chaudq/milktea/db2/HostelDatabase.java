package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.*;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HostelDatabase {
    public List<Hostel> getAllHostel(Landlady landlady) {
        List<Hostel> hostels = new ArrayList<>();
        String sql = "SELECT * FROM hostel where landladypeopleid=?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = LandladyDatabase.conn.prepareStatement(sql);
            preparedStatement.setString(1, landlady.getPeopleId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                String camera = resultSet.getString("camera");
                String park = resultSet.getString("park");
                String price = resultSet.getString("price");
                String description = resultSet.getString("descrition");
                String addressid = resultSet.getString("addressid");
                Address address = new AddressDatabase().getAddressByID(addressid);
                Hostel hostel = new Hostel(id, number, camera, park, price, description, name);
                hostel.setAddressId(address);
                hostels.add(hostel);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hostels;
    }

    public boolean insertHostel(Hostel hostel) {
        if (!new AddressDatabase().insertAddress(hostel.getAddressId())) {
            String sql = "INSERT INTO hostel (id, addressid,landladypeopleid, number,camera, park,price,descrition,name ) VALUES (?, ?, ?, ?,?,?,?,?,?) ";
            try {
                PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
                ps.setString(1, hostel.getId());
                ps.setString(2, hostel.getAddressId().getId());
                ps.setString(3, hostel.getLandladyPeopleId().getPeopleId());
                ps.setInt(4, hostel.getNumber());
                ps.setString(5, hostel.getCamera());
                ps.setString(6, hostel.getPark());
                ps.setString(7, hostel.getPrice());
                ps.setString(8, hostel.getDescrition());
                ps.setString(9, hostel.getName());
                return ps.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return true;
    }
}
