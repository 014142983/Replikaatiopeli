/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import ohha.replikaatiopeli.painikkeet.AloitaUusiPeli;
import ohha.replikaatiopeli.logiikka.Ajastin;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.domain.Emasjarjestys;

/**
 *
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-13
 */
public class PelinHaviaminen implements Runnable, Ikkuna {

    private GraafinenKali kali;
    private JFrame uusiIkkuna;
    private int luku;
    private Ajastin ajastin;

    public PelinHaviaminen(GraafinenKali kali, int luku, Ajastin ajastin) {
        this.kali = kali;
        this.luku = luku;
        this.ajastin = ajastin;
    }
    
    public PelinHaviaminen(GraafinenKali kali) {
        this.kali = kali;
    }

    @Override
    public void run() {
        uusiIkkuna = new JFrame("Hävisit pelin!");
        uusiIkkuna.setPreferredSize(new Dimension(500, 240));
        uusiIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(uusiIkkuna.getContentPane());
        uusiIkkuna.pack();
        uusiIkkuna.setVisible(true);
    }
    
    /**
     * Luo sisällön ikkunaan, joka ilmestyy, kun häviää pelin. Sisältönä on teksti,
     * joka on tietynlainen riippuen siitä häviääkö pelin, kun aika loppuu vai siten,
     * että painaa väärää emäspainiketta. Luo myös painikkeen, jolla pystyy käynnistämään
     * uuden pelin
     * 
     * @param c container-olio, johon käyttöliittymäkomponentin sisältö lisätään
     */
    public void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(2, 1);
        c.setLayout(layout);
        JLabel teksti; 
        if (luku == 1) {
            teksti = new JLabel("Hävisit pelin! Syötit väärän emäksen. Paina nappia yrittääksesi uudelleen!");
            ajastin.pysaytaAjastin();
        } else {
            teksti = new JLabel("Hävisit pelin! Aika loppui. Paina nappia yrittääksesi uudelleen!");
        }  
        JButton nappi = new JButton("Yritä uudelleen!");
        AloitaUusiPeli uusiPeli = new AloitaUusiPeli(kali, this);
        nappi.addActionListener(uusiPeli);
        c.add(teksti);
        c.add(nappi);
    }

    @Override
    public JFrame getFrame() {
        return uusiIkkuna;
    }
}
