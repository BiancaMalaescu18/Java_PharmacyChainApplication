package LantFarmacii.View;

import LantFarmacii.Model.Persistenta.PersistentaProduse;
import LantFarmacii.Presenter.PrezentareAnjagat;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDate;

public class ViewAngajat implements iViewAngajat {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel form;
    private JPanel form2;
    private JPanel form3;
    private JPanel sear;
    private JPanel sort;
    private JLabel title = new JLabel("-- Tabel de produse --");
    private JLabel sor = new JLabel("Filtrarea in functie de:");
    private JTextField tffilter = new JTextField();
    private JLabel search = new JLabel("Cautare dupa denumire:");
    private JLabel add = new JLabel("Adaugare produs/update:");
    private JButton button = new JButton("Adauga");
    private JLabel name = new JLabel("Nume:");
    private JTextField tfname = new JTextField();
    private JLabel disponibility = new JLabel("Disponibilitate:");
    private JTextField tfdisponibility = new JTextField();
    private JLabel id = new JLabel("Id:");
    private JTextField tfid = new JTextField();
    private JTextField tfsearch = new JTextField();
    private JLabel manufacturer = new JLabel("Producator:");
    private JTextField tfmanufacturer = new JTextField();
    private JLabel price = new JLabel("Pret:");
    private JTextField tfprice = new JTextField();
    private JLabel quantity = new JLabel("Cantitate:");
    private JTextField tfquantity = new JTextField();
    private JLabel valability = new JLabel("Valabilitate:");
    private JTextField tfvalability = new JTextField();
    private JButton show = new JButton("Afisare");
    private JButton bsea = new JButton("Cautare");
    private JButton bdisp = new JButton("Disponibilitate");
    private JButton bval = new JButton("Valabilitate");
    private JButton bprice = new JButton("Pret");
    private JButton bprod = new JButton("Producator");
    private JButton bdel = new JButton("Stergere");
    private JButton bupd = new JButton("Update");
    private JButton brap = new JButton("Generare rapoarte");
    private JTable table;
    PrezentareAnjagat an;

    public ViewAngajat() {

        an = new PrezentareAnjagat(this);

        mainFrame = new JFrame("Lant de farmacii");
        mainFrame.getContentPane().setBackground(new Color(229, 204, 255));
        mainFrame.setBounds(400, 150, 1000, 600);
        mainFrame.setLayout(new FlowLayout());

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        title.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setSize(200, 20);

        sor.setFont(new Font("Serif", Font.PLAIN, 25));
        sor.setSize(200, 20);

        search.setFont(new Font("Serif", Font.PLAIN, 25));
        search.setSize(200, 20);

        tfsearch.setFont(new Font("Serif", Font.PLAIN, 20));
        tfsearch.setPreferredSize(new Dimension(150, 25));

        tffilter.setFont(new Font("Serif", Font.PLAIN, 20));
        tffilter.setPreferredSize(new Dimension(150, 25));

        bdisp.setBackground(new Color(204, 153, 255));
        bdisp.setFont(new Font("Serif", Font.PLAIN, 20));
        bdisp.setSize(200, 50);

        bval.setBackground(new Color(204, 153, 255));
        bval.setFont(new Font("Serif", Font.PLAIN, 20));
        bval.setSize(200, 50);

        bprice.setBackground(new Color(204, 153, 255));
        bprice.setFont(new Font("Serif", Font.PLAIN, 20));
        bprice.setSize(200, 50);

        bprod.setBackground(new Color(204, 153, 255));
        bprod.setFont(new Font("Serif", Font.PLAIN, 20));
        bprod.setSize(200, 50);

        bsea.setBackground(new Color(204, 153, 255));
        bsea.setFont(new Font("Serif", Font.PLAIN, 20));
        bsea.setSize(200, 50);

        bdel.setBackground(new Color(204, 153, 255));
        bdel.setFont(new Font("Serif", Font.PLAIN, 20));
        bdel.setSize(200, 50);

        brap.setBackground(new Color(204, 153, 255));
        brap.setFont(new Font("Serif", Font.PLAIN, 20));
        brap.setSize(200, 50);

        add.setFont(new Font("Serif", Font.PLAIN, 25));
        add.setSize(200, 20);

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(500, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        name.setFont(new Font("Serif", Font.PLAIN, 20));

        tfname.setFont(new Font("Serif", Font.PLAIN, 20));
        tfname.setPreferredSize(new Dimension(150, 25));

        disponibility.setFont(new Font("Serif", Font.PLAIN, 20));

        tfdisponibility.setFont(new Font("Serif", Font.PLAIN, 20));
        tfdisponibility.setPreferredSize(new Dimension(150, 25));

        id.setFont(new Font("Serif", Font.PLAIN, 20));

        tfid.setFont(new Font("Serif", Font.PLAIN, 20));
        tfid.setPreferredSize(new Dimension(150, 25));

        manufacturer.setFont(new Font("Serif", Font.PLAIN, 20));

        tfmanufacturer.setFont(new Font("Serif", Font.PLAIN, 20));
        tfmanufacturer.setPreferredSize(new Dimension(150, 25));

        price.setFont(new Font("Serif", Font.PLAIN, 20));

        tfprice.setFont(new Font("Serif", Font.PLAIN, 20));
        tfprice.setPreferredSize(new Dimension(150, 25));

        quantity.setFont(new Font("Serif", Font.PLAIN, 20));

        tfquantity.setFont(new Font("Serif", Font.PLAIN, 20));
        tfquantity.setPreferredSize(new Dimension(150, 25));

        valability.setFont(new Font("Serif", Font.PLAIN, 20));

        tfvalability.setFont(new Font("Serif", Font.PLAIN, 20));
        tfvalability.setPreferredSize(new Dimension(150, 25));

        button.setBackground(new Color(204, 153, 255));
        button.setFont(new Font("Serif", Font.PLAIN, 20));
        button.setSize(200, 50);

        bupd.setBackground(new Color(204, 153, 255));
        bupd.setFont(new Font("Serif", Font.PLAIN, 20));
        bupd.setSize(200, 50);

        show.setBackground(new Color(204, 153, 255));
        show.setFont(new Font("Serif", Font.PLAIN, 25));
        show.setSize(200, 50);

        sear = new JPanel();
        sear.setLayout(new FlowLayout());

        sort = new JPanel();
        sort.setLayout(new FlowLayout());

        form = new JPanel();
        form.setLayout(new FlowLayout());

        form2 = new JPanel();
        form2.setLayout(new FlowLayout());

        form3 = new JPanel();
        form3.setLayout(new FlowLayout());


        sear.add(search);
        sear.add(tfsearch);
        sear.add(bsea);
        sear.add(bdel);
        sort.add(tffilter);
        sort.add(sor);
        sort.add(bdisp);
        sort.add(bval);
        sort.add(bprice);
        sort.add(bprod);
        form.add(name);
        form.add(tfname);
        form.add(disponibility);
        form.add(tfdisponibility);
        form.add(id);
        form.add(tfid);
        form.add(manufacturer);
        form.add(tfmanufacturer);
        form2.add(price);
        form2.add(tfprice);
        form2.add(quantity);
        form2.add(tfquantity);
        form2.add(valability);
        form2.add(tfvalability);
        form2.add(button);
        form2.add(bupd);
        form3.add(brap);


        mainFrame.add(title);
        mainFrame.add(show);
        mainFrame.add(controlPanel);
        mainFrame.add(sear);
        mainFrame.add(sort);
        mainFrame.add(add);
        mainFrame.add(form);
        mainFrame.add(form2);
        mainFrame.add(form3);
        mainFrame.setVisible(true);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAngajat v = new ViewAngajat();
                v.showTableDemo(PrezentareAnjagat.vizualizare());
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    an.adaugare();
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                }
            }
        });

        bdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    an.stergere();
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                }
            }
        });

        bsea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAngajat v = new ViewAngajat();
                v.showTableDemo(PrezentareAnjagat.cautare(tfsearch.getText()));
            }
        });

        bdisp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAngajat v = new ViewAngajat();
                v.showTableDemo(PrezentareAnjagat.filtrareDisponibilitate(getFilterDisponibility()));
            }
        });

        bval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAngajat v = new ViewAngajat();
                v.showTableDemo(PrezentareAnjagat.filtrareValabilitate(getFilterValability()));
            }
        });

        bprice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAngajat v = new ViewAngajat();
                v.showTableDemo(PrezentareAnjagat.filtrarePret(getFilterPrice()));
            }
        });

        bprod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                mainFrame.dispose();
                ViewAngajat v = new ViewAngajat();
                v.showTableDemo(PrezentareAnjagat.filtrareProducator(getFilterManufacturer()));
            }
        });

        bupd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    an.update();
                } catch (JAXBException ex) {
                    ex.printStackTrace();
                }
            }
        });
        brap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrezentareAnjagat.genRaportCSV();
                    PrezentareAnjagat.genRaportJson();
                } catch (JAXBException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public String[] getProdusSters() {
        String[] valori = new String[7];
        int randSelectat = table.getSelectedRow();

        for(int i = 0; i < table.getColumnCount(); i++) {
            valori[i] = String.valueOf(table.getValueAt(randSelectat, i));
        }

        return valori;
    }


    public void showTableDemo(PersistentaProduse listaProduse) {
        String[] columnNames = {"Nume", "Disponibilitate", "Id", "Producator", "Pret", "Cantitate", "Valabilitate"};


        table = new JTable(an.tableData(listaProduse), columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900, 200));
        table.setFillsViewportHeight(true);
        controlPanel.add(scrollPane);
        mainFrame.setVisible(true);
    }


    public static void main(String[] args) throws JAXBException {

        ViewAngajat v = new ViewAngajat();
    }

    public String getName() {
        if (tfname.getText().length() == 0)
            return null;
        else
            return tfname.getText();
    }

    public Boolean getDisponibility() {
        return Boolean.parseBoolean(tfdisponibility.getText());
    }

    public Integer getId() {
        return Integer.parseInt(tfid.getText());
    }

    public String getManufacturer() {
        if(tfmanufacturer.getText().length() == 0)
            return null;
        else
            return tfmanufacturer.getText();
    }

    public Double getPrice() {
        return Double.parseDouble(tfprice.getText());
    }

    public Integer getQuantity() {
        return Integer.parseInt(tfquantity.getText());
    }

    public LocalDate getValability() {
        return LocalDate.parse(tfvalability.getText());
    }

    public Boolean getFilterDisponibility() {
        return Boolean.parseBoolean(tffilter.getText());
    }

    public LocalDate getFilterValability() {
        return LocalDate.parse(tffilter.getText());
    }

    public Double getFilterPrice() {
        return Double.parseDouble(tffilter.getText());
    }

    public String getFilterManufacturer() {
        return tffilter.getText();
    }

}
