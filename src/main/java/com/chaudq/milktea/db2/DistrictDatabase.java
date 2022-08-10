package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.District;
import com.chaudq.milktea.model2.Street;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DistrictDatabase {
    public List<District> getAll() {
        try {
            List<District> districts = new ArrayList<>();
            String sql = "SELECT * FROM district ";
            PreparedStatement preparedStatement = LandladyDatabase.conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                List<Street> streets = new StreetDatabase().getAllByIDDistrict(id);
                District district = new District();
                district.setId(id);
                district.setName(name);
                district.setStreetList(streets);
                districts.add(district);
            }
            return districts;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public District getDistrictByID(String id) {
        try {

            String sql = "SELECT * FROM district WHERE id=? ";
            PreparedStatement preparedStatement = LandladyDatabase.conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                District district = new District();
                district.setId(id);
                district.setName(name);
                return district;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
