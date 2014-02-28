/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaihekaksi.domain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka, joka sisältää tiedon viidestä aminohaposta, joita lisätään pelin toisessa
 * vaiheessa merkkijonoon oikeiden syötteiden myötä
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.3
 * @since 2014-02-28
 */
public class Aminohapot {
    /**
     * Sisältää tiedon viidestä aminohaposta
     */
    private ArrayList<String> aminohapot;
    /**
     * Merkkijono, johon aminohappoja lisätään oikeiden syötteiden myötä
     */
    private String aminohappoketju;
    /**
     * Pitää kirjaa, kuinka monta aminohappoa aminohappoketjuun on lisätty
     */
    private int aminohappojenLkm;
    /**
     * Alustetaan oliomuuttujat
     */
    public Aminohapot() {
        this.aminohappojenLkm = 0;
        this.aminohappoketju = "";
        this.aminohapot = new ArrayList<>();
        aminohapot.add("fenyylialaniini");
        aminohapot.add("leusiini");
        aminohapot.add("kysteiini");
        aminohapot.add("tryptofaani");
        aminohapot.add("glutamiinihappo");
    }
    /**
     * Palauttaa viiden aminohapon joukosta satunnaisesti yhden
     * 
     * @return yksi aminohappo
     */
    public String getSatunnainenAminohappo() {
        Random random = new Random();
        int sijainti = random.nextInt(aminohapot.size());
        String randomAminohappo = aminohapot.get(sijainti);
        return randomAminohappo;
    }
    /**
     * Lisää aminohappo-merkkijonoon parametrinä annetun aminohapon
     * 
     * @param aminohappo
     * @return palauttaa aminohappoketjun, jonka perään on lisätty uusi aminohappo
     */
    public String kasvataAminohappoketjua(String aminohappo) {
        aminohappojenLkm++;
        if (aminohappoketju.isEmpty()) {
            aminohappoketju = aminohappo;
        } else {
        aminohappoketju = aminohappoketju + " - " + aminohappo;
        }
        return aminohappoketju;
    }

    public int getAminohappojenLkm() {
        return aminohappojenLkm;
    }
}
