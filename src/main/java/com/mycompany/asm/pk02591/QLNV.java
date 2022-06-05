/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asm.pk02591;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.standard.PresentationDirection;
import javax.swing.plaf.metal.MetalIconFactory;

/**
 *
 * @author Admin
 */
public class QLNV {

    static String url = "jdbc:mysql://localhost:3306/nhanvien";
    static String user = "root";
    static String password = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static List<NhanVien> findAll() {
        List<NhanVien> list = new ArrayList<>();
        String query = "select*from qlnv";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt("maNV"), rs.getString("hoTen"), rs.getInt("tuoi"),
                        rs.getString("email"), rs.getInt("luong"), rs.getString("phongBan"));
                list.add(nv);
            }
        } catch (Exception ex) {
        }
        return list;
    }

    public static void insert(String nv) {
        String tt[] = nv.split(";");
        String query = "INSERT INTO qlnv(hoTen, tuoi, email, luong, phongBan) VALUES (?,?,?,?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, tt[0]);
            pstmt.setInt(2, Integer.parseInt(tt[1]));
            pstmt.setString(3, tt[2]);
            pstmt.setInt(4, Integer.parseInt(tt[3]));
            pstmt.setString(5, tt[4]);
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String mnv) {

        String query = "delete from qlnv where maNv = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, mnv);
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void update(NhanVien nv) {
        String query = "update qlnv set hoTen = ?,tuoi = ?, email = ?, luong = ?, phongBan = ? where hoTen = '" + nv.getHoTen() + "'";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, nv.getHoTen());
            pstmt.setInt(2, nv.getTuoi());
            pstmt.setString(3, nv.getEmail());
            pstmt.setInt(4, nv.getLuong());
            pstmt.setString(5, nv.getPhongBan());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }  
    public static List<NhanVien> find(String key) {
        List<NhanVien> list = new ArrayList<>();
        try {
            String query = "select * from qlnv"
                    + "  where maNv like '%"+
                    "?"+"%' or hoTen like '%"+
                    "?"+"%' or tuoi like '%"+
                    "?"+"%' or email like '%"+
                    "?"+"%' or luong like '%"+
                    "?"+"%' or phongBan like '%"+"?%'";
            System.out.println("ne:" + query);
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, key);
            pstmt.setString(2, key);
            pstmt.setString(3, key);
            pstmt.setString(4, key);
            pstmt.setString(5, key);
            pstmt.setString(6, key);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt("maNV"), rs.getString("hoTen"), rs.getInt("tuoi"),
                        rs.getString("email"), rs.getInt("luong"), rs.getString("phongBan"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<NhanVien> findbyName(NhanVien n) {
        List<NhanVien> nvl = new ArrayList<>();
        String query = "select*from qlnv where qlnv.hoTen = '" + n.getHoTen() + "'";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt("maNV"), rs.getString("hoTen"), rs.getInt("tuoi"),
                        rs.getString("email"), rs.getInt("luong"), rs.getString("phongBan"));
                nvl.add(nv);
            }
        } catch (Exception ex) {

        }
        return nvl;
    }
}
