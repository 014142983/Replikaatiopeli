/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohha.replikaatiopeli.vaiheyksi.domain;

import java.util.Random;

/**
 * Luo emäsjärjestys-merkkijonon eli merkkijono, joka koostuu emäksistä, joita on
 * neljää erilaista. Mikä näistä tulee merkkijonon perään, määräytyy satunnaisesti
 * 
 * @author Leo Kallonen leo.kallonen@gmail.com
 * @version 1.1
 * @since 2014-01-22
 */
public class Emasjarjestys {
    /**
     * Neljä erilaista emästä käsittävä merkkijono
     */
    private String emakset;
    /**
     * Neljä erilaista emästä käsittävä merkkijono
     */
    private String RNAemakset;
    /**
     * Emäsjärjestys-merkkijono, joka koostuu emäksistä
     */
    private String sekvenssi;
    /**
     * Sisältää tiedon sen emäsjärjestys-merkkijonon kirjaimen järjestysluvusta, jota
     * verrataan käyttäjän syötteeseen´
     */
    private int jarjestysluku;

    public Emasjarjestys() {
        this.sekvenssi = "";
        this.emakset = "ACGT";
        this.RNAemakset = "ACGU";
        this.jarjestysluku = 0;
    }

    /**
     * Luo 9 merkkiä käsittävän merkkijonon, jonka jokainen merkki arvotaan
     * satunnaisesti siten, että se on joko C, G, T tai A
     */
    public void luoEmasjarjestys() {
        Random random = new Random();
        String uusiSekvenssi = "";
        for (int i = 1; i <= 9; i++) {
            uusiSekvenssi = uusiSekvenssi + emakset.charAt(random.nextInt(4));
        }
        sekvenssi = uusiSekvenssi;
    }
    /**
     * Luo parametrin lukuarvon pituisen emäsjärjestys-merkkijonon, jossa on aina vuoroin
     * kolme emästä ja alaviiva
     * 
     * @param lkm 
     */
    public void luoEmasjarjestys(int lkm) {
        Random random = new Random();
        String uusiSekvenssi = "";
        for (int i = 1; i <= lkm; i++) {
            if (i % 4 == 0) {
                uusiSekvenssi = uusiSekvenssi + "_";
            } else {
                uusiSekvenssi = uusiSekvenssi + RNAemakset.charAt(random.nextInt(4));
            }
        }
        sekvenssi = uusiSekvenssi;
    }

    /**
     * Palauttaa satunnaisesti generoidusta sekvenssi-merkkijonosta sen
     * kirjaimen, johon käyttäjän syötettä verrataan
     *
     * @return kirjain johon käytteen syötettä verrataan
     */
    public String getEmas() {
        String emas = sekvenssi.charAt(jarjestysluku) + "";
        return emas;
    }

    /**
     * Kasvattaa järjestyslukua eli lukua, jonka avulla määritetään mihin
     * sekvenssi- merkkijonon kirjaimeen käyttäjän syötettä verrataan. Jos
     * käyttäjän syöte on oikea, järjestysluku kasvaa ja voidaan siirtyä
     * seuraavan merkin käsittelyyn
     */
    public void kasvataJarjestyslukua() {
        jarjestysluku++;
    }

    /**
     * Palauttaa sekvenssi-merkkijonosta sen osan, jota ollaan verrattu
     * käyttäjän syötteisiin sekä viimeisenä merkin, johon käyttäjän viimeisintä
     * syötettä verrataan
     *
     * @return tietty osa sekvenssistä
     */
    public String getOsaSekvenssista() {
        String s = "";
        for (int i = 0; i < jarjestysluku + 1; i++) {
            s = s + sekvenssi.charAt(i);
        }
        return s;
    }

    public int getJarjestysluku() {
        return this.jarjestysluku;
    }

    public String getSekvenssi() {
        return this.sekvenssi;
    }

    public int getPituus() {
        return sekvenssi.length();
    }

    public void setSekvenssi(String uusiSekvenssi) {
        this.sekvenssi = uusiSekvenssi;
    }
}
