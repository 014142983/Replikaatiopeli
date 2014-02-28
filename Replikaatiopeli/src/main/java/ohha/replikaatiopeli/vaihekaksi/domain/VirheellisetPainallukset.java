/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.domain;

/**
 * Pitää kirjaa pelin toisessa vaiheessa käyttäjän väärien syötteiden lukumäärästä
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-28
 */
public class VirheellisetPainallukset {
    /**
     * Käyttäjän virheellisten syötteiden lukumäärä
     */
    private int virheet;
    /**
     * Teksti joka lisätään pelin toisen vaiheen graafiseen tekstikomponenttiin kertomaan
     * virheiden lukumäärästä
     */
    private String virheteksti;
    
    public VirheellisetPainallukset() {
        this.virheet = 0;
        this.virheteksti = "Virheellisiä painalluksia: " + virheet;
    }
    /**
     * Kasvattaa virheiden lukumäärää väärien syötteiden myötä
     */
    public void kasvataVirheidenLkm() {
        virheet++;
        this.virheteksti = "Virheellisiä painalluksia: " + virheet;
    }
    
    public String getVirheteksti() {
        return this.virheteksti;
    }
    
    public int getVirheidenLkm() {
        return virheet;
    }
}
