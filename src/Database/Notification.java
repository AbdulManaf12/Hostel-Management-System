package Database;

import Admin.AdminHome;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Abdul Manaf
 */
public class Notification extends JFrame implements Runnable, ListSelectionListener {
    private JList<String> list;
    private JTextArea adds;
    private JButton back, add, delete;
    private DefaultListModel adder;
    private String DeleteNot;

    public Notification() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setLayout(null);
        try {
            Thread t = new Thread(this, "notification");
            t.start();
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void SetComponents() {
        JMenuBar bar = new JMenuBar();
        bar.setLayout(null);
        bar.setBounds(0, 0, 1400, 100);
        JLabel tilte = new JLabel("Notifications");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(500, 10, 400, 100);
        bar.add(tilte);

        back = new JButton("Back");
        back.setBounds(1200, 70, 100, 25);
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font(Font.DIALOG, Font.BOLD, 17));

        delete = new JButton("Delete");
        delete.setBounds(1200, 40, 100, 25);
        delete.setBackground(Color.LIGHT_GRAY);
        delete.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        delete.setEnabled(false);

        add = new JButton("Add");
        add.setBounds(1200, 10, 100, 25);
        add.setBackground(Color.LIGHT_GRAY);
        add.setFont(new Font(Font.DIALOG, Font.BOLD, 17));

        bar.add(delete);
        bar.add(back);
        bar.add(add);
        add(bar);

        adds = new JTextArea(5, 5);

        JPanel p = new JPanel();
        p.setBounds(0, 100, 1400, 1000);
        p.setLayout(null);
        adder = new DefaultListModel();
        list = new JList<>(adder);
        if (Notification_Data.getIndex() > 0) {
            for (String n : Notification_Data.getNotification()) {
                adder.addElement(n);
            }
        }
        list.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        list.addListSelectionListener(this);
        JScrollPane pane = new JScrollPane(list);
        pane.setBounds(50, 50, 1300, 500);
        p.add(pane);
        add(p);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                close();
            }
        });
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Add Notification");
                f.setLayout(null);
                f.setResizable(false);
                f.setLocationRelativeTo(null);
                f.setSize(400, 300);
                adds.setBounds(0, 0, 400, 240);
                adds.setLineWrap(true);
                f.add(adds);
                JButton b = new JButton("Save");
                b.setBackground(Color.LIGHT_GRAY);
                b.setBounds(150, 240, 100, 30);
                f.add(b);
                f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                f.setVisible(true);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f.dispose();
                        adder.addElement(adds.getText());
                        Notification_Data.setNotification(adds.getText());
                        adds.setText(null);
                    }
                });
            }
        });
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Notification_Data.remove(DeleteNot)) {
                    adder.removeElement(DeleteNot);
                    delete.setEnabled(false);
                }
            }
        });
    }

    private void close() {
        this.dispose();
    }

    public void run() {
        SetComponents();
    }

    public void valueChanged(ListSelectionEvent e) {
        synchronized (list) {
            delete.setEnabled(true);
            DeleteNot = list.getSelectedValue();
        }
    }
}
