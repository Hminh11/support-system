/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class InvoiceSt {
     private int id;
    private Date time;
    private String cl;
    private String sch;
    private String tea;
    private int phone;

    public InvoiceSt() {

    }

    public InvoiceSt(int id, Date time, String cl, String sch, String tea, int phone) {
        this.id = id;
        this.time = time;
        this.cl = cl;
        this.sch = sch;
        this.tea = tea;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getSch() {
        return sch;
    }

    public void setSch(String sch) {
        this.sch = sch;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
