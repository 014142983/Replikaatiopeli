/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.domain;

import java.util.Random;

/**
 * Luo kolmen emäksen muodostaman merkkijonon, joka pelin toisessa vaiheessa kulkee
 * ruudussa edestakaisin vasemmalle ja oikealle
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-26
 */
public class Ribosomi {
    /**
     * Kolmen emäksen muodostama merkkijono
     */
    private String tripletti;
    /**
     * Merkkijono, joka sisältää kolme emästä sekä alaviivasta koostuvaa täytettä,
     * jotta merkkijono olisi yhtä pitkä kuin emäsjärjestysmerkkijono ja kolme emästä
     * liikkuisivat samaan tahtiin emäsjärjestys-merkkijonon kanssa
     */
    private String triplettimerkkijono;
    
    public Ribosomi() {
        tripletti = "";
    }
    /**
     * Luo kolmen emäksen muodostaman merkkijonon
     */
    public void luoTripletti() {
        String emakset = "ACGU";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            tripletti = tripletti + emakset.charAt(random.nextInt(3));
        }
    }
    /**
     * Luo merkkijonon joka koostuu alaviivoista ja kolmen emäksen muodostamasta merkkijonosta
     * 
     * @param lkm kuinka pitkä triplettimerkkijonosta tulee 
     */
    public void luoMerkkijonoJossaTripletti(int lkm) {
        luoTripletti();
        triplettimerkkijono = "";
        for (int i = 0; i < lkm; i++) {
            triplettimerkkijono = triplettimerkkijono + "_";
        }
        triplettimerkkijono = triplettimerkkijono + tripletti;
    }
    
    public String getTripletti() {
        return tripletti;
    }
    
    public String getTriplettimerkkijono() {
        return triplettimerkkijono;
    }
    
    public void setTriplettimerkkijono(String merkkijono) {
        triplettimerkkijono = merkkijono;
    }
}
