package Login;

import Admin.AdminHome;
import Database.JDBC_Data;
import User.UserHome;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Abdul Manaf
 */
public class LoginPage extends JFrame implements Runnable {
    JPanel panel0, panel1, panel2;
    JTextField usernames;
    JPasswordField paswords;
    JButton login;
    JLabel username, pasword, forgot, background, Title;

    public LoginPage() {
        super("Hostel Management System - 1.0");
        setSize(1470, 1100);
        Thread t = new Thread(this, "Login");
        t.start();
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(-5, 0);
        try {
            t.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        setVisible(true);
    }

    private void SetComponents() {
        panel0 = new JPanel();
        JLabel Head = new JLabel("بسم الله الرحمن الرحيم");
        Head.setForeground(Color.WHITE);
        Head.setBounds(440, -55, 400, 200);
        Head.setFont(new Font(Font.DIALOG, Font.BOLD, 45));
        Title = new JLabel("Hostel Management System");
        Title.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        panel0.add(Title);
        panel0.setBounds(310, 80, 600, 70);
        panel0.setBackground(Color.GRAY);
        panel1 = new JPanel();
        ImageIcon bgd = new ImageIcon(getClass().getClassLoader().getResource("Hostel-2.jpg"));
        background = new JLabel(bgd);
        background.add(Head);
        background.add(panel0);
        panel2 = new JPanel();
        panel2.setBounds(470, 200, 330, 400);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.setLayout(null);

        username = new JLabel("Userame ");
        username.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        username.setForeground(Color.orange);
        username.setBounds(110, 10, 150, 100);

        usernames = new JTextField();
        usernames.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 18));
        usernames.setBounds(70, 90, 180, 30);

        pasword = new JLabel("Password ");
        pasword.setBounds(100, 110, 150, 100);
        pasword.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        pasword.setForeground(Color.orange);

        paswords = new JPasswordField();
        paswords.setFont(new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 18));
        paswords.setBounds(70, 190, 180, 30);
        paswords.setEchoChar('#');

        JRadioButton showpassword = new JRadioButton("Show Password");
        showpassword.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 14));
        showpassword.setBounds(80, 215, 150, 35);
        showpassword.setForeground(Color.WHITE);

        login = new JButton("Login");
        login.setBounds(80, 250, 160, 35);
        login.setBackground(Color.LIGHT_GRAY);
        login.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));

        forgot = new JLabel("forgot password");
        forgot.setBounds(100, 290, 150, 35);
        forgot.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 14));
        forgot.setForeground(Color.yellow);
        forgot.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel terms = new JLabel("| Terms Policy");
        terms.setBounds(150, 370, 150, 35);
        terms.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 14));
        terms.setForeground(Color.yellow);
        terms.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel contact = new JLabel("Contact us");
        contact.setBounds(70, 370, 150, 35);
        contact.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 14));
        contact.setForeground(Color.yellow);
        contact.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel2.add(username);
        panel2.add(usernames);
        panel2.add(pasword);
        panel2.add(paswords);
        panel2.add(showpassword);
        panel2.add(login);
        panel2.add(forgot);
        panel2.add(terms);
        panel2.add(contact);

        background.add(panel2);
        background.setBounds(0, 0, 1470, 1100);
        panel1.add(background);
        add(panel1);

        showpassword.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    paswords.setEchoChar((char) 0);
                } else {
                    paswords.setEchoChar('#');
                }
            }
        });
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (usernames.getText().equalsIgnoreCase("admin") && new String(paswords.getPassword()).equalsIgnoreCase("admin")) {
                    new AdminHome();
                    close();
                } else if (JDBC_Data.CheckEmailForLogin(usernames.getText(), new String(paswords.getPassword()))) {
                    new UserHome();
                    close();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect username of Pasword", "Warning", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        forgot.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                String email = JOptionPane.showInputDialog(new JFrame(), "Email : ", "Forgot Password", JOptionPane.QUESTION_MESSAGE);
                if (JDBC_Data.isEmail(email)) {
                    String mobile = JOptionPane.showInputDialog(new JFrame(), "Mobile : ", " ", JOptionPane.QUESTION_MESSAGE);
                    if (JDBC_Data.getMobile(email).equalsIgnoreCase(mobile)) {
                        String newpas = JOptionPane.showInputDialog(new JFrame(), "Enter new Password", "New Password", JOptionPane.QUESTION_MESSAGE);
                        if (newpas.length() >= 8) {
                            JDBC_Data.setPassword(newpas, email);
                            JOptionPane.showMessageDialog(new JFrame(), "Your Pasword is updated", "Succesfully", JOptionPane.INFORMATION_MESSAGE);
                        } else if (newpas.length() < 8) {
                            JOptionPane.showMessageDialog(new JFrame(), "Password must be Greater than 8", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Network Problem", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showInputDialog(new JFrame(), "Wrong Mobile", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        terms.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                new Terms().setVisible(true);
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        contact.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                new Contact().setVisible(true);
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void run() {
        SetComponents();
    }

    private void close() {
        dispose();
    }
}