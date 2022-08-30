package main;


import main.exceptions.OutOfBoundArgumentException;

public class Purchase extends AbstractPurchase {

    public Purchase(Product product, int purchasedUnits) {
        super(product, purchasedUnits);
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

    @Override
    protected Euro getFinalCost(Euro cost) {
        return cost;
    }
}
