package main;


import main.exceptions.NegativeArgumentException;
import main.exceptions.OutOfBoundArgumentException;

public class Purchase implements Comparable<Purchase>{
    protected Product product;
    protected int purchasedUnits;

    public Purchase() {}

    public Purchase(Product product, int purchasedUnits) {
        if (purchasedUnits <= 0)
            throw new NegativeArgumentException("Purchased units amount can't be lower than zero or equal to zero");
        this.product = product;
        this.purchasedUnits = purchasedUnits;
    }

    public Purchase(String[] fields) {
        this(getValidPurchase(fields));
    }

    private static Purchase getValidPurchase(String[] fields) {
        if(fields.length != PurchasesFactory.getPurchaseFieldsNumber()) {
            throw new OutOfBoundArgumentException("wrong args number");
        }
        return new Purchase(new Product(fields[0], new Euro(fields[1])), Integer.parseInt(fields[2]));
    }

    public Purchase(Purchase purchase) {
        this(purchase.product, purchase.purchasedUnits);
    }


    public final int getPurchasedUnits() {
        return purchasedUnits;
    }

    public final Product getProduct() {
        return product;
    }

    protected Euro getFinalCost(Euro cost) {
        return cost;
    }

    public Euro getCost(){
        return product.getPrice().mul(purchasedUnits);
    }

    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + product + ";" + purchasedUnits;
    }

    @Override
    public int compareTo(Purchase o) {
        return o.getCost().compareTo(getCost());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Purchase) || (obj == null)) {
            return false;
        }

        Purchase another = (Purchase) obj;

        return this.product.equals(another.product) && purchasedUnits == another.purchasedUnits;
    }
}
