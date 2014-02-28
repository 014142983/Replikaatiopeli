/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.painikkeet.RibosomiPainallus;
import ohha.replikaatiopeli.vaihekaksi.domain.Ribosomi;
import ohha.replikaatiopeli.vaihekaksi.domain.RibosominVastinkolmikko;
import ohha.replikaatiopeli.vaihekaksi.domain.VirheellisetPainallukset;
import ohha.replikaatiopeli.vaihekaksi.logiikka.RibosominLiikuttaja;
import ohha.replikaatiopeli.vaihekaksi.logiikka.TekstinLiikuttaja;
import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;

/**
 * Pelin toisen vaiheen graafiset käyttöliittymäkomponentit sisältävä luokka. Oliomuuttujina
 * sovelluslogiikan luokkia ilmentäviä olioita, joiden tietoa asetetaan graafisiin tekstikomponentteihin. Sisältää
 * myös gettereitä, joiden avulla näiden sovelluslogiikan olioiden tietoa pystytään välittämään muille toisen 
 * vaiheen toiminnallisuudesta vastaaville luokille, kuten kuuntelijoille.
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-27
 */
public class PelinVaiheKaksi implements Runnable, PelattavaIkkuna {
    /**
     * Tähän tallennetaan pelin toisen vaiheen graafisen käyttöliittymän komponentit
     */
    private JFrame frame;
    /**
     * Ylin graafinen tekstikomponentti, jossa emäsjärjestys liikkuu oikealta vasemmalle
     */
    private JLabel sekvenssiTeksti;
    /**
     * Graafinen tekstikomponentti, johon lisätään aminohappoja oikeiden syötteiden myötä
     */
    private JLabel aminohappoTeksti;
    /**
     * Toinen graafinen tekstikomponentti, jossa vasemmalle ja oikealle edestakaisin
     * liikkuva punainen kolmen emäksen sarja, ribosomi
     */
    private JLabel ribosomiTeksti;
    /**
     * Alin käyttöliittymäkomponentti, jossa virheellisten syötteiden lukumäärä
     */
    private JLabel virheTeksti;
    /**
     * Merkkijono, joka sijoitetaan ylimpään tekstikomponenttiin. Tapahtumankuuntelija
     * muuttaa emäsjärjestystä siten, että näyttää, että se kulkee oikealta vasemmalle
     */
    private Emasjarjestys sekvenssi;
    /**
     * Merkkijono, joka sisältää tiedon toiseen tekstikomponenttiin lisättävästä punaisesta
     * kolmen kirjaimen sarjasta
     */
    private Ribosomi ribosomi;
    /**
     * Kolmesta pienestä kirjaimesta koostuva merkkijono, joka lisätään tietyin väliajoin
     * emäsjärjestykseen. Kirjaimet yhteensopivat ribosomin kolmea emästä vastaan.
     */
    private RibosominVastinkolmikko vastinkolmikko;
    /**
     * Sisältää tiedon käyttäjän antamien virheellisten syötteiden lukumäärästä. Asetetaan 
     * alimpaan graafiseen tekstikomponenttiin
     */
    private VirheellisetPainallukset virheet;
    /**
     * Luodaan sovelluslogiikan oliot toista vaihetta varten
     */
    public PelinVaiheKaksi() {
        sekvenssi = new Emasjarjestys();
        sekvenssi.luoEmasjarjestys(60);
        ribosomi = new Ribosomi();
        ribosomi.luoMerkkijonoJossaTripletti(60);
        vastinkolmikko = new RibosominVastinkolmikko(this);
        vastinkolmikko.luoVastinkolmikko();
        virheet = new VirheellisetPainallukset();
    }

    @Override
    public void run() {
        frame = new JFrame("Translaatio");
        frame.setPreferredSize(new Dimension(640, 240));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Luo graafisen käyttöliittymän: tekstikomponentit ja kuuntelijat näille komponenteille
     * sekä näppäimistönkuuntelijan.
     * 
     * @param c 
     */
    public void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(5, 1);
        c.setLayout(layout);
        
        sekvenssiTeksti = new JLabel(sekvenssi.getSekvenssi());
        sekvenssiTeksti.setVerticalAlignment(JLabel.BOTTOM);
        sekvenssiTeksti.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel kolmasTeksti = new JLabel("Tulevan proteiinin aminohapot: ");
        aminohappoTeksti = new JLabel();
        
        ribosomiTeksti = new JLabel("<html><font color = 'red'>" + ribosomi.getTriplettimerkkijono() + "</font></html>");     
        ribosomiTeksti.setVerticalAlignment(JLabel.TOP);
        ribosomiTeksti.setHorizontalAlignment(JLabel.CENTER);
        
        virheTeksti = new JLabel(virheet.getVirheteksti());
        
        final TekstinLiikuttaja liikuttaja = new TekstinLiikuttaja(this);
        final RibosominLiikuttaja liikuttaja2 = new RibosominLiikuttaja(this);
        
        frame.addKeyListener(new RibosomiPainallus(this, liikuttaja));
        sekvenssiTeksti.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                liikuttaja.actionPerformed(new ActionEvent(e.getSource(), e.getID(), "focusLost"));
            }
        });
        sekvenssiTeksti.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                liikuttaja2.actionPerformed(new ActionEvent(e.getSource(), e.getID(), "focusLost"));
            }
        });
        c.add(sekvenssiTeksti);
        c.add(ribosomiTeksti);
        c.add(kolmasTeksti);
        c.add(aminohappoTeksti);
        c.add(virheTeksti);
    }

    public JLabel getLiikkuvaSekvenssi() {
        return sekvenssiTeksti;
    }

    public Emasjarjestys getSekvenssi() {
        return sekvenssi;
    }

    public JLabel getLiikkuvaTeksti2() {
        return aminohappoTeksti;
    }
    
    public VirheellisetPainallukset getVirheellisetPainallukset() {
        return virheet;
    }
    
    public JLabel getVirheteksti() {
        return virheTeksti;
    }

    public Ribosomi getRibosomi() {
        return ribosomi;
    }
    
    public RibosominVastinkolmikko getRibosominVastinkolmikko() {
        return  vastinkolmikko;
    }
    
    public JLabel getLiikkuvaRibosomi() {
        return ribosomiTeksti;
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }   
}
