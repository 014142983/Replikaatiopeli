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
    private int jarjestysluku;

    public Emasjarjestys() {
        this.sekvenssi = "";
        this.emakset = "ACGT";
        this.jarjestysluku = 0;
    }

    public void luoEmasjarjestys() {
        Random random = new Random();
        String uusiSekvenssi = "";
        for (int i = 1; i <= 9; i++) {
            uusiSekvenssi = uusiSekvenssi + emakset.charAt(random.nextInt(4));
        }
        sekvenssi = uusiSekvenssi;
    }
    
    public String getEmas() {
        String emas = sekvenssi.charAt(jarjestysluku) + "";
        return emas;
    }
    
    public void kasvataJarjestyslukua() {
        jarjestysluku++;
    }

    public String getSekvenssi() {
        String s = "";
        for (int i = 0; i < jarjestysluku + 1; i++) {
            s = s + sekvenssi.charAt(i);
        }
        return s;
    }
    public int getPituus() {
        return sekvenssi.length();
    }
}
