import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    Inventory SUT;

    @BeforeEach
    public void setUp() {
        SUT = new Inventory(new HashMap<Integer,Product>());
        SUT.addProduct("prod 1",1.11,1);
        SUT.addProduct("prod 2",2.22,2);
        SUT.addProduct("prod 3",3.33,3);
    }

    @AfterEach
    public void tearDown() {
        SUT = null;
    }

    @Test
    public void testNull()
    {
        //TODO
    }

    @Test
    public void testEmpty() {
        SUT.inventory.clear();
        assertTrue(SUT.inventory.isEmpty());
    }

    @Test
    public void testNonEmpty() {
        assertFalse(SUT.inventory.isEmpty());
    }

    @Test
    public void testAddProduct() {
        SUT.addProduct("prod 4",4.44,4);
        assertTrue(SUT.inventory.containsKey(4));
    }

    @Test
    public void testAddItem() {
        assertTrue(SUT.addItem(1,1));
        assertEquals(2,SUT.inventory.get(1).getQuantity());
    }

    @Test
    public void testRemoveProduct() {
        SUT.removeProduct(3);
        assertFalse(SUT.inventory.containsKey(3));
    }

    @Test
    public void testRemoveItem() {
        assertTrue(SUT.removeItem(3,1));
        assertEquals(2,SUT.inventory.get(3).getQuantity());
    }

    // TODO add more tests with exceptions, checking different variables, etc

    @Test
    public void testSortByID() {
        // TODO
    }

    @Test
    public void testSortByQuantity() {
        // TODO
    }

    @Test
    public void testSortByPrice() {
        // TODO
    }

    @Test
    public void testTotalAverage() {
        // TODO
    }

    @Test
    public void testFindLowestPricedItem() {
        // TODO
    }

    @Test
    public void testFindHighestPricedItem() {
        // TODO
    }

    @Test
    public void testFindLowestQuantityItem() {
        // TODO
    }

    @Test
    public void testFindHighestQuantityItem() {
        // TODO
    }
}