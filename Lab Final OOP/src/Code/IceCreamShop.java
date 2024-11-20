package Code;

import Code.IceCream;

public class IceCreamShop {
    public static void main(String[] args) {
        IceCream mintChocolateChip = new IceCream("Mint Chocolate Chip", 2.80);
        IceCream chocolateFudge = new IceCream("Chocolate Fudge", 3.00);
        IceCream strawberrySwirl = new IceCream("Strawberry Swirl", 2.75);
        IceCream pistachioDelight = new IceCream("Pistachio Delight", 3.25);

        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping marshmallow = new Topping("Marshmallow", 0.70);
        Topping oreo = new Topping("Crushed Oreo", 0.85);
        Topping strawberries = new Topping("Fresh Strawberries", 1.00);
        Topping chocolateChips = new Topping("Chocolate Chips", 0.50);

        Order order = new Order();
        order.addScoop(mintChocolateChip);
        order.addScoop(chocolateFudge);
        order.addTopping(strawberries);
        order.addTopping(oreo);
        order.setCupType(true); // Waffle cone

        System.out.println(order.generateInvoice());
    }
}
