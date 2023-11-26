/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.PasswordResetDAO;
import DAO.UserDAO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.PasswordReset;
import Model.User;

/**
 *
 * @author DTS
 */
public class UserService {

    private static final UserDAO userDao = new UserDAO();
    private static final PasswordResetDAO passDao = new PasswordResetDAO();

    /**
     *
     * @param username
     * @param password
     * @return true if username and password is correct
     */
    public boolean userLogin(String username, String password) {

        if (username.contains("@")) {
            if (userDao.getUserByEmail(username) == null) { // if username does not exist --> login failed
                return false;
            } else {
                byte[] salted = userDao.getUserSaltByEmail(username);
//            System.out.println("salted: " + Arrays.toString(salted));

                byte[] hashedPassword = hashingPassword(password, salted);
                byte[] realHashed = userDao.getHashedPasswordByEmail(username);

//            System.out.println("hashed1: " + Arrays.toString(hashedPassword));
//            System.out.println("hashed2: " + Arrays.toString(realHashed));
                return Arrays.equals(realHashed, hashedPassword);
            }
        } else {
            if (!userDao.isUsernameExist(username)) { // if username does not exist --> login failed
                return false;
            } else {
                byte[] salted = userDao.getUserSalt(username);
//            System.out.println("salted: " + Arrays.toString(salted));

                byte[] hashedPassword = hashingPassword(password, salted);
                byte[] realHashed = userDao.getHashedPassword(username);

//            System.out.println("hashed1: " + Arrays.toString(hashedPassword));
//            System.out.println("hashed2: " + Arrays.toString(realHashed));
                return Arrays.equals(realHashed, hashedPassword);
            }
        }

    }

    /**
     * Generate salt, helping in password hashing
     *
     * @return byte[16] array filled in with random bytes
     */
    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return salt;
    }

    /**
     * Hashing a password
     *
     * @param password
     * @param salt
     * @return hashed password. Or null if SHA-512 is not supported
     */
    public byte[] hashingPassword(String password, byte[] salt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
//            System.out.println("Password after hash: " + Arrays.toString(hashedPassword));
            return hashedPassword;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Register a user.
     *
     * @param username
     * @param fullname
     * @param email
     * @param phone
     * @param password
     * @param retype_password
     * @return true if registered successfully, false otherwise
     */
    public boolean userRegister(String username, String fullname, String email, String phone, String password, String retype_password, int roleid) throws Exception {
        // check password     
        
        if(userDao.validateUserName(username)){
            throw new Exception("User Name cannot has special characters!");
        }

        if (userDao.isUsernameExist(username)) {
            throw new Exception("username already existed");
        }
        
        if (userDao.isEmailExist(email)) {
            throw new Exception("Email already existed");
        }
        
        if (phone.length() > 10) {
            throw new Exception("Phone Number must be 10 number");
        }
        
        if (phone.length() < 9) {
            throw new Exception("Phone Number must be 10 number");
        }

        if (userDao.isPhoneExist(phone)) {
            throw new Exception("Phone Number already existed");
        }

        if (!password.equals(retype_password)) {
            throw new Exception("Password does not match");
        }

        System.out.println("USERNAME: " + username);

        // Generate salt
        byte[] salt = generateSalt();
        System.out.println(Arrays.toString(salt));
        System.out.println("Salt size: " + salt.length);

        byte[] hashedPassword = hashingPassword(password, salt);
        System.out.println("Password size: " + hashedPassword.length);

        User newUser = new User(userDao.getLastID() + 1, fullname, username, email, phone, salt, hashedPassword, roleid);
        userDao.addUser(newUser);
        return true;
    }

    public Vector<User> getAllUSers() {
        return userDao.getAllUSers();
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public User getUserByPhone(String phoneNum) {
        return userDao.getUserByPhone(phoneNum);
    }

    public int getUserRoleID(String username) {
        return userDao.getUserRole(username);
    }

    public boolean updateUser(User user) {
        if (userDao.updateUser(user) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get user in the DB by ID
     *
     * @param uID
     * @return User object or null if there is no id
     */
    public User getUserByID(int uID) {
        return userDao.getUserByID(uID);
    }

    public void addPasswordReset(PasswordReset pwdR) {
        passDao.addPasswordReset(pwdR);
    }

    /**
     * Check whether this token belongs to this email in DB, and is in time
     *
     * @param token
     * @return
     */
    public boolean checkValidToken(String token) {
        return passDao.checkValidToken(token);
    }

    /**
     *
     * @param newPassword
     * @param token
     */
    public void changeUserPassword(String newPassword, String token) {
        String email = passDao.getEmailByToken(token);
        byte[] salt = userDao.getUserSaltByEmail(email);
        byte[] password = hashingPassword(newPassword, salt);
        userDao.updatePassword(email, password);
    }
    
    public void changeUserPassword1(String newPassword, String email) {
        byte [] salt = userDao.getUserSaltByEmail(email);
        byte[] password = hashingPassword(newPassword, salt);
        userDao.updatePassword(email, password);
    }
}
