package ohha.replikaatiopeli.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import ohha.replikaatiopeli.grafiikka.OikeaLahettiRNA;
import ohha.replikaatiopeli.grafiikka.PelinHaviaminen;
import ohha.replikaatiopeli.grafiikka.PelinVaiheYksi;
import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;
import ohha.replikaatiopeli.vaiheyksi.domain.LahettiRNA;
import ohha.replikaatiopeli.vaiheyksi.logiikka.Ajastin;
import ohha.replikaatiopeli.vaiheyksi.logiikka.EmasVertailija;
import ohha.replikaatiopeli.vaiheyksi.logiikka.Vertailija;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Tapahtumankuuntelija, joka lisätään pelin ensimmäisen vaiheen painikkeille. Käyttäjän
 * painaman napin sisältämää kirjainta verrataan emäsjärjestyksen viimeisimpään kirjaimeen.
 * Jos syöte on sovelluslogiikan mukainen, emäsjärjestyksestä paljastetaan yksi kirjain lisää
 * ja samalla kasvatetaan käyttäjän syötteistä koostuvaa lähetti-RNA-merkkijonoa. Väärät syötteet
 * johtavat pelinhäviämis-ikkunaan
 * 
 * @author Leo Kallonen
 * @version 1.1
 * @since 2014-02-06
 */
public class Emaspainikkeet implements ActionListener {
    /**
     * Vertailija-rajapinnan toteuttava olio. Vertaa käyttäjän syötettä emäsjärjestyksen merkkijonon viimeisimpään
     * kirjaimeen
     */
    private Vertailija vertailija;
    /**
     * Sisältää tiedon merkkijonosta, johon käyttäjän syötteitä verrataan
     */
    private Emasjarjestys sekvenssi;
    /**
     * Graafinen tekstikomponentti, joka sisältää tiedon emäsjärjestys-merkkijonosta
     */
    private JLabel mallijuoste;
    /**
     * Graafinen tekstikomponentti, joka sisältää tiedon käyttäjän antamista syötteistä
     */
    private JLabel koodaavaJuoste;
    /**
     * Graafinen painikekomponentti, joka toimii käyttäjän syötteenä
     */
    private JButton painike;
    /**
     * Sisältää tiedon merkkijonosta, johon lisätään käyttäjän antamat oikeat syötteet
     */
    private LahettiRNA lahettiRNA;
    /**
     * Olio, joka rajaa käyttäjän syötteen antamiseen olevaa aikaa
     */
    private Ajastin ajastin;
    /**
     * Pelin ensimmäisen vaiheen graafinen käyttöliittymä
     */
    private PelinVaiheYksi kali;
    /**
     * Konstruktorissa talletetaan oliomuuttujiin arvot ensimmäisen vaiheen graafisen käyttöliittymän
     * getterien avulla
     * 
     * @param painike käyttäjän syöte
     * @param kali pelin ensimmäisen vaiheen graafinen käyttöliittymä
     */
    public Emaspainikkeet(JButton painike, PelinVaiheYksi kali) {
        this.vertailija = new EmasVertailija();
        this.sekvenssi = kali.getEmasjarjestys();
        this.mallijuoste = kali.getMallijuoste();
        this.koodaavaJuoste = kali.getKoodaavaJuoste();
        this.painike = painike;
        this.lahettiRNA = kali.getLahettiRNA();
        this.ajastin = kali.getAjastin();
        this.kali = kali;
    }
    /**
     * Käsittelee käyttäjän antamat syötteet. Oikea napinpainallus paljastaa sekvenssi-
     * merkkijonosta uuden merkin, jota vastaavaa painiketta käyttäjän tulee jälleen
     * painaa, jotta merkkijonosta paljastuisi taas seuraava merkki. Samalla käyttäjän
     * napinpainallukset muodostavat oman merkkijononsa.
     * 
     * @param e käyttäjän napinpainalluksesta aiheutunut tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (lahettiRNA.getPituus() < 8) { 
            if (this.vertailija.vertaile(sekvenssi.getEmas(), painike.getText())) {
                lahettiRNA.setLahettiRNA(painike.getText());
                this.koodaavaJuoste.setText(lahettiRNA.getLahettiRNA());
                sekvenssi.kasvataJarjestyslukua();
                this.mallijuoste.setText(sekvenssi.getOsaSekvenssista());
                ajastin.setAjastinAlkuun();
            } else {
                PelinHaviaminen uusiPeli = new PelinHaviaminen(kali, 1, ajastin);
                SwingUtilities.invokeLater(uusiPeli);
            }
        } else if (lahettiRNA.getPituus() == 8) {
            lahettiRNA.setLahettiRNA(painike.getText());
            this.koodaavaJuoste.setText(lahettiRNA.getLahettiRNA());
            OikeaLahettiRNA pelinVoitto = new OikeaLahettiRNA(kali, ajastin);
            SwingUtilities.invokeLater(pelinVoitto);
        }
    }
}