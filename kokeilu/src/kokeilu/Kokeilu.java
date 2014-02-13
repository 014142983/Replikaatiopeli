/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kokeilu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Henri
 */
public class Kokeilu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Kayttoliittyma k = new Kayttoliittyma();
        SwingUtilities.invokeLater(k);
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
}
