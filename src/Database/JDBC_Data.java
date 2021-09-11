package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Abdul Manaf
 */
public class JDBC_Data {
    private static Connection con;
    private static Statement st;
    private static String email = "";

    private static synchronized void EstablishConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel_Management_Database?useSSL=false", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Network Not Found");
        }
    }

    public static synchronized void CloseConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        JDBC_Data.email = email;
    }

    public static String getID() {
        String query = "select (id) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getName() {
        String query = "select (name) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getFatherName() {
        String query = "select (father) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static int getAge() {
        String query = "select (age) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        int res = 0;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Integer.parseInt(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static void setAge(int age) {
        String query = "update student_info set age=" + age + " where email=\"" + email + "\"";
        EstablishConnection();
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
        } finally {
            CloseConnection();
        }
    }

    public static String getGender() {
        String query = "select (gender) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getMobile() {
        String query = "select * from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            if (rs.next()) {
                query = rs.getString(6);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static void setMobile(String pas) {
        String query = "update student_info set mobile=\"" + pas + "\" where email=\"" + email + "\"";
        EstablishConnection();
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
        } finally {
            CloseConnection();
        }
    }

    public static String getMobile(String email) {
        String query = "select * from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            if (rs.next()) {
                query = rs.getString(6);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getDepartment() {
        String query = "select (department) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getEmailFromJDBC(String name) {
        String query = "select (email) from student_info where name=\"" + name + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getAddress() {
        String query = "select (address) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getPassword() {
        String query = "select (pasword) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static void setPassword(String pasn) {
        String query = "update student_info set Pasword=\"" + pasn + "\" where email=\"" + email + "\"";
        EstablishConnection();
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
        } finally {
            CloseConnection();
        }
    }

    public static int getRoomNo() {
        String query = "select (roomno) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        int res = 0;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Integer.parseInt(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static double getTotalFees() {
        double res = 0;
        String query = "select (Total_Fees) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Double.parseDouble(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static double getRemainingFees() {
        double res = 0;
        String query = "select (Remaining_Fees) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Double.parseDouble(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static double getPaidFees() {
        double res = 0;
        String query = "select (Paid_Fees) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Double.parseDouble(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static String getDateFrom() {
        String query = "select (Date_from) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static String getDateTo() {
        String query = "select (Date_to) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            query = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return query;
    }

    public static double getMessTotalFees() {
        double res = 0;
        String query = "select (totalFees) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Double.parseDouble(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static double getMessTotalUnit() {
        double res = 0;
        String query = "select (total_unit) from student_info where email=\"" + email + "\"";
        EstablishConnection();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            rs.next();
            res = Double.parseDouble(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CloseConnection();
        return res;
    }

    public static int getAccountLength() {
        int result = 0;
        EstablishConnection();
        try {
            ResultSet r = st.executeQuery("select * from student_info");
            while (r.next()) {
                result++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setAccount(String id, String name, String father, int age, String Address, String dep, String mobile, String pasw, String email, String gen) {
        String query = "insert into student_info values (\"" + id + "\",\"" + name + "\",\"" + father + "\"," + age + ",\"" + gen + "\",\"" + mobile + "\",\"" + dep + "\",\"" + email + "\",\"" + Address + "\",\"" + pasw + "\",0,0,0,0,\"0/0/0000\",\"0/0/0000\",0,0)";
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setFees(double total, double paid, double remain, String from, String to, String email) {
        String query = "update student_info set Total_Fees=" + total + ",Paid_Fees=" + paid + ",Remaining_Fees=" + remain + ",Date_from=\"" + from + "\",Date_to=\"" + to + "\" where email=\"" + email + "\"";
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setRoom(double room, String email) {
        String query = "update student_info set roomno=" + room + " where email=\"" + email + "\"";
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setMessPayment(double totalpayment, int totalunit, String email) {
        String query = "update student_info set totalFees=" + totalpayment + ", total_unit=" + totalunit + " where email=\"" + email + "\"";
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean isName(String name) {
        boolean result = false;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select (name) from student_info");
            while (rs.next()) {
                if (name.equalsIgnoreCase(rs.getNString(1))) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean isEmail(String email) {
        boolean result = false;
        if (email != null && email.length() != 0) {
            EstablishConnection();
            try {
                ResultSet rs = st.executeQuery("select (email) from student_info");
                while (rs.next()) {
                    if (email.equalsIgnoreCase(rs.getNString(1))) {
                        result = true;
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                CloseConnection();
            }
        }
        return result;
    }

    public static ResultSet CheckID(String id) {
        ResultSet rs = null;
        String query = "select * from student_info where id=\"" + id + "\"";
        EstablishConnection();
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String[] getAllNames() {
        String r[] = new String[getAccountLength()];
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select (name) from student_info order by name asc");
            int index = 0;
            while (rs.next()) {
                r[index++] = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public static ResultSet getMessPayment(String n) {
        ResultSet rs = null;
        EstablishConnection();
        try {
            rs = st.executeQuery("select * from student_info where name=\"" + n + "\"");
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean DeleteAccount(String name) {
        boolean resutl = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate("delete from student_info where name=\"" + name + "\"");
            if (i == 1) {
                resutl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return resutl;
    }

    public static void setEmail_in_JDBC(String emn) {
        String query = "update student_info set email=\"" + emn + "\" where email=\"" + email + "\"";
        EstablishConnection();
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
        } finally {
            CloseConnection();
        }
    }

    public static boolean CheckEmailForLogin(String email, String pas) {
        boolean result = false;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from student_info where email=\"" + email + "\"");
            if (rs.next()) {
                String ems = rs.getString(8);
                if (ems.equalsIgnoreCase(email)) {
                    if (rs.getString(10).equalsIgnoreCase(pas)) {
                        JDBC_Data.email = email;
                        result = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getID(String email) {
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select (id) from student_info where email=\"" + email + "\"");
            email = rs.getString(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Wrong Email");
        } finally {
            CloseConnection();
        }
        return email;
    }

    public static void setPassword(String newpas, String email) {
        String query = "update student_info set pasword=\"" + newpas + "\" where email=\"" + email + "\"";
        EstablishConnection();
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
    }

    public static int getRoom(String name) {
        int rseult = 0;
        String query = "select * from student_info where name=\"" + name + "\"";
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                rseult = rs.getInt(11);
            }
        } catch (SQLException e) {
        } finally {
            CloseConnection();
        }
        return rseult;
    }

    public static boolean UpdateAccount(String id, String name, String father, int age, String gen, String mobile, String dep, String email, String Address, String pasw, String setname) {
        String query = "update student_info set id=\"" + id + "\",name=\"" + name + "\",father=\"" + father + "\",age=" + age + ",gender=\"" + gen + "\",mobile=\"" + mobile + "\",department=\"" + dep + "\",email=\"" + email + "\",address=\"" + Address + "\",pasword=\"" + pasw + "\" where name=\"" + setname + "\"";
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i >= 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }
}
