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

    public User getUser(String logUser, String logPass) {
        User user = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tbluser where username=? and password=?");
            pst.setString(1, logUser);
            pst.setString(2, logPass);
            rst = pst.executeQuery();
            if (rst != null) {
                while (rst.next()) {
                    user = new User();
                    user.setId(rst.getInt("id"));
                    user.setUserName(rst.getString("username"));
                    user.setFullName(rst.getString("fullname"));
                    user.setQuestion(rst.getString("question"));
                    user.setAnswer(rst.getString("answer"));
                    user.setType(rst.getString("type"));
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

    public User getUserByQA(String u, String q, String a) {
        User user = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tbluser where username=? and question=? and answer=?");
            pst.setString(1, u);
            pst.setString(2, q);
            pst.setString(3, a);

            rst = pst.executeQuery();
            if (rst != null) {
                while (rst.next()) {
                    user = new User();
                    user.setId(rst.getInt("id"));
                    user.setUserName(rst.getString("username"));
                    user.setFullName(rst.getString("fullname"));
                    user.setPassword(rst.getString("password"));
                    user.setQuestion(rst.getString("question"));
                    user.setAnswer(rst.getString("answer"));
                    user.setType(rst.getString("type"));
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

    public ArrayList<User> getUsers() {
        ArrayList<User> uList = new ArrayList<User>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tbluser");
            rst = pst.executeQuery();
            if (rst != null) {
                while (rst.next()) {
                    User user = new User();
                    user.setId(rst.getInt("id"));
                    user.setUserName(rst.getString("username"));
                    user.setFullName(rst.getString("fullname"));
                    user.setType(rst.getString("type"));
                    user.setDated(rst.getDate("dated"));
                    uList.add(user);
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

        return uList;
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

    public int saveRate(double rate, double fees) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("update tblrate set rate=?, fees=?");
            pst.setDouble(1, rate);
            pst.setDouble(2, fees);

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

    public double[] getRate() {
        double d[] = new double[2];
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT rate,fees from tblrate");
            rst = pst.executeQuery();
            while (rst.next()) {
                d[0] = rst.getDouble("rate");
                d[1] = rst.getDouble("fees");
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

        return d;
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
            if (!b) {
                pst = con.prepareStatement("insert into tblclinic(id,docid,roomno,timing,status,dated) values(NULL,?,?,?,?,NOW())");
                pst.setInt(1, c.getPid());
                pst.setString(2, c.getRoom());
                pst.setString(3, c.getStarttime());
                pst.setString(4, c.getStatus());
            } else {
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

    public Clinic getClinicById(int id) {
        Clinic c = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.id, a.docid, a.roomno, a.status, a.timing, a.status, b.fullname, c.sname\n"
                    + "FROM tblclinic a, tblphysician b, tblspeciality c\n"
                    + "WHERE a.id =?\n"
                    + "AND b.id = a.docid\n"
                    + "AND b.speciality = c.id");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                c = new Clinic();
                c.setId(rst.getInt("id"));
                c.setPid(rst.getInt("docid"));
                c.setRoom(rst.getString("roomno"));
                c.setStatus(rst.getString("status"));
                c.setStarttime(rst.getString("timing"));
                c.setDocname(rst.getString("fullname"));
                c.setSname(rst.getString("sname"));
                c.setToken(0);
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

        return c;
    }

    public ArrayList<Clinic> getClinics() {
        ArrayList<Clinic> cList = new ArrayList<Clinic>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.id, a.docid, a.roomno, a.status, a.timing, a.status, b.fullname, c.sname\n"
                    + "FROM tblclinic a, tblphysician b, tblspeciality c\n"
                    + "WHERE b.id = a.docid\n"
                    + "AND b.speciality = c.id");

            rst = pst.executeQuery();
            while (rst.next()) {
                Clinic c = new Clinic();
                c.setId(rst.getInt("id"));
                c.setPid(rst.getInt("docid"));
                c.setRoom(rst.getString("roomno"));
                c.setStatus(rst.getString("status"));
                c.setStarttime(rst.getString("timing"));
                c.setDocname(rst.getString("fullname"));
                c.setSname(rst.getString("sname"));
                c.setToken(0);
                cList.add(c);
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

        return cList;
    }

    public int savePatient(Patient p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tblpatient(id,name,age,contact,married,bloodgroup,height,weight,financialstatus,account,image,dated) values(NULL,?,?,?,?,?,?,?,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setString(1, p.getName());
                pst.setString(2, p.getAge());
                pst.setString(3, p.getContact());
                pst.setString(4, p.getMarried());
                pst.setString(5, p.getBlood());
                pst.setString(6, p.getHeight());
                pst.setString(7, p.getWeight());
                pst.setString(8, p.getFinancial());
                pst.setString(9, p.getAccount());
                pst.setBytes(10, p.getImage());
            } else {
                pst = con.prepareStatement("update tblpatient set name=?,age=?,contact=?,married=?,bloodgroup=?,height=?,weight=?,financialstatus=?,"
                        + "account=?,image=? where id=?");
                pst.setString(1, p.getName());
                pst.setString(2, p.getAge());
                pst.setString(3, p.getContact());
                pst.setString(4, p.getMarried());
                pst.setString(5, p.getBlood());
                pst.setString(6, p.getHeight());
                pst.setString(7, p.getWeight());
                pst.setString(8, p.getFinancial());
                pst.setString(9, p.getAccount());
                pst.setBytes(10, p.getImage());
                pst.setInt(11, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public Patient getPatientById(int id) {
        Patient p = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tblpatient where id=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                p = new Patient();
                p.setId(rst.getInt("id"));
                p.setName(rst.getString("name"));
                p.setContact(rst.getString("contact"));
                p.setAge(rst.getString("age"));
                p.setImage(rst.getBytes("image"));
                p.setMarried(rst.getString("married"));
                p.setBlood(rst.getString("bloodgroup"));
                p.setHeight(rst.getString("height"));
                p.setWeight(rst.getString("weight"));
                p.setFinancial(rst.getString("financialstatus"));
                p.setAccount(rst.getString("account"));
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

        return p;
    }

    public int saveToken(Token p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tblToken(tid,cid,did,pid,hfee,pfee,dated) values(NULL,?,?,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setInt(1, p.getCid());
                pst.setInt(2, p.getDid());
                pst.setInt(3, p.getPid());
                pst.setDouble(4, p.getHfee());
                pst.setDouble(5, p.getPfee());
            } else {
                pst = con.prepareStatement("update tblToken set cid=?,did=?,pid=?,hfee=?,pfee=? where tid=?");
                pst.setInt(1, p.getCid());
                pst.setInt(2, p.getDid());
                pst.setInt(3, p.getPid());
                pst.setDouble(4, p.getHfee());
                pst.setDouble(5, p.getPfee());
                pst.setInt(6, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<Token> getTokenByCID(int id) {
        ArrayList<Token> cList = new ArrayList<Token>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.tid, a.did, a.pid, a.ctoken, a.ptoken, a.btoken,a.dated,"
                    + "b.name from tbltoken a,tblpatient b where a.pid = b.id AND a.cid=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                Token c = new Token();
                c.setId(rst.getInt("tid"));
                c.setPid(rst.getInt("pid"));
                c.setPname(rst.getString("name"));
                c.setCtoken(rst.getString("ctoken"));
                c.setPtoken(rst.getString("ptoken"));
                c.setBtoken(rst.getString("btoken"));
                c.setTiming(rst.getDate("dated"));
                cList.add(c);
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

        return cList;
    }
    
    public ArrayList<Token> getTokenByPID(int id) {
        ArrayList<Token> cList = new ArrayList<Token>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.tid, a.did, a.pid, a.ctoken, a.ptoken, a.btoken,a.dated,"
                    + "b.name, c.fullname from tbltoken a,tblpatient b,tblphysician c where a.pid = b.id AND a.did=c.id and a.cid=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                Token c = new Token();
                c.setId(rst.getInt("tid"));
                c.setPid(rst.getInt("pid"));
                c.setPname(rst.getString("name"));
                c.setDocname(rst.getString("fullname"));
                c.setCtoken(rst.getString("ctoken"));
                c.setPtoken(rst.getString("ptoken"));
                c.setBtoken(rst.getString("btoken"));
                c.setTiming(rst.getDate("dated"));
                cList.add(c);
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

        return cList;
    }

    public Token getTokenByID(int id) {
        Token c = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.tid, a.did, a.pid, a.ctoken, a.ptoken, a.btoken,a.dated,"
                    + "b.name from tbltoken a,tblpatient b where a.pid = b.id AND a.tid=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                c = new Token();
                c.setId(rst.getInt("tid"));
                c.setPid(rst.getInt("pid"));
                c.setDid(rst.getInt("did"));
                c.setPname(rst.getString("name"));
                c.setCtoken(rst.getString("ctoken"));
                c.setPtoken(rst.getString("ptoken"));
                c.setBtoken(rst.getString("btoken"));
                c.setTiming(rst.getDate("dated"));
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

        return c;
    }

    public ArrayList<Token> getTokens() {
        ArrayList<Token> cList = new ArrayList<Token>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.tid, a.did, a.pid, a.ctoken, a.ptoken, a.btoken,a.dated,"
                    + "b.name, c.roomno,d.fullname from tbltoken a,tblpatient b,tblclinic c,tblphysician d where a.pid = b.id and a.cid=c.id and a.did=d.id");

            rst = pst.executeQuery();
            while (rst.next()) {
                Token c = new Token();
                c.setId(rst.getInt("tid"));
                c.setPid(rst.getInt("did"));
                c.setPname(rst.getString("name"));
                c.setCtoken(rst.getString("ctoken"));
                c.setPtoken(rst.getString("ptoken"));
                c.setBtoken(rst.getString("btoken"));
                c.setRoom(rst.getString("roomno"));
                c.setDocname(rst.getString("fullname"));
                c.setTiming(rst.getDate("dated"));
                cList.add(c);
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

        return cList;
    }

    public int saveDocument(Document p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tbldocument(id,pid,type,docdata,dated) values(NULL,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
//                pst.setInt(1, p.getId());
                pst.setInt(1, p.getTid());
                pst.setString(2, p.getType());
                pst.setBytes(3, p.getB());
            } else {
                pst = con.prepareStatement("update tbldocument set pid=?,type=?,docdata=? where id=?");
                pst.setInt(1, p.getTid());
                pst.setString(2, p.getType());
                pst.setBytes(3, p.getB());
                pst.setInt(4, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<Document> getDocumentByPID(int pid) {
        ArrayList<Document> cList = new ArrayList<Document>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT  * from tbldocument where pid=?");
            pst.setInt(1, pid);
            rst = pst.executeQuery();
            while (rst.next()) {
                Document c = new Document();
                c.setId(rst.getInt("id"));
                c.setType(rst.getString("type"));
                c.setDate(rst.getDate("dated"));
                cList.add(c);
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

        return cList;
    }

    public Document getDocumentByDID(int did) {
        Document c = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT  * from tbldocument where id=?");
            pst.setInt(1, did);
            rst = pst.executeQuery();
            while (rst.next()) {
                c = new Document();
                c.setId(rst.getInt("id"));
                c.setType(rst.getString("type"));
                c.setB(rst.getBytes("docdata"));
                c.setDate(rst.getDate("dated"));
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

        return c;
    }

    public int saveDiagnosys(Diagnosys p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tbldiagnosis(id,name,shortcode,rate,dated) values(NULL,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setString(1, p.getName());
                pst.setString(2, p.getShortcode());
                pst.setDouble(3, p.getRate());
            } else {
                pst = con.prepareStatement("update tbldiagnosis set name=?,shortcode=?,rate=? where id=?");
                pst.setString(1, p.getName());
                pst.setString(2, p.getShortcode());
                pst.setDouble(3, p.getRate());
                pst.setInt(4, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<Diagnosys> getDiagnosys() {
        ArrayList<Diagnosys> dList = new ArrayList<Diagnosys>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT  * from tbldiagnosis");
            rst = pst.executeQuery();
            while (rst.next()) {
                Diagnosys c = new Diagnosys();
                c.setId(rst.getInt("id"));
                c.setName(rst.getString("name"));
                c.setShortcode(rst.getString("shortcode"));
                c.setRate(rst.getDouble("rate"));
                c.setDated(rst.getDate("dated"));
                dList.add(c);
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

    public int savePDiagnosys(DiagnosysData p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tblpatientdiagnosis(id,patientid,diagnosisid,physicianid,status,detail,dated) values(NULL,?,?,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setInt(1, p.getPid());
                pst.setInt(2, p.getDid());
                pst.setInt(3, p.getPhysician());
                pst.setString(4, p.getStatus());
                pst.setString(5, p.getDetail());

            } else {
                pst = con.prepareStatement("update tblpatientdiagnosis set patientid=?,diagnosisid=?,physicianid=?,status=?,detail=? where id=?");
                pst.setInt(1, p.getPid());
                pst.setInt(2, p.getDid());
                pst.setInt(3, p.getPhysician());
                pst.setString(4, p.getStatus());
                pst.setString(5, p.getDetail());
                pst.setInt(6, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<DiagnosysData> getDiagnosysData(int pid) {
        ArrayList<DiagnosysData> dList = new ArrayList<DiagnosysData>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.id,a.dated,a.status,a.detail,b.name,b.id,b.shortcode,c.fullname from tblpatientdiagnosis a,tbldiagnosis b,tblphysician c where  a.patientid=? and a.diagnosisid=b.id and a.physicianid=c.id");
            pst.setInt(1, pid);

            rst = pst.executeQuery();
            while (rst.next()) {
                DiagnosysData c = new DiagnosysData();
                c.setId(rst.getInt("a.id"));
                c.setDated(rst.getDate("a.dated"));
                c.setDname(rst.getString("b.name"));
                c.setDid(rst.getInt("b.id"));
                c.setShortcode(rst.getString("b.shortcode"));
                c.setPname(rst.getString("c.fullname"));
                c.setStatus(rst.getString("a.status"));
                c.setDetail(rst.getString("a.detail"));
                dList.add(c);
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

    public int addPrescription(Prescription p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tblprescription(id,tokenno,physicianid,detail,dated) values(NULL,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setInt(1, p.getTokennno());
                pst.setInt(2, p.getPhysicianid());
                pst.setString(3, p.getStatus());
            } else {
                pst = con.prepareStatement("update tblprescription set tokenno=?,physicianid=?,detail=? where id=?");
                pst.setInt(1, p.getTokennno());
                pst.setInt(2, p.getPhysicianid());
                pst.setString(3, p.getStatus());
                pst.setInt(4, p.getPrescriptionid());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<Prescription> getPrescription(int token) {
        ArrayList<Prescription> dList = new ArrayList<Prescription>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.id,a.dated,a.detail,a.physicianid,b.fullname,a.detail from tblprescription a,tblphysician b where  a.physicianid=b.id and a.tokenno=?");
            pst.setInt(1, token);

            rst = pst.executeQuery();
            while (rst.next()) {
                Prescription c = new Prescription();
                c.setPrescriptionid(rst.getInt("a.id"));
                c.setPhysicianid(rst.getInt("a.physicianid"));
                c.setPhysicianname(rst.getString("b.fullname"));
                c.setStatus(rst.getString("a.detail"));
                c.setDated(rst.getDate("a.dated"));
                dList.add(c);
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

    public Prescription getPrescriptionByID(int pid) {
        Prescription c = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT a.id,a.dated,a.detail,a.physicianid,b.fullname,a.detail from tblprescription a,tblphysician b where  a.physicianid=b.id and a.id=?");
            pst.setInt(1, pid);

            rst = pst.executeQuery();
            while (rst.next()) {
                c = new Prescription();
                c.setPrescriptionid(rst.getInt("a.id"));
                c.setPhysicianid(rst.getInt("a.physicianid"));
                c.setPhysicianname(rst.getString("b.fullname"));
                c.setStatus(rst.getString("a.detail"));
                c.setDated(rst.getDate("a.dated"));
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

        return c;
    }

    public int savePaymentQueue(Payment p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tblpayment(id,pid,pname,ptype,torp,amount,recieved,status,dated)"
                        + " values(NULL,?,?,?,?,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setInt(1, p.getPid());
                pst.setString(2, p.getPname());
                pst.setString(3, p.getPtype());
                pst.setInt(4, p.getTorp());
                pst.setDouble(5, p.getAmount());
                pst.setDouble(6, p.getRecieved());
                pst.setString(7, p.getStatus());
            } else {
                pst = con.prepareStatement("update tblpayment set pid=?,pname=?,ptype=?,torp=?,amount=?,recieved=?,status=? where id=?");
                pst.setInt(1, p.getPid());
                pst.setString(2, p.getPname());
                pst.setString(3, p.getPtype());
                pst.setInt(4, p.getTorp());
                pst.setDouble(5, p.getAmount());
                pst.setDouble(6, p.getRecieved());
                pst.setString(7, p.getStatus());
                pst.setInt(8, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public int savePharmacyQueue(PharmacyQueue p, boolean b) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            if (!b) {
                pst = con.prepareStatement("insert into tblpharmacyqueue(id,pid,prescriptionid,status,dated)"
                        + " values(NULL,?,?,?,NOW())", PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setInt(1, p.getPatientid());
                pst.setInt(2, p.getPrescriptionid());
                pst.setString(3, p.getStatus());
            } else {
                pst = con.prepareStatement("update tblpharmacyqueue set pid=?,prescriptionid=?,status=? where id=?");
                pst.setInt(1, p.getPatientid());
                pst.setInt(2, p.getPrescriptionid());
                pst.setString(3, p.getStatus());
                pst.setInt(4, p.getId());
            }
            i = pst.executeUpdate();
            if (!b) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    i = rs.getInt(1);
                }
                rs.close();
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    public ArrayList<PharmacyQueue> getPharmacyQueue() {
        ArrayList<PharmacyQueue> dList = new ArrayList<PharmacyQueue>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tblpharmacyqueue where status='Active'");
            rst = pst.executeQuery();
            while (rst.next()) {
                PharmacyQueue c = new PharmacyQueue();
                c.setId(rst.getInt("id"));
                c.setPatientid(rst.getInt("pid"));
                c.setPrescriptionid(rst.getInt("prescriptionid"));
                c.setStatus(rst.getString("status"));
                c.setDated(rst.getDate("dated"));
                dList.add(c);
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

    public ArrayList<Payment> getPaymentQueue() {
        ArrayList<Payment> dList = new ArrayList<Payment>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tblpayment where status='Active'");
            rst = pst.executeQuery();
            while (rst.next()) {
                Payment c = new Payment();
                c.setId(rst.getInt("id"));
                c.setPid(rst.getInt("pid"));
                c.setPname(rst.getString("pname"));
                c.setPtype(rst.getString("ptype"));
                c.setTorp(rst.getInt("torp"));
                c.setAmount(rst.getDouble("amount"));
                c.setRecieved(rst.getDouble("recieved"));
                c.setStatus(rst.getString("status"));
                c.setDated(rst.getDate("dated"));
                dList.add(c);
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
    
    
    public ArrayList<Payment> getPaymentQueue(int pid) {
        ArrayList<Payment> dList = new ArrayList<Payment>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tblpayment where pid=?");
            pst.setInt(1, pid);
            rst = pst.executeQuery();
            while (rst.next()) {
                Payment c = new Payment();
                c.setId(rst.getInt("id"));
                c.setPid(rst.getInt("pid"));
                c.setPname(rst.getString("pname"));
                c.setPtype(rst.getString("ptype"));
                c.setTorp(rst.getInt("torp"));
                c.setAmount(rst.getDouble("amount"));
                c.setRecieved(rst.getDouble("recieved"));
                c.setStatus(rst.getString("status"));
                c.setDated(rst.getDate("dated"));
                dList.add(c);
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
    
    

    public Payment getPaymentQueueByID(int parseInt) {
        Payment c = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tblpayment where status='Active' and id=?");
            pst.setInt(1, parseInt);
            rst = pst.executeQuery();
            while (rst.next()) {
                c = new Payment();
                c.setId(rst.getInt("id"));
                c.setPid(rst.getInt("pid"));
                c.setPname(rst.getString("pname"));
                c.setPtype(rst.getString("ptype"));
                c.setTorp(rst.getInt("torp"));
                c.setAmount(rst.getDouble("amount"));
                c.setRecieved(rst.getDouble("recieved"));
                c.setStatus(rst.getString("status"));
                c.setDated(rst.getDate("dated"));
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
        return c;
    }

    public int saveMedicine(Medicine m) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into tblmedicine(id,name,brand,unit,rate,shelf,rack,box,dated) values(NULL,?,?,?,?,?,?,?,NOW())");
            pst.setString(1, m.getName());
            pst.setString(2, m.getBrand());
            pst.setString(3, m.getUnit());
            pst.setDouble(4, m.getRate());
            pst.setInt(5, m.getShelf());
            pst.setInt(6, m.getRack());
            pst.setInt(7, m.getBox());

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

    public ArrayList<Medicine> getMedicine() {
        ArrayList<Medicine> qList = new ArrayList<Medicine>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select id,name,brand from tblmedicine");
            rst = pst.executeQuery();
            while (rst.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rst.getInt("id"));
                medicine.setName(rst.getString("name"));
                medicine.setBrand(rst.getString("brand"));
                qList.add(medicine);
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

    public int saveMedicineStock(MedicineData m) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into tblmedicinestock(id,mid,quantity) values(NULL,?,?)");
            pst.setInt(1, m.getMid());
            pst.setInt(2, m.getQuantity());
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

    public ArrayList<MedicineStock> getMedicineData() {
        ArrayList<MedicineStock> qList = new ArrayList<MedicineStock>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("SELECT e.id, e.name, e.brand, e.unit, e.rate, e.shelf, e.rack, e.box, coalesce( p.total, 0 ) purchase, coalesce( s.total, 0 ) sell, coalesce( p.total, 0 ) - coalesce( s.total, 0 ) balance\n"
                    + "FROM tblmedicine e\n"
                    + "LEFT JOIN (\n"
                    + "\n"
                    + "SELECT mid, sum( quantity ) total\n"
                    + "FROM tblprescriptiondetail\n"
                    + "GROUP BY mid\n"
                    + ")s ON e.id = s.mid\n"
                    + "LEFT JOIN (\n"
                    + "\n"
                    + "SELECT mid, sum( quantity ) total\n"
                    + "FROM tblmedicinestock \n"
                    + "GROUP BY mid\n"
                    + ")p ON e.id = p.mid");
            rst = pst.executeQuery();
            while (rst.next()) {
                MedicineStock medicine = new MedicineStock();
                medicine.setId(rst.getInt("id"));
                medicine.setName(rst.getString("name"));
                medicine.setBrand(rst.getString("brand"));
                medicine.setUnit(rst.getString("unit"));
                medicine.setRate(rst.getDouble("rate"));
                medicine.setPurchase(rst.getInt("purchase"));
                medicine.setSell(rst.getInt("sell"));
                medicine.setBalance(rst.getInt("balance"));
                medicine.setShelf(rst.getInt("shelf"));
                medicine.setRack(rst.getInt("rack"));
                medicine.setBox(rst.getInt("box"));
                qList.add(medicine);
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

    public int removeUser(String user) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("delete from tbluser where username=?");
            pst.setString(1, user);

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

    public int saveUser(User user) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into  tbluser values(NULL,?,?,?,?,'','',NOW(),NOW(),NOW())");
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getType());
            pst.setString(4, user.getUserName());

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

    public int saveMessage(String from, String to, String message) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("insert into  tblchat values(?,?,?,NOW())");
            pst.setString(1, from);
            pst.setString(2, to);
            pst.setString(3, message);

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

    public ArrayList<Message> getMessage(String username) {
        ArrayList<Message> qList = new ArrayList<Message>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select * from tblchat where fromuser=? or touser=?");
            pst.setString(1, username);
            pst.setString(2, username);

            rst = pst.executeQuery();
            while (rst.next()) {
                Message medicine = new Message();
                medicine.setFrom(rst.getString("fromuser"));
                medicine.setTo(rst.getString("touser"));
                medicine.setMessage(rst.getString("message"));
                medicine.setDate(rst.getDate("dated"));
                qList.add(medicine);
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

    public int addPrescriptionData(int pid, ArrayList<PrescriptionData> plist) {
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("delete from tblprescriptiondetail where prescriptionid=?");
            pst.setInt(1, pid);
            i = pst.executeUpdate();

            pst = con.prepareStatement("insert into tblprescriptiondetail values(NULL,?,?,?,?,?,?,?,NOW())");
            for (PrescriptionData p : plist) {
                pst.setInt(1, pid);
                pst.setInt(2, p.getMid());
                pst.setString(3, p.getTake());
                pst.setString(4, p.getFrequency());
                pst.setString(5, p.getDuration());
                pst.setDouble(6, p.getQuantity());
                pst.setDouble(7, p.getRate());
                pst.addBatch();
            }
            pst.executeBatch();
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

    public ArrayList<PrescriptionData> getPrescriptionData(int pid) {
        ArrayList<PrescriptionData> pList = new ArrayList<PrescriptionData>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select p.mid,m.name,p.quantity,p.rate,p.take,p.frequency,p.duration from  tblprescriptiondetail p, tblmedicine m where p.prescriptionid=? and p.mid=m.id");
            pst.setInt(1, pid);
            rst = pst.executeQuery();
            while (rst.next()) {
                PrescriptionData p = new PrescriptionData();
                p.setMid(rst.getInt("p.mid"));
                p.setMedication(rst.getString("m.name"));
                p.setQuantity(rst.getDouble("p.quantity"));
                p.setRate(rst.getDouble("p.rate"));
                p.setTake(rst.getString("p.take"));
                p.setFrequency(rst.getString("p.frequency"));
                p.setDuration(rst.getString("p.duration"));
                pList.add(p);
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pList;
    }

    public double getPrescriptionAmount(int pid) {
        double amount = 0;

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            con = getCon();
            pst = con.prepareStatement("select quantity, rate from  tblprescriptiondetail where prescriptionid=?");
            pst.setInt(1, pid);
            rst = pst.executeQuery();
            while (rst.next()) {
                double q = rst.getDouble("quantity");
                double r = rst.getDouble("rate");
                amount = amount + (q * r);
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return amount;
    }

    public int updateUser(String u, String n, String q, String a) {

        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = getCon();

            pst = con.prepareStatement("update tbluser set password=?,question=?,answer=? where username=?");
            pst.setString(1, n);
            pst.setString(2, q);
            pst.setString(3, a);
            pst.setString(4, u);

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
