package Test;
import Code.IceCream;
import Code.Order;
import Code.Topping;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IceCreamShopTest {

    @Test
    void testAddMultipleScoopsAndToppingsRegularCup() {
        Order order = new Order();
        IceCream mintChocolateChip = new IceCream("Mint Chocolate Chip", 2.80);
        IceCream pistachioDelight = new IceCream("Pistachio Delight", 3.25);
        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping marshmallow = new Topping("Marshmallow", 0.70);

        order.addScoop(mintChocolateChip);
        order.addScoop(pistachioDelight);
        order.addTopping(sprinkles);
        order.addTopping(marshmallow);
        order.setCupType(false); // Regular cup

        String invoice = order.generateInvoice();
        assertTrue(invoice.contains("Mint Chocolate Chip - 1 scoop: $2.8"));
        assertTrue(invoice.contains("Pistachio Delight - 1 scoop: $3.25"));
        assertTrue(invoice.contains("Sprinkles - 1 time: $0.3"));
        assertTrue(invoice.contains("Marshmallow - 1 time: $0.7"));
        assertFalse(invoice.contains("Waffle Cone")); // Check no waffle cone charge
        assertEquals(7.05 * 1.08, order.calculateTotal(), 0.01); // Total with tax
    }

    @Test
    void testAddScoopsAndToppingsWaffleCone() {
        Order order = new Order();
        IceCream chocolateFudge = new IceCream("Chocolate Fudge", 3.00);
        Topping oreo = new Topping("Crushed Oreo", 0.85);

        order.addScoop(chocolateFudge);
        order.addTopping(oreo);
        order.setCupType(true); // Waffle cone

        String invoice = order.generateInvoice();
        assertTrue(invoice.contains("Chocolate Fudge - 1 scoop: $3.0"));
        assertTrue(invoice.contains("Crushed Oreo - 1 time: $0.85"));
        assertTrue(invoice.contains("Subtotal: $8.85")); // Includes waffle cone price
        assertEquals(8.85 * 1.08, order.calculateTotal(), 0.01);
    }

    @Test
    void testEmptyOrder() {
        Order order = new Order();
        String invoice = order.generateInvoice();

        assertTrue(invoice.contains("Ice Cream Shop Invoice"));
        assertTrue(invoice.contains("Subtotal: $0.0"));
        assertTrue(invoice.contains("Tax: $0.0"));
        assertTrue(invoice.contains("Total Amount Due: $0.0"));
        assertEquals(0.0, order.calculateTotal());
    }

    @Test
    void testOnlyToppings() {
        Order order = new Order();
        Topping strawberries = new Topping("Fresh Strawberries", 1.00);
        Topping chocolateChips = new Topping("Chocolate Chips", 0.50);

        order.addTopping(strawberries);
        order.addTopping(chocolateChips);

        String invoice = order.generateInvoice();
        assertTrue(invoice.contains("Fresh Strawberries - 1 time: $1.0"));
        assertTrue(invoice.contains("Chocolate Chips - 1 time: $0.5"));
        assertEquals(1.5 * 1.08, order.calculateTotal(), 0.01);
    }

    @Test
    void testOnlyScoops() {
        Order order = new Order();
        IceCream strawberrySwirl = new IceCream("Strawberry Swirl", 2.75);
        IceCream pistachioDelight = new IceCream("Pistachio Delight", 3.25);

        order.addScoop(strawberrySwirl);
        order.addScoop(pistachioDelight);

        String invoice = order.generateInvoice();
        assertTrue(invoice.contains("Strawberry Swirl - 1 scoop: $2.75"));
        assertTrue(invoice.contains("Pistachio Delight - 1 scoop: $3.25"));
        assertEquals(6.00 * 1.08, order.calculateTotal(), 0.01);
    }
}

