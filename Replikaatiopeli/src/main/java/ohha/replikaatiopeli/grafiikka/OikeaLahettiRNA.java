/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.painikkeet.YritaUudelleen;
import ohha.replikaatiopeli.vaiheyksi.logiikka.Ajastin;

/**
 * Väli-ikkuna, joka avautuu, kun pelin ensimmäinen vaihe on onnistuneesti suoritettu.
 * Sisältää myös ohjeet seuraavaan vaiheeseen sekä painikkeen, jolla seuraava vaihe
 * aukeaa.
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-13
 */
public class OikeaLahettiRNA implements Runnable, Ikkuna {
    
    /**
     * Oliomuuttuja, johon tallennetaan aloitusikkunaan tarvittavat käyttöliittymäkomponentit.
     */
    private JFrame frame;
    /**
     * Oliomuuttuja, joka saa konstruktorin parametrinä pelin ensimmäisen vaiheen. Tarvitaan,
     * jotta ikkuna, joka sisältää ensimmäisen vaiheen saadaan suljettua.
     */
    private PelinVaiheYksi kali;
    /**
     * Oliomuuttuja, joka saa konstruktorin parametrinä pelin ensimmäiseen vaiheen tarvittavan
     * ajastimen. Tarvitaan, jotta ajastin saadaan pysäytettyä, eikä ensimmäinen vaihe jää
     * taustalle pyörimään.
     */
    private Ajastin ajastin;
    /**
     * Konstruktori saa parametrinä pelin ensimmäisen vaiheen sekä sen käyttämän ajastimen.
     * konstruktorissa ensimmäisen vaiheen ikkuna suljetaan ja ajastin pysäytetään.
     * 
     * @param kali
     * @param ajastin 
     */
    public OikeaLahettiRNA(PelinVaiheYksi kali, Ajastin ajastin) {
        this.kali = kali;
        kali.getFrame().dispose();
        this.ajastin = ajastin;
        ajastin.pysaytaAjastin();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Oikea lähetti-RNA!");
        frame.setPreferredSize(new Dimension(700, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo komponentit ikkunaan, joka ilmestyy, kun on onnistuneesti suorittanut
     * pelin ensimmäisen vaiheen
     * 
     * @param c container-olio, johon onnittelu-teksti lisätään
     */
    public void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(3, 1);
        c.setLayout(layout);
        JLabel voittoTeksti = new JLabel("<html>Hienoa! Koodasit oikean lähetti-RNA:n!<br/><br/> Nyt lähetti-RNA pitää vielä "
                + "muuttaa aminohapoiksi, jotka muodostavat proteiinin!</html>");
        JLabel ohje = new JLabel("<html>Ohje:<br/><br/>Ruudun yläreunassa liikkuu vasemmalle lähetti-RNA. Sen alapuolella liikkuu<br/>"
                + "edestakaisin kolmesta emäksestä koostuva ribosomi. Muuten isoista kirjaimista koostuvassa<br/>"
                + "lähetti-RNA:ssa tulee ajoittain vastaan kolmen pienen kirjaimen sarjoja. Kun ribosomi osuu näiden<br/>"
                + "pienten kirjainten kohdalle, paina välilyöntiä lisätäksesi proteiiniisi aminohapon. Kun olet saanut 5<br/>"
                + "aminohappoa lisättyä, voitat! Kolmella väärällä painalluksella sen sijaan häviät.</html>");
        ohje.setVerticalAlignment(JLabel.TOP);
        JButton eteenpain = new JButton("Jatka eteenpäin!");
        YritaUudelleen uusipeli = new YritaUudelleen(this);
        eteenpain.addActionListener(uusipeli);
        c.add(voittoTeksti);
        c.add(ohje);
        c.add(eteenpain);
    }
    
    @Override
    public JFrame getFrame() {
        return frame;
    }
}
