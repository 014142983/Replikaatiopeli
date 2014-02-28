/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.domain;

import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Henri
 */
public class EmasjarjestysTest {

    Emasjarjestys e;

    @Before
    public void setUp() {
        e = new Emasjarjestys();
    }

    @Test
    public void emasjarjestyksenPituusOikea() {
        e.luoEmasjarjestys();
        assertEquals(e.getPituus(), 9);
    }

    @Test
    public void onkoSekvenssissaOikeitaEmaksia() {
        e.luoEmasjarjestys();
        boolean tarkistus = false;
        String s = e.getSekvenssi();
        for (int i = 0; i < e.getPituus(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'T' || s.charAt(i) == 'C' || s.charAt(i) == 'G') {
                tarkistus = true;
            } else {
                tarkistus = false;
            }
        }
        assertEquals(tarkistus, true);
    }

    @Test
    public void kasvaakoJarjestyslukuYhdella() {
        e.kasvataJarjestyslukua();
        assertEquals(1, e.getJarjestysluku());
    }

    @Test
    public void getEmasPalauttaaEnsimmaisenEmaksen() {
        e.luoEmasjarjestys();
        String merkki = "" + e.getSekvenssi().charAt(0);
        assertEquals(merkki, e.getEmas());
    }
    
    @Test
    public void getEmasPalauttaaViimeisenEmaksen() {
        e.luoEmasjarjestys();
        String merkki = "" + e.getSekvenssi().charAt(8);
        for (int i = 0; i < 8; i++) {
            e.kasvataJarjestyslukua();
        }
        assertEquals(merkki, e.getEmas());
    }
    
    @Test
    public void getOsaSekvenssistaPalauttaaSekvenssinEnsimmaisenEmaksen() {
        e.luoEmasjarjestys();
        String sekvenssi = "" + e.getSekvenssi().charAt(0);
        String testattava = e.getOsaSekvenssista();
        assertEquals(sekvenssi, testattava);
    }
    
    @Test
    public void getOsaSekvenssistaPalauttaaKolmeEmasta() {
        e.luoEmasjarjestys();
        String sekvenssi = "";
        for (int i = 0; i < 2; i++) {
            sekvenssi = sekvenssi + e.getSekvenssi().charAt(i);
        }
        for (int i = 0; i < 1; i++) {
            e.kasvataJarjestyslukua();
        }
        String testattava = e.getOsaSekvenssista();
        assertEquals(sekvenssi, testattava);
    }
    
    @Test
    public void getOsaSekvenssistaPalauttaaKokoSekvenssin() {
        e.luoEmasjarjestys();
        for (int i = 0; i < 8; i++) {
            e.kasvataJarjestyslukua();
        }
        assertEquals(e.getSekvenssi(), e.getOsaSekvenssista());
    }
}
