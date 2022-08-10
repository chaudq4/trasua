package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Bill;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class BillDatabase {
    public boolean addBill(Bill bill) {
        String sql = "INSERT INTO bill (id, feeid, timepay, typepay ) VALUES (?, ?, ?, ?) ";
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            LandladyDatabase.conn.setAutoCommit(false);
            ps.setString(1, bill.getId());
            ps.setString(2, bill.getFeeId().getId());
            ps.setString(3, bill.getTimePay());
            ps.setString(4, bill.getTypePay());
            ps.execute();
            sql = "UPDATE fee SET status=? WHERE id=?";
            ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1, "Đã thanh toán");
            ps.setString(2, bill.getFeeId().getId());
            ps.execute();
            LandladyDatabase.conn.commit();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                LandladyDatabase.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return true;
    }
}
