/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Teacher {
    private String teacherName;
    private String tPhoneNum;

    public Teacher() {
    }

    public Teacher(String teacherName, String tPhoneNum) {
        this.teacherName = teacherName;
        this.tPhoneNum = tPhoneNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String gettPhoneNum() {
        return tPhoneNum;
    }

    public void settPhoneNum(String tPhoneNum) {
        this.tPhoneNum = tPhoneNum;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherName=" + teacherName + ", tPhoneNum=" + tPhoneNum + '}';
    }

    

    
   }
