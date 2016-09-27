/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2013 09 02
 *                               modifikuota 2016 09 03
 * Tai yra demonstracinė Kasos klasė, kuris prideda prekės kainą prie
 *        kaupiamos sumos.
 * Ji turi sumavimo metodus vienai prekei ir kelioms prekėms.
   *  IŠBANDYKITE pilnai objektinę Java programą ir jos metodus.
   *  PAPILDYKITE klasę laukais, registruojančiais pirkimų ir prekių kiekius
   *  SUKURKITE metodus vidutinę pirkimo ir prekės kainą
   *  IŠBANDYKITE sukurtų metodų veikimą.
   ****************************************************************************/

public class D_Kasa {
    private static final char euroSym = 0x20AC;  // euro unicodo reikšmė
    private static int pradinisNr;               // pradinė reikšmė = 0
    private int kasosNr;
    private int pirkimųKiekis;
    private int prekiųKiekis;
    private double vidutinėPirkimoKaina;
    private static void incrementNr(){
        pradinisNr++;
    }
    private double kaupiamaSuma;
    public double getKaupiamaSuma(){
        return kaupiamaSuma;
    }
    
    double getVidutinėPirkimoKaina() {
        return kaupiamaSuma / pirkimųKiekis;
    }
    
    double getVidutinėPrekėsKaina() {
        return kaupiamaSuma / prekiųKiekis;
    }
    // konstruktorius, kai sukuriama kasa su unikaliu didėjančiu numeriu
    public D_Kasa() {
        kasosNr = pradinisNr; // naujos kasos numeris pastoviai didės
        pirkimųKiekis = 0;
        prekiųKiekis = 0;
        incrementNr();
    }
    // konstruktorius, kai sukuriama kasa su nurodytu numeriu
    public D_Kasa(int kasosNr) {
        this.kasosNr = kasosNr; // parametras nurodo kasos numerį
    }
    // prideda vienos prekės kainą
    double sumuoti(double kaina){
        kaupiamaSuma += kaina;
        pirkimųKiekis++;
        prekiųKiekis++;
        System.out.println("Kasoje nr." + kasosNr + " yra: " +
                kaupiamaSuma + euroSym + 
                "; Pirkimų kiekis: " + pirkimųKiekis + "; prekių kiekis: " + prekiųKiekis + 
                "; Vidutinė pirkimo kaina: " + getVidutinėPirkimoKaina() + "; Vidutinė prekės kaina: " + getVidutinėPrekėsKaina());
        return kaupiamaSuma;
    }
    // prideda nurodyto prekių kiekio kainą
    double sumuoti(double kaina, int kiekis){
        pirkimųKiekis++; 
        prekiųKiekis += kiekis;
        
        return sumuoti(kaina * kiekis);
    }
    // išvaloma sukaupta suma
    double reset() { 
        kaupiamaSuma = 0;
        pirkimųKiekis = 0;
        prekiųKiekis = 0;
        return kaupiamaSuma;
    }
    // išbandome kaip veikia sukurti metodai
    static void trial(){
        D_Kasa s0 = new D_Kasa();
        D_Kasa s1 = new D_Kasa();
        D_Kasa s2 = new D_Kasa();
        D_Kasa s3 = new D_Kasa();
        s0.sumuoti(5.68);
        s1.sumuoti(0.91, 2);
        s2.sumuoti(35.68);
        s0.sumuoti(40.00);
        s2.sumuoti(40.00);
        s0.sumuoti(40.0, 5);
        s1.sumuoti(50.0, 6);
        s0.reset();
        s0.sumuoti(0.03, 100_000);    
        s3.sumuoti(1.5);
    }
    public static void main(String[] args) {
        trial();
    }
}
