package Admin;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Abdul Manaf
 */
public class StudentUpadate extends JFrame implements Runnable, ListSelectionListener {
    private JList list;
    private JLabel Name, ID, Father, Age, Address, Department, Mobile, Password, email, no, genderlabel;
    private JTextField Names, IDs, Fathers, Ages, Departments, Mobiles, Passwords, emails;
    private JTextArea Addresss;
    private JButton Register, back;
    private JPanel panel;
    private JMenuBar bar;
    private JRadioButton male, female;
    private ButtonGroup gender;
    private String gen = null, searchuser = "";

    public StudentUpadate() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setLayout(null);
        try {
            Thread t = new Thread(this, "UpdateStudent");
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
        JLabel tilte = new JLabel("UPDATE STUDENT");
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
        Addresss = new JTextArea(4, 7);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        Departments = new JTextField();
        Mobiles = new JTextField();
        Passwords = new JTextField(8);
        emails = new JTextField(10);
        Register = new JButton("Update");
        back = new JButton("Back");
        genderlabel = new JLabel("Gender");
        String n[] = JDBC_Data.getAllNames();
        list = new JList(n);
        list.addListSelectionListener(this);
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

        ID.setBounds(200, 260, 100, 50);
        Name.setBounds(200, 330, 100, 50);
        Father.setBounds(200, 400, 100, 50);
        Age.setBounds(200, 460, 100, 50);
        genderlabel.setBounds(820, 20, 100, 50);
        Mobile.setBounds(830, 100, 100, 50);
        Department.setBounds(800, 170, 150, 50);
        Address.setBounds(820, 320, 150, 50);
        email.setBounds(820, 250, 100, 50);
        Password.setBounds(820, 440, 150, 50);

        IDs.setBounds(350, 270, 150, 30);
        Names.setBounds(350, 340, 150, 30);
        Fathers.setBounds(350, 410, 150, 30);
        Ages.setBounds(350, 470, 150, 30);
        male.setBounds(950, 20, 100, 50);
        female.setBounds(1050, 20, 150, 50);
        Mobiles.setBounds(970, 110, 150, 30);
        Departments.setBounds(970, 180, 150, 30);
        Addresss.setBounds(970, 320, 210, 80);
        emails.setBounds(970, 260, 150, 30);
        Passwords.setBounds(970, 450, 200, 30);
        Register.setBounds(1050, 520, 150, 40);
        back.setBounds(900, 520, 100, 40);

        Names.setToolTipText("Use Unique name which before doesnot exist");
        Ages.setToolTipText("only numerical form");
        emails.setToolTipText("Apropriate email and one email use one account");
        Passwords.setToolTipText("Pasword must be Greater than 8");
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

        JScrollPane sc = new JScrollPane(list);
        sc.setBounds(250, 20, 200, 230);
        gender.add(male);
        gender.add(female);
        panel.add(sc);
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
        panel.add(Addresss);
        panel.add(email);
        panel.add(emails);
        panel.add(Password);
        panel.add(Passwords);
        panel.add(Register);
        panel.add(back);
        add(bar);
        add(panel);

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean reslt1 = false, reslt2 = false, reslt3 = false;

                if (IDs.getText().length() >= 1 && Names.getText().length() > 1 && Fathers.getText().length() > 1 && (Integer.parseInt(Ages.getText()) > 0 && Integer.parseInt(Ages.getText()) < 100)) {
                    reslt1 = true;
                }
                if (Addresss.getText().length() > 1 && Passwords.getText().length() >= 8 && Departments.getText().length() > 1 && (male.isSelected() || female.isSelected())) {
                    reslt2 = true;
                }
                if (emails.getText().contains("@")) {
                    reslt3 = true;
                }
                if (reslt1 && reslt2 && reslt3) {
                    String genders = (male.isSelected()) ? "Male" : "Female";
                    if (JDBC_Data.UpdateAccount(IDs.getText(), Names.getText(), Fathers.getText(), Integer.parseInt(Ages.getText()), genders, Mobiles.getText(), Departments.getText(), emails.getText(), Addresss.getText(), Passwords.getText(), searchuser)) {
                        IDs.setText(null);
                        Names.setText(null);
                        Fathers.setText(null);
                        Ages.setText(null);
                        Addresss.setText(null);
                        Departments.setText(null);
                        Mobiles.setText(null);
                        Passwords.setText(null);
                        emails.setText(null);
                        gender.clearSelection();
                        JOptionPane.showMessageDialog(null, "SuccessFully Updated", "Edit Account", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Network Problem unsuccessfull", "Edit Account", JOptionPane.ERROR_MESSAGE);
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            searchuser = (String) list.getSelectedValue();
            ResultSet rs = JDBC_Data.getMessPayment(searchuser);
            IDs.setText(rs.getString(1));
            Names.setText(rs.getString(2));
            Fathers.setText(rs.getString(3));
            Ages.setText(Integer.toString(rs.getInt(4)));
            if (rs.getString(5).equalsIgnoreCase("Male")) {
                male.setSelected(true);
            } else {
                female.setSelected(true);
            }
            Mobiles.setText(rs.getString(6));
            Departments.setText(rs.getString(7));
            emails.setText(rs.getString(8));
            Addresss.setText(rs.getString(9));
            Passwords.setText(rs.getString(10));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBC_Data.CloseConnection();
        }
    }
}
