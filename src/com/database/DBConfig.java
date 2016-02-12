/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            pst = con.prepareStatement("insert into tblspeciality(id,name,dated) values(NULL,?,NOW())");
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
            pst = con.prepareStatement("select id,name from tblspeciality");
            rst = pst.executeQuery();
            while (rst.next()) {
                Speciality quali = new Speciality();
                quali.setId(rst.getInt("id"));
                quali.setName(rst.getString("name"));
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
            pst = con.prepareStatement("insert into tblqualification(id,name,dated) values(NULL,?,NOW())");
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
            pst = con.prepareStatement("select id,name from tblqualification");
            rst = pst.executeQuery();
            while (rst.next()) {
                Qualification quali = new Qualification();
                quali.setId(rst.getInt("id"));
                quali.setName(rst.getString("name"));
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

    public int saveDoctor(String speciality) {
        int i = 0;

        return i;
    }

    public int savePatient(String speciality) {
        int i = 0;

        return i;
    }
}
