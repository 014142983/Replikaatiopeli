/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.painikkeet.LopetaPeli;
import ohha.replikaatiopeli.painikkeet.ProteiininNimeaja;

/**
 * Ikkuna,joka avautuu, kun peli ollaan onnistuneesti läpäisty
 * 
 * @author Leo Kallonen
 * @version 1.3
 * @since 2014-02-28
 */
public class PelinVoitto implements Runnable, Ikkuna {
    /**
     * Sisältää gtaafiset käyttöliittymäkomponentit
     */
    private JFrame frame;
    /**
     * Rajapinta, joka voi saada parametrinä, joko pelin ensimmäisen tai toisen vaiheen.
     * Tarvitaan, jotta parametrinä saatu ikkuna voidaan sulkea
     */
    private PelattavaIkkuna ikkuna;
    /**
     * Konstruktorissa parametrinä saatu pelin ensimmäisen tai toisen vaiheen graafinen
     * käyttöliittymä suljetaan
     * 
     * @param ikkuna 
     */
    public PelinVoitto(PelattavaIkkuna ikkuna) {
        this.ikkuna = ikkuna;
        ikkuna.getFrame().dispose();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Voitit pelin!");
        frame.setPreferredSize(new Dimension(320, 240));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Luodaan graafisen käyttöliittymän komponentit: voittoteksti, pelin päättävä painike
     * ja työkalut valmiin proteiinin nimeämiseen
     * 
     * @param c 
     */
    public void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(3, 1);
        c.setLayout(layout);
        JLabel teksti1 = new JLabel("<html>Onneksi olkoon! Lääkeproteiinisi on valmis ja kaverisi pelastui!<br/><br/>"
                + "Lopuksi nimeä vielä proteiinisi!");
        JButton pelinLopettaja = new JButton("Lopeta peli");
        LopetaPeli lopeta = new LopetaPeli();
        pelinLopettaja.addActionListener(lopeta);
        c.add(teksti1);
        c.add(proteiininNimi());
        c.add(pelinLopettaja);
    }
    /**
     * Luo JPanel-olion, joka sisältää tekstikentän ja painikkeen, joiden avulla voidaan
     * antaa nimi pelissä luodulle proteiinille
     * 
     * @return JPanel-olio, joka voidaan lisätä graafiseen käyttöliittymään 
     */
    public JPanel proteiininNimi() {
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        
        GridLayout layout = new GridLayout(1, 2);
        panel.setLayout(layout);
        
        GridLayout layout2 = new GridLayout(2, 1);
        panel2.setLayout(layout2);
        
        JTextField tahanProteiininNimi = new JTextField();
        JButton nimipainike = new JButton("Anna nimi");
        JLabel proteiininNimi = new JLabel();
        ProteiininNimeaja nimeaja = new ProteiininNimeaja(tahanProteiininNimi, proteiininNimi);
        nimipainike.addActionListener(nimeaja);
        
        panel.add(tahanProteiininNimi);
        panel.add(nimipainike);
        panel2.add(panel);
        panel2.add(proteiininNimi);
        return panel2;
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }
}
