/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.util.Date;

/**
 *
 * @author Ajeet
 */
public class Token {

    int id;
    int pid;
    int cid;
    int did;
    double hfee;
    double pfee;
    String room;
    String docname;
    String ctoken;
    String ptoken;
    String btoken;
    String pname;
    Date timing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public double getHfee() {
        return hfee;
    }

    public void setHfee(double hfee) {
        this.hfee = hfee;
    }

    public double getPfee() {
        return pfee;
    }

    public void setPfee(double pfee) {
        this.pfee = pfee;
    }

    public String getCtoken() {
        return ctoken;
    }

    public void setCtoken(String ctoken) {
        this.ctoken = ctoken;
    }

    public String getPtoken() {
        return ptoken;
    }

    public void setPtoken(String ptoken) {
        this.ptoken = ptoken;
    }

    public String getBtoken() {
        return btoken;
    }

    public void setBtoken(String btoken) {
        this.btoken = btoken;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getTiming() {
        return timing;
    }

    public void setTiming(Date timing) {
        this.timing = timing;
    }

}
