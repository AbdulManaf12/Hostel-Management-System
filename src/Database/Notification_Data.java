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
public class Notification_Data {
    private static Connection con;
    private static Statement st;

    private static synchronized void EstablishConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel_Management_Database?useSSL=false", "root", "root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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

    public static int getIndex() {
        int res = 0;
        EstablishConnection();
        try {
            ResultSet s = st.executeQuery("select * from Notification");
            while (s.next()) {
                res++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return res;
    }

    public static String[] getNotification() {
        if (getIndex() > 0) {
            String no = "select * from Notification";
            String arr[] = new String[getIndex()];
            EstablishConnection();
            try {
                ResultSet rs = st.executeQuery(no);
                int i = 0;
                while (rs.next()) {
                    arr[i++] = rs.getString(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                CloseConnection();
            }
            return arr;
        } else {
            return null;
        }
    }

    public static void setNotification(String no) {
        String query = "insert into Notification values (\"" + no + "\")";
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Saved");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
    }

    public static boolean remove(String n) {
        boolean res = false;
        String query = "delete from Notification where notf=\"" + n + "\"";
        EstablishConnection();
        try {
            int i = st.executeUpdate(query);
            if (i > 0) {
                res = true;
                JOptionPane.showMessageDialog(null, "Deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something wrong", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        } finally {
            CloseConnection();
        }
        return res;
    }
}
