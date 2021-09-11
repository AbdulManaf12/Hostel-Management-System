package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Abdul Manaf
 */
public class Mess {
    private static Connection con;
    private static Statement st;

    private static void EstablishConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel_Management_Database?useSSL=false", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CloseConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getOneUnitPrice() {
        int result = 0;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral");
            while (rs.next()) {
                result = rs.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setOneUnitPrice(int price) {
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate("update MessGeneral set one_unit=" + price + " where t=34");
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

    public static int getMorningUnit() {
        int result = 0;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral");
            while (rs.next()) {
                result = rs.getInt(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static int getLunchUnit() {
        int result = 0;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral");
            while (rs.next()) {
                result = rs.getInt(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static int getDinnerUnit() {
        int result = 0;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral");
            while (rs.next()) {
                result = rs.getInt(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setMorningUnit(int unit) {
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate("update MessGeneral set morning_unit=" + unit + " where t=34");
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

    public static boolean setLunchUnit(int unit) {
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate("update MessGeneral set lunch_unit=" + unit + " where t=34");
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

    public static boolean setDinnerUnit(int unit) {
        boolean result = false;
        EstablishConnection();
        try {
            int i = st.executeUpdate("update MessGeneral set dinner_unit=" + unit + " where t=34");
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

    public static String getMon_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(6);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getMon_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(7);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getMon_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(8);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getTues_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(9);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getTues_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(10);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getTues_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(11);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getWed_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(12);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getWed_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(13);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getWed_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(14);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getThrus_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(15);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getThrus_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(16);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getThrus_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(17);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getFrid_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(18);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getFrid_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(19);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getFrid_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(20);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getSatur_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(21);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getSatur_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(22);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getSatur_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(23);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getSund_1() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(24);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getSund_2() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(25);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static String getSund_3() {
        String result = null;
        EstablishConnection();
        try {
            ResultSet rs = st.executeQuery("select * from MessGeneral where t=34");
            rs.next();
            result = rs.getString(26);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }

    public static boolean setMenu(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p, String q, String r, String s, String t, String u) {
        String query = "update MessGeneral set Mon1=\"" + a + "\",Mon2=\"" + b + "\",Mon3=\"" + c + "\",Tues1=\"" + d + "\",Tues2=\"" + e + "\",Tues3=\"" + f + "\",Wed1=\"" + g + "\",Wed2=\"" + h + "\",Wed3=\"" + i + "\",Thrus1=\"" + j + "\",Thrus2=\"" + k + "\",Thrus3=\"" + l + "\",Fri1=\"" + m + "\",Fri2=\"" + n + "\",Fri3=\"" + o + "\",Sat1=\"" + p + "\",Sat2=\"" + q + "\",Sat3=\"" + r + "\",Sun1=\"" + s + "\",Sun2=\"" + t + "\",Sun3=\"" + u + "\" where t=34";
        boolean result = false;
        EstablishConnection();
        try {
            int ch = st.executeUpdate(query);
            if (ch == 1)
                result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            CloseConnection();
        }
        return result;
    }
}
