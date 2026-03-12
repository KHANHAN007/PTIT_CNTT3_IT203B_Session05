import model.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class OrderTest {
    @Test
    void testTotalPrice(){
        MenuItem burger = new Food("F1","Burger",50);
        Order order = new Order("O1");
        order.addItem(burger,2);
        assertEquals(100.0, order.calculateTotal());
    }
}