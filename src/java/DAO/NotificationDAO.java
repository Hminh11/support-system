/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Notification;
import Utils.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class NotificationDAO extends DBConnect {
//    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

//    public List<NotificationDTO> getAllNotifications() {
//        String sql = "select * from NOTIFICATION";
//        ResultSet rs = getData(sql);
//        List<NotificationDTO> notis = new ArrayList<NotificationDTO>();
//
//        try {
//            while (rs.next()) {
//                int notiID = rs.getInt(1);
//                String content = rs.getString(2);
//                Date senDate = rs.getDate(3);
//                int sentID = rs.getInt(4);
//                int receiveID = rs.getInt(5);
//
//                NotificationDTO noti = new NotificationDTO(notiID, content, content, sentID, receiveID);
//                notis.add(noti);
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return notis;
//    }
    public Vector<Notification> getAllNotifications() {
        String sql = "select *\n"
                + "from NOTIFICATION\n"
                + "order by sentDate desc";
        ResultSet rs = getData(sql);
        Vector<Notification> notis = new Vector<>();

        try {
            while (rs.next()) {
                int notiID = rs.getInt(1);
                String content = rs.getString(2);
                Timestamp sentDate = rs.getTimestamp(3);
                int sentID = rs.getInt(4);
                int receiveID = rs.getInt(5);

                String sentFullName = getfullNamebySentID(sentID);
                String receiveFullName = getfullNamebyReceiveID(receiveID);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
                String formatedsentDate = dateFormat.format(sentDate);

                Notification noti = new Notification(notiID, content, sentDate, sentID, receiveID, sentFullName, receiveFullName);
                notis.add(noti);
            }
        } catch (SQLException e) {
        }
        return notis;
    }

    public Vector<Notification> getAllNotificationsbyUser(int id) {
        String sql = "  select *\n"
                + "from NOTIFICATION where receiveID = "+id+" \n"
                + "order by sentDate desc ";
        
        ResultSet rs = getData(sql);
        Vector<Notification> notis = new Vector<>();

        try {
            while (rs.next()) {
                int notiID = rs.getInt(1);
                String content = rs.getString(2);
                Timestamp sentDate = rs.getTimestamp(3);
                int sentID = rs.getInt(4);
                int receiveID = rs.getInt(5);

                String sentFullName = getfullNamebySentID(sentID);
                String receiveFullName = getfullNamebyReceiveID(receiveID);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
                String formatedsentDate = dateFormat.format(sentDate);

                Notification noti = new Notification(notiID, content, sentDate, sentID, receiveID, sentFullName, receiveFullName);
                notis.add(noti);
            }
        } catch (SQLException e) {
        }
        return notis;
    }

    public void deleteNotification(String notiID) {
        String sql = "delete from NOTIFICATION\n"
                + "where notiID = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, notiID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void insertNotification(String content, int receiveID, int sentID) {
        String sql = "insert into \n"
                + "NOTIFICATION(content, receiveID,sentID) \n"
                + "values (?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, content);
            ps.setInt(2, receiveID);
            ps.setInt(3, sentID);

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

//    public Notification getNotificationByID(String notiID) {
//        String sql = " select * from NOTIFICATION\n"
//                + " where notiID = ?";
//
//        try {
//            ResultSet rs = null;
//            PreparedStatement ps = connect.prepareStatement(sql);
//            ps.setString(1, notiID);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                return new Notification(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5));
//            }
//        } catch (SQLException e) {
//        }
//        return null;
//    }
    public Notification getNotificationByID(String notiID) {
        String sql = " select N.*, A1.fullName as sentFullName, A2.fullName as receiveFullName from NOTIFICATION N\n"
                + " inner join Account A1 on N.sentID = A1.id\n"
                + " inner join Account A2 on N.receiveID = A2.id\n"
                + " where N.notiID = ?";

        try {
            ResultSet rs = null;
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, notiID);
            rs = ps.executeQuery();

            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotiID(rs.getInt("notiID"));
                notification.setContent(rs.getString("content"));
                notification.setSentID(rs.getInt("sentID"));
                notification.setReceiveID(rs.getInt("receiveID"));
                notification.setSentFullName(rs.getString("sentFullName"));
                notification.setReceiveFullName(rs.getString("receiveFullName"));
                return notification;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void editNotification(String notiID, String content, String sentID, String receiveID) {
        String sql = "update NOTIFICATION\n"
                + "set content = ?,\n"
                + "sentID = ?,\n"
                + "receiveID = ?\n"
                + "where notiID = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, content);
            ps.setString(2, sentID);
            ps.setString(3, receiveID);
            ps.setString(4, notiID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

//    public void editNotification(String notiID, String content) {
//        String sql = "update NOTIFICATION\n"
//                + "set content = '?'\n"
//                + "where notiID = ?";
//        try {
//            PreparedStatement ps = connect.prepareStatement(sql);
//            ps.setString(1, content);
//            ps.setString(2, notiID);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//        }
//    }
    public String getfullNamebySentID(int sentID) {
        String fullName = null;
        String sql = "select A.fullName\n"
                + "from [NOTIFICATION] as N\n"
                + "inner join Account as A on N.sentID = A.id\n"
                + "where N.sentID = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, sentID);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    fullName = rs.getString("fullName");
                }
            }
        } catch (SQLException e) {
        }
        return fullName;
    }

    public String getfullNamebyReceiveID(int receiveID) {
        String fullName = null;
        String sql = "select A.fullName\n"
                + "from [NOTIFICATION] as N\n"
                + "inner join Account as A on N.receiveID = A.id\n"
                + "where N.receiveID = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, receiveID);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    fullName = rs.getString("fullName");
                }
            }
        } catch (SQLException e) {
        }
        return fullName;
    }

    public Notification getNotificationByReceiveID(String receiveID) {
        String sql = "select content \n"
                + "from [NOTIFICATION]\n"
                + "where receiveID = ?";
        try {
            ResultSet rs = null;
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, receiveID);
            rs = ps.executeQuery();

            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotiID(rs.getInt("notiID"));
                notification.setSentID(rs.getInt("sentID"));
                notification.setReceiveID(rs.getInt("receiveID"));
                notification.setSentFullName(rs.getString("sentFullName"));
                notification.setReceiveFullName(rs.getString("receiveFullName"));
                return notification;
            }
        } catch (SQLException e) {
        }
        return null;

    }

}
