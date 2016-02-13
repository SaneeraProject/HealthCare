/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ajeet
 */
public class DBConfig {

    private final String database = "health_care";
    private final String user = "root";
    private final String pass = "";

    public Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public boolean isUser(String logUser, String logPass, String logType) {
        boolean isUser = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select id from tbluser where username=? and password=? and type=?");
            pst.setString(1, logUser);
            pst.setString(2, logPass);
            pst.setString(3, logType);
            rst = pst.executeQuery();
            if (rst != null) {
                while (rst.next()) {
                    isUser = true;
                }
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return isUser;
    }

    public User getUser(String logUser, String logPass, String logType) {
        User user = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tbluser where username=? and password=? and type=?");
            pst.setString(1, logUser);
            pst.setString(2, logPass);
            pst.setString(3, logType);
            rst = pst.executeQuery();
            if (rst != null) {
                while (rst.next()) {
                    user = new User();
                    user.setId(rst.getInt("id"));
                    user.setUserName(rst.getString("username"));
                    user.setFullName(rst.getString("fullname"));
                    user.setDated(rst.getDate("dated"));
                }
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return user;
    }

    public int saveSpeciality(String speciality) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into tblspeciality(id,sname,dated) values(NULL,?,NOW())");
            pst.setString(1, speciality);
            i = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<Speciality> getSpeciality() {
        ArrayList<Speciality> qList = new ArrayList<Speciality>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select id,sname from tblspeciality");
            rst = pst.executeQuery();
            while (rst.next()) {
                Speciality quali = new Speciality();
                quali.setId(rst.getInt("id"));
                quali.setName(rst.getString("sname"));
                qList.add(quali);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return qList;
    }

    public int saveQualification(String qualification) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into tblqualification(id,qname,dated) values(NULL,?,NOW())");
            pst.setString(1, qualification);
            i = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<Qualification> getQualifications() {
        ArrayList<Qualification> qList = new ArrayList<Qualification>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select id,qname from tblqualification");
            rst = pst.executeQuery();
            while (rst.next()) {
                Qualification quali = new Qualification();
                quali.setId(rst.getInt("id"));
                quali.setName(rst.getString("qname"));
                qList.add(quali);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return qList;
    }

    public int saveDoctor(Doctor doctor, boolean isUpdate) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!isUpdate) {
                pst = con.prepareStatement("insert into tblphysician values(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'',NOW())");
                pst.setString(1, doctor.getFullName());
                java.util.Date date = doctor.getDob();
                pst.setDate(2, new java.sql.Date(date.getYear(), date.getMonth(), date.getDate()));
                pst.setString(3, doctor.getAddress());
                pst.setString(4, doctor.getEmail());
                pst.setString(5, doctor.getGender());
                pst.setString(6, doctor.getMarried());
                pst.setInt(7, doctor.getQuali().getId());
                pst.setString(8, doctor.getCouncil());
                pst.setString(9, doctor.getEmployer());
                pst.setDouble(10, doctor.getFees());
                pst.setInt(11, doctor.getSpeciality().getId());
                pst.setString(12, doctor.getBank());
                pst.setString(13, doctor.getBranch());
                pst.setString(14, doctor.getAccount());
                pst.setString(15, doctor.getChome());
                pst.setString(16, doctor.getCwork());
                pst.setString(17, doctor.getCmobile());
                pst.setString(18, doctor.getCemergency());
                pst.setString(19, doctor.getUser());
                pst.setString(20, doctor.getPass());
                pst.setString(21, "....");
                pst.setString(22, "....");

            } else {
                pst = con.prepareStatement("update tblphysician set fullname=?,dob=?,address=?,email=?,gender=?,married=?,qualification=?,councilreg=?,"
                        + "employer=?,fees=?,speciality=?,bank=?,branch=?,account=?,c1=?,c2=?,c3=?,c4=?,username=?,password=? where id=?");
                pst.setString(1, doctor.getFullName());
                java.util.Date date = doctor.getDob();
                pst.setDate(2, new java.sql.Date(date.getYear(), date.getMonth(), date.getDate()));
                pst.setString(3, doctor.getAddress());
                pst.setString(4, doctor.getEmail());
                pst.setString(5, doctor.getGender());
                pst.setString(6, doctor.getMarried());
                pst.setInt(7, doctor.getQuali().getId());
                pst.setString(8, doctor.getCouncil());
                pst.setString(9, doctor.getEmployer());
                pst.setDouble(10, doctor.getFees());
                pst.setInt(11, doctor.getSpeciality().getId());
                pst.setString(12, doctor.getBank());
                pst.setString(13, doctor.getBranch());
                pst.setString(14, doctor.getAccount());
                pst.setString(15, doctor.getChome());
                pst.setString(16, doctor.getCwork());
                pst.setString(17, doctor.getCmobile());
                pst.setString(18, doctor.getCemergency());
                pst.setString(19, doctor.getUser());
                pst.setString(20, doctor.getPass());
                pst.setInt(21, doctor.getId());
            }
            i = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public int savePatient(Patient patient) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into tblqualification(id,qname,dated) values(NULL,?,NOW())");
//            pst.setString(1, qualification);
            i = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public Doctor getDoctorByID(int parseInt) {
        Doctor doc = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select a.id,a.fullname,a.dob,a.email,a.address,a.gender,a.married,a.qualification,"
                    + "a.councilreg,a.employer,a.fees,a.speciality,a.bank,a.branch,a.account,a.c1,a.c2,a.c3,a.c4,a.username,"
                    + "a.password,b.qname,c.sname from tblphysician a,tblqualification b, tblspeciality c  where a.id=? and a.qualification=b.id and a.speciality=c.id");
            pst.setInt(1, parseInt);
            rst = pst.executeQuery();
            while (rst.next()) {
                doc = new Doctor();
                doc.setId(rst.getInt("id"));
                doc.setFullName(rst.getString("fullname"));
                doc.setDob(rst.getDate("dob"));
                doc.setEmail(rst.getString("email"));
                doc.setAddress(rst.getString("address"));
                doc.setGender(rst.getString("gender"));
                doc.setMarried(rst.getString("married"));
                Qualification quali = new Qualification();
                quali.setId(rst.getInt("qualification"));
                quali.setName(rst.getString("qname"));
                doc.setQuali(quali);
                doc.setCouncil(rst.getString("councilreg"));
                doc.setEmployer(rst.getString("employer"));
                doc.setFees(rst.getDouble("fees"));
                Speciality spec = new Speciality();
                spec.setId(rst.getInt("speciality"));
                spec.setName(rst.getString("sname"));
                doc.setSpeciality(spec);
                doc.setBank(rst.getString("bank"));
                doc.setBranch(rst.getString("branch"));
                doc.setAccount(rst.getString("account"));
                doc.setChome(rst.getString("c1"));
                doc.setCwork(rst.getString("c2"));
                doc.setCmobile(rst.getString("c3"));
                doc.setCemergency(rst.getString("c4"));
                doc.setUser(rst.getString("username"));
                doc.setPass(rst.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return doc;
    }
    
    
    public ArrayList<Doctor> getDoctors() {
        ArrayList<Doctor> dList = new ArrayList<Doctor>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select a.id,a.fullname,a.dob,a.email,a.address,a.gender,a.married,a.qualification,"
                    + "a.councilreg,a.employer,a.fees,a.speciality,a.bank,a.branch,a.account,a.c1,a.c2,a.c3,a.c4,a.username,"
                    + "a.password,b.qname,c.sname from tblphysician a,tblqualification b, tblspeciality c  where a.qualification=b.id and a.speciality=c.id");
        
            rst = pst.executeQuery();
            while (rst.next()) {
                Doctor doc = new Doctor();
                doc.setId(rst.getInt("id"));
                doc.setFullName(rst.getString("fullname"));
                doc.setDob(rst.getDate("dob"));
                doc.setEmail(rst.getString("email"));
                doc.setAddress(rst.getString("address"));
                doc.setGender(rst.getString("gender"));
                doc.setMarried(rst.getString("married"));
                Qualification quali = new Qualification();
                quali.setId(rst.getInt("qualification"));
                quali.setName(rst.getString("qname"));
                doc.setQuali(quali);
                doc.setCouncil(rst.getString("councilreg"));
                doc.setEmployer(rst.getString("employer"));
                doc.setFees(rst.getDouble("fees"));
                Speciality spec = new Speciality();
                spec.setId(rst.getInt("speciality"));
                spec.setName(rst.getString("sname"));
                doc.setSpeciality(spec);
                doc.setBank(rst.getString("bank"));
                doc.setBranch(rst.getString("branch"));
                doc.setAccount(rst.getString("account"));
                doc.setChome(rst.getString("c1"));
                doc.setCwork(rst.getString("c2"));
                doc.setCmobile(rst.getString("c3"));
                doc.setCemergency(rst.getString("c4"));
                doc.setUser(rst.getString("username"));
                doc.setPass(rst.getString("password"));
                dList.add(doc);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rst != null) {
                    rst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return dList;
    }

    public int saveClinic(Clinic c, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if(!b){
            pst = con.prepareStatement("insert into tblclinic(id,docid,roomno,timing,status,dated) values(NULL,?,?,?,?,NOW())");
            pst.setInt(1, c.getPid());
            pst.setString(2, c.getRoom());
            pst.setString(3, c.getStarttime());
            pst.setString(4, c.getStatus());
            }
            else{
            pst = con.prepareStatement("update tblclinic set docid=?,roomno=?,timing=?,status=? where id=?");
            pst.setInt(1, c.getPid());
            pst.setString(2, c.getRoom());
            pst.setString(3, c.getStarttime());
            pst.setString(4, c.getStatus());
            pst.setInt(5, c.getId());
            }
            i = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }
}
