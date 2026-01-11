package hostel.utils;

import hostel.domain.Exportable;
import java.util.List;

public class RaportSrv {

    public void printReport(String title, List<? extends Exportable> items) {
        System.out.println("=== RAPORT: " + title + " ===");
        if (items.isEmpty()) {
            System.out.println("(Brak danych)");
        } else {
            for (Exportable item : items) {
                System.out.println(item.toCsv());
            }
        }
        System.out.println("==========================\n");
    }
}