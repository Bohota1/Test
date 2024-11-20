package Code;

import Code.IceCream;

import java.util.ArrayList;

public class Order {
    ArrayList<IceCream> scoops = new ArrayList<>();
    ArrayList<Topping> toppings = new ArrayList<>();
    boolean isWaffleCone;
    double subtotal;

    public void addScoop(IceCream iceCream) {
        scoops.add(iceCream);
        subtotal += iceCream.getPricePerScoop();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
        subtotal += topping.getPrice();
    }

    public void setCupType(boolean isWaffleCone) {
        this.isWaffleCone = isWaffleCone;
        if (isWaffleCone) {
            subtotal += 5.00;
        }
    }

    public double calculateTotal() {
        return subtotal * 1.08; // Including 8% tax
    }

    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder("Ice Cream Shop Invoice\n");
        for (IceCream scoop : scoops) {
            invoice.append(scoop.getFlavor() + " - 1 scoop: $" + scoop.getPricePerScoop() + "\n");
        }
        for (Topping topping : toppings) {
            invoice.append(topping.getName() + " - 1 time: $" + topping.getPrice() + "\n");
        }
        invoice.append("Subtotal: $" + subtotal + "\n");
        invoice.append("Tax: $" + (subtotal * 0.08) + "\n");
        invoice.append("Total Amount Due: $" + calculateTotal() + "\n");
        return invoice.toString();
    }
}

