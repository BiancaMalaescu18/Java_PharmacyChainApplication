package LantFarmacii.View;

import LantFarmacii.Model.Persistenta.PersistentaProduse;
import LantFarmacii.Model.Persistenta.PersistentaUtilizatori;
import LantFarmacii.Model.Utilizator;
import LantFarmacii.Presenter.PrezentareAdministrator;
import LantFarmacii.Presenter.PrezentareAnjagat;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class ViewAdministrator implements iViewAdministrator{
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel form;
    private JPanel form2;
    private JPanel pdel;
    private JLabel title = new JLabel("-- Tabel de produse --");
    private JLabel space = new JLabel("                                                                              ");
    private JLabel space2 = new JLabel("                                                                             ");
    private JLabel add = new JLabel("Adaugare/update utilizator:");
    private JLabel role = new JLabel("Rol:");
    private JTextField tfrole = new JTextField();
    private JLabel username = new JLabel("Username:");
    private JTextField tfusername = new JTextField();
    private JLabel password = new JLabel("Parola:");
    private JTextField tfpassword = new JTextField();
    private JLabel name = new JLabel("Nume:");
    private JTextField tfname = new JTextField();
    private JLabel id_ph = new JLabel("Id farmacie:");
    private JTextField tfid_ph = new JTextField();
    private JButton button = new JButton("Adauga");
    private JButton bupd = new JButton("Update");
    private JButton show = new JButton("Afisare");
    private JButton bdel = new JButton("Sterge");
    private JLabel del = new JLabel("Stergere utilizator selectat din tabel:");
    private JTable table;
    PrezentareAdministrator adm;

    public ViewAdministrator() {

        adm = new PrezentareAdministrator(this);

        mainFrame = new JFrame("Lant de farmacii");
        mainFrame.getContentPane().setBackground(new Color(229, 204, 255));
        mainFrame.setBounds(400, 150, 1000, 600);
        mainFrame.setLayout(new FlowLayout());

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        title.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setSize(200, 20);

        del.setFont(new Font("Serif", Font.PLAIN, 25));
        del.setSize(200, 20);

        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(500,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        bdel.setBackground(new Color(204, 153, 255));
        bdel.setFont(new Font("Serif", Font.PLAIN, 20));
        bdel.setSize(200, 50);

        add.setFont(new Font("Serif", Font.PLAIN, 25));
        add.setSize(200, 20);

        role.setFont(new Font("Serif", Font.PLAIN, 20));

        tfrole.setFont(new Font("Serif", Font.PLAIN, 20));
        tfrole.setPreferredSize(new Dimension(150,25));

        username.setFont(new Font("Serif", Font.PLAIN, 20));

        tfusername.setFont(new Font("Serif", Font.PLAIN, 20));
        tfusername.setPreferredSize(new Dimension(150,25));

        password.setFont(new Font("Serif", Font.PLAIN, 20));

        tfpassword.setFont(new Font("Serif", Font.PLAIN, 20));
        tfpassword.setPreferredSize(new Dimension(150,25));

        name.setFont(new Font("Serif", Font.PLAIN, 20));

        tfname.setFont(new Font("Serif", Font.PLAIN, 20));
        tfname.setPreferredSize(new Dimension(150,25));

        id_ph.setFont(new Font("Serif", Font.PLAIN, 20));

        tfid_ph.setFont(new Font("Serif", Font.PLAIN, 20));
        tfid_ph.setPreferredSize(new Dimension(150,25));

        button.setBackground(new Color(204, 153, 255));
        button.setFont(new Font("Serif", Font.PLAIN, 20));
        button.setSize(200, 50);

        bupd.setBackground(new Color(204, 153, 255));
        bupd.setFont(new Font("Serif", Font.PLAIN, 20));
        bupd.setSize(200, 50);

        show.setBackground(new Color(204, 153, 255));
        show.setFont(new Font("Serif", Font.PLAIN, 20));
        show.setSize(200, 50);

        pdel = new JPanel();
        pdel.setLayout(new FlowLayout());

        form = new JPanel();
        form.setLayout(new FlowLayout());

        form2 = new JPanel();
        form2.setLayout(new FlowLayout());

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAdministrator v = new ViewAdministrator();
                v.showTableDemo(PrezentareAdministrator.vizualizare());


            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adm.adaugare();
                } catch (JAXBException | IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        bdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adm.stergere();
                } catch (JAXBException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        bupd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adm.update();
                } catch (JAXBException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        pdel.add(space);
        pdel.add(del);
        pdel.add(bdel);
        pdel.add(space2);
        form.add(role);
        form.add(tfrole);
        form.add(username);
        form.add(tfusername);
        form.add(password);
        form.add(tfpassword);
        form.add(name);
        form.add(tfname);
        form2.add(id_ph);
        form2.add(tfid_ph);
        form2.add(button);
        form2.add(bupd);

        mainFrame.add(title);
        mainFrame.add(show);
        mainFrame.add(controlPanel);
        mainFrame.add(pdel, BorderLayout.CENTER);
        mainFrame.add(add, BorderLayout.CENTER);
        mainFrame.add(form);
        mainFrame.add(form2);
        mainFrame.setVisible(true);
    }


    public static void main(String[] args)
    {
        ViewAdministrator v = new ViewAdministrator();
    }

    public void showTableDemo(PersistentaUtilizatori utilizatori) {
        String[] columnNames = {"Rol", "Username", "Parola", "Nume", "Id_farmacie"};

        table = new JTable(adm.tableData2(utilizatori), columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900, 200));
        table.setFillsViewportHeight(true);
        controlPanel.add(scrollPane);
        mainFrame.setVisible(true);
    }

    @Override
    public String[] getUtilizatorSters() {
        String[] valori = new String[5];
        int randSelectat = table.getSelectedRow();

        for(int i = 0; i < table.getColumnCount(); i++) {
            valori[i] = String.valueOf(table.getValueAt(randSelectat, i));
        }

        return valori;
    }


    public String getUsername() {
        if(tfusername.getText().length() == 0)
            return null;
        else
            return tfusername.getText();
    }

    public String getRole() {
        if(tfrole.getText().length() == 0)
            return null;
        else
            return tfrole.getText();
    }

    public String getPassword() {
        if(tfpassword.getText().length() == 0)
            return null;
        else
            return tfpassword.getText();
    }

    public String getName() {
        if(tfname.getText().length() == 0)
            return null;
        else
            return tfname.getText();
    }

    public Integer getId_ph() {
        return Integer.parseInt(tfid_ph.getText());
    }


}
