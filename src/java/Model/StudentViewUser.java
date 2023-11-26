/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentViewUser {
    private StudentUser st;
   private List<DetailUser>detail;

    public StudentViewUser() {
    }

    public StudentViewUser(StudentUser st, List<DetailUser> detail) {
        this.st = st;
        this.detail = detail;
    }

    public StudentUser getSt() {
        return st;
    }

    public void setSt(StudentUser st) {
        this.st = st;
    }

    public List<DetailUser> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailUser> detail) {
        this.detail = detail;
    }

   
}
