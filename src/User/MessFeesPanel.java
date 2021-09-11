package User;

import Database.JDBC_Data;
import Database.Mess;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * @author Abdul Manaf
 */
public class MessFeesPanel extends JPanel implements Runnable {
    public MessFeesPanel() {
        Thread t = new Thread(this, "Mess Fess");
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
        JLabel messmenu = new JLabel("Mess Menu");
        messmenu.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        messmenu.setForeground(Color.WHITE);
        messmenu.setBounds(300, 50, 200, 50);
        this.add(messmenu);
        String days[] = {"Days", "BreakFast", "Lunch", "Dinner"};
        String data[][] =
                {
                        {"Days", "BreakFast", "Lunch", "Dinner"},
                        {"Monday", Mess.getMon_1(), Mess.getMon_2(), Mess.getMon_3()},
                        {"Tuesday", Mess.getTues_1(), Mess.getTues_2(), Mess.getTues_3()},
                        {"Wednesday", Mess.getWed_1(), Mess.getWed_2(), Mess.getWed_3()},
                        {"Thrusday", Mess.getThrus_1(), Mess.getThrus_2(), Mess.getThrus_3()},
                        {"Friday", Mess.getFrid_1(), Mess.getFrid_2(), Mess.getFrid_3()},
                        {"Saturday", Mess.getSatur_1(), Mess.getSatur_2(), Mess.getSatur_3()},
                        {"Sunday", Mess.getSund_1(), Mess.getSund_2(), Mess.getSund_3()},
                        {"Units ", Mess.getMorningUnit() + "", Mess.getLunchUnit() + "", Mess.getDinnerUnit() + ""}
                };
        JTable table;
        table = new JTable(data, days);
        table.setBounds(20, 120, 800, 360);
        table.setEnabled(false);
        table.setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(40);
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        this.add(table);

        JLabel unit = new JLabel("Price of Unit : " + Mess.getOneUnitPrice());
        JLabel units = new JLabel("Total Units : " + (int) JDBC_Data.getMessTotalUnit());
        JLabel price = new JLabel("Total Price :" + JDBC_Data.getMessTotalFees());

        unit.setForeground(Color.WHITE);
        units.setForeground(Color.WHITE);
        price.setForeground(Color.WHITE);

        unit.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        units.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        price.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        unit.setBounds(950, 150, 200, 50);
        units.setBounds(950, 250, 200, 50);
        price.setBounds(950, 350, 400, 50);

        this.add(unit);
        this.add(units);
        this.add(price);
    }
}
