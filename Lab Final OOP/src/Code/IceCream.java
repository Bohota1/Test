package Code;

public class IceCream {
    String flavor;
    double pricePerScoop;

    public IceCream(String flavor, double pricePerScoop) {
        this.flavor = flavor;
        this.pricePerScoop = pricePerScoop;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public String getFlavor() {
        return flavor;
    }
}

