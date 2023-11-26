/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Service.UserService;
import Utils.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Role;
import Model.User;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author ghuy
 */
public class UserDAO extends DBConnect {

    /**
     * Return user object corresponding to id
     *
     * @param id
     * @return
     */
    public User getUserByID(int id) {
        String sqlStatement = "SELECT * FROM [Account] WHERE id = " + id + ";";
        ResultSet rs = getData(sqlStatement);
        User user = null;
        try {
            if (rs.next()) { // if there exists user with id
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);

                user = new User(id, fullname, username, email, phone, salt, passwordHashed, RoleID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    /**
     * Get User object by username
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        String sqlStatement = "SELECT * FROM [Account] WHERE username = '" + username + "';";
        ResultSet rs = getData(sqlStatement);
        User user = null;
        try {
            if (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);

                user = new User(id, fullname, username, email, phone, salt, passwordHashed, RoleID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    /**
     * Get User by username
     *
     * @param email
     * @return User object, or null if there is no user with email provided
     */
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM [Account] WHERE email = ?;";
        User user = null;
        try {
            PreparedStatement pre = connect.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);

                String phone = rs.getString(5);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);

                user = new User(id, fullname, username, email, phone, salt, passwordHashed, RoleID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public User getUserByPhone(String PhoneNum) {
        String sql = "SELECT * FROM [Account] WHERE phone = ?;";
        User user = null;
        try {
            PreparedStatement pre = connect.prepareStatement(sql);
            pre.setString(1, PhoneNum);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String email = rs.getString(4);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);

                user = new User(id, fullname, username, email, PhoneNum, salt, passwordHashed, RoleID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    /**
     * Add an user to DB
     *
     * @param user
     */
    public void addUser(User user) {
        String sqlStatement = "INSERT [dbo].[Account] ([id], [fullName], [username], [email], [phone], [salt], [pwd_hashed], [RoleID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pre;
        try {
            pre = connect.prepareStatement(sqlStatement);
            pre.setInt(1, user.getId());
            pre.setString(2, user.getFullname());
            pre.setString(3, user.getUsername());
            pre.setString(4, user.getEmail());
            pre.setString(5, user.getPhone());
            pre.setBytes(6, user.getSalted());
            System.out.println(Arrays.toString(user.getSalted()));
            pre.setBytes(7, user.getPasswordHashed());
            pre.setInt(8, user.getRoleID());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Get last user id
     *
     * @return the last ID in the DB, or -1 if DB is empty
     */
    public int getLastID() {
        String sqlStatement = "SELECT TOP(1) id FROM [Account] ORDER BY id DESC;";

        ResultSet rs = getData(sqlStatement);
        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * DEPRECATED
     *
     * @param username
     * @param password
     * @return
     */
    public boolean validate(String username, String password) {
//      SQL Server does not take into account whitespace in WHERE, so we must use LIKE for password
        String sqlStatement = "SELECT id FROM [Account] WHERE username = ? AND pwd_hashed LIKE ?;";
//        System.out.println(username.length() + " " + password.length());
        boolean success = false;

        try {
            PreparedStatement preStatement = connect.prepareStatement(sqlStatement);
            preStatement.setString(1, username);
            preStatement.setString(2, password);

            ResultSet rs = preStatement.executeQuery();

            success = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    /**
     * Get salt of account by username
     *
     * @param username
     * @return salt String, or null if error
     */
    public byte[] getUserSalt(String username) {
        String sqlStatement = "SELECT salt FROM [Account] WHERE username LIKE ?;";
        try {
            PreparedStatement pre = connect.prepareStatement(sqlStatement);

            pre.setString(1, username);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] getHashedPassword(String username) {
        String sqlStatement = "SELECT pwd_hashed FROM [Account] WHERE username LIKE ?;";
        try {
            PreparedStatement pre = connect.prepareStatement(sqlStatement);

            pre.setString(1, username);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] getHashedPasswordByEmail(String email) {
        String sqlStatement = "SELECT pwd_hashed FROM [Account] WHERE email = ?;";
        try {
            PreparedStatement pre = connect.prepareStatement(sqlStatement);

            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Check whether an username exists in the DB
     *
     * @param username
     * @return true if username already exist, false if it's not
     */
    public boolean isUsernameExist(String username) {
        String sqlStatement = "SELECT id FROM [Account] WHERE username LIKE '" + username + "';";
        ResultSet rs = getData(sqlStatement);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isEmailExist(String email) {
        String sqlStatement = "SELECT id FROM [Account] WHERE [email] LIKE '" + email + "';";
        ResultSet rs = getData(sqlStatement);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isPhoneExist(String phone) {
        String sqlStatement = "SELECT id FROM [Account] WHERE [phone] LIKE '" + phone + "';";
        ResultSet rs = getData(sqlStatement);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean validateUserName(String input) {
        int maxConsecutiveSpaces = 1;
        int consecutiveSpaces = 0;

        for (char c : input.toCharArray()) {
            if (c == ' ') {
                consecutiveSpaces++;
                if (consecutiveSpaces > maxConsecutiveSpaces) {
                    return true; // More than 2 consecutive spaces found
                }
            } else {
                consecutiveSpaces = 0; // Reset the count
            }
        }

        return false; // Input is valid
    }
    
    public boolean validateInput(String input) {
        // Regular expression to allow only letters, digits, and at most 2 consecutive spaces
        //String regex = "^[a-zA-Z0-9 ]*(?:\\s{0,2}[a-zA-Z0-9 ]*)*$";
        String regex = "^[a-zA-Z0-9 ]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
    

    public Vector<User> getAllUSers() {
        String sqlStatement = "SELECT * FROM [Account];";
        ResultSet rs = getData(sqlStatement);
        Vector<User> users = new Vector<>();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);

                User user = new User(id, fullname, username, email, phone, salt, passwordHashed, RoleID);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    /**
     * Get user role's id corresponding to username.
     *
     * @param username
     * @return role id. -1 if there is no username in DB
     */
    public int getUserRole(String username) {
        System.out.println("Username: " + username);
        String sqlStatement = "SELECT RoleID FROM [Account]  WHERE username LIKE ?;";

        try {
            PreparedStatement pre = connect.prepareStatement(sqlStatement);

            pre.setString(1, username);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    /**
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        String sql = "UPDATE [Account]\n"
                + "   SET [fullName] = ?,[username] = ?,[email] = ?,[phone] = ?,[RoleID] = ?\n"
                + " WHERE id = ?;";
        int n = 0;

        try {
            PreparedStatement pre = connect.prepareStatement(sql);
            pre.setString(1, user.getFullname());
            pre.setString(2, user.getUsername());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getPhone());
            pre.setInt(5, user.getRoleID());
            pre.setInt(6, user.getId());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update user error: " + ex.getMessage());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    /**
     * Get salt of account by email
     *
     * @param email
     * @return salt String, or null if error
     */
    public byte[] getUserSaltByEmail(String email) {
        String sqlStatement = "SELECT salt FROM [Account] WHERE email = ?;";
        try {
            PreparedStatement pre = connect.prepareStatement(sqlStatement);

            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param email email of account to update
     * @param password byte[] array contains hashed password
     * @return
     */
    public int updatePassword(String email, byte[] password) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [pwd_hashed] = ?\n"
                + " WHERE email LIKE ?;";
        int n = 0;
        try {
            PreparedStatement pre = connect.prepareStatement(sql);
            pre.setBytes(1, password);
            pre.setString(2, email);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    /**
     *
     * @param username true
     * @param password true
     * @return user
     */
    public User getUserByNameAndPass(String username, String pass) {

        User user = null;
        UserService service = new UserService();

        byte[] salt = getUserSalt(username);
        if (salt != null) {

            byte[] hashedPassword = service.hashingPassword(pass, salt);

            byte[] realHashed = getHashedPassword(username);

            if (Arrays.equals(realHashed, hashedPassword)) {

                return getUserByUsername(username);
            }
        }

        return null;
    }

    /**
     * for time log user
     *
     * @return all user except admin (system only one admin)
     */
    public List<User> getAllUSer(String idd) {
        String sqlStatement = "select * from [Account] where id !=  " + idd;
        ResultSet rs = getData(sqlStatement);
        List<User> users = new ArrayList();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);
                String timeLogin = getLastTimeLogin(id + "");
                String time = "";
                if (timeLogin == null) {
                    time = "No history login";
                } else {
                    time = timeLogin;
                }
                Role role = getRoleById(RoleID + "");
                User user = new User(id, fullname, username, email, phone, salt, passwordHashed, RoleID, time, role);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public List<User> getAllStaff() {
        String sqlStatement = "select * from [Account] where RoleID =3  ";
        ResultSet rs = getData(sqlStatement);
        List<User> users = new ArrayList();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                byte[] salt = rs.getBytes(6);
                byte[] passwordHashed = rs.getBytes(7);
                int RoleID = rs.getInt(8);
                String timeLogin = getLastTimeLogin(id + "");
                String time = "";
                if (timeLogin == null) {
                    time = "No history login";
                } else {
                    time = timeLogin;
                }
                Role role = getRoleById(RoleID + "");
                User user = new User(id, fullname, username, email, phone, salt, passwordHashed, RoleID, time, role);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    /**
     *
     * @param user login into system
     * @return time
     */
    public String getLastTimeLogin(String userID) {
        String sqlStatement = "select * from UserLog where UserID = ? order by [Time] DESC ";
        PreparedStatement pre;
        try {

            pre = connect.prepareStatement(sqlStatement);
            pre.setString(1, userID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString(3);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @return Role user
     */
    public Role getRoleById(String id) {
        String sqlStatement = "select * from [Role] where role_id = ?";

        try {
            PreparedStatement pre = connect.prepareStatement(sqlStatement);

            pre.setString(1, id);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * get role for change for admin
     *
     * @return
     */
    public List<Role> getAllRole() {
        String sqlStatement = "select * from [Role] where role_id > 1";
        ResultSet rs = getData(sqlStatement);
        List<Role> roles = new ArrayList();
        try {
            while (rs.next()) {
                roles.add(new Role(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    /**
     * insert the time log user into database
     *
     * @return
     */
    public void InsertIntoUserLog(String userID, String action) {
        String sqlStatement = "Insert into UserLog values (?,?,?)";
        PreparedStatement pre;
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(currentDateTime);
            timestamp.setNanos(0);
            pre = connect.prepareStatement(sqlStatement);
            pre.setString(1, userID);
            pre.setTimestamp(2, timestamp);
            pre.setString(3, action);

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * delete the user
     *
     * @return
     */
    public void DeleteAccount(String userID) {
        String sqlStatement = "Delete from [Account] where id  = ?";
        PreparedStatement pre;
        try {
            pre = connect.prepareStatement(sqlStatement);
            pre.setString(1, userID);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * this function for admin to change user role to manager or user
     *
     * @return
     */
    public void UpdateRoleAccount(String userID, String role) {
        String sqlStatement = "Update [Account] set RoleID = ? where id  = ?";
        PreparedStatement pre;
        try {
            pre = connect.prepareStatement(sqlStatement);
            pre.setString(2, userID);
            pre.setString(1, role);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * for login if the user login , the function will return into Fullname for
     * header
     *
     * @return fullname by username
     */
    public String getFullNameByUsername(String username) {
        String splStatement = "select [fullname] from [Account] where [username]= ? ; ";
        String fullname = "";
        PreparedStatement pre;
        try {
            pre = connect.prepareStatement(splStatement);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                fullname = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullname;
    }

    /**
     * for login if the user login , the function will return into Fullname for
     * header
     *
     * @return fullname by mail
     */
    public String getFullNameByEmail(String email) {
        String splStatement = "select [fullname] from [Account] where [email]= ? ; ";
        String fullname = "";
        PreparedStatement pre;
        try {
            pre = connect.prepareStatement(splStatement);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                fullname = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullname;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

         List<User> list = dao.getAllStaff();
        System.out.println(list);

    }
}
