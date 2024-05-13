package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanNumTest {

    @Test
    public void testConvertOne() {
        RomanNum converter = new RomanNum();
        assertEquals("I", converter.convert(1));
    }
    
    @Test
    public void testConvertTwo() {
        RomanNum converter = new RomanNum();
        assertEquals("II", converter.convert(2));
    }
    
    @Test
    public void testConvertThree() {
        RomanNum converter = new RomanNum();
        assertEquals("III", converter.convert(3));
    }
    
}
