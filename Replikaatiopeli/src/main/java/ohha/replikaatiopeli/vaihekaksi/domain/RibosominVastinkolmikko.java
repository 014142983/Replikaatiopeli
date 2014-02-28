/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.domain;

import ohha.replikaatiopeli.grafiikka.PelinVaiheKaksi;

/**
 * Luo kolmesta pienestä kirjaimesta koostuvan merkkijonon, joka lisätään tietyin
 * väliajoin pelin toisen vaiheen yläreunan emäsjärjestys-merkkijonoon. Yhteensopiva
 * kolmen emäksen muodostavalle ribosomi-merkkijonolle
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-26
 */
public class RibosominVastinkolmikko {
    /**
     * Kolmen pienen emäksen muodostama merkkijono
     */
    private String vastinjuoste;
    /**
     * Kolmen ison emäksen muodostama ribosomi-merkkijono
     */
    private String ribosomiTripletti;
    /**
     * Haetaan kolmen emäksen muodostama ribosomi-merkkijono graafisen käyttöliittymän
     * getterillä
     * 
     * @param lite pelin toisen vaiheen graafinen käyttöliittymä 
     */
    public RibosominVastinkolmikko(PelinVaiheKaksi lite) {
        ribosomiTripletti = lite.getRibosomi().getTripletti();
        vastinjuoste = "";
    }
    /**
     * Luodaan kolmen pienen emäksen muodostama merkkijono
     */
    public void luoVastinkolmikko() {
        for (int i = 0; i < ribosomiTripletti.length(); i++) {
            if (ribosomiTripletti.charAt(i) == 'A') {
                vastinjuoste = vastinjuoste + "u";
            }
            if (ribosomiTripletti.charAt(i) == 'U') {
                vastinjuoste = vastinjuoste + "a";
            }
            if (ribosomiTripletti.charAt(i) == 'C') {
                vastinjuoste = vastinjuoste + "g";
            }
            if (ribosomiTripletti.charAt(i) == 'G') {
                vastinjuoste = vastinjuoste + "c";
            }
        }
    }
    
    public String getVastinkolmikko() {
        return vastinjuoste;
    }
}
