package at.itkolleg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class KinoSaalTest
{
    private KinoSaal kinoSaal;

    @BeforeEach
    void setup()
    {
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        this.kinoSaal = new KinoSaal("Kinosaal4",map);
    }

    @Test
    void testePlatz()
    {
        Assertions.assertTrue(this.kinoSaal.pruefePlatz('C', 15), "Stimmt!");
    }

    @Test
    void testeFilmName()
    {
        Assertions.assertEquals("Kinosaal4", this.kinoSaal.getName(), "Richtiger Saal");
    }

}
