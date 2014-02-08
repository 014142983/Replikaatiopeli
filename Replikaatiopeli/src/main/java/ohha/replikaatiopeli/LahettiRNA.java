/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli;

/**
 *
 * @author Henri
 */
public class LahettiRNA {
    
    private String lahettiRNA;
    
    public LahettiRNA() {
        this.lahettiRNA = "";
    }
    
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
