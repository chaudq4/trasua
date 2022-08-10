package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Address;
import com.chaudq.milktea.model2.Street;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class AddressDatabase {
    public Address getAddressByID(String id) {
        String sql = "SELECT * FROM address WHERE ID=?";
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idStreet = rs.getString("streetid");
                String latitue = rs.getString("latitue");
                String longtitue = rs.getString("longtitue");
                String detail = rs.getString("detail");
                Street street = new StreetDatabase().getStreetByID(idStreet);
                Address address = new Address();
                address.setId(id);
                address.setDetail(detail);
                address.setLatitue(latitue);
                address.setLongtitue(longtitue);
                address.setStreetId(street);
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertAddress(Address address) {
        String sql = "INSERT INTO address (id, streetid, latitue, longtitue,detail ) VALUES (?, ?, ?, ?,?) ";
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, address.getId());
            ps.setString(2, address.getStreetId().getId());
            ps.setString(3, address.getLatitue());
            ps.setString(4, address.getLongtitue());
            ps.setString(5, address.getDetail());
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
