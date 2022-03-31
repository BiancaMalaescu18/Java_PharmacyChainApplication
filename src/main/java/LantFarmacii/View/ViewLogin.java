package LantFarmacii.View;

import LantFarmacii.Presenter.PrezentareLogin;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewLogin implements iViewLogin {

    private JFrame jframe;
    private JLabel title = new JLabel("Login");

    private JLabel user = new JLabel("Username :");
    private JLabel pass = new JLabel("Parola :");
    private JTextField tfUser = new JTextField();
    private JTextField tfPass = new JTextField();

    private JButton login = new JButton("Logare");


    public ViewLogin() {
        jframe = new JFrame();
        jframe.setTitle("Pagina de login");
        jframe.setBounds(400, 150, 1000, 600);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setResizable(false);

        Container c = jframe.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(229, 204, 255));

        title.setFont(new Font("Serif", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(400, 70);
        c.add(title);


        user.setFont(new Font("Serif", Font.PLAIN, 25));
        user.setSize(200, 20);
        user.setLocation(300, 150);
        c.add(user);

        tfUser.setFont(new Font("Serif", Font.PLAIN, 20));
        tfUser.setSize(250, 30);
        tfUser.setLocation(450, 150);
        c.add(tfUser);

        pass.setFont(new Font("Serif", Font.PLAIN, 25));
        pass.setSize(200, 20);
        pass.setLocation(300, 220);
        c.add(pass);

        tfPass.setFont(new Font("Serif", Font.PLAIN, 20));
        tfPass.setSize(250, 30);
        tfPass.setLocation(450, 220);
        c.add(tfPass);

        login.setBackground(new Color(204, 153, 255));
        login.setFont(new Font("Serif", Font.PLAIN, 25));
        login.setSize(200, 50);
        login.setLocation(350, 300);
        c.add(login);

        jframe.setVisible(true);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!PrezentareLogin.autentificare(getUsername(), getPassword())) {
                        JOptionPane.showMessageDialog(jframe, "Username si/sau parola gresite!");
                    }
                } catch (JAXBException jaxbException) {
                    jaxbException.printStackTrace();
                }
            }


        });

    }

    public String getUsername() {
        return tfUser.getText();

    }

    public String getPassword() {
        return tfPass.getText();

    }
}
