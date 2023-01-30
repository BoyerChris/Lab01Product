import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product s1;

    @BeforeEach
    void setUp() {
        s1 = new Product("000001", "Walkie Talkie", "Portable Radios", 50);
    }

    @Test
    void setID() {
        s1.setID("000001");
        assertEquals("000001", s1.getID());
    }

    @Test
    void setName() {
        s1.setName("Walkie Talkie");
        assertEquals("Walkie Talkie", s1.getName());
    }

    @Test
    void setDescription() {
        s1.setDescription("Portable Radios");
        assertEquals("Portable Radios", s1.getDescription());
    }

    @Test
    void setCost() {
        s1.setCost(50);
        assertEquals(50, s1.getCost());
    }

    @Test
    void testtoString() {
        s1.setID("000001");
        s1.setName("Walkie Talkie");
        s1.setDescription("Portable Radios");
        s1.setCost(50);
        assertEquals("000001, Walkie Talkie, Portable Radios, 50.0", s1.toString());
    }
}