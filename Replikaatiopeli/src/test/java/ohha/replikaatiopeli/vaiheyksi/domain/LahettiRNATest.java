/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.domain;

import ohha.replikaatiopeli.vaiheyksi.domain.LahettiRNA;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class LahettiRNATest {
    
    LahettiRNA rna;
    
    @Before
    public void setUp() {
        rna = new LahettiRNA();
    }
    
    @Test
    public void setLahettiRNALisaaKirjaimenKunLahettiRNATyhja() {
        rna.setLahettiRNA("A");
        assertEquals("A", rna.getLahettiRNA());
    }
    
    @Test
    public void setLahettiRNALisaaKirjaimenKunLahettiRNAEiTyhja() {
        rna.setLahettiRNA("ACG");
        rna.setLahettiRNA("G");
        assertEquals("ACGG", "ACGG");
    }
}
