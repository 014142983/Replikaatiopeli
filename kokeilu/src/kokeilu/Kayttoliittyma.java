/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kokeilu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author Henri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Timer timer;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Kokeilu");
        frame.setPreferredSize(new Dimension(320, 240));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container c) {
        BorderLayout layout = new BorderLayout();
        c.setLayout(layout);
        JButton painike = new JButton("Paina");
        JLabel aikateksti = new JLabel("5");
        
        Toteuttaja toteuttaja = new Toteuttaja(aikateksti);
        Terminator t = new Terminator(toteuttaja);
        painike.addActionListener(t);
        c.add(painike, BorderLayout.NORTH);

        c.add(aikateksti, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void luoAjastin(JLabel teksti) {
        timer = new Timer(1000, new Toteuttaja(teksti));
        timer.start();
    }
}
