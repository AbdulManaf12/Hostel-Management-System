import javax.swing.*;
import java.awt.*;

public class About extends JFrame
{
    About(){
        super("About");
        setSize(500,380);
        setLayout(null);
        setFocusable(true);
        getContentPane().setBackground(new Color(35, 110, 232));
        setType(Type.UTILITY);
        setAlwaysOnTop(true);
        setResizable(false);
        setLocation(400,150);
        _init_();
        setVisible(true);
    }
    private void _init_(){
        Image img = new ImageIcon(getClass().getClassLoader().getResource("icons/logo.png")).getImage().getScaledInstance(120,120,10);
        JLabel icon = new JLabel(new ImageIcon(img));
        JLabel NMR = new JLabel("NMR");
        JLabel texteditor = new JLabel("Text Editor");
        JLabel version = new JLabel("Version 1.1.0 ");
        JLabel edition = new JLabel("Edition: Plus");
        JLabel copy = new JLabel("Copyright \u00a9 2020 - IBA Sukkur");
        JLabel rights = new JLabel("All rights reserved");

        NMR.setFont(new Font(Font.DIALOG,Font.BOLD,50));
        texteditor.setFont(new Font(Font.DIALOG,Font.ITALIC,30));
        version.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        edition.setFont(new Font(Font.SERIF,Font.PLAIN,18));
        copy.setFont(new Font(Font.SERIF,Font.PLAIN,18));
        rights.setFont(new Font(Font.SERIF,Font.PLAIN,16));

        icon.setBounds(40,30,120,120);
        NMR.setBounds(200,30,200,100);
        texteditor.setBounds(220,70,300,100);
        version.setBounds(205,125,150,50);
        edition.setBounds(170,210,300,50);
        copy.setBounds(120,240,400,50);
        rights.setBounds(170,275,400,50);

        add(icon);add(NMR);add(texteditor);add(version);
        add(edition);add(copy);add(rights);
    }
}