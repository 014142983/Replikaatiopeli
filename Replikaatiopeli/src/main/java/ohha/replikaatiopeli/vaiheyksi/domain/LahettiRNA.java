/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.domain;

/**
 * Sisältää tiedon merkkijonosta, jota kasvatetaan pelin ensimmäisessä vaiheessa
 * käyttäjän oikeiden syötteiden perusteella
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-02-06
 */
public class LahettiRNA {
    /**
     * Merkkijono, joka kasvaa käyttäjän syötteiden perusteella
     */
    private String lahettiRNA;
    
    public LahettiRNA() {
        this.lahettiRNA = "";
    }
    /**
     * Lisää luokan oliomuuttujana olevaan merkkijonoon käyttäjän antaman syötteen.
     * 
     * @param s käyttäjän antama syöte
     */
    public void setLahettiRNA(String s) {
        this.lahettiRNA = this.lahettiRNA + s;
    }
    
    public String getLahettiRNA() {
        return lahettiRNA;
    }
    
    public int getPituus() {
        return lahettiRNA.length();
    }
}
