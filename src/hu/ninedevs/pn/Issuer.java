package hu.ninedevs.pn;

import hu.ninedevs.pn.model.PlateNumber;

import java.util.Arrays;

/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * Az osztályt az alábbiak szerint implementáld:
 *
    - tartson nyilván egy PlateNumber[] tömböt, (kiadottRendszamok néven) amiben eltárolja a már kiadott rendszámokat;
    - legyen egy require() nevű példánymetódusa, amelyen igényelni lehet egy új, még nem létező rendszámot;
    - a require() visszatérési értéke PlateNumber legyen;
    - az Issuer a Generator osztályt kérje meg, hogy gyártson számára egy új rendszámot, de csak akkor fogadja el,
        ha kiadott rendszámok között még nem létezik a legyártott rendszám;
    - az Issuer addig próbálkozzon a Generator-nál, ameddig nem kap olyan rendszámot, ami még nem létezik
    - ha megfelelő rendszámot kapott, akkor tárolja el a kiadottRendszámok tömbbben is
 */
public class Issuer {
    private PlateNumber[] kiadottRendszamok=new PlateNumber[]{};

    public Issuer(){
    }

    public Issuer(PlateNumber[] regiRendszamok){
         kiadottRendszamok=regiRendszamok;
    }


    public PlateNumber require(){
        int n=kiadottRendszamok.length;
        PlateNumber rendszam;
        Generator ujRendszam=new Generator();
        String[] sRendszam=ujRendszam.genPlateNumber();
        rendszam=ellenorzes(sRendszam);
        kiadottRendszamok = Arrays.copyOf(kiadottRendszamok,n+1);
        kiadottRendszamok[n]=rendszam;
        return rendszam;
    }
    public PlateNumber ellenorzes(String[] sRendszam){
        Generator ujRendszam=new Generator();
        String betuk=sRendszam[0];
        String szamok=sRendszam[1];
        PlateNumber ell=new PlateNumber(betuk,szamok);
        if((kiadottRendszamok.length)!=0) {
            for (int i = 0; i < kiadottRendszamok.length; i++) {
                if (ell.equals(kiadottRendszamok[i])) {
                    sRendszam = ujRendszam.genPlateNumber();
                    ell = ellenorzes(sRendszam);
                }
            }
        }
            return ell;
        }

    public PlateNumber[] getKiadottRendszamok() {
        return kiadottRendszamok;
    }
}

