/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author Admin
 */
public class Student {
private int id;
    private String name;
    private int gender;
    private int height;
    private int weight;
    private String status;
    private String editBy;

    public Student() {
    }

    public Student(int id, String name, int gender, int height, int weight, String status, String editBy) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.status = status;
        this.editBy = editBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
    
    
   
}
