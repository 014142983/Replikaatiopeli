/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.logiikka;

import ohha.replikaatiopeli.vaiheyksi.logiikka.EmasVertailija;
import java.util.Random;
import ohha.replikaatiopeli.vaiheyksi.domain.Emasjarjestys;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Henri
 */
public class EmasVertailijaTest {

    EmasVertailija v;
    String a;
    String u;
    String t;
    String c;
    String g;
    String o;

    public EmasVertailijaTest() {
        a = "A";
        c = "C";
        g = "G";
        u = "U";
        t = "T";
        o = "O";
    }

    @Before
    public void setUp() {
        v = new EmasVertailija();
    }

    @Test
    public void palauttaaTrueJosVerrataanAtaJaUta() {
        assertEquals(true, v.vertaile(a, u));
    }
    
    @Test
    public void palauttaaTrueJosVerrataanTtaJaAta() {
        assertEquals(true, v.vertaile(t, a));
    }
    
    @Test
    public void palauttaaTrueJosVerrataanCtaJaGta() {
        assertEquals(true, v.vertaile(c, g));
    }
    
    @Test
    public void palauttaaTrueJosVerrataanGtaJaCta() {
        assertEquals(true, v.vertaile(g, c));
    }
    
    @Test
    public void palauttaaFalseJosVerrataanAtaVaaraanKirjaimeen() {
        assertEquals(false, v.vertaile(a, o));
    }
    
    @Test
    public void palauttaaFalseJosVerrataanCtaVaaraanKirjaimeen() {
        String i = "I";
        assertEquals(false, v.vertaile(a, i));
    }
    
    @Test
    public void palauttaaFalseJosVerrataanGtaVaaraanKirjaimeen() {
        assertEquals(false, v.vertaile(a, o));
    }
    
    @Test
    public void palauttaaFalseJosVerrataanTtaVaaraanKirjaimeen() {
        assertEquals(false, v.vertaile(a, o));
    }
    
    @Test
    public void palauttaaFalseJosDNAtaVerrataanOlemattomaanRNAhan() {
        assertEquals(false, v.vertaile(a, ""));
    }
}

