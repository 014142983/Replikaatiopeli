/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;
import ohha.replikaatiopeli.vaihekaksi.domain.RibosominVastinkolmikko;
import ohha.replikaatiopeli.grafiikka.PelinVaiheKaksi;

/**
 * Tapahtumankuuntelija, joka liikuttaa pelin toisessa vaiheessa ruudun yläreunan
 * emäsjärjestys-merkkijonoa oikealta vasemmalle
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-26
 */
public class TekstinLiikuttaja implements ActionListener {
    /**
     * Ajastin, joka säätelee, kuinka usein emäsjärjestys liikkuu
     */
    private Timer timer;
    /**
     * Graafinen tekstikomponentti, johon lisätään tieto liikkuvasta emäsjärjestys-merkkijonosta
     */
    private JLabel sekvenssiTeksti;
    /**
     * Pelin toisen vaiheen graafinen käyttöliittymä
     */
    private PelinVaiheKaksi lite;
    /**
     * Sisältää tiedon ruudun yläreunassa liikkuvasta emäsjärjestys-merkkijonosta
     */
    private Emasjarjestys sekvenssi;
    /**
     * Lukuarvo sille, kuinka usein emäsjärjestys-merkkijono liikkuu
     */
    private int alkuaika;
    /**
     * Lukuarvo, joka kasvaa, kun emäsjärjestys-merkkijonoa käydään läpi. Kun j:n
     * lukuarvo sellainen, että kolme emästä käyty läpi, lisätään emäsjärjestys-merkkijonoon
     * alaviiva
     */
    private int j;
    /**
     * Lukuarvo, jonka perusteella emäsjärjestys-merkkijonoon lisätään pieniä kirjaimia
     */
    private int k;
    /**
     * Sisältää tiedon kolmen pienen emäksen merkkijonosta, joka lisätään tietyin väliajoin
     * emäsjärjestys-merkkijonoon
     */
    private RibosominVastinkolmikko vastinkolmikko;
    /**
     * Alustetaan oliomuuttujat graafisen käyttöliittymän gettereillä ja käynnistetään ajastin
     * 
     * @param lite pelin toisen vaiheen graafinen käyttöliittymä
     */
    public TekstinLiikuttaja(PelinVaiheKaksi lite) {
        this.lite = lite;
        this.sekvenssiTeksti = lite.getLiikkuvaSekvenssi();
        this.sekvenssi = lite.getSekvenssi();
        this.alkuaika = 200;
        this.j = 1;
        this.k = -1;
        this.vastinkolmikko = lite.getRibosominVastinkolmikko();
        this.timer = new Timer(alkuaika, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sekvenssinKorvaaja = "";

        for (int i = 0; i < sekvenssi.getSekvenssi().length() - 1; i++) {
            sekvenssinKorvaaja = sekvenssinKorvaaja + sekvenssi.getSekvenssi().charAt(i + 1);
        }
        if (j % 4 == 0) {
            sekvenssinKorvaaja = sekvenssinKorvaaja + "_";
        } else {
            if (!sekvenssinKorvaaja.contains(vastinkolmikko.getVastinkolmikko())) {
                sekvenssinKorvaaja = sekvenssinKorvaaja + luoPieniEmasPeraan();
            } else {
                sekvenssinKorvaaja = sekvenssinKorvaaja + luoEmasPeraan();
            }
        }
        sekvenssi.setSekvenssi(sekvenssinKorvaaja);
        sekvenssiTeksti.setText(sekvenssinKorvaaja);
        j++;
    }
    /**
     * Saa aikaan emäsjärjestyksen liikkumisen. Kun emäsjärjestys-merkkijono ollaan
     * käyty läpi siten, että ollaan luotu uusi entistä vastaava merkkijono, josta ensimmäinen
     * emäs puuttuu, tämä metodi lisää uuden satunnaisen emäksen uuden merkkijonon perään
     * 
     * @return uusi satunnainen emäs
     */
    public String luoEmasPeraan() {
        Random random = new Random();
        String emakset = "ACGU";
        String uusiEmas = "" + emakset.charAt(random.nextInt(3));
        return uusiEmas;
    }
    /**
     * Luo tietyin väliajoin ribosomi-merkkijonoa vastaavan pienen emäksen emäsjärjestys-merkkijonon
     * perään
     * 
     * @return uusi ribosomi-merkkijonoa vastaava pieni emäs 
     */
    public String luoPieniEmasPeraan() {
        if (k == 2) {
            k = -1;
        }
        k++;
        String uusiJuoste = vastinkolmikko.getVastinkolmikko();
        String uusiEmas = "" + uusiJuoste.charAt(k);
        return uusiEmas;
    }
    
    public void nopeutaAjastinta() {
        alkuaika = alkuaika - 40;
        timer.setDelay(alkuaika);
    }
}
