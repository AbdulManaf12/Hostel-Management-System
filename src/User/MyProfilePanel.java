package User;

import Database.JDBC_Data;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Abdul Manaf
 */
public class MyProfilePanel extends JPanel implements Runnable {
    public MyProfilePanel() {
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

        ImageIcon img;
        if (JDBC_Data.getGender().equalsIgnoreCase("Male")) {
            img = new ImageIcon("src\\material\\Male.png");
        } else {
            img = new ImageIcon("src\\material\\Female.png");
        }
        JLabel picture = new JLabel(img);
        picture.setBounds(1000, 150, 180, 200);
        this.add(picture);

        JLabel name, father, age, email, phone, address, id, gender, deprt;
        name = new JLabel("Name :" + JDBC_Data.getName());
        father = new JLabel("Father : " + JDBC_Data.getFatherName());
        age = new JLabel("Age : " + JDBC_Data.getAge());
        email = new JLabel("Email : " + JDBC_Data.getEmail());
        phone = new JLabel("Phone no : " + JDBC_Data.getMobile());
        address = new JLabel("Address : " + JDBC_Data.getAddress());
        id = new JLabel("ID : " + JDBC_Data.getID());
        gender = new JLabel("Gender : " + JDBC_Data.getGender());
        deprt = new JLabel("Department : " + JDBC_Data.getDepartment());

        name.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        father.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        age.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        email.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        phone.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        address.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        id.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        gender.setFont(new Font(Font.SERIF, Font.BOLD, 23));
        deprt.setFont(new Font(Font.SERIF, Font.BOLD, 23));

        name.setForeground(Color.WHITE);
        father.setForeground(Color.WHITE);
        age.setForeground(Color.WHITE);
        email.setForeground(Color.WHITE);
        phone.setForeground(Color.WHITE);
        address.setForeground(Color.WHITE);
        id.setForeground(Color.WHITE);
        gender.setForeground(Color.WHITE);
        deprt.setForeground(Color.WHITE);

        name.setBounds(300, 20, 300, 50);
        father.setBounds(300, 80, 300, 50);
        age.setBounds(300, 140, 300, 50);
        id.setBounds(300, 200, 300, 50);
        gender.setBounds(300, 260, 300, 50);
        email.setBounds(300, 320, 450, 50);
        phone.setBounds(300, 380, 300, 50);
        address.setBounds(300, 440, 600, 50);

        this.add(id);
        this.add(name);
        this.add(father);
        this.add(age);
        this.add(gender);
        this.add(email);
        this.add(phone);
        this.add(address);
    }
}
