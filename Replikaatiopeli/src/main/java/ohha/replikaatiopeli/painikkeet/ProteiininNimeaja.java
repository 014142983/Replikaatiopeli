/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Painike, jonka avulla käyttäjän tekstikenttään kirjoittama proteiinin nimi
 * lisätään toiseen tekstikenttään, jota ei voi muokata
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-28
 */
public class ProteiininNimeaja implements ActionListener {
    /**
     * Käyttäjän antama syöte
     */
    private JTextField syote;
    /**
     * Tekstikenttä, johon käyttäjän syöte lisätään
     */
    private JLabel nimi;
    /**
     * Oliomuuttujiin talletetaan pelinpäätösikkunasta konstruktorin parametreinä
     * saadut tekstikentät
     * 
     * @param syote
     * @param nimi 
     */
    public ProteiininNimeaja(JTextField syote, JLabel nimi) {
        this.syote = syote;
        this.nimi = nimi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nimi.setText("Proteiinisi nimi on: " + syote.getText());
    }
    
}
