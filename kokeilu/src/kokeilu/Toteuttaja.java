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
public class Toteuttaja implements ActionListener {
    
    private int luku;
    private JLabel aikateksti; 
    private Timer timer;
    
    public Toteuttaja(JLabel aikateksti) {
        this.luku = 5;
        this.aikateksti = aikateksti;
        timer = new Timer(1000,this);
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (luku > 0) {
            luku--;
            aikateksti.setText(Integer.toString(luku));
        }
    }
    
    public void setAika() {
        this.luku = 6;
    }
}

