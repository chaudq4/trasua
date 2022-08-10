package com.chaudq.milktea.db2;

import com.chaudq.milktea.model2.District;
import com.chaudq.milktea.model2.Imageroom;
import com.chaudq.milktea.model2.Street;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StreetDatabase {
    public List<Street> getAllByIDDistrict(String idDistrict) {
        try {
            List<Street> streets = new ArrayList<>();
            String sql = "SELECT * FROM street WHERE districtid=?";
            PreparedStatement preparedStatement = LandladyDatabase.conn.prepareStatement(sql);
            preparedStatement.setString(1, idDistrict);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                streets.add(new Street(id, name));
            }
            return streets;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Street getStreetByID(String id) {
        try {

            String sql = "SELECT * FROM street WHERE id=? ";
            PreparedStatement preparedStatement = LandladyDatabase.conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String districtid = resultSet.getString("districtid");
                District district;
                district = new DistrictDatabase().getDistrictByID(districtid);
                Street street = new Street();
                street.setId(id);
                street.setName(name);
                street.setDistrictId(district);
                return street;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

