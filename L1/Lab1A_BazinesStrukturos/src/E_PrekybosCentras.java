/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 02
 *                               modifikuota 2016 09 03
 * Tai yra demonstracinė Prekybos Centro klasė
 *       
 * Ji turi pirkimo ir analizės metodus.
   *  IŠBANDYKITE pilnai objektinę Java programą ir jos metodus.
   *  SUKURKITE nurodytus pinigų kiekio analizės metodus.
   *  IŠBANDYKITE sukurtų metodų veikimą.
   *  PERKELKITE Kasos ir PrekybosCentro klases į naują paketą prekyba
   *  PAKEISKITE klasių vardus (be prefiksų) refaktoringo pagalba
   ****************************************************************************/

import java.util.ArrayList;
import java.util.List;

public class E_PrekybosCentras {
    private String vardas;
    private List<D_Kasa> kasos;

    public E_PrekybosCentras(String vardas, int kasųKiekis) {
        this.vardas = vardas;
        kasos = new ArrayList<>(kasųKiekis);
        for(int i=0; i<kasųKiekis; i++)
            kasos.add(new D_Kasa(i));
    }
    void vykdytiPirkimą(int kasosNr, double kaina){
        kasos.get(kasosNr).sumuoti(kaina);
    }
    void vykdytiPirkimą(int kasosNr, double kaina, int kiekis){
        kasos.get(kasosNr).sumuoti(kaina, kiekis);
    }
    void dienosPirkimai(String[] pirkimai){
        for(String p: pirkimai){
            String[] pa = p.split(" ");
            switch(pa.length){
                case 2:
                    vykdytiPirkimą(Integer.parseInt(pa[0]), 
                                   Double.parseDouble(pa[1]));
                    break;
                case 3:
                    vykdytiPirkimą(Integer.parseInt(pa[0]), 
                                   Double.parseDouble(pa[1]),
                                   Integer.parseInt(pa[2]));
                    break;
                default:
                    System.out.println("Neteisingas pirkimas");
            }
        }      
    }
    double kiekVisoseKasoseYraPinigų(){
        // užrašykite reikalingus veiksmus
        return 0;
    }
    int kuriojeKasojeYraDaugiausiaiPinigų(){
        // užrašykite reikalingus veiksmus
        return 0;
    }
    void demo1(){
        String[] pd = { // papildykite duonenų sąrašą
            "2 12.45",
            "1 22.39",
            "3 12.51 4",
            "3 12.51 4 2",
            "1 10.00 10",
            "7 19.45",
            "7"
        };
        System.out.println("Prekybos centras " + vardas);
        dienosPirkimai(pd);
        // išbandykite sukurtus metodus
    }
        
    public static void main(String[] args) {
        E_PrekybosCentras pcRimi = new E_PrekybosCentras("Rimi", 8);
        pcRimi.demo1();
    }
}
