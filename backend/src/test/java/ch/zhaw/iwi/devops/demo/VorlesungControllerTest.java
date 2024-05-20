package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class VorlesungControllerTest {

    @Test
    public void testPostVorlesung() {
        VorlesungController controller = new VorlesungController();
        var vorlesung = new Vorlesung(0, "t", "d", "doz");
        controller.createVorlesung(vorlesung);
        
        assertEquals(1, controller.vorlesung().size());
        Vorlesung createdVorlesung = controller.getVorlesung(1);
        assertEquals(1, createdVorlesung.getId());
        assertEquals("t", createdVorlesung.getName());
        assertEquals("d", createdVorlesung.getDescription());
        assertEquals("doz", createdVorlesung.getDozent());
    }

    @Test
    public void testGetVorlesung() {
        VorlesungController controller = new VorlesungController();
        Vorlesung vorlesung = new Vorlesung(1, "t", "d", "doz");
        controller.createVorlesung(vorlesung);
        
        Vorlesung result = controller.getVorlesung(1);
        assertEquals("t", result.getName());
        assertEquals("d", result.getDescription());
        assertEquals("doz", result.getDozent());
    }

        @Test
    public void testPutVorlesung() {
        VorlesungController controller = new VorlesungController();
        var vorlesung = new Vorlesung(1, "t", "d", "doz");
        controller.createVorlesung(1, vorlesung);
        assertEquals(1, controller.vorlesung().size());
    }

        @Test
    public void testDeleteVorlesung() {
        VorlesungController controller = new VorlesungController();
        Vorlesung vorlesung = new Vorlesung(1, "t", "d", "doz");
        controller.createVorlesung(vorlesung);

        Vorlesung deleted = controller.deleteVorlesung(1);
        assertEquals("t", deleted.getName());
        assertEquals(0, controller.vorlesung().size());
        assertNull(controller.getVorlesung(1));
    }

}
