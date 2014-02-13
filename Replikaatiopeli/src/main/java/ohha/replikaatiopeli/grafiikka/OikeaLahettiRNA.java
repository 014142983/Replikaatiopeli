/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import ohha.replikaatiopeli.logiikka.Ajastin;

/**
 *
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-13
 */
public class OikeaLahettiRNA implements Runnable {
    
    private JFrame frame;
    private GraafinenKali kali;
    private Ajastin ajastin;
    
    public OikeaLahettiRNA(GraafinenKali kali, Ajastin ajastin) {
        this.kali = kali;
        kali.getFrame().dispose();
        this.ajastin = ajastin;
        ajastin.pysaytaAjastin();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Oikea lähetti-RNA!");
        frame.setPreferredSize(new Dimension(320, 240));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo komponentit ikkunaan, joka ilmestyy, kun on onnistuneesti suorittanut
     * pelin ensimmäisen vaiheen
     * 
     * @param c container-olio, johon onnittelu-teksti lisätään
     */
    public void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(2, 1);
        c.setLayout(layout);
        JLabel voittoTeksti = new JLabel("Hienoa! Koodasit oikean lähetti-RNA:n!");
        JButton eteenpain = new JButton("Jatka eteenpäin!");
        c.add(voittoTeksti);
        c.add(eteenpain);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
