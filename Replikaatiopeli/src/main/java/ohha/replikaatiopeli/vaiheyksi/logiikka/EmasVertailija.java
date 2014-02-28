/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.logiikka;

/**
 * Tehtävänä verrata pelin ensimmäisessä vaiheessa käyttäjän syötetta emäsjärjestys-
 * merkkijonoon. Palauttaa tosi, jos syöte sovelluslogiikan mukainen, muuten false
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-01-22
 */
public class EmasVertailija implements Vertailija {

    public EmasVertailija() {
    }
    
    /**
     * Vertailee käyttäjän antamaa syötettä ohjelman satunnaisesti generoiman 
     * merkkijonon kirjaimeen. Vain tietynlainen syöte kelpaa tiettyä merkkiä 
     * vastaan
     * 
     * @param DNA
     * @param RNA käyttäjän antama syöte
     * @return true jos käyttäjän syöte on oikeanlainen satunnaisesti generoidun
     * merkkijonon kirjaimeen nähden, muuten false
     */
    @Override
    public boolean vertaile(String DNA, String RNA) {
        if (RNA.length() == 0) {
            return false;
        }
        if (DNA.equals("A") && !RNA.equals("U")) {
            return false;
        }
        if (DNA.equals("C") && !RNA.equals("G")) {
            return false;
        }
        if (DNA.equals("G") && !RNA.equals("C")) {
            return false;
        }
        if (DNA.equals("T") && !RNA.equals("A")) {
            return false;
        }
        return true;
    }
}
