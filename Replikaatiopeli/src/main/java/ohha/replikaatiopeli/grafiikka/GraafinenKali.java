package ohha.replikaatiopeli.grafiikka;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.domain.Emasjarjestys;
import ohha.replikaatiopeli.domain.LahettiRNA;
import ohha.replikaatiopeli.logiikka.Vertailija;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-05
 */
public class GraafinenKali implements Runnable {
    
    private JFrame frame;
    private Vertailija vertailija;
    private Emasjarjestys sekvenssi;
    private LahettiRNA rna;
    private JLabel mallijuoste;
    private JLabel lahettiRNA;
    
    public GraafinenKali(Vertailija vertailija, Emasjarjestys sekvenssi) {
        this.vertailija = vertailija;
        this.sekvenssi = sekvenssi;
        sekvenssi.luoEmasjarjestys();
        this.mallijuoste = new JLabel(sekvenssi.getOsaSekvenssista());
        this.rna = new LahettiRNA();
        this.lahettiRNA = new JLabel(rna.getLahettiRNA());
    }
 
    @Override
    public void run() {
        frame = new JFrame("Replikaatiopeli");
        frame.setPreferredSize(new Dimension(320, 240));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Luo graafisen käyttöliittymän ikkunaan sisällön, jossa on painikkeet, jotka
     * toimivat käyttäjän syötteenä sekä kaksi tekstikenttää. Toisessa on satunnaisesti generoitu
     * sekvenssi-merkkijono ja toisessa käyttäjän napinpainalluksista syntyvä merkkijono. 
     * 
     * @param c container-olio, johon sisältö lisätään
     */
    private void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(3, 2);
        c.setLayout(layout);
        JLabel teksti1 = new JLabel("Mallijuoste: ");
        JLabel teksti2 = new JLabel("Lähetti-RNA: ");
        c.add(teksti1);
        c.add(mallijuoste);
        c.add(teksti2);
        c.add(lahettiRNA);
        c.add(luoCJaG());
        c.add(luoUJaA());
    }
    /**
     * Luo C- ja G-painikkeet, joiden painallukset toimivat syötteenä sovelluslogiikalle.
     * 
     * @return C- ja G-painikkeet
     */
    public JPanel luoCJaG() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(1, 2);
        panel.setLayout(layout);
        JButton sytosiini = new JButton("C");
        Emaspainikkeet kuuntelija = new Emaspainikkeet(vertailija, sekvenssi, mallijuoste, lahettiRNA, sytosiini, rna);
        sytosiini.addActionListener(kuuntelija);
        JButton guaniini = new JButton("G");
        Emaspainikkeet kuuntelija2 = new Emaspainikkeet(vertailija, sekvenssi, mallijuoste, lahettiRNA, guaniini, rna);
        guaniini.addActionListener(kuuntelija2);
        panel.add(sytosiini);
        panel.add(guaniini);
        return panel;
    }
    /**
     * Luo U- ja A-painikkeet, joiden painallukset toimivat syötteenä sovelluslogiikalle.
     * 
     * @return U- ja A-painikkeet 
     */
    public JPanel luoUJaA() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(1,2);
        panel.setLayout(layout);
        JButton urasiili = new JButton("U");
        Emaspainikkeet kuuntelija = new Emaspainikkeet(vertailija, sekvenssi, mallijuoste, lahettiRNA, urasiili, rna);
        urasiili.addActionListener(kuuntelija);
        JButton adenosiini = new JButton("A");
        Emaspainikkeet kuuntelija2 = new Emaspainikkeet(vertailija, sekvenssi, mallijuoste, lahettiRNA, adenosiini, rna);
        adenosiini.addActionListener(kuuntelija2);
        panel.add(urasiili);
        panel.add(adenosiini);
        return panel;
    }
}
