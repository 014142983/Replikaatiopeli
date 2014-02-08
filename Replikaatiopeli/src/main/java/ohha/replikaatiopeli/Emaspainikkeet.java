package ohha.replikaatiopeli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import ohha.replikaatiopeli.Vertailija;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henri
 */
public class Emaspainikkeet implements ActionListener {

    private Vertailija vertailija;
    private Emasjarjestys sekvenssi;
    private JLabel mallijuoste;
    private JLabel lahettiRNA;
    private JButton painike;
    private String templaatti;
    private LahettiRNA rna;

    public Emaspainikkeet(Vertailija vertailija, Emasjarjestys sekvenssi, JLabel mallijuoste, JLabel lahettiRNA, JButton painike, LahettiRNA rna) {
        this.vertailija = vertailija;
        this.sekvenssi = sekvenssi;
        this.mallijuoste = mallijuoste;
        this.lahettiRNA = lahettiRNA;
        this.painike = painike;
        this.rna = rna;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("toimii");
        if (rna.getPituus() < 8) {
            if (this.vertailija.vertaile(sekvenssi.getEmas(), painike.getText())) {
                System.out.println("true");
                rna.setLahettiRNA(painike.getText());
                System.out.println(rna.getLahettiRNA());
                this.lahettiRNA.setText(rna.getLahettiRNA());
                sekvenssi.kasvataJarjestyslukua();
                this.mallijuoste.setText(sekvenssi.getSekvenssi());
            } else {
                System.out.println("Väärä lähetti-RNA!");
            }
        } else if (rna.getPituus() == 8) {
            rna.setLahettiRNA(painike.getText());
            this.lahettiRNA.setText(rna.getLahettiRNA());
        }
    }
}