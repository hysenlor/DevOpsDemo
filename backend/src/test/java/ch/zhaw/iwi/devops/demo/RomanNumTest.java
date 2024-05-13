package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanNumTest {

    private RomanNum converter = new RomanNum(); // Eine einzige Instanz für alle Tests

    @Test
    public void testConvertOneToFour() {
        // Array von erwarteten Werten für die Zahlen 1, 2 und 3
        String[] expected = {"I", "II", "III","IV"};
        
        // Schleife, die die Zahlen 1 bis 3 testet
        for (int number = 1; number <= 4; number++) {
            assertEquals(expected[number - 1], converter.convert(number));
        }
    }
}
