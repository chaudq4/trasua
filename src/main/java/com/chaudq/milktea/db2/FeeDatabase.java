package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Fee;
import com.chaudq.milktea.model2.Landlady;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class FeeDatabase {
    public List<Fee> getAllFee(String idRent) {
        String sql = "SELECT *FROM fee WHERE rentId=?";
        List<Fee> fees = new ArrayList<>();
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, idRent);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String month = rs.getString("month");
                int numberOfE = rs.getInt("NumberOfElectric");
                int numberOfW = rs.getInt("NumberOfWater");
                int park = rs.getInt("park");
                int other = rs.getInt("other");
                String status = rs.getString("status");
                Fee fee = new Fee(id, month, numberOfE, numberOfW,  park, other, status);
                fees.add(fee);
            }
            return fees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addFee(Fee fee) {
        String sql = "INSERT INTO fee (id, rentid, Month, NumberOfElectric,NumberOfWater,Park,Other,Status ) VALUES ( ?, ?, ?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, fee.getId());
            ps.setString(2, fee.getRentId().getId());
            ps.setString(3, fee.getMonth());
            ps.setInt(4, fee.getNumberOfElectric());
            ps.setInt(5, fee.getNumberOfWater());
            ps.setInt(6, fee.getPark());
            ps.setInt(7, fee.getOther());
            ps.setString(8, "Chưa thanh toán");
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
