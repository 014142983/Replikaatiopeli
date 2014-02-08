package ohha.replikaatiopeli;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henri
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
        this.mallijuoste = new JLabel(sekvenssi.getSekvenssi());
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
