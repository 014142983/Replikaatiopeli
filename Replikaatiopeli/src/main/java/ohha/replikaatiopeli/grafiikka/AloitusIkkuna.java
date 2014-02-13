/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import ohha.replikaatiopeli.painikkeet.AloitaUusiPeli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-13-02
 */
public class AloitusIkkuna implements Runnable, Ikkuna {
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Aloita peli");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo aloitusikkunaan sisällön. Sisältönä ovat alustus pelistä sekä ohje pelin
     * ensimmäiseen vaiheeseen. Luo myös aloitusnapin, jonka painaminen käynnistää
     * ensimmäisen vaiheen
     * 
     * @param c container olio, johon käyttöliittymäkomponentit lisätään
     */
    public void luoKomponentit(Container c) {
        GridLayout layout = new GridLayout(4, 1);
        c.setLayout(layout);
        JLabel alustus = new JLabel("<html>Hyvä, että osuit paikalle! Kaverisi on vakavasti sairas, eikä<br/>"
                + "hänen hoitamiseen ole lääkettä. Maailman etevimpänä geenitutkijanahan sinä<br/>"
                + "kuitenkin valmistat sellaisen kädenkäänteessä!</html>");
        JLabel ohje = new JLabel("<html>Ensin luodaan lähetti-RNA!<br/>Ohje: Mallijuosteen perässä näkyy kirjain. Se on joko A, C, G tai T.<br/>"
                + "Sinun tulee painaa alhaalla olevia painikkeita siten, että ne vastaavat mallijuosteen<br/>"
                + "viimeistä kirjainta. Jos mallijuosteessa on A, sinun tulee painaa U, jos T paina A, C niin G "
                + "ja G niin C.</html>");
        JButton aloitusnappi = new JButton("Aloita peli!");
        AloitaUusiPeli uusipeli = new AloitaUusiPeli(this);
        aloitusnappi.addActionListener(uusipeli);
        c.add(luoPelinNimi());
        c.add(alustus);
        c.add(ohje);
        c.add(aloitusnappi);
    }
    
    /**
     * Luo aloitusikkunan yläruutuun keskelle pelin nimen
     * 
     * @return käyttöliittymäkomponentti, joka voidaan lisätä container-olioon 
     */
    public JPanel luoPelinNimi() {
        JPanel nimiruutu = new JPanel();
        GridLayout layout = new GridLayout(1, 3);
        nimiruutu.setLayout(layout);
        JLabel tyhjaRuutu1 = new JLabel("");
        JLabel tyhjaRuutu2 = new JLabel("");
        JLabel pelinNimi = new JLabel("Proteiinipeli"); 
        nimiruutu.add(tyhjaRuutu1);
        nimiruutu.add(pelinNimi);
        nimiruutu.add(tyhjaRuutu2);
        return nimiruutu;
    }
    
    @Override
    public JFrame getFrame() {
        return frame;
    }
}
