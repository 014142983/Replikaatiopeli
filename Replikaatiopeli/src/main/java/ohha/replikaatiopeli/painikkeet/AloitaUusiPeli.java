/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import ohha.replikaatiopeli.domain.Emasjarjestys;
import ohha.replikaatiopeli.grafiikka.GraafinenKali;
import ohha.replikaatiopeli.grafiikka.Ikkuna;
import ohha.replikaatiopeli.logiikka.EmasVertailija;
import ohha.replikaatiopeli.logiikka.Vertailija;

/**
 *
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-12
 */
public class AloitaUusiPeli implements ActionListener {
    
    private GraafinenKali kali;
    private Ikkuna ikkuna;
    
    public AloitaUusiPeli(GraafinenKali kali, Ikkuna ikkuna) {
        kali.getFrame().dispose(); // sulkee graafisen käyttöliittymän ikkunan
        this.ikkuna = ikkuna;
    }
    
    public AloitaUusiPeli(Ikkuna ikkuna) {
        this.ikkuna = ikkuna;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        kali = new GraafinenKali(); // luo uuden graafisen käyttöliittymän eli käynnistää pelin uusiksi
        kali.run();
        ikkuna.getFrame().dispose();
    }   
}
