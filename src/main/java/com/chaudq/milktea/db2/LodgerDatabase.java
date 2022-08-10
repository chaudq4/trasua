package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.Lodger;
import com.chaudq.milktea.model2.People;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration

public class LodgerDatabase {
    public List<Lodger> searchLodgerByName(String name) {
        String sql = "SELECT * FROM people as P, account as A, lodger as L where p.accountid=a.id and L.peopleid=p.id and p.name=" + name;
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Lodger> lodgers = new ArrayList<>();
            while (rs.next()) {
                String newname = rs.getString("Name");
                String peopleid = rs.getString("peopleid");
                String school = rs.getString("school");
                String job = rs.getString("Job");
                People people = new People();
                people.setId(peopleid);
                people.setName(newname);
                Lodger lodger = new Lodger();
                lodger.setJob(job);
                lodger.setPeople(people);
                lodger.setSchool(school);
                lodgers.add(lodger);

            }
            return lodgers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Lodger getLodgerByID(String idLodger) {
        String sql = "SELECT * FROM people AS p, lodger AS l where P.ID=L.PeopleId and id=?";
        try {
            PreparedStatement ps = LandladyDatabase.conn.prepareStatement(sql);
            ps.setString(1,idLodger);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name");
                String dob = rs.getString("Dob");
                String phone = rs.getString("phone");
                String address = rs.getString("Address");
                String school = rs.getString("School");
                String job = rs.getString("Job");
                String sex = rs.getString("Sex");
                People people = new People();
                people.setId(idLodger);
                people.setName(name);
                people.setAddress(address);
                people.setDob(dob);
                people.setPhone(phone);
                people.setSex(sex);
                Lodger lodger = new Lodger();
                lodger.setPeople(people);
                lodger.setSchool(school);
                lodger.setJob(job);
                return lodger;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
