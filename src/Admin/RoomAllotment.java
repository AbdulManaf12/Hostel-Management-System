package Admin;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Abdul Manaf
 */
public class RoomAllotment extends JFrame implements Runnable, ListSelectionListener {
    private JList<String> list, list2;
    private JLabel Roomno;
    private JTextField Roomnos;
    private JButton back, Save;
    private String name;

    public RoomAllotment() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setLayout(null);
        try {
            Thread t = new Thread(this, "RoomAllotment");
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
        JLabel tilte = new JLabel("Room Allotment");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(500, 10, 400, 100);
        bar.add(tilte);
        add(bar);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 100, 1400, 1000);
        panel.setBackground(Color.DARK_GRAY);

        String names[] = JDBC_Data.getAllNames();
        list = new JList<>(names);
        JScrollPane scroll = new JScrollPane(list);
        list.addListSelectionListener(this);
        scroll.setBounds(50, 70, 200, 400);
        panel.add(scroll);

        Roomno = new JLabel("Room no :");
        Roomno.setBounds(300, 150, 150, 50);
        Roomno.setForeground(Color.WHITE);
        Roomno.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        panel.add(Roomno);

        Roomnos = new JTextField();
        Roomnos.setBounds(450, 160, 150, 40);
        panel.add(Roomnos);

        back = new JButton("Back");
        back.setBounds(400, 230, 100, 40);
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        panel.add(back);

        Save = new JButton("Save");
        Save.setBounds(530, 230, 100, 40);
        Save.setBackground(Color.LIGHT_GRAY);
        Save.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        Save.setEnabled(false);
        panel.add(Save);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                close();
            }
        });
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (JDBC_Data.setRoom(Double.parseDouble(Roomnos.getText()), name)) {
                        Save.setEnabled(false);
                        Roomnos.setText(null);
                        list.clearSelection();
                        JOptionPane.showMessageDialog(null, "Updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not working");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Room", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(panel);
    }

    private void close() {
        this.dispose();
    }

    public void valueChanged(ListSelectionEvent e) {
        name = list.getSelectedValue();
        Roomnos.setText(JDBC_Data.getRoom(name) + "");
        name = JDBC_Data.getEmailFromJDBC(name);
        Save.setEnabled(true);
    }
}
