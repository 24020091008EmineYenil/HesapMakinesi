package tr.edu.istiklal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HesapMakinesi extends JFrame implements ActionListener {

    JTextField ekran;

    JButton[] sayiTuslari = new JButton[10];

    JButton toplaTusu, cikarTusu, carpTusu, bolTusu;
    JButton esittirTusu, silTusu, temizleTusu, noktaTusu;

    JPanel tusPaneli;

    double sayi1 = 0, sayi2 = 0, sonuc = 0;
    char islem;

    public HesapMakinesi() {
        this.setTitle("Hesap Makinesi");
        this.setSize(420, 550);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.PINK);
        Color benimPembem = new Color(255, 182, 193);


        ekran = new JTextField();
        ekran.setBounds(50, 25, 300, 50);
        ekran.setEditable(false);
        this.add(ekran);

        toplaTusu = new JButton("+");
        cikarTusu = new JButton("-");
        carpTusu = new JButton("*");
        bolTusu = new JButton("/");
        noktaTusu = new JButton(".");
        esittirTusu = new JButton("=");
        silTusu = new JButton("Sil");
        temizleTusu = new JButton("Temizle");

        toplaTusu.addActionListener(this);
        cikarTusu.addActionListener(this);
        carpTusu.addActionListener(this);
        bolTusu.addActionListener(this);
        noktaTusu.addActionListener(this);
        esittirTusu.addActionListener(this);
        silTusu.addActionListener(this);
        temizleTusu.addActionListener(this);

        for(int i = 0; i < 10; i++){
            sayiTuslari[i] = new JButton(String.valueOf(i));
            sayiTuslari[i].addActionListener(this);
            sayiTuslari[i].setBackground(benimPembem);
            sayiTuslari[i].setForeground(Color.BLACK);

            sayiTuslari[i].setBorderPainted(false);
            sayiTuslari[i].setFocusPainted(false);

        }

        silTusu.setBounds(50, 430, 145, 50);
        temizleTusu.setBounds(205, 430, 145, 50);

        this.add(silTusu);
        this.add(temizleTusu);

        tusPaneli = new JPanel();
        tusPaneli.setBounds(50, 100, 300, 300);

        tusPaneli.setLayout(new GridLayout(4, 4, 10, 10));

        tusPaneli.add(sayiTuslari[1]);
        tusPaneli.add(sayiTuslari[2]);
        tusPaneli.add(sayiTuslari[3]);
        tusPaneli.add(toplaTusu);

        tusPaneli.add(sayiTuslari[4]);
        tusPaneli.add(sayiTuslari[5]);
        tusPaneli.add(sayiTuslari[6]);
        tusPaneli.add(cikarTusu);

        tusPaneli.add(sayiTuslari[7]);
        tusPaneli.add(sayiTuslari[8]);
        tusPaneli.add(sayiTuslari[9]);
        tusPaneli.add(carpTusu);

        tusPaneli.add(noktaTusu);
        tusPaneli.add(sayiTuslari[0]);
        tusPaneli.add(esittirTusu);
        tusPaneli.add(bolTusu);

        this.add(tusPaneli);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10; i++){
            if(e.getSource() == sayiTuslari[i]){
                ekran.setText(ekran.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == noktaTusu){
            ekran.setText(ekran.getText().concat("."));
        }
        if(e.getSource() == toplaTusu){
            sayi1 = Double.parseDouble(ekran.getText());
            islem = '+';
            ekran.setText("");
        }
        if(e.getSource() == cikarTusu){
            sayi1 = Double.parseDouble(ekran.getText());
            islem = '-';
            ekran.setText("");
        }
        if(e.getSource() == carpTusu){
            sayi1 = Double.parseDouble(ekran.getText());
            islem = '*';
            ekran.setText("");
        }
        if(e.getSource() == bolTusu){
            sayi1 = Double.parseDouble(ekran.getText());
            islem = '/';
            ekran.setText("");
        }
        if(e.getSource() == esittirTusu){
            sayi2 = Double.parseDouble(ekran.getText());

            switch(islem) {
                case '+': sonuc = sayi1 + sayi2; break;
                case '-': sonuc = sayi1 - sayi2; break;
                case '*': sonuc = sayi1 * sayi2; break;
                case '/': sonuc = sayi1 / sayi2; break;
            }
            ekran.setText(String.valueOf(sonuc));
            sayi1 = sonuc;
        }
        if(e.getSource() == silTusu){
            String yazi = ekran.getText();
            ekran.setText("");

            for(int i = 0; i < yazi.length() - 1; i++) {
                ekran.setText(ekran.getText() + yazi.charAt(i));
            }
        }
        if(e.getSource() == temizleTusu){
            ekran.setText("");
        }

    }

}
