//A simple Java Encryption Software
import com.appsdeveloperblog.encryption.PasswordUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel accountLink;
    private JTextField taccountLink;
    private JLabel UserName;
    private JTextField tUserName;
    private JLabel Password;
    private JTextField tPassword;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    // constructor, to initialize the components
    // with default values.
    public MyFrame()
    {
        setTitle("Encryption Software!");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Save your login info Safely");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(500, 30);
        title.setLocation(300, 30);
        c.add(title);

        accountLink = new JLabel("Link:");
        accountLink.setFont(new Font("Arial", Font.PLAIN, 20));
        accountLink.setSize(100, 20);
        accountLink.setLocation(100, 100);
        c.add(accountLink);

        taccountLink = new JTextField();
        taccountLink.setFont(new Font("Arial", Font.PLAIN, 15));
        taccountLink.setSize(190, 20);
        taccountLink.setLocation(200, 100);
        c.add(taccountLink);

        UserName = new JLabel("Username :");
        UserName.setFont(new Font("Arial", Font.PLAIN, 20));
        UserName.setSize(150, 20);
        UserName.setLocation(100, 150);
        c.add(UserName);

        tUserName = new JTextField();
        tUserName.setFont(new Font("Arial", Font.PLAIN, 15));
        tUserName.setSize(190, 20);
        tUserName.setLocation(200, 150);
        c.add(tUserName);

        Password = new JLabel("Password :");
        Password.setFont(new Font("Arial", Font.PLAIN, 20));
        Password.setSize(200, 20);
        Password.setLocation(100, 200);
        c.add(Password);

        tPassword = new JTextField();
        tPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tPassword.setSize(190, 20);
        tPassword.setLocation(200, 200);
        c.add(tPassword);


        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);


        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (!taccountLink.getText().isEmpty() && !tUserName.getText().isEmpty() && !tPassword.getText().isEmpty()) {
                String salt = PasswordUtils.getSalt(30);
                String mySecurePassword = PasswordUtils.generateSecurePassword(tPassword.getText(), salt);
                String mySecureUserName = PasswordUtils.generateSecurePassword(tUserName.getText(), salt);
                String data
                        = "Link : "
                        + taccountLink.getText() + "\n\n"
                        + "UserName : "
                        + mySecureUserName + "\n\n"
                        + "Password : "
                        + mySecurePassword+ "\n\n";
                tout.setText(data);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
            }else
                {
                tout.setText("");
                resadd.setText("");
                res.setText("Please fill up the"
                        + " form");
            }

        }

        else if (e.getSource() == reset) {
            String def = "";
            taccountLink.setText(def);
            tUserName.setText(def);
            tPassword.setText(def);
            resadd.setText(def);
        }
    }
}

