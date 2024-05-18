package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumTest {

    private RomanNum converter = new RomanNum(); //Eine einzige Instanz für alle Tests

    @ParameterizedTest
    @CsvSource({
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "6, VI",
        "8, VIII",
        "10, X",
        "11, XI",
        "12, XII"
    })
    public void testConvertNumbers(int number, String expected) {
        assertEquals(expected, converter.convert(number));
    }
}
