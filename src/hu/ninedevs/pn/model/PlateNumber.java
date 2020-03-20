package hu.ninedevs.pn.model;

/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * Az osztályt az alábbiak szerint implementáld:
 *
 * - konstruktora vegyen át 2 String-et, a rendszám betű és szám részeit;
 * - a konstruktor az átvett paramétereket tárolja el az osztály ezen két adattagjában: String letterPart és String numberPart;
 * - az osztálytól lehessen lekérdezni a teljes rendszámot, mondjuk a public String getFullPlateNumber() metódusban,
 *      ami összefűzi a rendszám 2 részét, köztük egy kötőjelet téve;
 * - a toString() metódust is írd meg: adja vissza ugyanazt, mint a getFullPlateNumber(), természetesen kódduplikáció nélkül
 */
public class PlateNumber {

    String letterPart;
    String numberPart;

    //konstruktor:
    public PlateNumber(String letterPart, String numberPart){
        this.letterPart = letterPart;
        this.numberPart = numberPart;
    }

    //teljes rendszám lekérdezés:
    public String getFullPlateNumber(){
        String fpn;
        fpn = this.letterPart + " - " + this.numberPart;

        return fpn;
    }

    //toString:
    @Override
    public String toString() {
        return getFullPlateNumber();
    }
}
