/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 09
   *
   *  Tai yra Žaidėjo charakteristikass aprašanti klasė.
   ****************************************************************************/

package proj_basketball;

import java.util.Comparator;

public class Žaidėjas implements Comparable<Žaidėjas>{
    int nr;
    String name;
    int t1, t2, t3;  // tikslių metimų skaičius
    int n1, n2, n3;  // nepataikytų metimų skaičius
    
    // nr ir pavardė imami iš duomenų eilutės
    public Žaidėjas(String data) {
        int k = data.indexOf(' ');
        nr = Integer.parseInt(data.substring(0, k));
        name = data.substring(k+1);
    }     
    
    int taškai(){ return t1 + 2*t2 + 3*t3; }
    
    @Override
    public int compareTo(Žaidėjas ž) {
        return nr - ž.nr;
    }    
    public static Comparator<Žaidėjas> pagalTaškus = new Comparator<Žaidėjas>(){
        @Override
        public int compare(Žaidėjas ž1, Žaidėjas ž2) {
            return ž2.taškai() - ž1.taškai();
        }
    };
}
