import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    Inventory SUT;
    private static final double DELTA = 0.000001;

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
        SUT.getMap().clear();
        assertTrue(SUT.getMap().isEmpty());
    }

    @Test
    public void testNonEmpty() {
        assertFalse(SUT.getMap().isEmpty());
    }

    @Test
    public void testAddProduct() {
        SUT.addProduct("prod 4",4.44,4);
        assertTrue(SUT.getMap().containsKey(4));
    }

    @Test
    public void testAddItem() {
        assertTrue(SUT.addItem(1,1));
        assertEquals(2,SUT.getMap().get(1).getQuantity());
    }

    @Test
    public void testAddItem2() {
        assertTrue(SUT.addItem(3,3));
        assertEquals(6,SUT.getMap().get(3).getQuantity());
    }

    @Test
    public void testAddItemFalse() {
        assertFalse(SUT.addItem(3,0));
        assertEquals(3,SUT.getMap().get(3).getQuantity());
    }

    @Test
    public void testAddItemFalse2() {
        assertFalse(SUT.addItem(1,-1));
        assertEquals(1,SUT.getMap().get(1).getQuantity());
    }

    @Test
    public void testRemoveProduct() {
        assertTrue(SUT.removeProduct(3));
        assertFalse(SUT.getMap().containsKey(3));
    }

    @Test
    public void testRemoveProductFalse() {
        assertFalse(SUT.removeProduct(4));
    }

    @Test
    public void testRemoveItem() {
        assertTrue(SUT.removeItem(3,1));
        assertEquals(2,SUT.getMap().get(3).getQuantity());
    }

    @Test
    public void testRemoveItem2() {
        assertTrue(SUT.removeItem(3,10));
        assertEquals(0,SUT.getMap().get(3).getQuantity());
    }

    @Test
    public void testRemoveItemFalse() {
        assertFalse(SUT.removeItem(2, 0));
        assertEquals(2, SUT.getMap().get(2).getQuantity());
    }

    @Test
    public void testRemoveItemFalse2() {
        assertFalse(SUT.removeItem(3, -1));
        assertEquals(3, SUT.getMap().get(3).getQuantity());
    }

    @Test
    public void testSortByID() {
        // TODO: do other test sorting methods before this one
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
    public void testTotalValue()
    {
        assertEquals(15.54, SUT.totalValue(), DELTA);
    }

    @Test
    public void testTotalValue2()
    {
        SUT.addItem(3,1);
        assertEquals(18.87, SUT.totalValue(), DELTA);
    }

    @Test
    public void testAveragePrice() {
        assertEquals(2.59,SUT.averagePrice(), DELTA);
    }

    @Test
    public void testAveragePrice2() {
        SUT.removeProduct(2);
        assertEquals(2.775,SUT.averagePrice(), DELTA);
    }

    @Test
    public void testFindLowestPricedItem() {
        assertEquals(1,SUT.findLowestPricedItem());
    }

    @Test
    public void testFindLowestPricedItem2() {
        SUT.addProduct("prod 4", 1.00, 1);
        assertEquals(4,SUT.findLowestPricedItem());
    }

    @Test
    public void testFindHighestPricedItem() {
        assertEquals(3,SUT.findHighestPricedItem());
    }

    @Test
    public void testFindHighestPricedItem2() {
        SUT.addProduct("prod 4", 30.00, 1);
        assertEquals(4,SUT.findHighestPricedItem());
    }

    @Test
    public void testFindLowestQuantityItem() {
        assertEquals(1,SUT.findLowestQuantityItem());
    }

    @Test
    public void testFindLowestQuantityItem2() {
        SUT.addItem(1,4);
        assertEquals(2,SUT.findLowestQuantityItem());
    }

    @Test
    public void testFindHighestQuantityItem() {
        assertEquals(3,SUT.findHighestQuantityItem());
    }

    @Test
    public void testFindHighestQuantityItem2() {
        SUT.addItem(1,30);
        assertEquals(1,SUT.findHighestQuantityItem());
    }
}