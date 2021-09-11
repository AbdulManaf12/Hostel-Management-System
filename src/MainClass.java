import Login.LoginPage;

import java.awt.*;
import javax.swing.*;

/**
 * @author Abdul Manaf
 */
public class MainClass {
    private static JProgressBar b;
    private static JFrame o;

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            MainClass m = new MainClass();
            m.Start();
            m.iterate(b);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
    }

    private void Start() {
        o = new JFrame("Hostel Management System");
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Starting.jpg"));
        JLabel panel = new JLabel(img);
        o.add(panel);
        o.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("RoomAllotement.jpg")).getImage());
        panel.setBounds(0, 0, 400, 300);
        panel.setLayout(null);
        o.setLocation(430, 220);
        o.setLayout(null);
        o.setUndecorated(true);
        o.setVisible(true);
        o.setSize(400, 300);
        JLabel l = new JLabel("Hostel Management System");
        l.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        l.setForeground(Color.BLACK);
        l.setBounds(30, 25, 500, 100);
        panel.add(l);

        JLabel iba = new JLabel("Powered by IBA Sukkur");
        iba.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        iba.setForeground(Color.BLUE);
        iba.setBounds(160, 20, 500, 200);
        panel.add(iba);

        JLabel cs = new JLabel("Computer Science");
        cs.setFont(new Font(Font.DIALOG, Font.ITALIC, 18));
        cs.setForeground(Color.BLUE);
        cs.setBounds(190, 43, 200, 200);
        panel.add(cs);

        b = new JProgressBar(0, 3000);
        b.setBounds(30, 250, 340, 20);
        b.setValue(0);
        b.setBorderPainted(false);
        b.setStringPainted(true);
        panel.add(b);
    }

    private void iterate(JProgressBar b) {
        int i = 0;
        while (i <= 3000) {
            i += (i < 1000) ? 100 : (i < 2000) ? 50 : 90;
            b.setValue(i);
            if (i % 7 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage();
                o.dispose();
            }
        });
    }
}