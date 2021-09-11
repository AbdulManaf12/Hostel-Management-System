package User;

import Database.Notification_Data;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Abdul Manaf
 */
public class NotificationPanel extends JPanel implements Runnable {
    public NotificationPanel() {
        Thread t = new Thread(this, "Notification");
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

        if (Notification_Data.getIndex() >= 1) {
            String list[] = new String[Notification_Data.getIndex()];
            int i = 0;
            for (String n : Notification_Data.getNotification()) {
                list[i++] = n;
            }
            JList<String> notification = new JList<>(list);
            notification.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            JScrollPane pane = new JScrollPane(notification);
            pane.setBounds(50, 50, 1300, 500);
            this.add(pane);
        } else {
            JLabel no = new JLabel("No Record Found");
            no.setForeground(Color.WHITE);
            no.setBounds(500, 200, 300, 50);
            no.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            this.add(no);
        }
    }
}
