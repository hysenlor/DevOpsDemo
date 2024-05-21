package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VorlesungTest {

    @Test
    void testSetDozent() {
        Vorlesung vorlesung = new Vorlesung(1, "Informatik", "Grundlagen der Informatik", "Dr. Müller");
        String neuerDozent = "Prof. Dr. Schmidt";
        vorlesung.setDozent(neuerDozent);
        assertEquals(neuerDozent, vorlesung.getDozent(), "Der Dozent sollte geändert worden sein.");
    }
}
    
