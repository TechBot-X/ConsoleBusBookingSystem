
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connectionutil.Connectionutil;

import Project_1.Project1_Console;

public class BusDAO {

    private Connection con;

    public BusDAO() throws Exception {

        con = Connectionutil.getConnection();
        System.out.println("----Inside Bus DAO Object Created----");
    }

   
    public ArrayList<Project1_Console> getAllBookings() throws SQLException {

        String sql = "select * from bus";

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        ArrayList<Project1_Console> list = new ArrayList<Project1_Console>();

        while (rs.next()) {

            Project1_Console t = new Project1_Console(
                    rs.getInt("busId"),
                    rs.getString("customerName"),
                    rs.getString("pickup"),
                    rs.getString("destination"),
                    rs.getDouble("fare"));
                   

            list.add(t);
        }

        rs.close();

        return list;
    }

    
    public int addBooking(Project1_Console pc) throws SQLException {

        String sql = "insert into bus values(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, pc.getTaxiId());
        ps.setString(2, pc.getCustomerName());
        ps.setString(3, pc.getPickup());
        ps.setString(4, pc.getDestination());
        ps.setDouble(5, pc.getFare());
       

        int i = ps.executeUpdate();

        return i;
    }

   
    public int updateFare(int busId, double fare) throws SQLException {

        String sql = "update bus set fare=? where busId=?1";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, fare);
        ps.setInt(2, busId);

        int i = ps.executeUpdate();

        return i;
    }

   
    public int deleteBooking(int busId) throws SQLException {

        String sql = "delete from bus where busId=?1";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, busId);

        int i = ps.executeUpdate();

        return i;
    }

}

