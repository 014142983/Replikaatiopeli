/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Henri
 */
public class EmasjarjestysTest {

    public EmasjarjestysTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void emasjarjestyksenPituusOikea() {
        Emasjarjestys e = new Emasjarjestys();
        e.luoEmasjarjestys();
        assertEquals(e.getPituus(), 9);
    }
    
    @Test
    public void onkoSekvenssissaOikeitaEmaksia() {
        Emasjarjestys e = new Emasjarjestys();
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
}
