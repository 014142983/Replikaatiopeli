/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ohha.replikaatiopeli.grafiikka.AloitusIkkuna;
import ohha.replikaatiopeli.grafiikka.Ikkuna;
import ohha.replikaatiopeli.grafiikka.PelattavaIkkuna;
import ohha.replikaatiopeli.grafiikka.PelinVaiheKaksi;
import ohha.replikaatiopeli.grafiikka.PelinVaiheYksi;

/**
 * Tapahtumankuuntelija painikkeille, jotka avaavat joko pelin ensimmäisen tai toisen
 * vaiheen. Napin painaminen käynnistää jomman kumman näistä vaiheista riippuen mistä
 * painikkeesta on kyse sekä sulkee sen ikkunan, jossa nappi itse sijaitsee
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-12
 */
public class YritaUudelleen implements ActionListener {
    /**
     * Tallennetaan tieto joko pelin ensimmäisestä tai toisesta vaiheesta
     */
    private PelattavaIkkuna kali;
    /**
     * Tallenetaan tieto ikkunasta, jossa painike sijaitsee
     */
    private Ikkuna ikkuna;
    /**
     * Konstruktori tilanteille, joissa peli on hävitty. Konstruktorissa pelin vaiheesta
     * vastaavan graafisen käyttöliittymän ikkuna suljetaan
     * 
     * @param kali pelin ensimmäinen tai toinen vaihe
     * @param ikkuna ikkuna, jossa painike sijaitsee 
     */
    public YritaUudelleen(PelattavaIkkuna kali, Ikkuna ikkuna) {
        this.kali = kali;
        kali.getFrame().dispose(); // sulkee graafisen käyttöliittymän ikkunan
        this.ikkuna = ikkuna;
    }
    /**
     * Konstruktori pelin aloitusikkunalle. Aloitusikkunassa napin painaminen käynnistää
     * pelin
     * 
     * @param ikkuna pelin aloitusikkuna
     */
    public YritaUudelleen(Ikkuna ikkuna) {
        this.ikkuna = ikkuna;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ikkuna instanceof AloitusIkkuna || kali instanceof PelinVaiheYksi) {
            kali = new PelinVaiheYksi(); // luo uuden graafisen käyttöliittymän eli käynnistää pelin uusiksi
        } else {
            kali = new PelinVaiheKaksi();
        }
        kali.run();
        ikkuna.getFrame().dispose();
    }
}
