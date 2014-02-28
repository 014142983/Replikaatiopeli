/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.grafiikka;

import javax.swing.JFrame;

/**
 * Rajapinta, joka helpottaa pelin ensimmäisen ja toisen vaiheen käsittelyä
 * samalla luokalla.
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-27
 */
public interface PelattavaIkkuna {
    JFrame getFrame();
    public void run();
}
