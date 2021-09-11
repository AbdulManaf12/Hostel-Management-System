package Admin;

import Database.JDBC_Data;
import Database.Mess;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Abdul Manaf
 */
public class JPanelMessPayment extends JPanel implements ListSelectionListener {
    private static String email;
    private JLabel Unit, TotalPayment, TotalUnit;
    private JList<String> user;
    private JTextField Units, TotalPayments, TotalUnits;
    private JButton Update;

    public JPanelMessPayment() {
        setLayout(null);

        Unit = new JLabel("Price of one unit : " + Mess.getOneUnitPrice());
        Unit.setBounds(420, 50, 350, 50);
        Unit.setFont(new Font(Font.DIALOG, Font.BOLD, 26));

        TotalUnit = new JLabel("Total Unit");
        TotalUnit.setBounds(430, 170, 150, 30);
        TotalUnit.setFont(new Font(Font.DIALOG, Font.BOLD, 24));

        TotalUnits = new JTextField();
        TotalUnits.setBounds(570, 170, 150, 30);
        TotalUnits.setFont(new Font(Font.DIALOG, Font.BOLD, 24));

        String name[] = JDBC_Data.getAllNames();
        user = new JList<>(name);
        user.setVisibleRowCount(5);
        user.addListSelectionListener(this);
        JScrollPane p = new JScrollPane(user);
        p.setBounds(100, 50, 300, 500);

        TotalPayment = new JLabel("Total Payment");
        TotalPayment.setBounds(430, 250, 180, 50);
        TotalPayment.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

        TotalPayments = new JTextField();
        TotalPayments.setBounds(610, 260, 150, 30);
        TotalPayments.setFont(new Font(Font.DIALOG, Font.BOLD, 24));

        Update = new JButton("Update");
        Update.setBounds(500, 350, 150, 40);
        Update.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        Update.setBackground(Color.LIGHT_GRAY);

        add(p);
        add(Unit);
        add(TotalUnit);
        add(TotalUnits);
        add(TotalPayment);
        add(TotalPayments);
        add(Update);
        Update.setEnabled(false);
        Update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (JDBC_Data.setMessPayment(Double.parseDouble(TotalPayments.getText()), Integer.parseInt(TotalUnits.getText()), email)) {
                        TotalPayments.setText(null);
                        TotalUnits.setText(null);
                        Update.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Updated", "New Payment", JOptionPane.INFORMATION_MESSAGE);
                        user.clearSelection();
                    } else {
                        JOptionPane.showMessageDialog(null, "Network Problem", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void valueChanged(ListSelectionEvent e) {
        Update.setEnabled(true);
        String n = user.getSelectedValue();
        try {
            ResultSet rs = JDBC_Data.getMessPayment(n);
            TotalPayments.setText(rs.getDouble(17) + "");
            email = rs.getString(8);
            TotalUnits.setText(rs.getDouble(18) + "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            JDBC_Data.CloseConnection();
        }
    }
}
