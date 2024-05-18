package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanNumTest {

    private RomanNum converter = new RomanNum(); // Eine einzige Instanz für alle Tests

    @Test
    public void testConvertOneToFour() {
        String[] expected = {"I", "II", "III","IV"};
        
        for (int number = 1; number <= 4; number++) {
            assertEquals(expected[number - 1], converter.convert(number));
        }
    }
}
