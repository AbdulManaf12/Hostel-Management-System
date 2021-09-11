package User;

import Login.LoginPage;
import Database.JDBC_Data;

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
import javax.swing.JTabbedPane;

/**
 * @author Abdul Manaf
 */
public class UserHome extends JFrame implements Runnable {
    private JPanel panel;
    private JMenuBar bar;
    private JTabbedPane tabbed;
    private HostelFeesPanel hostelfees;
    private MessFeesPanel messfees;
    private MyProfilePanel myProfile;
    private NotificationPanel notifiication;
    private SettingPanel setting;

    public UserHome() {
        super("Hostel Management System - 1.0");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setSize(1400, 1100);
        setLayout(null);
        setLocation(-10, 0);
        try {
            Thread t = new Thread(this, "UserHome");
            t.start();
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void SetComponents() {
        hostelfees = new HostelFeesPanel();
        messfees = new MessFeesPanel();
        myProfile = new MyProfilePanel();
        notifiication = new NotificationPanel();
        setting = new SettingPanel();

        bar = new JMenuBar();
        bar.setLayout(null);
        bar.setBounds(0, 0, 1400, 100);

        JLabel tilte = new JLabel(JDBC_Data.getName());
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(50, 0, 400, 100);
        bar.add(tilte);

        JButton logout = new JButton("Logout");
        logout.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        logout.setBounds(1250, 10, 100, 70);
        bar.add(logout);
        add(bar);

        panel = new JPanel();
        panel.setBounds(0, 100, 1400, 1000);
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        tabbed = new JTabbedPane();
        tabbed.setBounds(0, 0, 1400, 1000);
        tabbed.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        tabbed.add(hostelfees, "Hostel Fees");
        tabbed.add(messfees, "Mess Fees");
        tabbed.add(notifiication, "Notification");
        tabbed.add(myProfile, "My Profile");
        tabbed.add(setting, "Setting");
        panel.add(tabbed);
        add(panel);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
    }

    @Override
    public void run() {
        SetComponents();
    }
}
