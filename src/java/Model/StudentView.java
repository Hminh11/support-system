/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author ^Zin^
 */
public class StudentView {
    private Student student;
    private List<Detail>detail;
    public StudentView(){
        
    }

    public StudentView(Student student, List<Detail> detail) {
        this.student = student;
        this.detail = detail;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }


    
   
}
