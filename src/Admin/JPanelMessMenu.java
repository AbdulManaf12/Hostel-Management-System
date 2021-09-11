package Admin;

import Database.Mess;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Abdul Manaf
 */
public class JPanelMessMenu extends JPanel {
    private JTable table;
    private JLabel unit;
    private JTextField Units;
    private JButton save;

    public JPanelMessMenu() {
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        unit = new JLabel("Price of one unit");
        unit.setBounds(230, 100, 230, 30);
        unit.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
        unit.setBackground(Color.CYAN);
        unit.setForeground(Color.white);

        Units = new JTextField(Mess.getOneUnitPrice() + "");
        Units.setBounds(470, 100, 150, 30);
        Units.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        Units.setEnabled(false);

        save = new JButton("edit");
        save.setBounds(630, 100, 100, 30);
        save.setBackground(Color.LIGHT_GRAY);
        save.setFont(new Font(Font.DIALOG, Font.BOLD, 24));

        add(unit);
        add(Units);
        add(save);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (save.getText().equals("edit")) {
                        Units.setEnabled(true);
                        save.setText("Save");
                    } else {
                        if (Mess.setOneUnitPrice(Integer.parseInt(Units.getText()))) {
                            JOptionPane.showMessageDialog(null, "Saved");
                            Units.setEnabled(false);
                            save.setText("edit");
                        } else {
                            JOptionPane.showMessageDialog(null, "Database Problem", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Price of a unit is invalid", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
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
        JTable t = new JTable();
        table = new JTable(data, days);
        table.setBounds(200, 150, 800, 360);
        table.setEnabled(false);
        table.setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(40);
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        add(table);
        JButton edit = new JButton("edit");
        edit.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        edit.setBounds(1010, 450, 100, 30);
        edit.setBackground(Color.GRAY);
        add(edit);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                if (edit.getText().equals("Save")) {
                    String a = ((String) table.getValueAt(1, 1));
                    String b = ((String) table.getValueAt(1, 2));
                    String c = ((String) table.getValueAt(1, 3));
                    String d = ((String) table.getValueAt(2, 1));
                    String e = ((String) table.getValueAt(2, 2));
                    String f = ((String) table.getValueAt(2, 3));
                    String g = ((String) table.getValueAt(3, 1));
                    String h = ((String) table.getValueAt(3, 2));
                    String i = ((String) table.getValueAt(3, 3));
                    String j = ((String) table.getValueAt(4, 1));
                    String k = ((String) table.getValueAt(4, 2));
                    String l = ((String) table.getValueAt(4, 3));
                    String m = ((String) table.getValueAt(5, 1));
                    String n = ((String) table.getValueAt(5, 2));
                    String o = ((String) table.getValueAt(5, 3));
                    String p = ((String) table.getValueAt(6, 1));
                    String q = ((String) table.getValueAt(6, 2));
                    String r = ((String) table.getValueAt(6, 3));
                    String s = ((String) table.getValueAt(7, 1));
                    String t = ((String) table.getValueAt(7, 2));
                    String u = ((String) table.getValueAt(7, 3));
                    try {
                        if (Mess.setMorningUnit(Integer.parseInt(table.getValueAt(8, 1) + "")) && Mess.setLunchUnit(Integer.parseInt(table.getValueAt(8, 2) + "")) && Mess.setDinnerUnit(Integer.parseInt(table.getValueAt(8, 3) + ""))) {
                            if (Mess.setMenu(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u)) {
                                JOptionPane.showMessageDialog(null, "Saved");
                            } else {
                                throw new NumberFormatException();
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException exs) {
                        JOptionPane.showMessageDialog(null, "Invalid Data", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (table.isEnabled()) {
                    table.setEnabled(false);
                    edit.setText("edit");
                } else {
                    table.setEnabled(true);
                    edit.setText("Save");
                }
            }
        });
    }

}
