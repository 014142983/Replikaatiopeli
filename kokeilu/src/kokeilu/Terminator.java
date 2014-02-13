/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kokeilu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Henri
 */
public class Terminator implements ActionListener {
    
    private Toteuttaja toteuttaja;
    
    public Terminator(Toteuttaja toteuttaja) {
        this.toteuttaja = toteuttaja;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        toteuttaja.setAika();
    }   
}
