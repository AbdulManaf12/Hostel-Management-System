package User;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Abdul Manaf
 */
public class HostelFeesPanel extends JPanel implements Runnable {
    public HostelFeesPanel() {
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

        JLabel Hostel_no = new JLabel("Hostel No : " + JDBC_Data.getRoomNo());
        JLabel from = new JLabel("From : " + JDBC_Data.getDateFrom());
        JLabel to = new JLabel("To : " + JDBC_Data.getDateTo());
        JLabel Paid_Fees = new JLabel("Paid Fees : ");
        JLabel Remaining_Fees = new JLabel("Remaining Fees : ");
        JLabel Total_Fees = new JLabel("Total Fees : ");
        JLabel Paid = new JLabel(JDBC_Data.getPaidFees() + "");
        JLabel Remaining = new JLabel(JDBC_Data.getRemainingFees() + "");
        JLabel Total = new JLabel(JDBC_Data.getTotalFees() + "");

        Hostel_no.setForeground(Color.WHITE);
        from.setForeground(Color.WHITE);
        to.setForeground(Color.WHITE);
        Paid_Fees.setForeground(Color.WHITE);
        Remaining_Fees.setForeground(Color.WHITE);
        Total_Fees.setForeground(Color.WHITE);
        Paid.setForeground(Color.WHITE);
        Remaining.setForeground(Color.WHITE);
        Total.setForeground(Color.WHITE);

        Hostel_no.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        from.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        to.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        Paid_Fees.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        Remaining_Fees.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        Total_Fees.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        Paid.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        Remaining.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        Total.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        Hostel_no.setBounds(520, 100, 200, 50);
        from.setBounds(320, 200, 200, 50);
        to.setBounds(700, 200, 200, 50);
        Paid_Fees.setBounds(300, 300, 150, 50);
        Remaining_Fees.setBounds(650, 300, 200, 50);
        Total_Fees.setBounds(430, 400, 150, 50);
        Paid.setBounds(450, 300, 150, 50);
        Remaining.setBounds(850, 300, 150, 50);
        Total.setBounds(580, 400, 150, 50);

        this.add(Hostel_no);
        this.add(from);
        this.add(to);
        this.add(Paid_Fees);
        this.add(Paid);
        this.add(Remaining_Fees);
        this.add(Remaining);
        this.add(Total_Fees);
        this.add(Total);
    }
}
