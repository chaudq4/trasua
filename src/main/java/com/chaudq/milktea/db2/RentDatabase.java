package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Fee;
import com.chaudq.milktea.model2.Landlady;
import com.chaudq.milktea.model2.Lodger;
import com.chaudq.milktea.model2.Rent;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Configuration

public class RentDatabase {
    public boolean addRent(Rent rent) {

        String sql = "INSERT INTO rent(id,LodgerPeopleId,roomid,starttime,endtime) VALUES(?,?,?,?,?)";
        try {

            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            LandladyDatabase.conn.setAutoCommit(false);
            ps.setString(1, rent.getId());
            ps.setString(2, rent.getLodgerPeopleId().getPeople().getId());
            ps.setString(3, rent.getRoomId().getId());
            ps.setString(4, rent.getStartTime());
            ps.setString(5, "renting");
            ps.execute();
            sql = "UPDATE room SET status=? WHERE id=?";
            ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, "Có");
            ps.setString(2, rent.getRoomId().getId());
            ps.execute();
            LandladyDatabase.conn.commit();
            return false;
        } catch (SQLException e) {
            try {
                LandladyDatabase.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }
        return true;
    }

    public Rent getRent(String idRoom) {

        String sql = "SELECT *FROM rent WHERE endtime=? AND roomid="+idRoom;
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, "renting");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idRent = rs.getString("id");
                String idLodger = rs.getString("LodgerPeopleId");
                String startTime = rs.getString("startTime");
                List<Fee> feeList = new FeeDatabase().getAllFee(idRent);
                Lodger lodger = new LodgerDatabase().getLodgerByID(idLodger);
                Rent rent = new Rent();
                rent.setId(idRent);
                rent.setFeeList(feeList);
                rent.setStartTime(startTime);
                rent.setLodgerPeopleId(lodger);
                return rent;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
