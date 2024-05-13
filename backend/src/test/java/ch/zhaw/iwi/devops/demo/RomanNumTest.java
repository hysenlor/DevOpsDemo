package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanNumTest {

    @Test
    public void testConvertZero() {
        RomanNum converter = new RomanNum();
        assertEquals("N", converter.convert(0));
    }

    
}
