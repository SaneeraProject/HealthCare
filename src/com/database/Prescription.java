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
public class Prescription {

    int prescriptionid;
    int tokennno;
    int physicianid;
    Date dated;
    String physicianname;
    String status;

    public String getPhysicianname() {
        return physicianname;
    }

    public void setPhysicianname(String physicianname) {
        this.physicianname = physicianname;
    }

    public int getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(int prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public int getTokennno() {
        return tokennno;
    }

    public void setTokennno(int tokennno) {
        this.tokennno = tokennno;
    }

    public int getPhysicianid() {
        return physicianid;
    }

    public void setPhysicianid(int physicianid) {
        this.physicianid = physicianid;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
