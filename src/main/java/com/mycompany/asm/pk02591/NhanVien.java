/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asm.pk02591;
// em add dữ liêu vào nó k lên table
// trong sql co bao nhieu du lieu
// có 3, mà e đang làm bài tập thêm xóa sửa các thứ, 
// thi phai lam them chuc nang chu
/**
 *
 * @author Admin
 */
public class NhanVien {
    private int maNv;
    private String hoTen;
    private int tuoi;
    private String email;
    private int luong;
    private String phongBan;

    public NhanVien() {
    }

    public NhanVien(int maNv, String hoTen, int tuoi, String email, int luong, String phongBan) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.email = email;
        this.luong = luong;
        this.phongBan = phongBan;
    }

    public int getMaNv() {
        return maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    
}
