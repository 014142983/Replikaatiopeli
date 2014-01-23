/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Henri
 */
public class Emasjarjestys {

    private String emakset;
    private String sekvenssi;

    public Emasjarjestys() {
        this.sekvenssi = "";
        this.emakset = "ACGT";
    }

    public void luoEmasjarjestys() {
        Random random = new Random();
        String uusiSekvenssi = "";
        for (int i = 1; i <= 9; i++) {
            uusiSekvenssi = uusiSekvenssi + emakset.charAt(random.nextInt(4));
        }
        sekvenssi = uusiSekvenssi;
    }

    public String getSekvenssi() {
        return sekvenssi;
    }
    public int getPituus() {
        return sekvenssi.length();
    }
}
