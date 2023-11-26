/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;

/**
 *
 * @author ghuy
 */
public class User {
    private int id;
    private String username;
    private String fullname;
    private String email;
    private String phone;
    private byte[] passwordHashed;
    private byte[] salted;
    private int RoleID;
    public String lastLogin;
    public Role role;

    public User(int id, String fullname, String username, String email, String phone, byte[] salted, byte[] passwordHashed, int RoleID) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.passwordHashed = passwordHashed;
        this.salted = salted;
        this.RoleID = RoleID;
    }

    public User(int id, String username, String fullname, String email, String phone, byte[] passwordHashed, byte[] salted, int RoleID, String lastLogin, Role role) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.passwordHashed = passwordHashed;
        this.salted = salted;
        this.RoleID = RoleID;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

   

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setSalted(byte[] salted) {
        this.salted = salted;
    }

    public String getFullname() {
        return fullname;
    }

    public byte[] getSalted() {
        return salted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getPasswordHashed() {
        return Arrays.copyOf(passwordHashed, passwordHashed.length);
    }

    public void setPasswordHashed(byte[] passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }


    
}
