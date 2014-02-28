/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.painikkeet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import ohha.replikaatiopeli.grafiikka.PelattavaIkkuna;
import ohha.replikaatiopeli.grafiikka.PelinHaviaminen;
import ohha.replikaatiopeli.grafiikka.PelinVaiheKaksi;
import ohha.replikaatiopeli.grafiikka.PelinVoitto;
import ohha.replikaatiopeli.vaihekaksi.domain.Aminohapot;
import ohha.replikaatiopeli.vaihekaksi.domain.Ribosomi;
import ohha.replikaatiopeli.vaihekaksi.domain.VirheellisetPainallukset;
import ohha.replikaatiopeli.vaihekaksi.logiikka.RNAVertailija;
import ohha.replikaatiopeli.vaihekaksi.logiikka.TekstinLiikuttaja;
import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;
import ohha.replikaatiopeli.vaiheyksi.logiikka.Vertailija;

/**
 * Käsittelee mitä tapahtuu, kun käyttäjä painaa välilyöntiä. Vertailee siis ruudussa
 * edestakaisin sahaavaa kolmen emäksen ribosomitekstiä ja oikealta vasemmalle etenevää
 * emäsjärjestystekstiä. Jos ribosomiteksti on samassa kohdassa kuin emäsjärjestystekstin
 * kolme pientä kirjainta, ruudun toiseksi alimpaan graafiseen tekstikomponenttiin
 * lisätään aminohappo. Väärä kohta kasvattaa alimman tekstikomponentin sisältämää arvoa
 * virheellisistä syötteistä. Kolme väärää syötettä ja pelin häviää, viisi oikeaa niin voittaa
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-27
 */
public class RibosomiPainallus implements KeyListener {
    /**
     * Pelin toisen vaiheen graafinen käyttöliittymä
     */
    private PelattavaIkkuna lite;
    /**
     * Tapahtumankuuntelija, jonka tehtävänä liikuttaa ruudun yläreunan emäsjärjestys-merkkijonoa
     */
    private TekstinLiikuttaja liikuttaja;
    /**
     * Graafinen tekstikomponentti, johon lisätään oikeiden syötteiden myötä aminohappo-merkkijonoja
     */
    private JLabel aminohappoTeksti;
    /**
     * Graafinen tekstikomponentti, jossa tieto virheellisten syötteiden lukumäärästä
     */
    private JLabel virheTeksti;
    /**
     * Sisältää tiedon emäsjärjestys-merkkijonosta
     */
    private Emasjarjestys sekvenssi;
    /**
     * Sisältää tiedon ribosomi-merkkijonosta
     */
    private Ribosomi ribosomi;
    /**
     * Olio, jonka avulla verrataan ribosomi-merkkijonon kolmea kirjainta ja emäsjärjestys-merkkijonon
     * kolmea pientä kirjainta
     */
    private Vertailija vertailija;
    /**
     * Ruudussa edestakaisin liikkuva kolmen emäksen merkkijono
     */
    private String ribosominVastinkolmikko;
    /**
     * Olio, joka sisältää tiedon viidestä erilaisesta aminohaposta, joita lisätään aminohappo-merkkijonoon
     * oikeiden syötteiden myötä
     */
    private Aminohapot aminohapot;
    /**
     * Olio, joka pitää kirjaa virheellisten syötteiden lukumäärästä
     */
    private VirheellisetPainallukset virheet;
    /**
     * Konstruktorissa alustetaan oliomuuttujat, joko antamalla niille arvoja pelin toisen vaiheen
     * graafisesta käyttöliittymästä getterien avulla tai luomalla uusia luokkia toteuttavia olioita
     * 
     * @param lite pelin toisen vaiheen graafinen käyttöliittymä
     * @param liikuttaja yläreunan merkkijonon liikkumisesta vastaava tapahtumankuuntelija
     */
    public RibosomiPainallus(PelinVaiheKaksi lite, TekstinLiikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
        this.lite = lite;
        this.aminohappoTeksti = lite.getLiikkuvaTeksti2();
        this.virheTeksti = lite.getVirheteksti();
        this.sekvenssi = lite.getSekvenssi();
        this.ribosomi = lite.getRibosomi();
        this.vertailija = new RNAVertailija();
        this.ribosominVastinkolmikko = lite.getRibosominVastinkolmikko().getVastinkolmikko();
        this.virheet = lite.getVirheellisetPainallukset();
        this.aminohapot = new Aminohapot();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    /**
     * Kasvattaa aminohappo-merkkijonoa, jos välilyöntiä painetaan oikeaan aikaan. Jos painetaan
     * väärään aikaan, virheellisten painallusten lukumäärä kasvaa. Viiden aminohapon ketjulla pelin
     * voitto, kolmella väärällä painalluksella häviö
     * 
     * @param e käyttäjä painaa välilyöntiä 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (vertaileRibosomiaJaSekvenssia()) {
                aminohappoTeksti.setText(aminohapot.kasvataAminohappoketjua(aminohapot.getSatunnainenAminohappo()));
                liikuttaja.nopeutaAjastinta();
                if (aminohapot.getAminohappojenLkm() == 5) {
                    PelinVoitto voitto = new PelinVoitto(lite);
                    SwingUtilities.invokeLater(voitto);
                }
            } else {
                virheet.kasvataVirheidenLkm();
                virheTeksti.setText(virheet.getVirheteksti());
                if (virheet.getVirheidenLkm() == 3) {
                    PelinHaviaminen liikaaVirheita = new PelinHaviaminen(lite);
                    SwingUtilities.invokeLater(liikaaVirheita);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    /**
     * Palauttaa järjestysluvun, jolla ensimmäinen pieni kirjain esiintyy emäsjärjestys-merkkijonossa
     * 
     * @return ensimmäisen pienen kirjaimen järjestysluku
     */
    public int sekvenssinPienenKirjaimenJarjestysluku() {
        return sekvenssi.getSekvenssi().indexOf(ribosominVastinkolmikko);
    }
    /**
     * Vertailee emäsjärjestys-mekkijonon pieniä kirjaimia ja ribosomimerkkijonon kolmea kirjainta.
     * Jos sijainnit samat, palauttaa tosi, muuten false
     * 
     * @return totuusarvon riippuen kahden merkkijonon kirjainten sijainnista
     */
    public boolean vertaileRibosomiaJaSekvenssia() {
        boolean ovatkoRibosomiJaSekvenssiSamat = false;

        int kirjaimenIndeksi = sekvenssinPienenKirjaimenJarjestysluku();

        if (kirjaimenIndeksi > 0) {

            String sekvenssinEkaKirjain = "" + sekvenssi.getSekvenssi().charAt(kirjaimenIndeksi);
            String ribosominEkaKirjain = "" + ribosomi.getTriplettimerkkijono().charAt(kirjaimenIndeksi);
            String ribosominTokaKirjain = "" + ribosomi.getTriplettimerkkijono().charAt(kirjaimenIndeksi + 1);
            String ribosominKolmasKirjain = "" + ribosomi.getTriplettimerkkijono().charAt(kirjaimenIndeksi + 2);
            String ribosomiaEnnenKirjain = "" + ribosomi.getTriplettimerkkijono().charAt(kirjaimenIndeksi - 1);
            String ribosominNeljasKirjain = "" + ribosomi.getTriplettimerkkijono().charAt(kirjaimenIndeksi + 3);

            if (vertailija.vertaile(sekvenssinEkaKirjain, ribosominEkaKirjain) || vertailija.vertaile(sekvenssinEkaKirjain, ribosominTokaKirjain)
                    || vertailija.vertaile(sekvenssinEkaKirjain, ribosomiaEnnenKirjain)
                    || vertailija.vertaile(sekvenssinEkaKirjain, ribosominKolmasKirjain)
                    || vertailija.vertaile(sekvenssinEkaKirjain, ribosominNeljasKirjain)) {
                ovatkoRibosomiJaSekvenssiSamat = true;
            }
        }
        return ovatkoRibosomiJaSekvenssiSamat;
    }
}
