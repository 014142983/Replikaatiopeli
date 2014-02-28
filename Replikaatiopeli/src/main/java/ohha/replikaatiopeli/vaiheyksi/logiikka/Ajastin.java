/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import ohha.replikaatiopeli.grafiikka.PelinHaviaminen;
import ohha.replikaatiopeli.grafiikka.PelinVaiheYksi;

/**
 * Ajastin, joka vähentää aikaa, joka käyttäjällä on oikean syötteen antamiseen.
 * Jos aika loppuu, pelin häviää. Jos antaa oikean syötteen, ajastin palautuu alkutilaan.
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-12
 */
public class Ajastin implements ActionListener {
    /**
     * Lukuarvo, joka kertoo, kuinka paljon aikaa on jäljellä
     */
    private int aika;
    /**
     * Ajastin, jonka vähentää lukuarvoa tietyin väliajoin
     */
    private Timer timer;
    /**
     * Graafinen tekstikomponentti, johon talletetaan tieto jäljellä olevasta ajasta
     */
    private JLabel aikateksti;
    /**
     * Pelin ensimmäisen vaiheen graafinen käyttöliittymä
     */
    private PelinVaiheYksi kali;
    /**
     * Totuusarvo, jota tarvitaan määrittämään, milloin aika on loppu ja pelin häviää
     */
    private boolean lopeta;
    
    public Ajastin(JLabel aikateksti, PelinVaiheYksi kali) {
        this.aika = 3;
        this.aikateksti = aikateksti;
        this.timer = new Timer(1000, this);
        timer.start();
        this.kali = kali;
        this.lopeta = true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (aika > 0) {
            aika--;
            this.aikateksti.setText(Integer.toString(aika));
        }
        if (aika == 0 && lopeta) {
            PelinHaviaminen aikaLoppui = new PelinHaviaminen(kali);
            SwingUtilities.invokeLater(aikaLoppui);
            lopeta = false;
        }
    }
    
    /**
     * Palauttaa ajastimen sekunnit alkuperäiseen arvoonsa
     */
    public void setAjastinAlkuun() {
        this.aika = 4;
    }
    /**
     * Pysäyttää ajastimen
     */
    public void pysaytaAjastin() {
        timer.stop();
    }
}
