/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import ohha.replikaatiopeli.vaihekaksi.domain.Ribosomi;
import ohha.replikaatiopeli.grafiikka.PelinVaiheKaksi;

/**
 * Tapahtumankuuntelija, joka liikuttaa pelin toisessa vaiheessa kolmen punaisen emäksen muodostamaa ribosomi-merkkijonoa
 * ruudussa edestakaisin oikealle ja vasemmalle
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-26
 */
public class RibosominLiikuttaja implements ActionListener {
    /**
     * Pelin toisen vaiheen graafinen käyttöliittymä
     */
    private PelinVaiheKaksi lite;
    /**
     * Graafinen tekstikomponentti, johon lisätään tieto liikkuvasta ribosomi-merkkijonosta
     */
    private JLabel ribosomiTeksti;
    /**
     * Sisältää tiedon merkkijonosta, jota kuuntelija liikuttaa
     */
    private Ribosomi ribosomi;
    /**
     * Ajastin, joka määrää, kuinka usein ribosomi.merkkijono liikkuu
     */
    private Timer timer;
    /**
     * Totuusarvo, joka muuttuu, kun ribosomi-merkkijono saavuttaa jomman kumman pään. Tällöin
     * arvo muuttuu ja ribosomi-merkkijono kulkee toiseen suuntaan
     */
    private boolean suunta;
    /**
     * Kertoo kuinka paljon ribosomi-merkkijono on liikkunut. Tietyn liikemäärän jälkeen suunta-totuusarvo
     * muuttuu ja ribosomi-merkkijono kulkee toiseen suuntaan
     */
    private int i;
    /**
     * Alustetaan oliomuuttuja pelin toisen vaiheen graafisen käyttöliittymän gettereillä ja asetetaan liikkuminen
     * tapahtumaan 0,3 sekunnin välein
     * 
     * @param lite pelin toisen vaiheen graafinen käyttöliittymä 
     */
    public RibosominLiikuttaja(PelinVaiheKaksi lite) {
        this.lite = lite;
        this.ribosomiTeksti = lite.getLiikkuvaRibosomi();
        this.ribosomi = lite.getRibosomi();
        this.suunta = true;
        this.i = 0;
        this.timer = new Timer(300, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String korvaaja = "";
        if (suunta) {
            for (int j = 0; j < ribosomi.getTriplettimerkkijono().length() - 1; j++) {
                korvaaja = korvaaja + ribosomi.getTriplettimerkkijono().charAt(j + 1);
            }
            korvaaja = korvaaja + "_";
            ribosomi.setTriplettimerkkijono(korvaaja);
            ribosomiTeksti.setText("<html><p style = 'color:red;'>" + korvaaja + "</p></html>");
            i++;
            if (i == 60) {
                suunta = false;
                korvaaja = "";
            }
        }
        if (!suunta) {
            for (int k = 0; k < ribosomi.getTriplettimerkkijono().length() - 1; k++) {
                korvaaja = korvaaja + ribosomi.getTriplettimerkkijono().charAt(k);
            }
            korvaaja = "_" + korvaaja;
            ribosomi.setTriplettimerkkijono(korvaaja);
            ribosomiTeksti.setText("<html><p style = 'color:red;'>" + korvaaja + "</p></html>");
            i--;
            if (i == 1) {
                suunta = true;
            }
        }
    }
}
