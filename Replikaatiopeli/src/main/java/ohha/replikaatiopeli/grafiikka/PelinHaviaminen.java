/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import ohha.replikaatiopeli.painikkeet.YritaUudelleen;
import ohha.replikaatiopeli.vaiheyksi.logiikka.Ajastin;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Ikkuna, joka ilmestyy tilanteissa, kun pelin häviää. Sisältö on erilainen riippuen
 * siitä häviääkö pelin ensimmäisessä vaiheessa ajan loputtua, väärän painalluksen
 * myötä vai häviääkö toisessa vaiheessa
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-13
 */
public class PelinHaviaminen implements Runnable, Ikkuna {
    /**
     * PelattavaIkkuna-rajapinnan toteuttava oliomuuttuja. Voi saada konstruktorin 
     * parametrinä sekä ensimmäisen että toisen vaiheen.
     */
    private PelattavaIkkuna kali;
    /**
     * Oliomuuttuja, joka sisältää pelinhäviämis-ikkunan vaatimat käyttöliittymäkomponentit
     */
    private JFrame uusiIkkuna;
    /**
     * Lukuarvo, joka erottaa pelin erilaiset häviämistavat toisistaan. Jos pelin ensimmäisen
     * vaiheen on hävinnyt painamalla väärää emästä, lukuarvo on 1. Jos aika on loppunut, lukuarvoa
     * ei ole.
     */
    private int luku;
    /**
     * Pelin ensimmäisen vaiheen käyttämä ajastin. Tarvitaan konstruktorin parametrinä, jotta
     * jotta se saadaan pysäytettyä, kun pelin häviää, eikä peli jää pyörimään taustalle.
     */
    private Ajastin ajastin;
    /**
     * Konstruktori tilanteelle, jossa peli hävitään ensimmäisessä vaiheessa painamalla
     * väärää nappia.
     * 
     * @param kali pelin ensimmäinen vaihe
     * @param luku häviämistilanteet erottava luku
     * @param ajastin pelin ensimmäisen vaiheen ajastin
     */
    public PelinHaviaminen(PelinVaiheYksi kali, int luku, Ajastin ajastin) {
        this.kali = kali;
        this.luku = luku;
        this.ajastin = ajastin;
    }
    /**
     * Vaihtoehtoinen konstruktori tilanteille, joissa pelin toinen vaihe hävitään tai
     * ensimmäinen vaihe hävitään ajan loputtua. Koska konstruktorin parametrinä on rajapinta,
     * se voi olla pelin ensimmäinen tai toinen vaihe, jotka molemmat toteuttavat sen.
     * 
     * @param kali rajapinta, jonka pelin ensimmäinen ja toinen vaihe toteuttavat
     */
    public PelinHaviaminen(PelattavaIkkuna kali) {
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
     * joka on tietynlainen riippuen siitä häviääkö pelin, kun aika loppuu vai, painaa väärää 
     * emäspainiketta, tai häviää pelin toisen vaiheen. Luo myös painikkeen, jolla pystyy käynnistämään
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
        } else if (kali instanceof PelinVaiheYksi) {
            teksti = new JLabel("Hävisit pelin! Aika loppui. Paina nappia yrittääksesi uudelleen!");
        } else {
            teksti = new JLabel("<html>Hävisit pelin! Painoit välilyöntiä kolme kertaa väärään aikaan!<br/>"
                    + "Paina nappia yrittääksesi uudelleen!</html>");
        }
        JButton nappi = new JButton("Yritä uudelleen!");
        YritaUudelleen uusiPeli = new YritaUudelleen(kali, this);
        nappi.addActionListener(uusiPeli);
        c.add(teksti);
        c.add(nappi);
    }

    @Override
    public JFrame getFrame() {
        return uusiIkkuna;
    }
}
