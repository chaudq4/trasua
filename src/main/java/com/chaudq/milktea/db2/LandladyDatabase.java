package com.chaudq.milktea.db2;


import com.chaudq.milktea.model2.Account;
import com.chaudq.milktea.model2.Landlady;
import com.chaudq.milktea.model2.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class LandladyDatabase {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/hostel";
    public static Connection conn = null;


    @Bean
    public void intialize() {
        String USER = "root";
        String PASS = "15041997";
        try {
            // Buoc 2: Dang ky Driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Dang ket noi toi co so du lieu ...");
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {

            }
            // Buoc 4: Thuc thi truy van
            System.out.println("Tao cac lenh truy van SQL ...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Landlady login(Account account) {
        try {

            String sql = "SELECT * FROM account WHERE username= ? AND password=? AND type=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getType());
            ResultSet resultSet = preparedStatement.executeQuery();
            String id = null;
            String email = null;
            while (resultSet.next()) {
                id = resultSet.getString("id");
                email = resultSet.getString("email");
            }

            if (id == null) return null;


            sql = "SELECT * FROM people WHERE accountid= ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String idPeople = resultSet.getString("id");
                String name = resultSet.getString("name");
                String dob = resultSet.getString("dob");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                account.setEmail(email);
                account.setId(id);
                People people = new People(idPeople, name, dob, phone, address, account);
                Landlady landlady = new Landlady();
                landlady.setPeople(people);
                landlady.setPeopleId(idPeople);

                return landlady;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(Account account) {
        String sql = "INSERT INTO account (id, username, password, email,type ) VALUES (?, ?, ?, ?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getId());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.setString(4, account.getEmail());
            ps.setString(5, account.getType());
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateInfo(Landlady landlady) {
        String sql = "INSERT INTO people (id, accountid,name, dob, phone,address,sex ) VALUES (?, ?, ?, ?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, landlady.getPeopleId());
            ps.setString(2, landlady.getPeople().getAccountId().getId());
            ps.setString(3, landlady.getPeople().getName());
            ps.setString(4, landlady.getPeople().getDob());
            ps.setString(5, landlady.getPeople().getPhone());
            ps.setString(6, landlady.getPeople().getAddress());
            ps.setString(7, landlady.getPeople().getSex());
            ps.execute();

            String sql1 = "INSERT INTO landlady (peopleid ) VALUES (?) ";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, landlady.getPeopleId());
            return ps1.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
