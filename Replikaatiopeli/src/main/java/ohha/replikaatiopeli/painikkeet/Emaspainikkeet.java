package ohha.replikaatiopeli.painikkeet;

import ohha.replikaatiopeli.logiikka.Ajastin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import ohha.replikaatiopeli.domain.Emasjarjestys;
import ohha.replikaatiopeli.domain.LahettiRNA;
import ohha.replikaatiopeli.grafiikka.GraafinenKali;
import ohha.replikaatiopeli.grafiikka.OikeaLahettiRNA;
import ohha.replikaatiopeli.grafiikka.PelinHaviaminen;
import ohha.replikaatiopeli.logiikka.Vertailija;
import ohha.replikaatiopeli.logiikka.Vertailija;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leo Kallonen
 * @version 1.1
 * @since 2014-02-06
 */
public class Emaspainikkeet implements ActionListener {

    private Vertailija vertailija;
    private Emasjarjestys sekvenssi;
    private JLabel mallijuoste;
    private JLabel koodaavaJuoste;
    private JButton painike;
    private String templaatti;
    private LahettiRNA lahettiRNA;
    private Ajastin ajastin;
    private GraafinenKali kali;

    public Emaspainikkeet(JButton painike, GraafinenKali kali) {
        this.vertailija = kali.getVertailija();
        this.sekvenssi = kali.getEmasjarjestys();
        this.mallijuoste = kali.getMallijuoste();
        this.koodaavaJuoste = kali.getKoodaavaJuoste();
        this.painike = painike;
        this.lahettiRNA = kali.getLahettiRNA();
        this.ajastin = kali.getAjastin();
        this.kali = kali;
    }
    /**
     * Käsittelee käyttäjän antamat syötteet. Oikea napinpainallus paljastaa sekvez<nssi-
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