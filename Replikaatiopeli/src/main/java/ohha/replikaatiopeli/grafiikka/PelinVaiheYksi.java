package ohha.replikaatiopeli.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.painikkeet.Emaspainikkeet;
import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;
import ohha.replikaatiopeli.vaiheyksi.domain.LahettiRNA;
import ohha.replikaatiopeli.vaiheyksi.logiikka.Ajastin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Pelin ensimmäisen vaiheen graafiset käyttöliittymäkomponentit sisältävä luokka. Oliomuuttujina
 * sovelluslogiikan luokkia ilmentäviä olioita, joiden tietoa asetetaan graafisiin tekstikomponentteihin. Sisältää
 * myös gettereitä, joiden avulla näiden sovelluslogiikan olioiden tietoa pystytään välittämään muille ensimmäisen
 * vaiheen toiminnallisuudesta vastaaville luokille, kuten painikkeisiin liitetyille
 * tapahtumankuuntelijoille. 
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-05
 */
public class PelinVaiheYksi implements Runnable, PelattavaIkkuna {
    /**
     * Sisältää pelin ensimmäisen vaiheen graafiset käyttöliittymäkomponentit
     */
    private JFrame frame;
    /**
     * Sisältää tiedon merkkijonosta, joka lisätään yläreunassa olevaan graafiseen tekstikomponenttiin.
     * Merkkijonoa paljastetaan vähitellen merkki kerrallaan, kun käyttäjä antaa oikeita
     * syötteitä
     */
    private Emasjarjestys sekvenssi;
    /**
     * Sisältää tiedon merkkijonosta, joka lisätään sekvenssin alapuoliseen graafiseen tekstikomponenttiin.
     * Muodostuu käyttäjän napinpainalluksista
     */
    private LahettiRNA lahettiRNA;
    /**
     * Graafinen tekstikomponentti, johon sekvenssimerkkijono talletetaan
     */
    private JLabel mallijuoste;
    /**
     * Graafinen tekstikomponentti, johon lähetti-RNA-merkkijono talletetaan
     */
    private JLabel koodaavaJuoste;
    /**
     * Graafinen tekstikomponentti, johon talletetaan tieto ajasta, joka käyttäjällä on jäljellä
     * oikean syötteen antamiseen
     */
    private JLabel aika;
    /**
     * Olio, joka rajaa käyttäjän jäljellä olevan ajan syötteiden antamiseen
     */
    private Ajastin ajastin;
    /**
     * Luodaan sovelluslogiikan oliot ja alustetaan joitain graafisia käyttöliittymäkomponentteja
     */
    public PelinVaiheYksi() {
        this.sekvenssi = new Emasjarjestys();
        sekvenssi.luoEmasjarjestys();
        this.mallijuoste = new JLabel(sekvenssi.getOsaSekvenssista());
        this.lahettiRNA = new LahettiRNA();
        this.koodaavaJuoste = new JLabel(lahettiRNA.getLahettiRNA());
        this.aika = new JLabel("3");
        this.ajastin = new Ajastin(aika, this);
    }

    @Override
    public void run() {
        frame = new JFrame("Transkriptio");
        frame.setPreferredSize(new Dimension(380, 240));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo graafisen käyttöliittymän ikkunaan sisällön, jossa on painikkeet,
     * jotka toimivat käyttäjän syötteenä sekä kaksi tekstikenttää. Toisessa on
     * satunnaisesti generoitu sekvenssi-merkkijono ja toisessa käyttäjän
     * napinpainalluksista syntyvä merkkijono.
     *
     * @param c container-olio, johon sisältö lisätään
     */
    private void luoKomponentit(Container c) {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(2, 1);
        GridLayout layout2 = new GridLayout(3, 2);
        c.setLayout(layout);
        panel.setLayout(layout2);
        JLabel aikaaJaljella = new JLabel("Aikaa jäljellä: ");
        JLabel teksti1 = new JLabel("Mallijuoste: ");
        JLabel teksti2 = new JLabel("Lähetti-RNA: ");
        panel.add(aikaaJaljella);
        panel.add(aika);
        panel.add(teksti1);
        panel.add(mallijuoste);
        panel.add(teksti2);
        panel.add(koodaavaJuoste);
        c.add(panel);
        c.add(luoEmakset());
    }

    /**
     * Luo C-, G-, U- ja A-painikkeet, joiden painallukset toimivat syötteenä
     * sovelluslogiikalle.
     *
     * @return C-, G-, U- ja A-painikkeet
     */
    public JPanel luoEmakset() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(1, 4);
        panel.setLayout(layout);
        JButton sytosiini = new JButton("C");
        Emaspainikkeet kuuntelija = new Emaspainikkeet(sytosiini, this);
        sytosiini.addActionListener(kuuntelija);

        JButton guaniini = new JButton("G");
        Emaspainikkeet kuuntelija2 = new Emaspainikkeet(guaniini, this);
        guaniini.addActionListener(kuuntelija2);
        
        JButton urasiili = new JButton("U");
        Emaspainikkeet kuuntelija3 = new Emaspainikkeet(urasiili, this);
        urasiili.addActionListener(kuuntelija3);
        
        JButton adenosiini = new JButton("A");
        Emaspainikkeet kuuntelija4 = new Emaspainikkeet(adenosiini, this);
        adenosiini.addActionListener(kuuntelija4);
        
        panel.add(sytosiini);
        panel.add(guaniini);
        panel.add(urasiili);
        panel.add(adenosiini);
        return panel;
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

    public Emasjarjestys getEmasjarjestys() {
        return sekvenssi;
    }

    public JLabel getMallijuoste() {
        return mallijuoste;
    }

    public LahettiRNA getLahettiRNA() {
        return lahettiRNA;
    }

    public JLabel getKoodaavaJuoste() {
        return koodaavaJuoste;
    }

    public Ajastin getAjastin() {
        return ajastin;
    }
}
