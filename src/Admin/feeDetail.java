package Admin;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Abdul Manaf
 */
public class feeDetail extends JFrame implements Runnable {
    private JLabel ID, Name, Totalfees, Paidfees, Remaingfees, datefrom, dateto;
    private JTextField IDs, Names, Totalfeess, Paidfeess, Remaingfeess, datefroms, datetos;
    private JButton back, Save, search;
    private JPanel panel;
    private JMenuBar bar;
    private String searchemail = "";

    public feeDetail() {
        super("Hostel Management System - 1.0");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setSize(1400, 1100);
        setLayout(null);
        try {
            Thread t = new Thread(this, "feedetail");
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
        JLabel tilte = new JLabel("Hostel Fees");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(500, 10, 400, 100);
        bar.add(tilte);
        add(bar);

        panel = new JPanel();
        panel.setBounds(0, 100, 1400, 1000);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        ID = new JLabel("ID");
        IDs = new JTextField(10);
        search = new JButton("Find");
        Name = new JLabel("Name ");
        Names = new JTextField(10);
        Totalfees = new JLabel("Total Fees ");
        Totalfeess = new JTextField(10);
        Paidfees = new JLabel("Paid Fees ");
        Paidfeess = new JTextField(10);
        Remaingfees = new JLabel("Remaining Fees ");
        Remaingfeess = new JTextField(10);
        datefrom = new JLabel("Date From : ");
        datefroms = new JTextField(10);
        dateto = new JLabel("Date To : ");
        datetos = new JTextField(10);
        back = new JButton("Back");
        Save = new JButton("Save");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                dispose();
            }
        });
        ID.setBounds(300, 60, 150, 50);
        IDs.setBounds(400, 70, 150, 30);
        search.setBounds(560, 70, 70, 30);
        Name.setBounds(670, 60, 150, 50);
        Names.setBounds(800, 70, 150, 30);
        Totalfees.setBounds(300, 180, 210, 50);
        Totalfeess.setBounds(470, 190, 150, 30);
        Remaingfees.setBounds(670, 180, 210, 50);
        Remaingfeess.setBounds(880, 190, 200, 30);
        Paidfees.setBounds(300, 300, 200, 50);
        Paidfeess.setBounds(480, 310, 210, 30);
        datefrom.setBounds(700, 300, 200, 50);
        datefroms.setBounds(900, 310, 200, 30);
        dateto.setBounds(440, 400, 210, 50);
        datetos.setBounds(630, 410, 210, 30);
        back.setBounds(450, 500, 130, 45);
        Save.setBounds(700, 500, 130, 45);

        ID.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Name.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Totalfees.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Remaingfees.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Paidfees.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        datefrom.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        dateto.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        back.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        Save.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
        search.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        back.setBackground(Color.LIGHT_GRAY);
        Save.setBackground(Color.LIGHT_GRAY);
        search.setBackground(Color.LIGHT_GRAY);
        Names.setEditable(false);
        Save.setEnabled(false);

        panel.add(ID);
        panel.add(IDs);
        panel.add(search);
        panel.add(Name);
        panel.add(Names);
        panel.add(Totalfees);
        panel.add(Totalfeess);
        panel.add(Remaingfees);
        panel.add(Remaingfeess);
        panel.add(Paidfees);
        panel.add(Paidfeess);
        panel.add(datefrom);
        panel.add(datefroms);
        panel.add(dateto);
        panel.add(datetos);
        panel.add(back);
        panel.add(Save);

        add(panel);

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = JDBC_Data.CheckID(IDs.getText());
                    if (rs.next()) {
                        if (rs != null) {
                            Save.setEnabled(true);
                            Names.setText(rs.getString(2));
                            Paidfeess.setText(rs.getDouble(14) + "");
                            Remaingfeess.setText(rs.getDouble(13) + "");
                            Totalfeess.setText(rs.getDouble(12) + "");
                            datefroms.setText(rs.getString(15));
                            datetos.setText(rs.getString(16));
                            searchemail = rs.getString(8);
                        }
                        if (!Save.isEnabled()) {
                            JOptionPane.showMessageDialog(null, "No Record Found...!", "error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No Record Found...!", "error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    JDBC_Data.CloseConnection();
                }
            }
        });

        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Save.setEnabled(false);
                try {
                    if (JDBC_Data.setFees(Double.parseDouble(Totalfeess.getText()), Double.parseDouble(Paidfeess.getText()), Double.parseDouble(Remaingfeess.getText()), datefroms.getText(), datetos.getText(), searchemail)) {
                        IDs.setText(null);
                        Names.setText(null);
                        Remaingfeess.setText(null);
                        Paidfeess.setText(null);
                        Totalfeess.setText(null);
                        datefroms.setText(null);
                        datetos.setText(null);
                        JOptionPane.showMessageDialog(null, "Updated", "Fess Update", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
