/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ^Zin^
 */
public class AddnewDAO extends DBConnect {

    PreparedStatement stm;
    ResultSet rs = null;

    public int getschoolID(String name, int level) {
        String query = "select schoolID from School where schoolName like ? and Level = ?";
        try {

            stm = connect.prepareStatement(query);
            stm.setString(1, name);
            stm.setInt(2, level);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getclassID(String lop, int truong) {
        String query = "select ClassID from Classes where Class like ? and schoolID = ?";
        try {

            stm = connect.prepareStatement(query);
            stm.setString(1, lop);
            stm.setInt(2, truong);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void AddSchool(String schoolname, int level) {
        String query = "insert into School(schoolName,Level)\n"
                + "values(?,?)";
        try {

            stm = connect.prepareStatement(query);
            stm.setString(1, schoolname);
            stm.setInt(2, level);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddTeacher(String name, int classid, int phone) {
        String query = "insert into Teacher(TeacherName,classID,TPhoneNum)\n"
                + "values(?,?,?)";
        try {

            stm = connect.prepareStatement(query);
            stm.setString(1, name);
            stm.setInt(2, classid);
            stm.setInt(3, phone);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddClass(int schoolid, String name, int confirm) {
        String query = "insert into Classes(SchoolID,Class,Confirm)\n"
                + "                values(?,?,?)";
        try {

            stm = connect.prepareStatement(query);
            stm.setInt(1, schoolid);
            stm.setString(2, name);
            stm.setInt(3, confirm);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddStudent(String name, String sex, String status, int lop) {
        String query = "insert into Student(StudentName,Sex,Status,ClassID)\n"
                + "values (?,?,?,?)";
        try {

            stm = connect.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, sex);
            stm.setString(3, status);
            stm.setInt(4, lop);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String []args){
        AddnewDAO dao = new AddnewDAO();
      
        System.out.println(dao.getschoolID("aaa", 1));
        
    }

}
