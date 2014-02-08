/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

/**
 *
 * @author Henri
 */
public class EmasVertailija implements Vertailija {

    public EmasVertailija() {
    }
    
    @Override
    public boolean vertaile(String DNA, String RNA) {
        String verrattava = RNA.toUpperCase();
        if (verrattava.length() == 0) {
            return false;
        }
        if (DNA.equals("A") && !verrattava.equals("U")) {
            return false;
        }
        if (DNA.equals("C") && !verrattava.equals("G")) {
            return false;
        }
        if (DNA.equals("G") && !verrattava.equals("C")) {
            return false;
        }
        if (DNA.equals("T") && !verrattava.equals("A")) {
            return false;
        }
        return true;
    }
}
