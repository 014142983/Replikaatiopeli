/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.logiikka;

/**
 * Rajapinta, joka helpottaa vertailijaolioiden käyttämistä
 * 
 * @author Leo Kallonen
 * @version 1.1
 * @since 2014-02-06
 */
public interface Vertailija {
    boolean vertaile(String a, String b);
}
