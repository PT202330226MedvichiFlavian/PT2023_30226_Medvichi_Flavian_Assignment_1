package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfata {

    //text fields
    JTextField pol1 = new JTextField("ax^2+bx+c");
    JTextField pol2 = new JTextField("ax^2+bx+c");
    JTextField rez = new JTextField();

    //labels
    JLabel label_pol1 = new JLabel("          Polinom 1 =");
    JLabel label_pol2 = new JLabel("          Polinom 2 =");
    JLabel label_rez = new JLabel("          Rezultat =");

    //buttons
    JButton buton1 = new JButton("Adunare");
    JButton buton2 = new JButton("Scadere");
    JButton buton3 = new JButton("Inmultire");
    JButton buton4 = new JButton("Impartire");
    JButton buton5 = new JButton("Derivare");
    JButton buton6 = new JButton("Integrare");


    public Interfata() {

        JFrame frame = new JFrame("Calculator Polinoame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        //panels
        JPanel panel1 = new JPanel();//contains text boxes
        JPanel panel2 = new JPanel();//contains labels
        JPanel panel3 = new JPanel();//contains panel 1 and panel 2
        JPanel panel4 = new JPanel();//contains buttons
        JPanel main_panel = new JPanel();

        pol1.setPreferredSize(new Dimension(300, 90));
        pol1.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        pol2.setPreferredSize(new Dimension(300, 90));
        pol2.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        rez.setPreferredSize(new Dimension(300, 90));
        rez.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 30));

        label_pol1.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        label_pol2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        label_rez.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        panel3.add(label_pol1);
        panel3.add(pol1);
        panel3.add(label_pol2);
        panel3.add(pol2);
        panel3.add(label_rez);
        panel3.add(rez);
        panel3.setLayout(new GridLayout(0, 2));

        panel4.add(buton1);
        panel4.add(buton2);
        panel4.add(buton3);
        panel4.add(buton4);
        panel4.add(buton5);
        panel4.add(buton6);
        panel4.setLayout(new GridLayout(2, 3));

        main_panel.add(panel3);
        main_panel.add(panel4);
        main_panel.setLayout(new GridLayout(2, 1));

        frame.setContentPane(main_panel);

        pol1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(pol1.getText().equals("ax^2+bx+c"))
                    pol1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (pol1.getText().isEmpty()) {
                    pol1.setText("ax^2+bx+c");
                }
            }
        });

        pol2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(pol2.getText().equals("ax^2+bx+c"))
                    pol2.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (pol2.getText().isEmpty()) {
                    pol2.setText("ax^2+bx+c");
                }
            }
        });
        frame.setVisible(true);
    }


    public void adunarea (ActionListener actionListener){
        this.buton1.addActionListener(actionListener);
    }
    public void scaderea (ActionListener actionListener){
        this.buton2.addActionListener(actionListener);
    }
    public void inmultirea (ActionListener actionListener){
        this.buton3.addActionListener(actionListener);
    }
    public void impartirea (ActionListener actionListener){
        this.buton4.addActionListener(actionListener);
    }
    public void derivarea (ActionListener actionListener){
        this.buton5.addActionListener(actionListener);
    }
    public void integrarea (ActionListener actionListener){
        this.buton6.addActionListener(actionListener);
    }

    public String getPol1() {
        return this.pol1.getText();
    }

    public String getPol2() {
        return this.pol2.getText();
    }

    public void setRez(String s){
        this.rez.setText(s);
    }
}
