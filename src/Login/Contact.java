package Login;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Abdul Manaf
 */
public class Contact extends JFrame {
    public Contact(){
        super("Contact");
        setSize(500,480);
        setLayout(null);
        setFocusable(true);
        setResizable(false);
        getContentPane().setBackground(new Color(35, 110, 232));
        setType(Type.UTILITY);
        setAlwaysOnTop(true);
        setLocation(400,100);
        _init_();
    }
    private void _init_(){
        Image img = new ImageIcon(getClass().getClassLoader().getResource("Abdul_Manaf.jpg")).getImage().getScaledInstance(160,160,10);
        JLabel manaf = new JLabel(new ImageIcon(img));
        manaf.setBounds(170,30,160,160);
        add(manaf);

        JLabel name2 = new JLabel("Abdul Manaf");
        name2.setFont(new Font(Font.SERIF,Font.BOLD,35));
        name2.setBounds(140,170,200,120);
        add(name2);

        JLabel cms2 = new JLabel("023-19-0084");
        cms2.setFont(new Font(Font.SERIF,Font.BOLD,30));
        cms2.setBounds(165,220,200,120);
        add(cms2);

        JLabel email2 = new JLabel("sahitoa97@gmail.com");
        email2.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        email2.setBounds(155,260,200,120);
        email2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(email2);

        JLabel number2 = new JLabel("0300-3141736");
        number2.setFont(new Font(Font.SERIF,Font.PLAIN,22));
        number2.setBounds(180,300,200,120);
        number2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(number2);

        img = new ImageIcon(getClass().getClassLoader().getResource("whatsapp.png")).getImage().getScaledInstance(30,30,10);
        JLabel whatsapp = new JLabel(new ImageIcon(img));
        whatsapp.setBounds(170,390,30,30);
        add(whatsapp);
        img = new ImageIcon(getClass().getClassLoader().getResource("CallIcon.png")).getImage().getScaledInstance(30,30,10);
        JLabel call = new JLabel(new ImageIcon(img));
        call.setBounds(230,390,30,30);
        add(call);
        img = new ImageIcon(getClass().getClassLoader().getResource("GmailIcon.png")).getImage().getScaledInstance(30,30,10);
        JLabel mail = new JLabel(new ImageIcon(img));
        mail.setBounds(290,390,30,30);
        add(mail);
    }
}
