/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Notification {
    private int notiID;
    private String content;
    private Timestamp sentDate;
    private int sentID;
    private int receiveID;
    private String sentFullName;
    private String receiveFullName;

    public Notification() {
    }

    public Notification(int notiID, String content, Timestamp sentDate, int sentID, int receiveID) {
        this.notiID = notiID;
        this.content = content;
        this.sentDate = sentDate;
        this.sentID = sentID;
        this.receiveID = receiveID;
    }

    public Notification(int notiID, String content, Timestamp sentDate, int sentID, int receiveID, String sentFullName, String receiveFullName) {
        this.notiID = notiID;
        this.content = content;
        this.sentDate = sentDate;
        this.sentID = sentID;
        this.receiveID = receiveID;
        this.sentFullName = sentFullName;
        this.receiveFullName = receiveFullName;
    }

    public int getNotiID() {
        return notiID;
    }

    public void setNotiID(int notiID) {
        this.notiID = notiID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSentDate() {
        return sentDate;
    }

    public void setSentDate(Timestamp sentDate) {
        this.sentDate = sentDate;
    }

    public int getSentID() {
        return sentID;
    }

    public void setSentID(int sentID) {
        this.sentID = sentID;
    }

    public int getReceiveID() {
        return receiveID;
    }

    public void setReceiveID(int receiveID) {
        this.receiveID = receiveID;
    }

    public String getSentFullName() {
        return sentFullName;
    }

    public void setSentFullName(String sentFullName) {
        this.sentFullName = sentFullName;
    }

    public String getReceiveFullName() {
        return receiveFullName;
    }

    public void setReceiveFullName(String receiveFullName) {
        this.receiveFullName = receiveFullName;
    }
    
    
    
//    @Override
//    public String toString() {
//        return "NotificationDTO{" + "notiID=" + notiID + ", content=" + content + ", sentDate=" + sentDate + ", sentID=" + sentID + ", receiveID=" + receiveID + '}';
//    }

    @Override
    public String toString() {
        return "Notification{" + "notiID=" + notiID + ", content=" + content + ", sentDate=" + sentDate + ", sentID=" + sentID + ", receiveID=" + receiveID + ", sentFullName=" + sentFullName + ", receiveFullName=" + receiveFullName + '}';
    }


}


