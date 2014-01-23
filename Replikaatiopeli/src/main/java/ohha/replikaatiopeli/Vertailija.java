/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

/**
 *
 * @author Henri
 */
public class Vertailija {

    public Vertailija() {
    }

    public boolean vertaile(String sekvenssi, String v) {
        String verrattava = v.toUpperCase();
        if (verrattava.length() == 0) {
            return false;
        }
        for (int i = 0; i < sekvenssi.length(); i++) {
            if (sekvenssi.charAt(i) == 'A' && verrattava.charAt(i) != 'U') {
                return false;
            }
            if (sekvenssi.charAt(i) == 'T' && verrattava.charAt(i) != 'A') {
                return false;
            }
            if (sekvenssi.charAt(i) == 'C' && verrattava.charAt(i) != 'G') {
                return false;
            }
            if (sekvenssi.charAt(i) == 'G' && verrattava.charAt(i) != 'C') {
                return false;
            }
            
        }
        return true;
    }
}
