package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Abdul Manaf
 */
public class MessSystem extends JFrame implements Runnable {
    private JTabbedPane tp;
    private JPanel panel1, panel2;
    private JMenuBar bar;

    public MessSystem() {
        super("Hostel Management System - 1.0");
        setSize(1400, 1100);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        setLayout(null);
        try {
            Thread t = new Thread(this, "MessSystem");
            t.start();
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void SetComponents() {
        bar = new JMenuBar();
        bar.setLayout(null);
        bar.setBounds(0, 0, 1400, 100);
        JLabel tilte = new JLabel("Mess System");
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

        panel1 = new JPanelMessPayment();
        panel2 = new JPanelMessMenu();
        tp = new JTabbedPane();
        tp.setBounds(0, 100, 1400, 900);
        tp.add("Mess Payment", panel1);
        tp.add("Mess Menu", panel2);
        tp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        add(tp);
    }

    public void run() {
        SetComponents();
    }

    private void close() {
        this.dispose();
    }
}
