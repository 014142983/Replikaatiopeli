/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henri
 */
public class VertailijaTest {

    EmasVertailija v;
    Emasjarjestys e;
    String s;

    public VertailijaTest() {
    }

    @Before
    public void setUp() {
        v = new EmasVertailija();
        e = new Emasjarjestys();
        e.luoEmasjarjestys();
        s = e.getSekvenssi();
    }

    @Test
    public void palauttaaFalseJosSyoteLiianLyhyt() {
        String lyhytSyote = "AGC";
        assertEquals(v.vertaile(lyhytSyote, s), false);
    }

    @Test
    public void palauttaaFalseJosSyoteLiianPitka() {
        String pitkaSyote = s + "A";
        assertEquals(v.vertaile(pitkaSyote, s), false);
    }

    @Test
    public void palauttaaFalseJosSyoteSisaltaaVaariaKirjaimia() {
        String vaaraSyote = "ASDSDDCVT";
        assertEquals(v.vertaile(vaaraSyote, s), false);
    }

    @Test
    public void palauttaaTrueJosSyoteOikeaMuttaPienillaKirjaimilla() {
        String testiSyote = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                testiSyote += 'u';
            }
            if (s.charAt(i) == 'T') {
                testiSyote += 'a';
            }
            if (s.charAt(i) == 'C') {
                testiSyote += 'g';
            }
            if (s.charAt(i) == 'G') {
                testiSyote += 'c';
            }
        }
        assertEquals(v.vertaile(s, testiSyote), true);
    }

    @Test
    public void palauttaaTrueJosSyoteOikeaMuttaSekaPieniaEttaIsojaKirjaimia() {
        Random r = new Random();
        String testiSyote = "";
        for (int i = 0; i < s.length(); i++) {
            double luku = r.nextDouble();
            if (s.charAt(i) == 'A') {
                if (luku < 0.5) {
                    testiSyote += 'u';
                } else {
                    testiSyote += 'U';
                }
            }
            if (s.charAt(i) == 'T') {
                if (luku < 0.5) {
                    testiSyote += 'a';
                } else {
                    testiSyote += 'A';
                }
            }
            if (s.charAt(i) == 'C') {
                if (luku < 0.5) {
                    testiSyote += 'g';
                } else {
                    testiSyote += 'G';
                }
            }
            if (s.charAt(i) == 'G') {
                if (luku < 0.5) {
                    testiSyote += 'c';
                } else {
                    testiSyote += 'C';
                }
            }
        }
        assertEquals(v.vertaile(s, testiSyote), true);
    }
    
    @Test
    public void palauttaaTrueJosSyoteSisaltaaPelkkiaIsojaKirjaimia() {
        String testiSyote = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                testiSyote += 'U';
            }
            if (s.charAt(i) == 'T') {
                testiSyote += 'A';
            }
            if (s.charAt(i) == 'C') {
                testiSyote += 'G';
            }
            if (s.charAt(i) == 'G') {
                testiSyote += 'C';
            }
        }
    }
    
    @Test
    public void palauttaaFalseJosSyotteenPituusNolla() {
        String testisyote = "";
        assertEquals(v.vertaile(s, testisyote), false);
    }
}

