package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * @author Abdul Manaf
 */
public class AdminHome extends JFrame implements Runnable {
    private JButton StudentInfo, RoomAllotement, DeleteStudent, FeeDetail, Mess, AddStudent, Notification, UpdateStudent, Logout;
    private JPanel panel1;
    private JMenuBar bar;
    private JLabel l1;

    public AdminHome() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setLayout(null);
        try {
            Thread t = new Thread(this, "AdminHome");
            t.start();
            t.join();
            setVisible(true);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void SetComponents() {
        bar = new JMenuBar();
        panel1 = new JPanel();
        panel1.setBounds(0, 150, 1400, 1100);
        bar.setBounds(0, 0, 1400, 150);

        JLabel tilte = new JLabel("Admin Page");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        tilte.setBounds(300, 20, 300, 100);
        bar.add(tilte);
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("AdminHome.jpg"));
        l1 = new JLabel(img);
        l1.setBounds(0, 0, 1400, 1100);
        l1.setLayout(null);

        StudentInfo = new JButton("Student Info");
        StudentInfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        StudentInfo.setBounds(20, 20, 200, 100);
        StudentInfo.setBorder(null);
        StudentInfo.setBackground(Color.LIGHT_GRAY);

        RoomAllotement = new JButton("Room Allotment");
        RoomAllotement.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        RoomAllotement.setBounds(20, 140, 200, 100);
        RoomAllotement.setBorder(null);
        RoomAllotement.setBackground(Color.LIGHT_GRAY);

        FeeDetail = new JButton("Fee Detail");
        FeeDetail.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        FeeDetail.setBounds(230, 20, 200, 100);
        FeeDetail.setBorder(null);
        FeeDetail.setBackground(Color.LIGHT_GRAY);

        Mess = new JButton("Mess System");
        Mess.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        Mess.setBounds(230, 140, 200, 100);
        Mess.setBorder(null);
        Mess.setBackground(Color.LIGHT_GRAY);

        AddStudent = new JButton("Add Student");
        AddStudent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        AddStudent.setBounds(20, 260, 200, 100);
        AddStudent.setBorder(null);
        AddStudent.setBackground(Color.LIGHT_GRAY);

        Notification = new JButton("Notifications");
        Notification.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        Notification.setBounds(230, 260, 200, 100);
        Notification.setBorder(null);
        Notification.setBackground(Color.LIGHT_GRAY);

        DeleteStudent = new JButton("Delete Student");
        DeleteStudent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        DeleteStudent.setBounds(20, 380, 200, 100);
        DeleteStudent.setBorder(null);
        DeleteStudent.setBackground(Color.LIGHT_GRAY);

        UpdateStudent = new JButton("Update Student");
        UpdateStudent.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        UpdateStudent.setBounds(230, 380, 200, 100);
        UpdateStudent.setBorder(null);
        UpdateStudent.setBackground(Color.LIGHT_GRAY);

        Logout = new JButton("Logout");
        Logout.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        Logout.setBounds(1200, 5, 130, 130);
        Logout.setBorder(null);
        Logout.setBackground(Color.LIGHT_GRAY);

        l1.add(StudentInfo);
        l1.add(RoomAllotement);
        l1.add(FeeDetail);
        l1.add(Mess);
        l1.add(AddStudent);
        l1.add(Notification);
        l1.add(DeleteStudent);
        l1.add(UpdateStudent);
        bar.setLayout(null);

        bar.add(Logout);
        panel1.add(l1);
        add(bar);
        add(panel1);
    }

    @Override
    public void run() {
        SetComponents();
        Actions();
    }

    private void close() {
        this.dispose();
    }

    private void Actions() {
        StudentInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StudentInfo();
                close();
            }
        });
        RoomAllotement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RoomAllotment();
                close();
            }
        });
        Mess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MessSystem();
                close();
            }
        });
        AddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddStudent();
                close();
            }
        });
        Notification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Database.Notification();
                close();
            }
        });
        FeeDetail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new feeDetail();
                close();
            }
        });
        DeleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteStudent();
                close();
            }
        });
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login.LoginPage();
                close();
            }
        });
        UpdateStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentUpadate();
                close();
            }
        });
    }
}
