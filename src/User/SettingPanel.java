package User;

import Login.Contact;
import Login.Terms;
import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Abdul Manaf
 */
public class SettingPanel extends JPanel implements Runnable, ListSelectionListener {
    private final String b[] = new String[8];
    private final Terms terms = new Terms();
    private final Contact contact = new Contact();
    private JList<String> list;

    public SettingPanel() {
        Thread t = new Thread(this, "Hostel Fess");
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
        }
    }

    public void run() {
        SetComponent();
    }

    private void SetComponent() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);

        b[0] = "              Setting             ";
        b[1] = "---------------------------------------";
        b[2] = "       Change Pasword   ";
        b[3] = "       Change Email        ";
        b[4] = "       Change Phone no  ";
        b[5] = "       Change Age           ";
        b[6] = "       Terms and Conditions";
        b[7] = "        About                 ";

        list = new JList<>(b);
        list.setBounds(300, 100, 400, 450);
        list.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        list.addListSelectionListener(this);
        list.setBackground(Color.LIGHT_GRAY);
        this.add(list);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String temp = list.getSelectedValue();
        if (b[2].equalsIgnoreCase(temp)) {
            list.clearSelection();
            String pas = JOptionPane.showInputDialog(null, "Old Pasword : ", "Change Password", JOptionPane.QUESTION_MESSAGE);
            if (pas == null ? false : pas.equals(JDBC_Data.getPassword())) {
                String pasn = JOptionPane.showInputDialog(null, "New Pasword : ", "Change Password", JOptionPane.QUESTION_MESSAGE);
                if (pasn.length() > 8) {
                    JDBC_Data.setPassword(pasn);
                    JOptionPane.showMessageDialog(null, "Saved Password", "Succesfully", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (b[3].equalsIgnoreCase(temp)) {
            list.clearSelection();
            String em = JOptionPane.showInputDialog(null, "Old Email : ", "Change Email", JOptionPane.QUESTION_MESSAGE);
            if (JDBC_Data.getEmail().equalsIgnoreCase(em)) {
                String emn = JOptionPane.showInputDialog(null, "New Email : ", "Change Email", JOptionPane.QUESTION_MESSAGE);
                if ("@".contains(emn)) {
                    JDBC_Data.setEmail_in_JDBC(emn);
                    JOptionPane.showMessageDialog(null, "Saved Email", "Succesfully", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Email", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (b[4].equalsIgnoreCase(temp)) {
            list.clearSelection();
            String pas = JOptionPane.showInputDialog(null, "Old Phone no : ", "Change Phone no", JOptionPane.QUESTION_MESSAGE);
            if (JDBC_Data.getMobile().equalsIgnoreCase(pas)) {
                pas = "";
                pas = JOptionPane.showInputDialog(null, "New Phone no : ", "Change Phone no", JOptionPane.QUESTION_MESSAGE);
                if (pas.length() > 0) {
                    JDBC_Data.setMobile(pas);
                    JOptionPane.showMessageDialog(null, "Saved Phone Number ", "Change Phone no", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid ", "Change Phone no", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Phone no", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (b[5].equalsIgnoreCase(temp)) {
            list.clearSelection();
            String pas = JOptionPane.showInputDialog(null, "New Age : ", "Change Age", JOptionPane.QUESTION_MESSAGE);
            try {
                int age = Integer.parseInt(pas);
                if (age < 100 && age > 0) {
                    JDBC_Data.setAge(age);
                    JOptionPane.showMessageDialog(null, "Saved Age", "Change Age", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (b[6].equalsIgnoreCase(temp)) {
            list.clearSelection();
            if (!terms.isVisible()) {
                terms.setVisible(true);
            }
        } else if (b[7].equalsIgnoreCase(temp)) {
            list.clearSelection();
            if (!contact.isVisible()) {
                contact.setVisible(true);
            }
        }
        list.clearSelection();
    }
}