package hu.ninedevs.pn;


/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * TEAM MUNKA 3 fős fejlesztői csoportokban.
 *
 * Team 1:
 *      - Zsigmond (dev1, lead developer)
 *      - Tamás (dev2)
 *      - Gábor (dev3)
 *
 * Team 2:
 *      - Attila (dev1)
 *      - Levente (dev2)
 *      - Kálmán (dev3, lead developer)
 *
 * A csoport lead developer-e forkolja és klónozza a repository-t, és ellenőrizze, hogy a saját neve alatt létrejött-e a GitHub-on a másolat.
 * A lead developer hívja meg a másik két csapattagot kollaborációra a saját neve alatt létrejött másolathoz. Ezen a másolaton fog dolgozni a csapat.
 * Mindhárman klónozzák a forkolt repót.
 * Az eredeti repót (zsoltkiss/Java-Collaboration2) SENKI NE KLÓNOZZA!
 * Segítsétek a lead developer munkáját, de ha bármiről dönteni kell, ő dönt!
 *
 * A PROJEKT: Rendszám generálás (PlateNumbers.java)
 * Írj olyan programot, amely szabályos magyar gépjármű rendszámokat generál (3 betű, kötőjel, 3 szám)!
 * A programot OOP szemlélettel írd meg, a következő komponensek (osztályok) alkalmazásával:
 * - hu.ninedevs.pn.Issuer
 * - hu.ninedevs.pn.Generator
 * - hu.ninedevs.pn.model.PlateNumber
 * - hu.ninedevs.pn.PlateNumbers
 *
 * MUNKAMEGOSZTÁS:
 *      Developer 1 csinálja: PlateNumbers.java, PlateNumber.java
 *      Developer 2 csinálja: Issuer.java
 *      Developer 3 csinálja: Generator.java
 *
 * CÉL:
 *      A team munka eredményeképp jöjjön létre a fordítási hibától mentes, futtatható, a megadott specifikációnak mindenben megfelelő program.
 *      Minden olyan aspektusban, amit a feladatkiírás esetleg nem szab meg, a döntés elsősorban a lead developer-é, másodsorban azé a fejlesztőé, aki
 *      az adott osztályt/kódrészletet implementálja.
 *
 * DEADLINE/HATÁRIDŐ:
 *      A kezdéstől számított 1 óra.
 */

import hu.ninedevs.pn.model.PlateNumber;

import java.io.*;

/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * Az osztályt az alábbiak szerint implementáld:
 *
 *  - itt írd meg a program belépési pontját;
 *  - igényelj 5 rendszámot az Issuer-től és írasd ki őket;
 */
public class PlateNumbers {

    public static void main(String[] args) {
        PlateNumber[] regiRendszamok=new PlateNumber[]{};
        File f = new File("src/rendszamok.txt");
        regiRendszamok=readFromFile(f);


        Issuer is = new Issuer(regiRendszamok);

        for (int i =0; i < 5; i++){
            System.out.println(is);
            appendPlateNumber(is.require());
        }

    }
    static PlateNumber[] readFromFile(File f) {
        PlateNumber[] regiRendszamok=new PlateNumber[]{};

        try {
            FileReader fr=new FileReader(f);
            BufferedReader br= new BufferedReader(fr);
            String egysor;
            int n=0;
            while((egysor=br.readLine())!=null){
                String[] reszek=egysor.split("-");
                String betuk=reszek[0];
                String szamok=reszek[1];
                PlateNumber rendszam= new PlateNumber(betuk,szamok);
                regiRendszamok[n]=rendszam;
                n++;
            }
            br.close();
        } catch (FileNotFoundException efn) {
            efn.printStackTrace();
        } catch(IOException eio){eio.printStackTrace();}


        return regiRendszamok;

    }

    static void appendPlateNumber(PlateNumber pn) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("")); // ide kell egy elérési út!
        bw.newLine();                                         // ús sort kezd.
        bw.write(pn);
        bw.close();
    }

}
