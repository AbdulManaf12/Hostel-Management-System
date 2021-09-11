package Admin;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Abdul Manaf
 */
public class AddStudent extends JFrame implements Runnable {
    private JLabel Name, ID, Father, Age, Address, Department, Mobile, Password, email, no, genderlabel;
    private JTextField Names, IDs, Fathers, Ages, Departments, Mobiles, Passwords, emails;
    private JTextArea Addresses;
    private JButton Register, back;
    private JPanel panel;
    private JMenuBar bar;
    private JRadioButton male, female;
    private ButtonGroup gender;
    private String gen = null;

    public AddStudent() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setLayout(null);
        try {
            Thread t = new Thread(this, "StudentInfo");
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
        bar = new JMenuBar();
        bar.setLayout(null);
        bar.setBounds(0, 0, 1400, 100);
        JLabel tilte = new JLabel("ADD STUDENT");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(500, 10, 400, 100);
        bar.add(tilte);
        panel = new JPanel();
        panel.setBounds(0, 103, 1400, 1000);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);
        Name = new JLabel("Name");
        ID = new JLabel("ID");
        Father = new JLabel("Father");
        Age = new JLabel("Age");
        Address = new JLabel("Address");
        gender = new ButtonGroup();
        Department = new JLabel("Department");
        Mobile = new JLabel("Mobile");
        Password = new JLabel("Password");
        email = new JLabel("Email");
        Names = new JTextField(10);
        IDs = new JTextField(8);
        Fathers = new JTextField(10);
        Ages = new JTextField(5);
        Addresses = new JTextArea(4, 7);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        Departments = new JTextField();
        Mobiles = new JTextField();
        Passwords = new JTextField(8);
        emails = new JTextField(10);
        Register = new JButton("Register");
        back = new JButton("Back");
        genderlabel = new JLabel("Gender");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                close();
            }
        });


        ID.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Name.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Father.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Age.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        male.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        female.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Mobile.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Department.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Address.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        email.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Password.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        back.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        Register.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        genderlabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        back.setBackground(Color.lightGray);
        Register.setBackground(Color.lightGray);

        ID.setBounds(150, 10, 100, 50);
        Name.setBounds(150, 70, 100, 50);
        Father.setBounds(150, 130, 100, 50);
        Age.setBounds(150, 190, 100, 50);
        male.setBounds(300, 250, 100, 50);
        genderlabel.setBounds(150, 250, 100, 50);
        Mobile.setBounds(150, 330, 100, 50);
        Department.setBounds(150, 400, 150, 50);
        Address.setBounds(550, 10, 150, 50);
        email.setBounds(150, 480, 100, 50);
        Password.setBounds(550, 110, 150, 50);

        IDs.setBounds(300, 20, 150, 30);
        Names.setBounds(300, 80, 150, 30);
        Fathers.setBounds(300, 140, 150, 30);
        Ages.setBounds(300, 200, 150, 30);
        female.setBounds(400, 250, 150, 50);
        Mobiles.setBounds(300, 340, 150, 30);
        Departments.setBounds(300, 410, 150, 30);
        Addresses.setBounds(700, 20, 230, 80);
        emails.setBounds(300, 490, 150, 30);
        Passwords.setBounds(700, 120, 200, 30);
        Register.setBounds(750, 200, 150, 40);
        back.setBounds(630, 200, 100, 40);

        Names.setToolTipText("Use Unique name which before doesn't exist");
        Ages.setToolTipText("only numerical form");
        emails.setToolTipText("Appropriate email and one email use one account");
        Passwords.setToolTipText("Password must be Greater than 8");
        no = new JLabel(("No: " + JDBC_Data.getAccountLength()));
        no.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        no.setBounds(680, 250, 100, 50);
        male.setBackground(Color.LIGHT_GRAY);
        female.setBackground(Color.lightGray);
        male.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gen = "Male";
            }
        });
        female.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gen = "Female";
            }
        });

        gender.add(male);
        gender.add(female);
        panel.add(ID);
        panel.add(IDs);
        panel.add(Name);
        panel.add(Names);
        panel.add(Father);
        panel.add(Fathers);
        panel.add(Age);
        panel.add(Ages);
        panel.add(genderlabel);
        panel.add(male);
        panel.add(female);
        panel.add(Mobile);
        panel.add(Mobiles);
        panel.add(Department);
        panel.add(Departments);
        panel.add(Address);
        panel.add(Addresses);
        panel.add(email);
        panel.add(emails);
        panel.add(Password);
        panel.add(Passwords);
        panel.add(Register);
        panel.add(back);
        panel.add(no);
        add(bar);
        add(panel);

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean reslt1 = false, reslt2 = false, reslt3 = false, rselt4 = false;

                if (IDs.getText().length() >= 1 && Names.getText().length() > 1 && Fathers.getText().length() > 1 && (Integer.parseInt(Ages.getText()) > 0 && Integer.parseInt(Ages.getText()) < 100)) {
                    reslt1 = true;
                }
                if (Addresses.getText().length() > 1 && Passwords.getText().length() >= 8 && Departments.getText().length() > 1 && (male.isSelected() || female.isSelected())) {
                    reslt2 = true;
                }
                if (emails.getText().contains("@")) {
                    if (!JDBC_Data.isEmail(emails.getText())) {
                        reslt3 = true;
                    } else {
                        emails.setForeground(Color.red);
                    }
                }
                if (!JDBC_Data.isName(Names.getText())) {
                    rselt4 = true;
                }
                if (reslt1 && reslt2 && reslt3 && rselt4) {
                    String genders = (male.isSelected()) ? "Male" : "Female";
                    if (JDBC_Data.setAccount(IDs.getText(), Names.getText(), Fathers.getText(), Integer.parseInt(Ages.getText()), Addresses.getText(), Departments.getText(), Mobiles.getText(), Passwords.getText(), emails.getText(), genders)) {
                        IDs.setText(null);
                        Names.setText(null);
                        Fathers.setText(null);
                        Ages.setText(null);
                        Addresses.setText(null);
                        Departments.setText(null);
                        Mobiles.setText(null);
                        Passwords.setText(null);
                        emails.setText(null);
                        gender.clearSelection();
                        no.setText(JDBC_Data.getAccountLength() + "");
                        JOptionPane.showMessageDialog(null, "SuccessFully Created", "New Account", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Network Problem unsuccessfull", "New Account", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Data. Check Properly", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void close() {
        dispose();
    }
}