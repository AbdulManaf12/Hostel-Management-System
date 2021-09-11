package Admin;

import Database.JDBC_Data;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Abdul Manaf
 */
public class DeleteStudent extends JFrame implements Runnable, ListSelectionListener, ActionListener {
    private JButton delete;
    private JList<String> list;
    private String slectedlist;
    private DefaultListModel listadder;

    public DeleteStudent() {
        super("Hostel Management System - 1.0");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setSize(1400, 1100);
        setLayout(null);
        try {
            Thread t = new Thread(this, "DeleteStudent");
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
        JLabel tilte = new JLabel("Delete Student");
        tilte.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tilte.setBounds(500, 10, 400, 100);
        JButton back = new JButton("Back");
        back.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        back.setBackground(Color.LIGHT_GRAY);
        back.setBounds(1200, 35, 90, 40);
        bar.add(back);
        bar.add(tilte);
        add(bar);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminHome();
                close();
            }
        });
        listadder = new DefaultListModel();
        list = new JList<>(listadder);
        for (String na : JDBC_Data.getAllNames()) {
            listadder.addElement(na);
        }
        JPanel panel = new JPanel();
        panel.setBounds(0, 100, 1400, 1000);
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        list.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 20));
        delete = new JButton("Delete");
        delete.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 20));
        delete.setBounds(800, 300, 100, 50);
        delete.setBackground(Color.LIGHT_GRAY);
        list.addListSelectionListener(this);
        delete.setEnabled(false);
        JScrollPane pane = new JScrollPane(list);
        pane.setBounds(400, 50, 300, 500);
        panel.add(delete);
        list.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
        list.setVisibleRowCount(10);
        panel.add(pane);
        add(panel);

        delete.addActionListener(this);
    }

    private void close() {
        this.dispose();
    }

    public void valueChanged(ListSelectionEvent e) {
        delete.setEnabled(true);
        slectedlist = list.getSelectedValue();
    }

    public void actionPerformed(ActionEvent e) {
        if (JDBC_Data.DeleteAccount(slectedlist)) {
            delete.setEnabled(false);
            list.clearSelection();
            JOptionPane.showConfirmDialog(null, "This Account is Deleted", "Delete Account", JOptionPane.INFORMATION_MESSAGE);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new DeleteStudent();
                }
            });
            this.dispose();
        } else {
            JOptionPane.showConfirmDialog(null, "Error", "Delete Account", JOptionPane.ERROR_MESSAGE);
        }
    }
}
