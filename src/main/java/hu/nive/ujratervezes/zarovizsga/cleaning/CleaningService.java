package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    } // hozzáaad egy ingatlant


    public int cleanAll() {
        int sum = 0;
        Iterator<Cleanable> cleanableIterator = cleanables.iterator();
        while (cleanableIterator.hasNext()) {
            Cleanable focused = cleanableIterator.next();
            sum += focused.clean();
            cleanableIterator.remove();
        }
        return sum;
    } // kitakarítja az összes ingatlant, és visszaadja, hogy mennyibe került, ezután nem marad egy ingatlan sem


    public int cleanOnlyOffices() {
        int sum = 0;
        Iterator<Cleanable> cleanableIterator = cleanables.iterator();
        while (cleanableIterator.hasNext()) {
            Cleanable focused = cleanableIterator.next();
            if (focused.isOffice()) {
                sum += focused.clean();
                cleanableIterator.remove();
            }
        }
        return sum;
    } // kitakarítja csak az irodákat, és visszaadja, hogy mennyibe került. Ezután csak a házak maradnak.


    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> cleanablesWithAddressPart = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                cleanablesWithAddressPart.add(cleanable);
            }
        }
        return cleanablesWithAddressPart;
    } // visszaadja azokat az ingatlanokat, melynek címében szerepel a paraméterként megadott érték


    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            sb.append(cleanable.getAddress());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    } //visszaadja az ingatlanok címeit vesszővel és egy szóközzel elválasztva


}
