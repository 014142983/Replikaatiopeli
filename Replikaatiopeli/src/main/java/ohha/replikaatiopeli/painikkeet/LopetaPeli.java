/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Painike, jonka avulla peli päättyy
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-28
 */
public class LopetaPeli implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }  
}
