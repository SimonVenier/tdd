package at.itkolleg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class VorstellungTest
{

    private KinoSaal ks;
    private Vorstellung vs;
    private Ticket ti;

    @BeforeEach
    void setup()
    {
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        this.ks = new KinoSaal("Kinosaal 3",map);
        this.vs = new Vorstellung(this.ks, Zeitfenster.NACHT, LocalDate.of(2020,10,03), "Herr der Ringe", 10);
        this.ti = new Ticket("Kinosaal 3", Zeitfenster.NACHT, LocalDate.of(2020,10,03), 'A', 20);

    }

    @Test
    void filmTesten()
    {
        Assertions.assertEquals("Herr der Ringe", this.vs.getFilm(), "true");
    }

    @Test
    void saalTesten()
    {
        Assertions.assertEquals(this.ks, this.vs.getSaal(), "true");
    }

    @Test
    void datumTesten()
    {
        Assertions.assertEquals(LocalDate.now(), this.vs.getDatum(), "false");
    }

    @Test
    void testZeit()
    {
        Assertions.assertEquals(Zeitfenster.NACHT, this.vs.getZeitfenster(), "true");
    }

    @Test
    void testeTicketkaufen()
    {
        Ticket t1 = this.vs.kaufeTicket('A', 5, 20);
        Assertions.assertNotNull(this.vs.kaufeTicket('A', 5, 20), "true");
    }

    @ParameterizedTest
    @ValueSource(

            chars = {'A', 'B', 'C', 'D', 'E'}
    )
    void testeTickets()
    {
        Ticket t1 = this.vs.kaufeTicket('A', 10, 20);
        Assertions.assertNotNull(t1);
        System.out.println(t1);
    }

}
