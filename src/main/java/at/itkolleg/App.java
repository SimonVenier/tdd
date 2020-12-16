package at.itkolleg;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Dieses Beispiel stammt aus http://www.cherriz.de/training/index.php?chapter=5.4
 */
public class App 
{
    public static void main( String[] args )
    {
        //Saal anlegen
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        KinoSaal ks = new KinoSaal("Herr der Ringe",map);

        //Platz prüfen
        System.out.println(ks.pruefePlatz('A',11));
        System.out.println(ks.pruefePlatz('A',10));
        System.out.println(ks.pruefePlatz('B',10));
        System.out.println(ks.pruefePlatz('C',14));

        //Vorstellung anlegen
        Vorstellung vorstell = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2020,10,02), "Herr Der Ringe", 15);

        //Kinoverwaltung anlegen
        KinoVerwaltung kinoV = new KinoVerwaltung();

        //Tickets anlegen
        Ticket tickets = new Ticket("Saal 1", Zeitfenster.NACHT, LocalDate.of(2002,01,02), '2', 10);
        Ticket tickets2 = kinoV.kaufeTicket(vorstell, 'A', 10,10);

        //Ausgabe
        System.out.println(tickets2);

    }
}
