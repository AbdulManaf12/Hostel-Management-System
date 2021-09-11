package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Abdul Manaf
 */
public class Terms extends JFrame {
    public Terms() {
        super("Terms and Conditions");
        setSize(500, 500);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        String text = "                                                                                      \n " +
                "          Welcome to Hostel Management System             \n " +
                "                                                                                      \n " +
                "                                                                                      \n " +
                " Hostel Management System builds very easy\n" +
                " service for user and admin to manage hostel \n" +
                " problems in very easy soultion in this software.\n" +
                " You can add students and remove too add data\n" +
                " also manage your mess System in this very easily.\n" +
                "And user can also review his account with mess and\n" +
                "hostel in this software notification tab also present if \n" +
                "any notice or urgent thing would hapeen it is in this \n" +
                "you can add and for fees you can add and mess menu\n" +
                "is also avaliable in this you can change it and update\n " +
                "So the core idea of this software is to give facility to\n " +
                "hostelers and wardens to comunicate with eachother\n" +
                "                                                                                      \n " +
                "In this admin only can enroll the students because some\n" +
                "reasons to secure this and admin can enroll 100 students\n" +
                "in this software beacuse most of hostels have less students\n" +
                "                                                                                      \n " +
                " I hope you like and give feedback to us about this and for \n" +
                " contact to us email on this : \"Sahitoa97@Gmail.com\" \n " +
                "                         Thankyou                       ";

        JTextArea policy = new JTextArea(text);
        policy.setEditable(false);
        policy.setBounds(0, 0, 500, 432);
        policy.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        policy.setBorder(null);
        JScrollPane pane = new JScrollPane(policy);
        pane.setBounds(0, 0, 500, 432);
        policy.setWrapStyleWord(true);
        add(pane);

        JPanel p = new JPanel();
        p.setBounds(0, 432, 500, 68);
        p.setBackground(Color.WHITE);
        JButton close = new JButton("close");
        close.setBounds(410, 435, 70, 25);
        close.setBackground(Color.WHITE);
        p.add(close);
        add(p);
        setResizable(false);
        setLocationRelativeTo(null);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
