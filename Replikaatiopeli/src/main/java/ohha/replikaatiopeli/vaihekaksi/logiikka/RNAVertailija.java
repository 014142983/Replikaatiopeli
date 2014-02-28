/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.logiikka;

import ohha.replikaatiopeli.vaiheyksi.logiikka.Vertailija;

/**
 * Vertailee pelin toisessa vaiheessa kolmen pienen emäksen muodostamaa ribosomin vastinkolmikkoa
 * sekä kolmea ribosomi-merkkijonon kolmea suurikokoista emästä
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-27
 */
public class RNAVertailija implements Vertailija {

    @Override
    public boolean vertaile(String RNA1, String RNA2) {
        if (RNA2.length() == 0) {
            return false;
        }
        if (RNA1.equals("a") && !RNA2.equals("U")) {
            return false;
        }
        if (RNA1.equals("c") && !RNA2.equals("G")) {
            return false;
        }
        if (RNA1.equals("g") && !RNA2.equals("C")) {
            return false;
        }
        if (RNA1.equals("u") && !RNA2.equals("A")) {
            return false;
        }
        return true;
    }
}
