package hu.ninedevs.pn;

import java.util.Random;

/**
 *  FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 *  Az osztályt az alábbiak szerint implementáld:
 *
 * - egyetlen static metódust tartalmazzon, ami egy kételemű String[] tömböt ad vissza;
 * - a visszaadott tömb 0. eleme legyen a rendszám 3 betűből álló része, az 1. eleme pedig a rendszám 3 számból álló része;
 * - véletlenszerű számot és betűkombinációt generáljon minden meghívásra
 * - ennek az osztálynak nem kell törődnie azzal, hogy a generált kombinációk fel lettek-e már használva kiadott rendszámokban
 */
public class Generator {

    public static String[] genPlateNumber(){

        String alphas="";
        String nums="";
        Random ran=new Random();

        for (int n=0; n<3; n++) alphas+=(char)('A'+ran.nextInt(26));

        for (int n=0; n<3; n++) nums+=ran.nextInt(10);

        return new String[]{alphas,nums};
    }
}
