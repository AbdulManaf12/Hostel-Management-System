package Admin;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Abdul Manaf
 */
public class StudentInfo extends JFrame implements Runnable {
    private JTable table;

    public StudentInfo() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setLayout(null);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        try {
            Thread t = new Thread(this, "MessSystem");
            t.start();
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void run() {
        SetComponent();
    }

    private void SetComponent() {
        JMenuBar bar = new JMenuBar();
        bar.setLayout(null);
        bar.setBounds(0, 0, 1400, 100);
        JLabel tilte = new JLabel("INFORMATION OF STUDENT");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(400, 10, 600, 100);
        JButton back = new JButton("Back");
        back.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        back.setBounds(1200, 15, 100, 40);
        back.setBackground(Color.LIGHT_GRAY);
        bar.add(tilte);
        bar.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                close();
            }
        });
        JPanel panel = new JPanel();
        panel.setBounds(0, 103, 1400, 1000);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        String column[] = {"No:", "Name", "Father", "ID", "Department", "Mobile No", "Gender", "Email", "Age", "Address", "Password"};
        Object records[][] = new Object[100][11];
        if (JDBC_Data.getAccountLength() != 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel_Management_Database?useSSL=false", "root", "root");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from student_info");
                int i = 0;
                while (rs.next()) {
                    records[i][0] = i;
                    records[i][1] = rs.getString(2);
                    records[i][2] = rs.getString(3);
                    records[i][3] = rs.getString(1);
                    records[i][4] = rs.getString(7);
                    records[i][5] = rs.getString(6);
                    records[i][6] = rs.getString(5);
                    records[i][7] = rs.getString(8);
                    records[i][8] = rs.getInt(4);
                    records[i][9] = rs.getString(9);
                    records[i][10] = rs.getString(10);
                    i++;
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            for (int i = 0; i < 100; i++) {
                records[i][0] = null;
                records[i][1] = null;
                records[i][2] = null;
                records[i][3] = null;
                records[i][4] = null;
                records[i][5] = null;
                records[i][6] = null;
                records[i][7] = null;
                records[i][8] = null;
                records[i][9] = null;
                records[i][10] = null;
            }
        }
        table = new JTable(records, column);
        table.setRowHeight(30);
        table.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 20, 1320, 550);
        panel.add(scroll);
        add(bar);
        add(panel);
    }

    private void close() {
        this.dispose();
    }
}
